package com.github.codersparks.brickorganiser.model.bricklink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by codersparks on 30/12/2016.
 */
public class EmptyStringJAXBAdapter extends XmlAdapter<String, String> {

    private static final Logger logger = LoggerFactory.getLogger(EmptyStringJAXBAdapter.class);
    @Override
    public String unmarshal(String v) throws Exception {

        logger.info("Unmarshalling value: '{}'",v);
        if("".equals(v)) {
            return null;
        }
        return v;
    }

    @Override
    public String marshal(String v) throws Exception {

        logger.info("Marshalling value: '{}'", v);
        if(null == v) {
            return "";
        }
        return v;
    }
}
