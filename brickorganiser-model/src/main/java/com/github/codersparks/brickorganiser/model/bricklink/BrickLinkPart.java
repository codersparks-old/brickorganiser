package com.github.codersparks.brickorganiser.model.bricklink;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Representation of part from catalogue available from https://www.bricklink.com/catalogDownload.asp
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrickLinkPart {

    private String categoryName;

    @Id
    private String id;
    private String name;
    private int categoryId;
    private String dimensions;

}
