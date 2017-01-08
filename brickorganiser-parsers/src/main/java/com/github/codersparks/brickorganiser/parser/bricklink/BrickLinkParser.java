package com.github.codersparks.brickorganiser.parser.bricklink;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by codersparks on 04/01/2017.
 */
public interface BrickLinkParser<T> {

    List<T> parse(InputStream inputStream) throws IOException;
}
