package com.dbsync.mongodebezium.configuration;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

@ReadingConverter
public class LocalDateTimeReadConverter implements Converter<Date, OffsetDateTime> {
    @Override
    public OffsetDateTime convert(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toOffsetDateTime();
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }
}
