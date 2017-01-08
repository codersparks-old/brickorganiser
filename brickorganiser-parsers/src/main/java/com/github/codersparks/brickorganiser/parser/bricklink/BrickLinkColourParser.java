package com.github.codersparks.brickorganiser.parser.bricklink;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkColour;
import com.github.codersparks.brickorganiser.parser.CsvParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by codersparks on 04/01/2017.
 */
public class BrickLinkColourParser implements BrickLinkParser<BrickLinkColour> {

    private static final char columnSeperator = '\t';
    private final CsvParser<BrickLinkColour> csvParser;

    public BrickLinkColourParser() {

        CsvSchema csvSchema = CsvSchema.builder()
                .addColumn("id")
                .addColumn("name")
                .addColumn("rgbValue")
                .addColumn("type")
                .addColumn("partCount")
                .addColumn("inSets")
                .addColumn("wanted")
                .addColumn("forSale")
                .addColumn("yearFrom")
                .addColumn("yearTo")
                .setColumnSeparator(columnSeperator)
                .build();

        this.csvParser = new CsvParser<>(BrickLinkColour.class, true, csvSchema);
    }

    @Override
    public List<BrickLinkColour> parse(InputStream inputStream) throws IOException {
        return this.csvParser.loadObjectList(inputStream);
    }
}
