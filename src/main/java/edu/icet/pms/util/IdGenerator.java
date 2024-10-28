package edu.icet.pms.util;

import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator implements IdentifierGenerator {
    private String prefix = "";
    private final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        int currentCount = counter.incrementAndGet();
        return prefix + currentCount;
    }

    @Override
    public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {
        prefix = properties.getProperty("prefix");
    }
}
