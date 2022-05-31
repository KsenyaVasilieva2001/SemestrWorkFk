package ru.kpfu.itis.skatingblog.security.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.kpfu.itis.skatingblog.security.filters.GoogleFilter;
import ru.kpfu.itis.skatingblog.security.filters.UserFilter;


@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GlobalSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    private final UserFilter userFilter;

    private final GoogleFilter googleFilter;

    @Qualifier("UserDetailsServiceImpl")
    private final UserDetailsService userDetailsService;

    public GlobalSecurityConfig(PasswordEncoder passwordEncoder, UserFilter userFilter, GoogleFilter googleFilter, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userFilter = userFilter;
        this.googleFilter = googleFilter;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().antMatchers("/css/**", "/images/**").permitAll()
                .antMatchers("/", "/signup").permitAll()
                .antMatchers("/article").authenticated().and()
                .formLogin()
                .loginPage("/signin").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/", true)
                .failureUrl("/signin?error").and()
                .oauth2Login().defaultSuccessUrl("/", true).and()
                .addFilterAfter(userFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(googleFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .logoutSuccessUrl("/signin")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
