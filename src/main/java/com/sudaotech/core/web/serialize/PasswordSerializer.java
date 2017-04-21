package com.sudaotech.core.web.serialize;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class PasswordSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String date, JsonGenerator jgen, SerializerProvider arg2) throws IOException,
            JsonProcessingException {
        jgen.writeString("***");
    }

}
