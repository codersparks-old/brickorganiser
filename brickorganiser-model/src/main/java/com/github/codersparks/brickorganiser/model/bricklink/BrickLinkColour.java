package com.github.codersparks.brickorganiser.model.bricklink;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by codersparks on 04/01/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrickLinkColour {

    private int id;
    private String name;
    private String rgbValue;
    private String type;
    private Integer partCount;
    private String yearFrom;
    private String yearTo;

}
