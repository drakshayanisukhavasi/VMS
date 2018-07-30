package com.draks.wro4j.processors;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ro.isdc.wro.model.resource.processor.ResourcePostProcessor;
import ro.isdc.wro.model.resource.processor.ResourcePreProcessor;
import ro.isdc.wro.model.resource.processor.support.ProcessorProvider;

public class Wro4jProcessorProvider  implements ProcessorProvider {

    private final Map<String, ResourcePreProcessor> preProcessors;

    private final Map<String, ResourcePostProcessor> postProcessors;

    public Wro4jProcessorProvider() {
        final Map<String, ResourcePreProcessor> tmp = new HashMap<String, ResourcePreProcessor>();
        tmp.put("removeSourceMaps", new RemoveSourceMapsProcessor());
        this.preProcessors = Collections.unmodifiableMap(tmp);
        this.postProcessors = Collections.unmodifiableMap(new HashMap<String, ResourcePostProcessor>());
    }

    @Override
    public Map<String, ResourcePreProcessor> providePreProcessors() {
        return this.preProcessors;
    }

    @Override
    public Map<String, ResourcePostProcessor> providePostProcessors() {
        return this.postProcessors;
    }
}