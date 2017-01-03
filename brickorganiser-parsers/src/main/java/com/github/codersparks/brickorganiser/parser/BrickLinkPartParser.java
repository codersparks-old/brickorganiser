package com.github.codersparks.brickorganiser.parser;

import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkPart;
import org.springframework.stereotype.Component;

/**
 * <p>Parser for parsing BrickLink parts from the downloaded TSV file available from: http://www.bricklink.com/catalogDownload.asp</p>
 */
@Component
public class BrickLinkPartParser extends BrickLinkBaseParser<BrickLinkPart> {

    public BrickLinkPartParser() {
        super(BrickLinkPart.class, true);
    }
}
