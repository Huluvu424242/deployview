//package com.github.huluvu424242.deployview.restapi;
//
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//
//@Converter
//public class UmgebungConverter implements
//        AttributeConverter<Umgebung, String> {
//
//
//    @Override
//    public String convertToDatabaseColumn(Umgebung umgebung) {
//        if (umgebung == null) {
//            return null;
//        } else {
//            return umgebung.getId();
//        }
//    }
//
//    @Override
//    public Umgebung convertToEntityAttribute(String id) {
//        if (id == null || id.isEmpty()) {
//            return null;
//        } else {
//            return new Umgebung(id);
//        }
//    }
//}
