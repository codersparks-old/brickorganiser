package com.github.codersparks.brickorganiser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * Created by codersparks on 27/12/2016.
 */
@Entity
@Table(indexes={
        @Index(name="description_index", columnList = "description", unique = false),
        @Index(name="category_index", columnList = "category", unique = false)
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Part {

    @Id
    private String id;

    private String description;

    private int category;
}
