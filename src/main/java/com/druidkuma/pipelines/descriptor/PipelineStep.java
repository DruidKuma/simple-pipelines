package com.druidkuma.pipelines.descriptor;

import java.util.Map;

/**
 * Created by Yurii Miedviediev
 *
 * @author DruidKuma
 * @version 1.0.0
 * @since 13.04.2020
 */
public class PipelineStep {
    private String processor;
    Map<String, String> configuration; //flat map, each key and value is guaranteed to be a String

    private PipelineStep() {
    }

    public PipelineStep(String processor, Map<String, String> configuration) {
        this.processor = processor;
        this.configuration = configuration;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Map<String, String> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Map<String, String> configuration) {
        this.configuration = configuration;
    }
}
