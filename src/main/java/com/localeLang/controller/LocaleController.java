package com.localeLang.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LocaleController {
	
	@Autowired
    private MessageSource messageSource;

    //Get message based on `Accept-Language` header
	
    @GetMapping("/greet")
    public String getGreeting(@RequestHeader(name = "Accept-Language", required = false) String lang) {
        Locale locale = (lang != null) ? Locale.forLanguageTag(lang) : Locale.ENGLISH;
        return messageSource.getMessage("greeting", null, locale);
    }

    //Get message by passing `lang` as a URL parameter
    
    @GetMapping("/greet-lang")
    public String getGreetingByParam(@RequestParam(name = "lang", required = false, defaultValue = "en") String lang) {
        Locale locale = new Locale(lang);
        return messageSource.getMessage("greeting", null, locale);
    }
    
   //Get message based on `Accept-Language` header for goodbye
	
    @GetMapping("/bye")
    public String getGoodbye(@RequestHeader(name = "Accept-Language", required = false) String lang) {
        Locale locale = (lang != null) ? Locale.forLanguageTag(lang) : Locale.ENGLISH;
        return messageSource.getMessage("bye", null, locale);
    }

    //Get message by passing `lang` as a URL parameter for goodbye
    
    @GetMapping("/bye-lang")
    public String getGoodbyeByParam(@RequestParam(name = "lang", required = false, defaultValue = "en") String lang) {
        Locale locale = new Locale(lang);
        return messageSource.getMessage("bye", null, locale);
    }

}
