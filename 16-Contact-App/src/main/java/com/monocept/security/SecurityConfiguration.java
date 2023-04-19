package com.monocept.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails souvik = User.builder().username("souvik").password("{noop}Hello@World").roles("admin").build();
		UserDetails rohit = User.builder().username("rohit").password("{noop}Hello@World").roles("user").build();
		
		return new InMemoryUserDetailsManager(souvik,rohit);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	
		http.authorizeHttpRequests((configurer) ->
		
		configurer.requestMatchers(HttpMethod.GET,"/user/get-all-users").hasRole("admin").
		requestMatchers(HttpMethod.GET,"/user/get-user/**").hasRole("admin").
		requestMatchers(HttpMethod.POST,"/user/save-all").hasRole("admin").
		requestMatchers(HttpMethod.POST,"/user/save").hasRole("admin").
		requestMatchers(HttpMethod.PUT,"/user/update/**").hasRole("admin").
		requestMatchers(HttpMethod.DELETE,"/user/delete/**").hasRole("admin").
		requestMatchers(HttpMethod.GET,"/contact/get-all-contacts").hasRole("user").
		requestMatchers(HttpMethod.GET,"/contact/get-contact/**").hasRole("user").
		requestMatchers(HttpMethod.POST,"/contact/save-all").hasRole("user").
		requestMatchers(HttpMethod.POST,"/contact/save").hasRole("user").
		requestMatchers(HttpMethod.PUT,"/contact/update/**").hasRole("user").
		requestMatchers(HttpMethod.DELETE,"/contact/delete/**").hasRole("user").
		requestMatchers(HttpMethod.GET,"/details/get-all-details").hasRole("user").
		requestMatchers(HttpMethod.GET,"/details/get-detail/**").hasRole("user").
		requestMatchers(HttpMethod.POST,"/details/save-all").hasRole("user").
		requestMatchers(HttpMethod.POST,"/details/save").hasRole("user").
		requestMatchers(HttpMethod.PUT,"/details/update/**").hasRole("user").
		requestMatchers(HttpMethod.DELETE,"/details/delete/**").hasRole("user")
		);
		
		http.httpBasic();
		http.csrf().disable();
		
		return http.build();
		
	}
	
}
