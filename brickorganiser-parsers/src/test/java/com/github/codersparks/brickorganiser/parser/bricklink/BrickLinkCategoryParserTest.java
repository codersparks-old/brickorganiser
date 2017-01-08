package com.github.codersparks.brickorganiser.parser.bricklink;

import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkCategory;
import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;

/**
 * Created by codersparks on 03/01/2017.
 */
public class BrickLinkCategoryParserTest {

    private static final Logger logger = LoggerFactory.getLogger(BrickLinkCategoryParserTest.class);

    @BeforeClass
    public static void beforeLoading() {
        BasicConfigurator.configure();
    }

    @Test
    public void loadObjectList() throws Exception {

        String testString = "Category ID\tCategory Name\n" +
                "\n" +
                "143\t(Other)\n" +
                "535\tBrick, Modified, Decorated\n" +
                "128\tTrain, Track\n" +
                "133\tTechnic, Connector\n" +
                "561\t1955";

        BrickLinkCategory expected1 = new BrickLinkCategory(143, "(Other)");
        BrickLinkCategory expected2 = new BrickLinkCategory(535, "Brick, Modified, Decorated");
        BrickLinkCategory expected3 = new BrickLinkCategory(128, "Train, Track");
        BrickLinkCategory expected4 = new BrickLinkCategory(133, "Technic, Connector");
        BrickLinkCategory expected5 = new BrickLinkCategory(561, "1955");

        InputStream in = new ByteArrayInputStream(testString.getBytes());

        BrickLinkCategoryParser brickLinkCategoryParser = new BrickLinkCategoryParser();

        List<BrickLinkCategory> categoryList = brickLinkCategoryParser.parse(in);

        logger.info("Category list produced: {}", categoryList);

        assertEquals("Size of Category list not as expected",5, categoryList.size());
        assertThat(categoryList, contains(expected1, expected2, expected3, expected4, expected5));



    }



}