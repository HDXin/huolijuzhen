package com.sudaotech.core.web.serialize;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.sudaotech.core.EnumType;

public class EnumTypeSerializer extends JsonSerializer<EnumType> {

    public void serialize(EnumType obj, JsonGenerator jgen, SerializerProvider arg2) throws IOException,
            JsonProcessingException {
        jgen.writeStartObject();
//        jgen.writeFieldName("code");
//        jgen.writeNumber(obj.code());
        jgen.writeFieldName("name");
        jgen.writeString(obj.name());
        jgen.writeFieldName("text");
        jgen.writeString(obj.text());
        jgen.writeEndObject();  
    }

}
