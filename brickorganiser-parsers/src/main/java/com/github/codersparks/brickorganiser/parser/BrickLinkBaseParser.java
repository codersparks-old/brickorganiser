package com.github.codersparks.brickorganiser.parser;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Base paser used for all of the BrickLink Parsers in this package</p>
 * <p>
 * <p>Attempts to read the CSV into the supplied type in the constructor. Uses the first line of the file to read the column names in</p>
 * <p>
 * <p>If the data contains a blank first row then suppy <b>{@code true}</b> as the value for skipFirstDataLine, otherwise supply <b>{@code false}</b></p>
 */
@RequiredArgsConstructor
@Data
public class BrickLinkBaseParser<T> {

    private static final Logger logger = LoggerFactory.getLogger(BrickLinkBaseParser.class);

    private final Class<T> type;
    private final boolean header;
    private char delimeter = '\t';
    private final CsvSchema csvSchema;

    /**
     * Parse the selected {@link InputStream} for data in CSV format (using the supplied delimeter instead of comma)
     * <p>
     * <p>This method will ignore any blank lines in the file</p>
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public List<T> loadObjectList(InputStream inputStream) throws IOException {

        logger.debug("Attempting to read CSV data from input stream as type {}", type.getCanonicalName());

        CsvMapper mapper = new CsvMapper();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(String.class, new StringAsNullDeserialiser(String.class));
        mapper.registerModule(module);

        List<T> resultList = new ArrayList<T>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        int lineCount = 0;

        // If we have a header then we just discard the first row
        if(header) {
            bufferedReader.readLine();
            lineCount++;
        }

        while ((line = bufferedReader.readLine()) != null) {
            lineCount++;
            if(line.length() == 0 || "".equals(line)) {
                logger.debug("Found blank line at line {}...ignoring", lineCount);
                continue;
            }
            MappingIterator<T> mappingIterator = mapper.readerFor(type).with(csvSchema).readValues(line);

            mappingIterator.readAll(resultList);

        }

        return resultList;
    }
}
