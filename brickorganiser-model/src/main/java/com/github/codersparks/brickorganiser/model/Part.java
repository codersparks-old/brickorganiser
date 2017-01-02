package com.github.codersparks.brickorganiser.model;

import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkItem;
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

    public Part(BrickLinkItem brickLinkPart) {

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
        } else { // null or length <= 0
            dimX = null;
        }
        String brickLinkDimY = brickLinkPart.getItemDimY();
        if(brickLinkDimY != null && brickLinkDimY.length() > 0) {
            try {
                dimY = Integer.parseInt(brickLinkDimY);
            } catch(Exception e) {
                logger.warn(String.format("Exception caught when trying to parse Y Dimension from BrickLink part with ID: %s setting to null", brickLinkPart.getItemID()), e);
                dimY = null;
            }
        }else { // null or length <= 0
            dimY = null;
        }
        String brickLinkDimZ = brickLinkPart.getItemDimZ();
        if(brickLinkDimZ != null && brickLinkDimZ.length() > 0) {
            try {
                dimZ = Integer.parseInt(brickLinkDimZ);
            } catch(Exception e) {
                logger.warn(String.format("Exception caught when trying to parse Z Dimension from BrickLink part with ID: %s setting to null", brickLinkPart.getItemID()), e);
                dimZ = null;
            }
         }else { // null or length <= 0
            dimY = null;
        }
    }

    @Id
    private String id;

    @Indexed
    private String description;

    @Indexed
    private int category;

    private Integer dimX = null;
    private Integer dimY = null;
    private Integer dimZ = null;

}
