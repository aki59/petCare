package com.petOcare.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

public class Oauth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
	
	private TokenStore tokenStore=new InMemoryTokenStore();
	
	@Autowired
	@Qualifier("authenticationManagerBean")
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	Environment env;

	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients.inMemory()
		       .withClient("inventory-service")
		       .secret(env.getProperty("INVENTORY_SERVICE_PASSWORD"))
		       .authorizedGrantTypes("client_credentials","refresh_token")
		       .scopes("server");
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints
		         .tokenStore(tokenStore)
		         .authenticationManager(authenticationManager)
		         .userDetailsService(userDetailsService);
		         
	}
}
