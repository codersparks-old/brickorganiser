package com.github.codersparks.brickorganiser.model.bricklink;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representation of Part element of catalogue available from https://www.bricklink.com/catalogDownload.asp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrickLinkPart {

    private String itemType;
    private String itemID;
    private String itemName;
    private int category;
    private Integer itemDimX;
    private Integer itemDimY;
    private Integer itemDimZ;
}
