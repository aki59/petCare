package com.petOcare.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import com.petOcare.security.model.security.CustomUserDetailsService;


/**
 * This class is made to kick start the authorization process as Jdbc token will 
 * require some POC.
 * @author akash
 *
 */

@Configuration
@EnableAuthorizationServer
public class Oauth2AuthorizationConfigInMemory extends AuthorizationServerConfigurerAdapter  {
	
	 private TokenStore tokenStore = new InMemoryTokenStore();

	    @Autowired
	    @Qualifier("authenticationManagerBean")
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private CustomUserDetailsService userDetailsService;

	    
	    @Override
	    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

	        // TODO persist clients details

	        // @formatter:off
	        clients.inMemory()
	        .withClient("browser")
            .authorizedGrantTypes("refresh_token", "password")
            .scopes("ui")
            .and()
	               .withClient("inventory-service")
	               .secret(passwordEncoder().encode("inventory001"))
	               .authorizedGrantTypes("refresh_token","client_credentials")
	               .scopes("server");
	        // @formatter:on
	    }

	    @Override
	    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	        endpoints
	                .tokenStore(tokenStore)
	                .authenticationManager(authenticationManager)
	                .userDetailsService(userDetailsService);
	    }

	    @Override
	    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
	        oauthServer
	                .tokenKeyAccess("permitAll()")
	                .checkTokenAccess("isAuthenticated()")
	                .passwordEncoder(passwordEncoder());
	    }
	    
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

}
