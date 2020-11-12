package com.video.social.config;

import com.video.social.dataaccess.UserDetailsRepository;
import com.video.social.filter.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


public class SecurityConfig {

    @Order(1)
    @Configuration
    public static class ApiConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        private JwtTokenProvider jwtTokenProvider;

        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

        @Override
        protected void configure(final HttpSecurity http) throws Exception {
            http    .cors().and().csrf().disable()
                    .antMatcher("/api/**")
                    .authorizeRequests()
                    .antMatchers("/api/user/login", "/api/teams",
                            "/api/swagger-ui/**", "/api/swagger-ui.html",
                            "/api/docs", "/api/docs/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .apply(new JwtConfigurer(jwtTokenProvider));
        }

        @Autowired
        private UserDetailsRepository userDetailsRepository;

        @Autowired
        public void configure(final AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsRepository);
        }
    }



    @Configuration
    public static class WebConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(final HttpSecurity http) throws Exception {
            http    .cors().and().csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/css/**", "/ico/**", "/js/**", "/user/login",
                            "/form_process").permitAll()
                    .anyRequest().authenticated()
                    .and().logout().logoutUrl("/user/logout").logoutSuccessUrl("/user/login")
                    .and().formLogin()
                    .loginPage("/user/login").loginProcessingUrl("/form_process").failureUrl("/user/login?error=true").permitAll();
        }

        @Autowired
        private UserDetailsRepository userDetailsRepository;

        @Autowired
        public void configure(final AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsRepository);
        }
    }
}
