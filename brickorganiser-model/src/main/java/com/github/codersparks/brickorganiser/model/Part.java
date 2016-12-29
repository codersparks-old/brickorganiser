package com.github.codersparks.brickorganiser.model;

import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkPart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

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
    
    private static final Logger logger = LoggerFactory.getLogger(Part.class);

    public Part(BrickLinkPart brickLinkPart) {

        this.id = brickLinkPart.getItemID();
        this.category = brickLinkPart.getCategory();
        this.description = brickLinkPart.getItemName();
        
        String brickLinkDimX = brickLinkPart.getItemDimX();
        if(brickLinkDimX != null && brickLinkDimX.length() > 0) {
            try {
                dimX = Integer.parseInt(brickLinkDimX);
            } catch(Exception e) {
                logger.warn(String.format("Exception caught when trying to parse X Dimension from BrickLink part with ID: %s setting to null", brickLinkPart.getItemID()), e);
                dimX = null;
            }
        }
        String brickLinkDimY = brickLinkPart.getItemDimY();
        if(brickLinkDimY != null && brickLinkDimY.length() > 0) {
            try {
                dimY = Integer.parseInt(brickLinkDimY);
            } catch(Exception e) {
                logger.warn(String.format("Exception caught when trying to parse Y Dimension from BrickLink part with ID: %s setting to null", brickLinkPart.getItemID()), e);
                dimY = null;
            }
        }
        String brickLinkDimZ = brickLinkPart.getItemDimZ();
        if(brickLinkDimZ != null && brickLinkDimZ.length() > 0) {
            try {
                dimZ = Integer.parseInt(brickLinkDimZ);
            } catch(Exception e) {
                logger.warn(String.format("Exception caught when trying to parse Z Dimension from BrickLink part with ID: %s setting to null", brickLinkPart.getItemID()), e);
                dimZ = null;
            }
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
