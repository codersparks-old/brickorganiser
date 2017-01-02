package com.github.codersparks.brickorganiser.parser.utilities;

import com.github.codersparks.brickorganiser.exception.BrickOrganiserException;
import com.github.codersparks.brickorganiser.model.Part;
import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkCategory;
import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkItem;
import com.github.codersparks.brickorganiser.repository.bricklink.BrickLinkCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by codersparks on 02/01/2017.
 */
public class PartFactory {

    private static final Logger logger = LoggerFactory.getLogger(PartFactory.class);

    @Autowired
    private BrickLinkCategoryRepository brickLinkCategoryRepository;

    public Part constructPart(BrickLinkItem brickLinkPart) throws BrickOrganiserException {

        BrickLinkCategory brickLinkCategory = brickLinkCategoryRepository.findOne(brickLinkPart.getCategory());

        if(brickLinkCategory == null) {
            throw new BrickOrganiserException(String.format("Cannot find category with id: %s", brickLinkPart.getCategory()));
        }

        // If we get here then we can construct the part
        Part part = new Part();

        part.setId(brickLinkPart.getId());


        // Set the category name to be the string name found from looking up the category id
        part.setCategory(brickLinkCategory.getName());
        part.setDescription(brickLinkPart.getName());

        String brickLinkDimX = brickLinkPart.getDimX();
        Integer dimX = null;
        if(brickLinkDimX != null && brickLinkDimX.length() > 0) {
            try {
                dimX = Integer.parseInt(brickLinkDimX);
            } catch(Exception e) {
                logger.warn(String.format("Exception caught when trying to parse X Dimension from BrickLink part with ID: %s setting to null", brickLinkPart.getId()), e);
                dimX = null;
            }
        }
        part.setDimX(dimX);

        String brickLinkDimY = brickLinkPart.getDimY();
        Integer dimY = null;
        if(brickLinkDimY != null && brickLinkDimY.length() > 0) {
            try {
                dimY = Integer.parseInt(brickLinkDimY);
            } catch(Exception e) {
                logger.warn(String.format("Exception caught when trying to parse Y Dimension from BrickLink part with ID: %s setting to null", brickLinkPart.getId()), e);
                dimY = null;
            }
        }
        part.setDimY(dimY);

        String brickLinkDimZ = brickLinkPart.getDimZ();
        Integer dimZ = null;
        if(brickLinkDimZ != null && brickLinkDimZ.length() > 0) {
            try {
                dimZ = Integer.parseInt(brickLinkDimZ);
            } catch(Exception e) {
                logger.warn(String.format("Exception caught when trying to parse Z Dimension from BrickLink part with ID: %s setting to null", brickLinkPart.getId()), e);
                dimZ = null;
            }
        }
        part.setDimZ(dimZ);

        return part;
    }
}
