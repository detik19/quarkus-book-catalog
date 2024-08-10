package com.subrutin.lingkar.catalog.audit;

import java.util.EnumSet;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;

public class UpdateByAudit implements BeforeExecutionGenerator {

    @Override
    public EnumSet<EventType> getEventTypes() {
        return EnumSet.of(EventType.INSERT, EventType.UPDATE);

    }

    @Override
    public Object generate(SharedSessionContractImplementor session, Object owner, Object currentValue,
            EventType eventType) {
        StringBuilder attributeValueBuilder = new StringBuilder()
                .append("test");

        return attributeValueBuilder.toString();
    }
}
