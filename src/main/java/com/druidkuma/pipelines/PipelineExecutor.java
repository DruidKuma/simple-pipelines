package com.druidkuma.pipelines;

import com.druidkuma.pipelines.descriptor.PipelineDescriptor;
import com.druidkuma.pipelines.factory.ProcessorFactory;
import com.druidkuma.pipelines.processor.Processor;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Yurii Miedviediev
 *
 * @author DruidKuma
 * @version 1.0.0
 * @since 13.04.2020
 */
public class PipelineExecutor {

    private ProcessorFactory processorFactory;
    private ExecutorService executorService;

    public PipelineExecutor(ProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
        executorService = Executors.newCachedThreadPool();
    }

    public void transform(PipelineDescriptor pipelineDescriptor, Map<String, Object> jsonDocument, long maximumTransformTimeMs) throws TimeoutException {
        try {
            executorService.submit(() -> pipelineDescriptor.getSteps().forEach(step -> {
                Processor processor = processorFactory.create(step.getProcessor());
                processor.initialize(step.getConfiguration());
                processor.process(jsonDocument);
            })).get(maximumTransformTimeMs, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException e) {
            // Thread interruption or runtime execution exceptions can be handled here
        }
    }

    @Override
    protected void finalize() {
        if(!executorService.isShutdown()) {
            executorService.shutdown();
        }
    }
}

