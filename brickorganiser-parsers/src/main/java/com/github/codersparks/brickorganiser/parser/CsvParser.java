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
 * <p>Base CSV paser used for all of the Parsers in this package</p>
 *
 * <p>Attempts to read the CSV into the supplied type in the constructor.</p>
 *
 * <p>Use the csvSchema field to update the schema to use when parsing</p>
 *
 * <p>Empty fields will be set to null unless {@link #emptyFieldsAsNull} is set to <b>{@code false}</b></p>
 *
 */
@RequiredArgsConstructor
@Data
public class CsvParser<T> {

    private static final Logger logger = LoggerFactory.getLogger(CsvParser.class);

    /**
     * The type that the CsvParser will attempt to use to model the data
     */
    private final Class<T> type;

    /**
     * Does the data contain a header row (this will be ignored)
     */
    private final boolean header;

    /**
     * The {@link CsvSchema} to use to parse the data
     */
    private final CsvSchema csvSchema;

    /**
     * Should empty fields be set as null (default true)
     */
    private boolean emptyFieldsAsNull = true;

    /**
     * <p>Parse the selected {@link InputStream} for data in CSV format (using the supplied delimeter instead of comma)</p>
     *
     * <p>This method will ignore any blank lines in the file</p>
     *
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public List<T> loadObjectList(InputStream inputStream) throws IOException {

        logger.debug("Attempting to read CSV data from input stream as type {}", type.getCanonicalName());

        CsvMapper mapper = new CsvMapper();

        if(emptyFieldsAsNull) {

            SimpleModule module = new SimpleModule();
            module.addDeserializer(String.class, new StringAsNullDeserialiser(String.class));
            mapper.registerModule(module);
        }
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
