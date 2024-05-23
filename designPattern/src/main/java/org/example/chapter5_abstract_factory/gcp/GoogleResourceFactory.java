package org.example.chapter5_abstract_factory.gcp;


import org.example.chapter5_abstract_factory.Instance;
import org.example.chapter5_abstract_factory.ResourceFactory;
import org.example.chapter5_abstract_factory.Storage;

//Factory implementation for Google cloud platform resources
public class GoogleResourceFactory implements ResourceFactory {

    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new GoogleComputeEngineInstance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new GoogleCloudStorage(capMib);
    }
}
