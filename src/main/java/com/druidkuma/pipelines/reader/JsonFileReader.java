package com.druidkuma.pipelines.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Yurii Miedviediev
 *
 * @author DruidKuma
 * @version 1.0.0
 * @since 13.04.2020
 */
public class JsonFileReader {

    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T readObjectFromClasspath(String file, Class<T> clazz) throws IOException {
        File jsonFile = getFileFromResources(file);
        return mapper.readValue(jsonFile, clazz);
    }

    public <T> T readObjectFromClasspath(String file, TypeReference<T> typeReference) throws IOException {
        File jsonFile = getFileFromResources(file);
        return mapper.readValue(jsonFile, typeReference);
    }

    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException(String.format("File is not found: %s", fileName));
        } else {
            return new File(resource.getFile());
        }
    }
}
