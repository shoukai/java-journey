package org.apframework.spi.service;

import org.apframework.spi.serializer.JavaSerializer;
import org.apframework.spi.serializer.ObjectSerializer;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/6/3 19:37
 */
@Service
public class SerializerService {

    public ObjectSerializer getObjectSerializer() {
        ServiceLoader<ObjectSerializer> serializers = ServiceLoader.load(ObjectSerializer.class);
        final Optional<ObjectSerializer> serializer = StreamSupport
                .stream(serializers.spliterator(), false)
                .findFirst();
        return serializer.orElse(new JavaSerializer());
    }
}