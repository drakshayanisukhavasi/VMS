package com.draks.wro4j.processors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.regex.Pattern;
import ro.isdc.wro.model.resource.processor.ResourcePreProcessor;

import ro.isdc.wro.model.resource.Resource;

public class RemoveSourceMapsProcessor implements ResourcePreProcessor {

    /**
     * Pattern to match sourceMappingUrls.
     */
    public static final Pattern SOURCE_MAP_PATTERN = Pattern.compile("^/(?:\\*|/)?(?:#|@) sourceMappingURL=.+(?:\\s+\\*/)?$");

    @Override
    public void process(Resource resource, Reader reader, Writer writer) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        try {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!SOURCE_MAP_PATTERN.matcher(line).matches()) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
        }
        finally {
            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    }
}