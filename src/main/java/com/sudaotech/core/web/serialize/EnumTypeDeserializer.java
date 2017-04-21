package com.sudaotech.core.web.serialize;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.sudaotech.core.EnumType;
import com.sudaotech.core.enums.Gender;

public class EnumTypeDeserializer extends JsonDeserializer<Gender> {

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

	@Override
	public Gender deserialize(JsonParser parser, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		
		
		ObjectCodec oc = parser.getCodec();
        JsonNode node = oc.readTree(parser);
        
//        Iterator<String> iterator = node.getFieldNames();
//        while (iterator.hasNext()) {
//        	System.out.println(iterator.next());
//        }
        
        String textValue = node.get("name").getTextValue();
        
		return Gender.valueOf(textValue.toUpperCase());
	}

//	@Override
//	public EnumType deserialize(JsonParser parser, DeserializationContext arg1)
//			throws IOException, JsonProcessingException {
//		JsonToken jsonToken = parser.nextValue();
//		String name = jsonToken.name();
//		String asString = jsonToken.asString();
//		System.out.println(name);
//		System.out.println(asString);
//		return null;
//	}

}
