package com.github.codersparks.brickorganiser.utilities;

import com.github.codersparks.brickorganiser.model.Part;
import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkPart;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by codersparks on 03/01/2017.
 */
public class PartFactoryTest {

    private PartFactory underTest;

    private String categoryName = "Brick";
    private String id = "99999";
    private String name = "Test Brick";
    private int categoryId = 99999999;


    @Before
    public void setup() {
        this.underTest = new PartFactory();
    }

    BrickLinkPart expected1 = new BrickLinkPart("Brick", "3001", "Brick 2 x 4", 5, "2 x 4 x 1");
    BrickLinkPart expected2 = new BrickLinkPart("Hinge", "3830c01", "Hinge Brick 1 x 4 Swivel - Complete Assembly", 22, "1.5 x 4 x 1");
    BrickLinkPart expected3 = new BrickLinkPart("Technic", "32474pb01", "Technic Ball Joint with Black and Silver TT-8L/Y7 Gatekeeper Droid Pattern - Set 4475" ,36 ,  "1.26 x 1.26 x 1");
    BrickLinkPart expected4 = new BrickLinkPart("Sticker", "3148stk01", "Sticker for Set 3148 - (22955/4141448)", 160, "12 x 12.5 x 0");
    BrickLinkPart expected5 = new BrickLinkPart("Brick, Modified, Decorated", "30600pb08", "Brick, Modified 2 x 2 No Studs, Sloped with Flared Wings and Ghost Pattern", 535, "2.33 x 4 x 1.5");


    @Test
    public void constructPartWithAllDimensions() throws Exception {

        String dimensionString = "1 x 2 x 3.5";

        BrickLinkPart brickLinkPart = new BrickLinkPart(categoryName, id, name, categoryId, dimensionString);

        Part part =underTest.constructPart(brickLinkPart);

        assertEquals("Category does not match", categoryName, part.getCategory());
        assertEquals("Id does not match", id, part.getId());
        assertEquals("Description does not match", name, part.getDescription());

        assertEquals("Dim X not as expected", (Float)1f, part.getDimX());
        assertEquals("Dim Y not as expected", (Float)2f, part.getDimY());
        assertEquals("Dim Z not as expected", (Float)3.5f, part.getDimZ());
    }

    @Test
    public void constructPartWithOnlyXDimension() throws Exception {

        String dimensionString = "1 x ? x ?";

        BrickLinkPart brickLinkPart = new BrickLinkPart(categoryName, id, name, categoryId, dimensionString);

        Part part =underTest.constructPart(brickLinkPart);

        assertEquals("Category does not match", categoryName, part.getCategory());
        assertEquals("Id does not match", id, part.getId());
        assertEquals("Description does not match", name, part.getDescription());

        assertEquals("Dim X not as expected", (Float)1f, part.getDimX());
        assertNull("Dim Y not null", part.getDimY());
        assertNull("Dim Z not null", part.getDimZ());
    }

    @Test
    public void constructPartWithOnlyYDimensionXIsNotNumber() throws Exception {

        String dimensionString = "z x 1 x ?";

        BrickLinkPart brickLinkPart = new BrickLinkPart(categoryName, id, name, categoryId, dimensionString);

        Part part =underTest.constructPart(brickLinkPart);

        assertEquals("Category does not match", categoryName, part.getCategory());
        assertEquals("Id does not match", id, part.getId());
        assertEquals("Description does not match", name, part.getDescription());

        assertEquals("Dim Y not as expected", (Float)1f, part.getDimY());
        assertNull("Dim X not null", part.getDimX());
        assertNull("Dim Z not null", part.getDimZ());
    }

    @Test
    public void constructPartWithOnlyZDimension() throws Exception {

        String dimensionString = "? x ? x 1";

        BrickLinkPart brickLinkPart = new BrickLinkPart(categoryName, id, name, categoryId, dimensionString);

        Part part =underTest.constructPart(brickLinkPart);

        assertEquals("Category does not match", categoryName, part.getCategory());
        assertEquals("Id does not match", id, part.getId());
        assertEquals("Description does not match", name, part.getDescription());

        assertEquals("Dim Z not as expected", (Float)1f, part.getDimZ());
        assertNull("Dim Y not null", part.getDimY());
        assertNull("Dim X not null", part.getDimX());
    }

    @Test
    public void constructPartAllDimsEmpty() throws Exception {

        String dimensionString = "? x ? x ?";

        BrickLinkPart brickLinkPart = new BrickLinkPart(categoryName, id, name, categoryId, dimensionString);

        Part part =underTest.constructPart(brickLinkPart);

        assertEquals("Category does not match", categoryName, part.getCategory());
        assertEquals("Id does not match", id, part.getId());
        assertEquals("Description does not match", name, part.getDescription());


        assertNull("Dim X not null", part.getDimX());
        assertNull("Dim Y not null", part.getDimY());
        assertNull("Dim Z not null", part.getDimZ());
    }

    @Test
    public void constructPartAllDimsNotANumber() throws Exception {

        String dimensionString = "asd x sdf2sdd x asdf2sds";

        BrickLinkPart brickLinkPart = new BrickLinkPart(categoryName, id, name, categoryId, dimensionString);

        Part part =underTest.constructPart(brickLinkPart);

        assertEquals("Category does not match", categoryName, part.getCategory());
        assertEquals("Id does not match", id, part.getId());
        assertEquals("Description does not match", name, part.getDescription());


        assertNull("Dim X not null", part.getDimX());
        assertNull("Dim Y not null", part.getDimY());
        assertNull("Dim Z not null", part.getDimZ());
    }

}