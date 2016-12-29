package com.github.codersparks.brickorganiser.model;

import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkPart;
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

    public Part(BrickLinkPart brickLinkPart) {

        this.id = brickLinkPart.getItemID();
        this.category = brickLinkPart.getCategory();
        this.description = brickLinkPart.getItemName();
        Integer dimX = brickLinkPart.getItemDimX();
        if(dimX != null) {
            this.dimX = dimX.intValue();
        }

        Integer dimY = brickLinkPart.getItemDimY();
        if(dimY != null) {
            this.dimY = dimY.intValue();
        }
        Integer dimZ = brickLinkPart.getItemDimZ();
        if(dimZ != null) {
            this.dimZ = dimZ.intValue();
        }
    }

    @Id
    private String id;

    private String description;

    private int category;

    private Integer dimX = null;
    private Integer dimY = null;
    private Integer dimZ = null;

}
