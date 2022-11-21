package org.woehlke.greenshop.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
@EnableAsync
@EnableJpaRepositories({
        "org.woehlke.greenshop"
})
@EnableConfigurationProperties({
        GreenshopProperties.class
})
@EnableWebMvc
@EnableSpringDataWebSupport
@EnableAutoConfiguration
public class GreenshopWebMvcConfig implements WebMvcConfigurer {

    private final GreenshopProperties greenshopProperties;

    @Autowired
    public GreenshopWebMvcConfig(GreenshopProperties greenshopProperties) {
        this.greenshopProperties = greenshopProperties;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.GERMAN);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        for(String key: greenshopProperties.getWebConfig().getWebAddResourceHandlers()){
            registry.addResourceHandler("/"+key+"*").addResourceLocations("/"+key);
            registry.addResourceHandler("/"+key+"**").addResourceLocations("/"+key);
        }
        for(String key: greenshopProperties.getWebConfig().getWebAddResourceHandlersStatic()){
            registry.addResourceHandler("/"+key+"*").addResourceLocations("classpath:/static/"+key);
            registry.addResourceHandler("/"+key+"**").addResourceLocations("classpath:/static/"+key);
        }
    }
}
