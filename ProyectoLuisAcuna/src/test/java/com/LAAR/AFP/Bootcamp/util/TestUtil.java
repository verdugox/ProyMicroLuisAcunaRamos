package com.LAAR.AFP.Bootcamp.util;


import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TestUtil {
    public static <T> T convertFileToObject(File file, Class<T> valueType) throws IOException {
        return new Gson().fromJson(FileUtils.readFileToString(file, StandardCharsets.UTF_8), valueType);
    }

    public static <T> T readFile(String file, String folder, Class<T> className) throws IOException {
        return TestUtil.convertFileToObject(ResourceUtils.getFile("src/test/resources/" + folder +
                "/" + file + ".json"), className);
    }

}
