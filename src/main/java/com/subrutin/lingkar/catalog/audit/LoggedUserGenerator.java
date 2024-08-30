package com.subrutin.lingkar.catalog.audit;

import java.util.EnumSet;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;

import com.subrutin.lingkar.catalog.util.SecurityUtil;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LoggedUserGenerator implements BeforeExecutionGenerator {


    @Override
    public EnumSet<EventType> getEventTypes() {
        return EnumSet.of(EventType.INSERT);
    }

    @Override
    public Object generate(SharedSessionContractImplementor session, Object owner, Object currentValue,
            EventType eventType) {
        StringBuilder attributeValueBuilder = new StringBuilder()
                .append("SYSTEM");
        return attributeValueBuilder.toString();
    }

}
