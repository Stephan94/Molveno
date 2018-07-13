package com.MolvenoLakeResort.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

    public static final String WEBROLE = "WEBROLE";

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth,
                                @Value("${api.username}") String user,
                                @Value("${api.password}") String pass) throws Exception{

        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance()) // !!! new in Spring Boot 2... deprecated please fix ... 
                .withUser(user)
                .password(pass)
                .roles(WEBROLE);
    }

    @Configuration
    @Order(1)
    public static class AuWebSecurityAdapterRest extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/api/**").permitAll();//hasRole(WEBROLE).and().httpBasic();
            http.authorizeRequests().antMatchers("/mainMenu/**").hasRole(WEBROLE).and().httpBasic();

            http.authorizeRequests().anyRequest().permitAll();

            // the rest is implicit denied
        }
    }

}
