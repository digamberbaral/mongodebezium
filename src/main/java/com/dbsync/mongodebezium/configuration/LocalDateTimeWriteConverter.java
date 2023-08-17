package com.dbsync.mongodebezium.configuration;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.data.convert.WritingConverter;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

@WritingConverter
public class LocalDateTimeWriteConverter implements Converter<OffsetDateTime, Date> {
    @Override
    public Date convert(OffsetDateTime offsetDateTime) {
        return Date
                .from(offsetDateTime.toLocalDateTime().atZone(ZoneId.systemDefault())
                        .toInstant());
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
