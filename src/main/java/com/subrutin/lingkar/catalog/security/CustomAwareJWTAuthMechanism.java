package com.subrutin.lingkar.catalog.security;

import java.util.Set;

import io.quarkus.security.identity.IdentityProviderManager;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.identity.request.AuthenticationRequest;
import io.quarkus.smallrye.jwt.runtime.auth.JWTAuthMechanism;
import io.quarkus.vertx.http.runtime.security.ChallengeData;
import io.quarkus.vertx.http.runtime.security.HttpAuthenticationMechanism;
import io.quarkus.vertx.http.runtime.security.HttpCredentialTransport;
import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.RoutingContext;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;

@Alternative
@Priority(value = 1)
@ApplicationScoped
public class CustomAwareJWTAuthMechanism implements HttpAuthenticationMechanism {

	@Inject
	JWTAuthMechanism  delegate;
	
	@Override
	public Uni<SecurityIdentity> authenticate(RoutingContext context, IdentityProviderManager identityProviderManager) {
		return delegate.authenticate(context, identityProviderManager);

	}

	@Override
	public Uni<ChallengeData> getChallenge(RoutingContext context) {
		System.out.println("get challenge");

		return delegate.getChallenge(context);

	}

	@Override
	public Set<Class<? extends AuthenticationRequest>> getCredentialTypes() {
		System.out.println("get getCredentialTypes");

		return delegate.getCredentialTypes();

	}

	@Override
	public HttpCredentialTransport getCredentialTransport() {
		System.out.println("get getCredentialTransport");

		return delegate.getCredentialTransport();
	}
	

}
