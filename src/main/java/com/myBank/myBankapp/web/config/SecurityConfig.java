package com.myBank.myBankapp.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtFilter jwtFilter;

    @Autowired
    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                /*
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                //.sessionManagment()
                //.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))//Add policy statless
                .authorizeHttpRequests(customizeRequests -> {
                            customizeRequests
                                    .requestMatchers("/api/v1/customers/all").hasAuthority("random_order")
                                    .requestMatchers(HttpMethod.GET,"/api/v1/customers/**").hasRole("ADMIN")
                                    //.requestMatchers(HttpMethod.POST).denyAll()
                                    .requestMatchers("/api/auth").permitAll()
                                    .requestMatchers(HttpMethod.POST).hasRole("ADMIN")
                                    .anyRequest()
                                    .authenticated();
                        }
                )
                //.httpBasic(Customizer.withDefaults());//Remove the basicAuth
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        //.csrf(Customizer.withDefaults());
        */

                .csrf().disable()
                .cors().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**").permitAll()
                //.requestMatchers("/api/customers/**").hasAnyRole("ADMIN", "CUSTOMER")
                /*.requestMatchers(HttpMethod.GET, "/api/pizzas/**").hasAnyRole("ADMIN", "CUSTOMER")
                .requestMatchers(HttpMethod.POST, "/api/pizzas/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
                .requestMatchers("/api/orders/random").hasAuthority("random_order")
                .requestMatchers("/api/orders/**").hasRole("ADMIN")*/
                .anyRequest()
                .authenticated()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
