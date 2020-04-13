package com.druidkuma.pipelines.processor;

import java.util.Map;

/**
 * Created by Yurii Miedviediev
 *
 * @author DruidKuma
 * @version 1.0.0
 * @since 13.04.2020
 */
public interface Processor {
    void initialize(Map<String, String> configuration);
    void process(Map<String, Object> jsonDocument);
}
