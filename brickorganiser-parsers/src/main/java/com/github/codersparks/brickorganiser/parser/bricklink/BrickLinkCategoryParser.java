package com.github.codersparks.brickorganiser.parser.bricklink;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkCategory;
import com.github.codersparks.brickorganiser.parser.CsvParser;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>Parser for parsing BrickLinkCategories from the downloaded TSV file available from: http://www.bricklink.com/catalogDownload.asp</p>
 */
@Component
public class BrickLinkCategoryParser implements BrickLinkParser<BrickLinkCategory> {

    private static final char columnSeperator = '\t';
    private final CsvParser<BrickLinkCategory> csvParser;

    public BrickLinkCategoryParser() {

        CsvSchema csvSchema = CsvSchema.builder()
                .addColumn("id").addColumn("name")
                .setColumnSeparator(columnSeperator)
                .build();

        this.csvParser = new CsvParser<>(BrickLinkCategory.class, true, csvSchema);
    }

    public List<BrickLinkCategory> parse(InputStream in) throws IOException {
        return this.csvParser.loadObjectList(in);
    }
}
