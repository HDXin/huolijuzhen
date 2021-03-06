package com.sudaotech.core.web.serialize;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class DateSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jgen, SerializerProvider arg2) throws IOException,
            JsonProcessingException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(date);
        jgen.writeString(formattedDate);
    }

}
