package com.github.codersparks.brickorganiser.model.bricklink;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Representation of Item element of catalogue available from https://www.bricklink.com/catalogDownload.asp
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class BrickLinkItem {

    @XmlElement(name = "ITEMTYPE")
    private String itemType;

    @XmlElement(name = "ITEMID")
    private String itemID;

    @XmlElement(name = "ITEMNAME")
    private String itemName;

    @XmlElement(name = "CATEGORY")
    private int category;

    @XmlElement(name = "ITEMDIMX")
    private String itemDimX;

    @XmlElement(name = "ITEMDIMY")
    private String itemDimY;

    @XmlElement(name = "ITEMDIMZ")
    private String itemDimZ;

    /**
     * Unfortunately BrickLink use empty field for dimensions not present therefore to ensure that this is present in
     * the xml we have to convert null values to empty strings (beforeMarshal function) and then empty strings back to
     * null values after unmarshalling (afterMarshal function)
     * @param marshaller
     */
    private void beforeMarshal(Marshaller marshaller) {
        if(null == itemDimX) {
            itemDimX = "";
        }
        if(null == itemDimY) {
            itemDimY = "";
        }
        if(null == itemDimZ) {
            itemDimZ = "";
        }
    }


    /**
     * Unfortunately BrickLink use empty field for dimensions not present therefore to ensure that this is present in
     * the xml we have to convert null values to empty strings (beforeMarshal function) and then empty strings back to
     * null values after unmarshalling (afterMarshal function)
     * @param marshaller
     */
    private void afterMarshal(Marshaller marshaller) {
        if("".equals(itemDimX)) {
            itemDimX = null;
        }
        if("".equals(itemDimY)) {
            itemDimY = null;
        }
        if("".equals(itemDimZ)) {
            itemDimZ = null;
        }
    }

    /**
     * As for the beforeMarshal and afterMarshal we need to modify the dimension fields (if they are empty then we convert
     * them to null values)
     * @param unmarshaller
     * @param parent
     */
    private void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {

        if("".equals(itemDimX)) {
            itemDimX = null;
        }
        if("".equals(itemDimY)) {
            itemDimY = null;
        }
        if("".equals(itemDimZ)) {
            itemDimZ = null;
        }
    }


}
