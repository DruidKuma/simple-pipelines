package com.druidkuma.pipelines.processor.impl;

import com.druidkuma.pipelines.processor.Processor;

import java.util.Map;

/**
 * Created by Yurii Miedviediev
 *
 * Fake Processor for No Operation
 *
 * @author DruidKuma
 * @version 1.0.0
 * @since 13.04.2020
 */
public class NoOpProcessor implements Processor {
    @Override
    public void initialize(Map<String, String> configuration) {
        //No operation
    }

    @Override
    public void process(Map<String, Object> jsonDocument) {
        //No operation
    }
}
