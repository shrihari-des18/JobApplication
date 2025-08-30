package com.shrihari.jobapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    public UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

        return provider;
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//                .csrf(customizer->customizer.disable())
//                .authorizeHttpRequests(request->request.anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(session->session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        return http.build();
//    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                // Username + Password (your UserDetailsService + BCryptPasswordEncoder)
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                // OAuth2 Login
                .oauth2Login(Customizer.withDefaults())
                // Stateless session (you can change if you want sessions)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                );

        return http.build();
    }


//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
//
//        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
//                .oauth2Login(Customizer.withDefaults());
//
//        return http.build();
//    }


    /*@Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User
                                .withDefaultPasswordEncoder()
                                .username("shri")
                                .password("1234")
                                .roles("USER")
                                .build();

        UserDetails admin = User
                .withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }*/
}
