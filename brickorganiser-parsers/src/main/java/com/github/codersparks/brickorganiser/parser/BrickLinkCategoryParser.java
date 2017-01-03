package com.github.codersparks.brickorganiser.parser;

import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkCategory;
import org.springframework.stereotype.Component;

/**
 * <p>Parser for parsing BrickLinkCategories from the downloaded TSV file available from: http://www.bricklink.com/catalogDownload.asp</p>
 */
@Component
public class BrickLinkCategoryParser extends BrickLinkBaseParser {

    public BrickLinkCategoryParser() {
        super(BrickLinkCategory.class, true);
    }
}
