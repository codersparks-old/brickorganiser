package com.github.codersparks.brickorganiser.interfaces.bricklink;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by markwhiteley on 07/01/2017.
 */
public interface BrickLinkService {

    void loadBrickLinkPartData(InputStream inputStream) throws IOException;
}
