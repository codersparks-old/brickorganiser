package com.github.codersparks.brickorganiser.model.bricklink;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representation of part from catalogue available from https://www.bricklink.com/catalogDownload.asp
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "categoryId", "categoryName", "id", "name", "dimensions"})
public class BrickLinkPart {

    private String categoryName;
    private String id;
    private String name;
    private int categoryId;
    private String dimensions;

}
