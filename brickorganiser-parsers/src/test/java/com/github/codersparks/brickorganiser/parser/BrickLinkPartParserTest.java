package com.github.codersparks.brickorganiser.parser;

import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkPart;
import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

/**
 * Created by codersparks on 03/01/2017.
 */
public class BrickLinkPartParserTest {

    private static final Logger logger = LoggerFactory.getLogger(BrickLinkCategoryParserTest.class);

    @BeforeClass
    public static void beforeClass() {
        BasicConfigurator.configure();
    }
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void loadObjectList() throws Exception {

        String testString = "Category ID\tCategory Name\tNumber\tName\tDimensions\n" +
                "\n" +
                "\n" +
                "5\tBrick\t3001\tBrick 2 x 4\t2 x 4 x 1\n" +
                "22\tHinge\t3830c01\tHinge Brick 1 x 4 Swivel - Complete Assembly\t1.5 x 4 x 1\n" +
                "36\tTechnic\t32474pb01\tTechnic Ball Joint with Black and Silver TT-8L/Y7 Gatekeeper Droid Pattern - Set 4475\t1.26 x 1.26 x 1\n" +
                "160\tSticker\t3148stk01\tSticker for Set 3148 - (22955/4141448)\t12 x 12.5 x 0\n" +
                "535\tBrick, Modified, Decorated\t30600pb08\tBrick, Modified 2 x 2 No Studs, Sloped with Flared Wings and Ghost Pattern\t2.33 x 4 x 1.5\n"
                ;

        BrickLinkPart expected1 = new BrickLinkPart("Brick", "3001", "Brick 2 x 4", 5, "2 x 4 x 1");
        BrickLinkPart expected2 = new BrickLinkPart("Hinge", "3830c01", "Hinge Brick 1 x 4 Swivel - Complete Assembly", 22, "1.5 x 4 x 1");
        BrickLinkPart expected3 = new BrickLinkPart("Technic", "32474pb01", "Technic Ball Joint with Black and Silver TT-8L/Y7 Gatekeeper Droid Pattern - Set 4475" ,36 ,  "1.26 x 1.26 x 1");
        BrickLinkPart expected4 = new BrickLinkPart("Sticker", "3148stk01", "Sticker for Set 3148 - (22955/4141448)", 160, "12 x 12.5 x 0");
        BrickLinkPart expected5 = new BrickLinkPart("Brick, Modified, Decorated", "30600pb08", "Brick, Modified 2 x 2 No Studs, Sloped with Flared Wings and Ghost Pattern", 535, "2.33 x 4 x 1.5");

        InputStream in = new ByteArrayInputStream(testString.getBytes());

        BrickLinkPartParser brickLinkCategoryParser = new BrickLinkPartParser();

        List<BrickLinkPart> categoryList = brickLinkCategoryParser.loadObjectList(in);

        logger.info("Category list produced: {}", categoryList);

        assertEquals("Size of Category list not as expected",5, categoryList.size());
        assertThat(categoryList, contains(expected1, expected2, expected3, expected4, expected5));
    }

}