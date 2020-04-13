package com.druidkuma.pipelines;

import com.druidkuma.pipelines.descriptor.PipelineDescriptor;
import com.druidkuma.pipelines.factory.ProcessorFactory;
import com.druidkuma.pipelines.processor.Processor;

import java.util.Map;

/**
 * Created by Yurii Miedviediev
 *
 * @author DruidKuma
 * @version 1.0.0
 * @since 13.04.2020
 */
public class PipelineExecutor {

    private ProcessorFactory processorFactory;

    public PipelineExecutor(ProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
    }

    public void transform(PipelineDescriptor pipelineDescriptor, Map<String, Object> jsonDocument){
        pipelineDescriptor.getSteps().forEach(step -> {
            Processor processor = processorFactory.create(step.getProcessor());
            processor.initialize(step.getConfiguration());
            processor.process(jsonDocument);
        });
    }
}

