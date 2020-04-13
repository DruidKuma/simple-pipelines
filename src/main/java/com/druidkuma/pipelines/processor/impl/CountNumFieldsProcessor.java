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
public class CountNumFieldsProcessor implements Processor {

    private String countFieldName;

    public void initialize(Map<String, String> configuration) {
        assert configuration.containsKey(Constants.COUNT_FIELD_NAME);

        this.countFieldName = configuration.get(Constants.COUNT_FIELD_NAME);
    }

    public void process(Map<String, Object> jsonDocument) {
        jsonDocument.put(countFieldName, jsonDocument.keySet().size());
    }
}
