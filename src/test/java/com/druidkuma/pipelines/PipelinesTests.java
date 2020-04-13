package com.druidkuma.pipelines;

import com.druidkuma.pipelines.descriptor.PipelineDescriptor;
import com.druidkuma.pipelines.factory.DefaultProcessorFactory;
import com.druidkuma.pipelines.reader.JsonFileReader;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yurii Miedviediev
 *
 * @author DruidKuma
 * @version 1.0.0
 * @since 13.04.2020
 */
public class PipelinesTests {

    private JsonFileReader fileReader;

    @Before
    public void setUpTests() {
        fileReader = new JsonFileReader();
    }

    @Test
    public void singleSanityPipelinesTest() throws IOException {
        //Given
        PipelineDescriptor pipelineDescriptor = fileReader.readObjectFromClasspath("pipeline.json", PipelineDescriptor.class);
        Map<String, Object> dataObject = fileReader.readObjectFromClasspath("initial-test-object.json",
                new TypeReference<Map<String, Object>>() {});

        //When
        DefaultProcessorFactory processorFactory = new DefaultProcessorFactory();
        PipelineExecutor pipelineExecutor = new PipelineExecutor(processorFactory);
        pipelineExecutor.transform(pipelineDescriptor, dataObject);

        //Then
        assertEquals(dataObject.keySet().size(), 5);
        assertEquals(dataObject.get("firstName"), "George");
        assertEquals(dataObject.get("numOfFields"), 4);
    }

}
