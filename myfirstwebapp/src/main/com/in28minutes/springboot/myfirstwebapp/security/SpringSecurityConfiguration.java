package com.in28minutes.springboot.myfirstwebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	// LDAP OR DB
	// for now -> using In memory
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		Function<String, String> passwordEncoder = 
				input -> passwordEncoder().encode(input);
				
		UserDetails userDetails = User.builder()
									.passwordEncoder(passwordEncoder)
									.username("Paritosh Dadhich")
									.password("pdadhich")
									.roles("USER", "ADMIN")
									.build();
									
		return new InMemoryUserDetailsManager(userDetails);
	}
	
	/*
	 * Earlier was using withDefaultPasswordEncoder() -> that was a deprecated function, that is not good for production
	 * now will be using PasswordEncoder which is safe and used strong hash function
	 */
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
