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
public class RemoveFieldProcessor implements Processor {

    private String fieldName;

    public void initialize(Map<String, String> configuration) {
        assert configuration.containsKey(Constants.FIELD_NAME);

        this.fieldName = configuration.get(Constants.FIELD_NAME);
    }

    public void process(Map<String, Object> jsonDocument) {
        jsonDocument.remove(fieldName);
    }
}
