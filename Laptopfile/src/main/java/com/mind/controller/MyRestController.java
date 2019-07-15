
package com.mind.controller;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class MyRestController {

	@Autowired
	private MessageSource messageSource; 

	@RequestMapping(value = "test", method = RequestMethod.GET)
	  public ResponseEntity<?> test() {
	//	System.out.println("abacadafag");
		Locale locale = LocaleContextHolder.getLocale();
		String message = messageSource.getMessage ("name1", new Object[] {"AlertCategory","AlertSubCategory"}, locale);
		System.out.println(message);
		return ResponseEntity.ok(message);
	}
}