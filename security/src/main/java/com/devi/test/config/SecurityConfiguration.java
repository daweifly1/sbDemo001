package com.devi.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
}

    private AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserCache(userCache());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
                .and()
                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
                .anyRequest()               // 任何请求,登录后可以访问
                .authenticated();

//        http.headers().frameOptions().disable();
//        http.authorizeRequests()
//                .antMatchers("/403").permitAll() // for test
//                .antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access", "/appManager").permitAll() // for login
//                .antMatchers("/image", "/js/**", "/fonts/**").permitAll() // for login
//                .antMatchers("/j_spring_security_check").permitAll()
//                .antMatchers("/oauth/authorize").authenticated();
//        /*.anyRequest().fullyAuthenticated();*/
//        http.formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
//                .and()
//                .authorizeRequests().anyRequest().authenticated()
//                .and().logout().invalidateHttpSession(true)
//                .and().sessionManagement().maximumSessions(1).expiredUrl("/login?expired").sessionRegistry(sessionRegistry());
//        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//        http.rememberMe().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/images/**", "/static/**", "/webjars/**", "/v2/api-docs");
    }
}
