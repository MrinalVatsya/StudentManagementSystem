/**
 * 
 */
package com.mind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author mrinalvatsya
 *
 */
@SpringBootApplication
public class Application {
	
	/**
	 * @param args
	 */	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
