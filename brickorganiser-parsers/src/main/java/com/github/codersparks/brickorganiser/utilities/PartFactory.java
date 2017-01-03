package com.github.codersparks.brickorganiser.utilities;

import com.github.codersparks.brickorganiser.exception.BrickOrganiserException;
import com.github.codersparks.brickorganiser.model.Part;
import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkCategory;
import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkPart;
import com.github.codersparks.brickorganiser.repository.bricklink.BrickLinkCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Part factory allows the user to create a BrickOrganiser part from a BrickLink part
 */
public class PartFactory {

    private static final Logger logger = LoggerFactory.getLogger(PartFactory.class);

    private static final Pattern dimensionsPattern = Pattern.compile("([^x\\s]+) x ([^x\\s]+) x ([^x\\s]+)");

    @Autowired
    private BrickLinkCategoryRepository brickLinkCategoryRepository;

    public Part constructPart(BrickLinkPart brickLinkPart) throws BrickOrganiserException {



        // If we get here then we can construct the part
        Part part = new Part();

        part.setId(brickLinkPart.getId());


        // Set the category name to be the string name found from looking up the category id
        part.setCategory(brickLinkPart.getCategoryName());
        part.setDescription(brickLinkPart.getName());

        String brickLinkDimensions = brickLinkPart.getDimensions();

        Matcher dimensionsMatcher = dimensionsPattern.matcher(brickLinkDimensions);
        dimensionsMatcher.find();

        String dimXString = dimensionsMatcher.group(1);
        logger.info("DimX string extracted as: {}", dimXString);

        if("?".equals(dimXString)) {
            logger.debug("Unknown character (?) detected for dimX setting part dimX value to null");
            part.setDimX(null);
        } else {
            logger.debug("DimX value is not unknown char (?) so attempting to parse as a Float");
            try {
                float dimX = Float.parseFloat(dimXString);
                part.setDimX(dimX);

            } catch (NumberFormatException e) {
                logger.debug("Number format exception caught when parsing dimX as Float, setting part dimX value to null", e);
                part.setDimX(null);
            }
        }

        String dimYString = dimensionsMatcher.group(2);
        logger.info("DimY string extracted as: {}", dimYString);

        if("?".equals(dimYString)) {
            logger.debug("Unknown character (?) detected for dimY setting part dimY value to null");
            part.setDimY(null);
        } else {
            logger.debug("DimY value is not unknown char (?) so attempting to parse as a Float");
            try {
                float dimY = Float.parseFloat(dimYString);
                part.setDimY(dimY);

            } catch (NumberFormatException e) {
                logger.debug("Number format exception caught when parsing dimY as Float, setting part dimY value to null", e);
                part.setDimY(null);
            }
        }

        String dimZString = dimensionsMatcher.group(3);
        logger.info("DimZ string extracted as: {}", dimZString);

        if("?".equals(dimZString)) {
            logger.debug("Unknown character (?) detected for dimZ setting part dimZ value to null");
            part.setDimZ(null);
        } else {
            logger.debug("DimZ value is not unknown char (?) so attempting to parse as a Float");
            try {
                float dimZ = Float.parseFloat(dimZString);
                part.setDimZ(dimZ);

            } catch (NumberFormatException e) {
                logger.debug("Number format exception caught when parsing dimZ as Float, setting part dimZ value to null", e);
                part.setDimZ(null);
            }
        }

        return part;
    }
}
