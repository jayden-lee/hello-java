package com.jayden.ch04.tacos.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/design", "/orders")
                    .access("hasRole('ROLE_USER')")
                .antMatchers("/", "/h2-console/**", "/**")
                    .permitAll()
            .and()
            .formLogin()
                .loginPage("/login")
            .and()
            .logout()
                .logoutSuccessUrl("/")
            .and()
            .csrf();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());

        // 인메모리 사용자 스토어
        /*auth.inMemoryAuthentication()
            .withUser("user1")
            .password("{noop}password1")
            .authorities("ROLE_USER")
            .and()
            .withUser("user2")
            .password("{noop}password2")
            .authorities("ROLE_USER");*/

        // JDBC 기반의 사용자 스토어
        /*auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery(
                "select username, password, enabled from users " +
                    "where username=?")
            .authoritiesByUsernameQuery(
                "select username, authority from authorities " +
                    "where username=?")
            .passwordEncoder(new NoEncodingPasswordEncoder());*/
    }
}
