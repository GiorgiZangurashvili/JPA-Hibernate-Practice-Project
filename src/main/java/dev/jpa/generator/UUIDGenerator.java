package dev.jpa.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.EventType;
import org.hibernate.generator.Generator;
import org.hibernate.id.IdentifierGenerator;

import java.util.EnumSet;
import java.util.UUID;

public class UUIDGenerator implements Generator {
    @Override
    public boolean generatedOnExecution() {
        return false;
    }

    @Override
    public EnumSet<EventType> getEventTypes() {
        return null;
    }
}
