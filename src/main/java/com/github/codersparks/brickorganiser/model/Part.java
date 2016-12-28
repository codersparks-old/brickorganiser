package com.github.codersparks.brickorganiser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by codersparks on 27/12/2016.
 */
@Document
@Data
@AllArgsConstructor
public class Part {

    @Id
    private String id;

    @Indexed
    private String description;

    @Indexed
    private int category;
}
