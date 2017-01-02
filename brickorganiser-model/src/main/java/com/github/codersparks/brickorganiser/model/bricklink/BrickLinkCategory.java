package com.github.codersparks.brickorganiser.model.bricklink;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by codersparks on 02/01/2017.
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
