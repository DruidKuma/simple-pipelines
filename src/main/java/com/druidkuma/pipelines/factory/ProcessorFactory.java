package com.druidkuma.pipelines.factory;

import com.druidkuma.pipelines.processor.Processor;

/**
 * Created by Yurii Miedviediev
 *
 * @author DruidKuma
 * @version 1.0.0
 * @since 13.04.2020
 */
public interface ProcessorFactory {
    Processor create(String processorName);
}
