package com.project.EmployeeDirectory.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
//    hard coded user and password

    @Bean
    public InMemoryUserDetailsManager userDetails() {
//        create a basic user that is hard coded into memory
        UserDetails bob = User.builder().username("bob").password("{noop}bob123").roles("USER").build();

//        create another hard coded user with the admin role
        UserDetails boss = User.builder().username("boss").password("{noop}boss123").roles("USER,ADMIN").build();

        return new InMemoryUserDetailsManager(bob, boss);
    };

//    filter request by auth account privileges
    @Bean
    public SecurityFilterChain filter(HttpSecurity security) throws Exception {
            security.authorizeHttpRequests(
                    config -> config
                            .requestMatchers(HttpMethod.GET, "/api/workers").hasRole("USER")
                            .requestMatchers(HttpMethod.GET, "/api/workers/**").hasRole("USER")
                            .requestMatchers(HttpMethod.POST, "/api/workers").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.PUT, "/api/workers").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.DELETE, "/api/workers").hasRole("ADMIN")
            );

            security.httpBasic(Customizer.withDefaults());

            //disable Cross Site Request Forgery - Not needed for Rest API
            security.csrf(csrf -> csrf.disable());

            return security.build();

    }
}
