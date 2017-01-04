package com.github.codersparks.brickorganiser.parser;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkPart;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Parser for parsing BrickLink parts from the downloaded TSV file available from: http://www.bricklink.com/catalogDownload.asp</p>
 */
@Component
public class BrickLinkPartParser implements BrickLinkParser<BrickLinkPart> {

    private static final char columnSeperator = '\t';

    private final CsvSchema csvSchema = CsvSchema.emptySchema();
    private final BrickLinkBaseParser<BrickLinkPart> baseParser;

    public BrickLinkPartParser() {
        CsvSchema csvSchema = CsvSchema.builder()
                .addColumn("categoryId")
                .addColumn("categoryName")
                .addColumn("id")
                .addColumn("name")
                .addColumn("dimensions")
                .setColumnSeparator(columnSeperator)
                .build();

        baseParser = new BrickLinkBaseParser<>(BrickLinkPart.class, true, csvSchema);
    }

    @Override
    public List<BrickLinkPart> parse(InputStream inputStream) throws IOException {
        return baseParser.loadObjectList(inputStream);
    }
}
