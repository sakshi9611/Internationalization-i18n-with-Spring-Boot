package com.localeLang.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class LocaleConfig {

	// Define default locale resolver (stores locale in session)
	@Bean
	public LocaleResolver localResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.ENGLISH); // Default language is English
		return slr;
	}

	//Load messages from 'messages_*.properties' files
	
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages"); // Looks for messages_en.properties, messages_fr.properties, messages_hi.properties etc.
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
	//Enable locale change using a request parameter (e.g., ?lang=fr)
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang"); // Example: http://localhost:8080/greet?lang=fr
        return lci;
    }
	
}
