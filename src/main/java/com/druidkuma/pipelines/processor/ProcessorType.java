package com.druidkuma.pipelines.processor;

import com.druidkuma.pipelines.processor.impl.AddFieldProcessor;
import com.druidkuma.pipelines.processor.impl.CountNumFieldsProcessor;
import com.druidkuma.pipelines.processor.impl.NoOpProcessor;
import com.druidkuma.pipelines.processor.impl.RemoveFieldProcessor;

import java.util.function.Supplier;

/**
 * Created by Yurii Miedviediev
 *
 * @author DruidKuma
 * @version 1.0.0
 * @since 13.04.2020
 */
public enum ProcessorType {
    NO_OP("NoOp", NoOpProcessor::new),
    ADD_FIELD("AddField", AddFieldProcessor::new),
    REMOVE_FIELD("RemoveField", RemoveFieldProcessor::new),
    COUNT_NUM_OF_FIELDS("CountNumOfFields", CountNumFieldsProcessor::new);

    private String operation;
    private Supplier<Processor> processorProducer;
    ProcessorType(String operation, Supplier<Processor> processorProducer) {
        this.operation = operation;
        this.processorProducer = processorProducer;
    }

    public Processor createProcessor() {
        return processorProducer.get();
    }

    public static ProcessorType getType(String operation) {
        for (ProcessorType type : values()) {
            if(type.operation.equals(operation))
                return type;
        }
        return NO_OP;
    }
}
