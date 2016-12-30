package com.github.codersparks.brickorganiser.model.bricklink;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

/**
 * Created by codersparks on 30/12/2016.
 */
public class BrickLinkCatalogTest {

    Marshaller marshaller;
    Unmarshaller unmarshaller;

    private String expectedId;
    private String expectedType;
    private int expectedCategory;
    private String expectedName;
    private String expectedDimX;
    private String expectedDimY;
    private String expectedDimZ;

    @Before
    public void setUp() throws Exception {

        expectedId = "id";
        expectedType = "type";
        expectedCategory = 1;
        expectedName = "name";
        expectedDimX = "1";
        expectedDimY = null;
        expectedDimZ = "3";

        JAXBContext jaxbContext = JAXBContext.newInstance(BrickLinkCatalog.class);
        marshaller = jaxbContext.createMarshaller();
        unmarshaller = jaxbContext.createUnmarshaller();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMarshall() throws JAXBException {

        BrickLinkItem brickLinkItem = new BrickLinkItem(expectedType, expectedId, expectedName, expectedCategory, expectedDimX, expectedDimY, expectedDimZ);
        BrickLinkItem brickLinkItem2 = new BrickLinkItem(expectedType + "2", expectedId + "2", expectedName + "2", expectedCategory + 2, expectedDimY, expectedDimX + "2", expectedDimZ + "2");
        BrickLinkCatalog brickLinkCatalog = new BrickLinkCatalog();
        brickLinkCatalog.getItems().add(brickLinkItem);
        brickLinkCatalog.getItems().add(brickLinkItem2);

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(brickLinkCatalog, stringWriter);

        String xmlString = stringWriter.toString();

        assertThat(xmlString,
                allOf(
                        containsString("<CATALOG><ITEM>"),
                        containsString("<ITEM><ITEMTYPE>type</ITEMTYPE><ITEMID>id</ITEMID><ITEMNAME>name</ITEMNAME><CATEGORY>1</CATEGORY><ITEMDIMX>1</ITEMDIMX><ITEMDIMY></ITEMDIMY><ITEMDIMZ>3</ITEMDIMZ></ITEM>"),
                        containsString("<ITEM><ITEMTYPE>type2</ITEMTYPE><ITEMID>id2</ITEMID><ITEMNAME>name2</ITEMNAME><CATEGORY>3</CATEGORY><ITEMDIMX></ITEMDIMX><ITEMDIMY>12</ITEMDIMY><ITEMDIMZ>32</ITEMDIMZ></ITEM>"),
                        containsString("</ITEM></CATALOG>")
                )
        );
    }

    @Test
    public void testUnMarshall() throws JAXBException {

        String testXmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CATALOG><ITEM><ITEMTYPE>type</ITEMTYPE><ITEMID>id</ITEMID><ITEMNAME>name</ITEMNAME><CATEGORY>1</CATEGORY><ITEMDIMX>1</ITEMDIMX><ITEMDIMY></ITEMDIMY><ITEMDIMZ>3</ITEMDIMZ></ITEM><ITEM><ITEMTYPE>type2</ITEMTYPE><ITEMID>id2</ITEMID><ITEMNAME>name2</ITEMNAME><CATEGORY>3</CATEGORY><ITEMDIMX></ITEMDIMX><ITEMDIMY>12</ITEMDIMY><ITEMDIMZ>32</ITEMDIMZ></ITEM></CATALOG>";

        BrickLinkItem brickLinkItem = new BrickLinkItem(expectedType, expectedId, expectedName, expectedCategory, expectedDimX, expectedDimY, expectedDimZ);
        BrickLinkItem brickLinkItem2 = new BrickLinkItem(expectedType + "2", expectedId + "2", expectedName + "2", expectedCategory + 2, expectedDimY, expectedDimX + "2", expectedDimZ + "2");

        BrickLinkCatalog brickLinkCatalog = (BrickLinkCatalog) unmarshaller.unmarshal(new StreamSource(new StringReader(testXmlString)));

        assertTrue(brickLinkCatalog.getItems().containsAll(Arrays.asList(brickLinkItem, brickLinkItem2)));
        assertEquals(2, brickLinkCatalog.getItems().size());


    }

}