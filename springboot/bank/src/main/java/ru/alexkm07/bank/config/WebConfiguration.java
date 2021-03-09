package ru.alexkm07.bank.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;


@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

//    @Bean(name = "messageSource")
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();
//        messageResource.setBasenames("classpath:i18n/messages");
//        messageResource.setDefaultEncoding("UTF-8");
//        return messageResource;
//    }
//
//    @Bean(name = "localeResolver")
//    public LocaleResolver localeResolver() {
//        CookieLocaleResolver resolver= new CookieLocaleResolver();
//        resolver.setCookieDomain("myAppLocaleCookie");
//        // 60 minutes
//        resolver.setCookieMaxAge(60*60);
//        resolver.setDefaultLocale(Locale.US);
//        return resolver;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//        localeChangeInterceptor.setParamName("lang");
//        registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/*");
//    }

}
