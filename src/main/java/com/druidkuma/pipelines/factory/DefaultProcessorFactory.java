package com.druidkuma.pipelines.factory;

import com.druidkuma.pipelines.processor.Processor;
import com.druidkuma.pipelines.processor.ProcessorType;


/**
 * Created by Yurii Miedviediev
 *
 * @author DruidKuma
 * @version 1.0.0
 * @since 13.04.2020
 */
public class DefaultProcessorFactory implements ProcessorFactory {
    public Processor create(String processorName) {
        return ProcessorType.getType(processorName).createProcessor();
    }
}
