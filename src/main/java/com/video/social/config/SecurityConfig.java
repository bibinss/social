package com.video.social.config;

import com.video.social.dataaccess.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(
//            ServerHttpSecurity http) {
//        return http.authorizeExchange()
//                .pathMatchers("/css/**", "/ico/**", "/js/**", "/", "/login").permitAll()
//                .anyExchange().authenticated()
//                .and().oauth2Login().and().build();
//    }


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http    .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**", "/ico/**", "/js/**", "/user/login",
                        "/form_process",
                        "/api/user/register",
                        "/api/swagger-ui/**", "/api/swagger-ui.html",
                        "/api/docs", "/api/docs/**").permitAll()
                .anyRequest().authenticated()
                .and().logout().logoutUrl("/user/logout").logoutSuccessUrl("/user/login")
                .and().formLogin()
                .loginPage("/user/login").loginProcessingUrl("/form_process").failureUrl("/user/login?error=true").permitAll();
    }

//    @Bean
//    public MapReactiveUserDetailsService userDetailsService() {
//        UserDetails user = User
//                .withUsername("user")
//                .password("{noop}password")
//                .roles("USER")
//                .build();
//        return new MapReactiveUserDetailsService(user);
//    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsRepository);
    }

    private List<UserDetails> userDetailsList = new ArrayList<>();

    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        userDetailsList.add(User.withUsername("coach").password("{noop}password")
                .roles("COACH").build());
        return new InMemoryUserDetailsManager(userDetailsList);
    }
}
