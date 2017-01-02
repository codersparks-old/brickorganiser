package com.github.codersparks.brickorganiser.model.bricklink;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representation of Item element of catalogue available from https://www.bricklink.com/catalogDownload.asp
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrickLinkItem {

    private String type;
    private String id;
    private String name;
    private int category;
    private String dimX;
    private String dimY;
    private String dimZ;

}
