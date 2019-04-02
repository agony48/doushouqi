package com.color_analysis_in_xinjiangtimes.network;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;

import java.lang.reflect.Field;

/**
 * Created by kalen on 16/3/7.
 */
public class AnnotateNaming implements FieldNamingStrategy {

    @Override
    public String translateName(Field field) {
        ParamName a = field.getAnnotation(ParamName.class);
        return a != null ? a.value() : FieldNamingPolicy.IDENTITY.translateName(field);
    }
}
