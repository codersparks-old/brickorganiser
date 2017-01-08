package com.github.codersparks.brickorganiser.parser.bricklink;

import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkColour;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

/**
 * Created by codersparks on 04/01/2017.
 */
public class BrickLinkColourParserTest {

    private static final Logger logger = LoggerFactory.getLogger(BrickLinkColourParserTest.class);

    private BrickLinkColourParser underTest;

    @Before
    public void setup() {
        underTest = new BrickLinkColourParser();
    }

    @Test
    public void parse() throws Exception {

        String testString = "Color ID\tColor Name\tRGB\tType\tParts\tIn Sets\tWanted\tFor Sale\tYear From\tYear To\n" +
                "\n" +
                "0\t(Not Applicable)\t\tN/A\t3165\t8974\t34246\t8589\t1954\t2017\n" +
                "41\tAqua\tb5d3d6\tSolid\t86\t52\t297\t121\t1998\t2006\n" +
                "11\tBlack\t212121\tSolid\t7097\t8575\t8645\t7251\t1957\t2017\n" +
                "140\tMx Olive Green\t7C9051\tModulex\t\t\t13\t19\t\t";

        BrickLinkColour expected1 = new BrickLinkColour(0, "(Not Applicable)", null, "N/A", 3165, "1954", "2017");
        BrickLinkColour expected2 = new BrickLinkColour(41, "Aqua", "b5d3d6", "Solid", 86, "1998", "2006");
        BrickLinkColour expected3 = new BrickLinkColour(11, "Black", "212121", "Solid", 7097, "1957", "2017");
        BrickLinkColour expected4 = new BrickLinkColour(140, "Mx Olive Green", "7C9051", "Modulex", null, null, null);

        List<BrickLinkColour> expectedValues = Arrays.asList(expected1, expected2, expected3, expected4);

        InputStream in = new ByteArrayInputStream(testString.getBytes());

        List<BrickLinkColour> colours = underTest.parse(in);

        logger.info("Constructed list: {}", colours);

        assertEquals("Length of produced BrickLinkColour list is not as expected", 4, colours.size());

        final AtomicInteger count = new AtomicInteger(0);
        colours.parallelStream().forEach(colour -> {
            int index = colours.indexOf(colour);
            logger.info("Processing index: " + index);
            BrickLinkColour expected = expectedValues.get(index);
            assertEquals("Id is not as expected for element " + count, expected.getId(), colour.getId());
            assertEquals("Name is not as expected for element " + count, expected.getName(), colour.getName());
            assertEquals("RGBValue is not as expected for element " + count, expected.getRgbValue(), colour.getRgbValue());
            assertEquals("Type is not as expected for element " + count, expected.getType(), colour.getType());
            assertEquals("Part Count is not as expected for element " + count, expected.getPartCount(), colour.getPartCount());
            assertEquals("Year From is not as expected for element " + count, expected.getYearFrom(), colour.getYearFrom());
            assertEquals("Year To is not as expected for element " + count, expected.getYearTo(), colour.getYearTo());

        });
    }

}