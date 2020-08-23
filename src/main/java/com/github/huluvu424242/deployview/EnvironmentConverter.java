package com.github.huluvu424242.deployview;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EnvironmentConverter implements
        AttributeConverter<Environment, String> {


    @Override
    public String convertToDatabaseColumn(Environment environment) {
        if (environment == null) {
            return null;
        } else {
            return environment.getId();
        }
    }

    @Override
    public Environment convertToEntityAttribute(String dbEnvironment) {
        if (dbEnvironment == null || dbEnvironment.isEmpty()) {
            return null;
        } else {
            return new Environment(dbEnvironment);
        }
    }
}
