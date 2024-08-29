package com.subrutin.lingkar.catalog.audit;

import java.util.EnumSet;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;

import com.subrutin.lingkar.catalog.security.AuthenticationContext;

import io.quarkus.vertx.http.runtime.security.HttpSecurityUtils;
import io.vertx.core.Vertx;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;


@RequestScoped
public class LoggedUserGenerator implements BeforeExecutionGenerator {


    @Inject @Context
    SecurityContext securityContext;

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
