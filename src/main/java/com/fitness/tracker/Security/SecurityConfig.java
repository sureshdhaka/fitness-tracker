// package com.fitness.tracker.Security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig  {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf().disable()
//             .authorizeHttpRequests()
//             .requestMatchers("/api/users/**").hasRole("ADMIN")  // Updated to use requestMatchers
//             .requestMatchers("/api/workout-plans/**", "/api/activity-logs/**").hasRole("USER") // Updated to use requestMatchers
//             .anyRequest().authenticated() // Ensure all other requests require authentication
//             .and()
//             .httpBasic();  // Enable basic authentication
//         return http.build();
//     }

//     // Define the AuthenticationManager with in-memory authentication
//     @Bean
//     public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//         AuthenticationManagerBuilder authenticationManagerBuilder = 
//             http.getSharedObject(AuthenticationManagerBuilder.class);
        
//         authenticationManagerBuilder
//             .inMemoryAuthentication()
//             .passwordEncoder(passwordEncoder())
//             .withUser(User.withUsername("admin")
//                 .password(passwordEncoder().encode("password"))
//                 .roles("ADMIN"))
//             .withUser(User.withUsername("user")
//                 .password(passwordEncoder().encode("password"))
//                 .roles("USER"));
        
//         return authenticationManagerBuilder.build();
//     }

//     // Define PasswordEncoder bean (BCryptPasswordEncoder recommended for encoding passwords)
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }


