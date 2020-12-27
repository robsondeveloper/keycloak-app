package com.example.keycloak.web;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyResource {

	@GetMapping(path = "users")
	public String user(KeycloakAuthenticationToken keycloakAuthenticationToken) {
		@SuppressWarnings("unchecked")
		KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) keycloakAuthenticationToken
				.getPrincipal();

		System.out.println(principal.getKeycloakSecurityContext().getToken().getOtherClaims());
		String email = principal.getKeycloakSecurityContext().getToken().getEmail();

		return principal.getName() + " >>> " + email;
	}

	@GetMapping(path = "admins")
	public String admin(KeycloakAuthenticationToken keycloakAuthenticationToken) {
		@SuppressWarnings("unchecked")
		KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) keycloakAuthenticationToken
				.getPrincipal();

		System.out.println(principal.getKeycloakSecurityContext().getToken().getOtherClaims());
		String email = principal.getKeycloakSecurityContext().getToken().getEmail();

		return principal.getName() + " >>> " + email;
	}

}
