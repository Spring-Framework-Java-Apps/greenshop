package org.woehlke.greenshop.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.woehlke.greenshop.oodm.admin.service.AdministratorService;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableSpringDataWebSupport
@Import({
        GreenshopWebMvcConfig.class
})
@EnableWebMvc
@EnableAutoConfiguration
public class GreenshopWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public GreenshopWebSecurityConfig(
            AuthenticationManagerBuilder auth,
            AdministratorService administratorService,
            GreenshopProperties greenshopProperties
    ) {
        this.authenticationManagerBuilder = auth;
        this.administratorService = administratorService;
        this.greenshopProperties = greenshopProperties;
    }

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserDetailsService administratorService;
    private final GreenshopProperties greenshopProperties;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers()
                .disable()
                .authorizeRequests()
                .antMatchers(
                        this.greenshopProperties.getWebSecurity().getAntMatchersPermitAll()
                )
                .permitAll()
                .antMatchers(
                        this.greenshopProperties.getWebSecurity().getAntMatchersFullyAuthenticated()
                )
                .fullyAuthenticated().anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(
                        this.greenshopProperties.getWebSecurity().getLoginPage()
                )
                .usernameParameter(this.greenshopProperties.getWebSecurity().getUsernameParameter())
                .passwordParameter(this.greenshopProperties.getWebSecurity().getPasswordParameter())
                .defaultSuccessUrl(this.greenshopProperties.getWebSecurity().getDefaultSuccessUrl())
                .failureForwardUrl(this.greenshopProperties.getWebSecurity().getFailureForwardUrl())
                .loginProcessingUrl(this.greenshopProperties.getWebSecurity().getLoginProcessingUrl())
                //.successHandler(this.authenticationSuccessHandler)
                .permitAll()
                .and()
                .logout()
                .logoutUrl(this.greenshopProperties.getWebSecurity().getLogoutUrl())
                .deleteCookies(this.greenshopProperties.getWebSecurity().getDeleteCookies())
                .invalidateHttpSession(this.greenshopProperties.getWebSecurity().getInvalidateHttpSession())
                .permitAll();
    }

    /**
     * @see <a href="https://asecuritysite.com/encryption/PBKDF2">Encrypt with PBKDF2</a>
     * @return PasswordEncoder encoder
     */
    @Bean
    public PasswordEncoder encoder(){
        CharSequence secret=this.greenshopProperties.getWebSecurity().getSecret();
        int iterations=this.greenshopProperties.getWebSecurity().getIterations();
        int hashWidth=this.greenshopProperties.getWebSecurity().getHashWidth();
        Pbkdf2PasswordEncoder encoder = (new Pbkdf2PasswordEncoder(secret,iterations,hashWidth));
        encoder.setEncodeHashAsBase64(true);
        return encoder;
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(  this.administratorService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return this.authenticationManagerBuilder.userDetailsService(administratorService).passwordEncoder(encoder()).and().build();
    }

    @Bean
    public UsernamePasswordAuthenticationFilter authenticationFilter() throws Exception {
        UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setFilterProcessesUrl(this.greenshopProperties.getWebSecurity().getLoginProcessingUrl());
        return filter;
    }

}
