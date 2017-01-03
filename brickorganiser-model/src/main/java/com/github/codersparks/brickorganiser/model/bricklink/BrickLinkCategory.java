package com.github.codersparks.brickorganiser.model.bricklink;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Item to represent a BrickLink Category - This will be used to store the categories in the DB
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class BrickLinkCategory {

    @Id
    private int id;
    private String name;

}
