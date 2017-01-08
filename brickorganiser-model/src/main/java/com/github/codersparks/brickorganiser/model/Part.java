package com.github.codersparks.brickorganiser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by codersparks on 27/12/2016.
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Part {
    
    private static final Logger logger = LoggerFactory.getLogger(Part.class);

    @Id
    private String id;

    @Indexed
    private String description;

    @Indexed
    private String category;

    /**
     * This field is used when brickLink use a different id to Rebrickable
     */
    private String brickLinkId;

    private Float dimX = null;
    private Float dimY = null;
    private Float dimZ = null;

}
