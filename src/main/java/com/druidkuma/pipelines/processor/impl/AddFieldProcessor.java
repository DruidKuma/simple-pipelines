package com.druidkuma.pipelines.processor.impl;

import com.druidkuma.pipelines.processor.Constants;
import com.druidkuma.pipelines.processor.Processor;

import java.util.Map;

/**
 * Created by Yurii Miedviediev
 *
 * @author DruidKuma
 * @version 1.0.0
 * @since 13.04.2020
 */
public class AddFieldProcessor implements Processor {

    private String fieldName;
    private String fieldValue;

    public void initialize(Map<String, String> configuration) {
        assert configuration.containsKey(Constants.FIELD_NAME);
        assert configuration.containsKey(Constants.FIELD_VALUE);

        this.fieldName = configuration.get(Constants.FIELD_NAME);
        this.fieldValue = configuration.get(Constants.FIELD_VALUE);
    }

    public void process(Map<String, Object> jsonDocument) {
        jsonDocument.put(fieldName, fieldValue);
    }
}
