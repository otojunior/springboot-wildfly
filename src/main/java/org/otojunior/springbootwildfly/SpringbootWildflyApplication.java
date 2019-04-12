package org.otojunior.springbootwildfly;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Oto Soares Coelho Junior
 *
 */
@SpringBootApplication
public class SpringbootWildflyApplication extends SpringBootServletInitializer {
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootWildflyApplication.class);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbootWildflyApplication.class, args);
	}
	
	/**
	 * 
	 * @author Oto Soares Coelho Junior
	 */
	@RestController
	class SpringbootWildflyHomeController {
		/**
		 * 
		 * @return
		 */
		@RequestMapping("/")
		public String inicio() {
			return "<p>"
				+ "<h3>SpringbootWildflyApplication online!</h3>"
				+ LocalDateTime.now().toString()
				+ "</p>";
		}
	}
}
