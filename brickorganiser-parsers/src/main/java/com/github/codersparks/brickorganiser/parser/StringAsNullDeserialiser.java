package com.github.codersparks.brickorganiser.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * Created by codersparks on 04/01/2017.
 */
public class StringAsNullDeserialiser extends StdDeserializer<String> {

    protected StringAsNullDeserialiser(Class<?> vc) {
        super(vc);
    }

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String result = StringDeserializer.instance.deserialize(jsonParser, deserializationContext);
        if(StringUtils.isEmpty(result)) {
            return null;
        }

        return result;
    }
}
