package org.otojunior.springbootwildfly;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Component;
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
	static class SpringbootWildflyHomeController {
		@Autowired
		private EntidadeDao dao;
		
		/**
		 * 
		 * @return
		 */
		@RequestMapping("/")
		public String inicio() {
			List<Entidade> all = dao.findAll();
			return "<p>"
				+ "<h3>SpringbootWildflyApplication online!</h3>"
				+ LocalDateTime.now().toString()
				+ "</p>"
				+ "<p>"
				+ all.toString()
				+ "</p>";
		}
	}
	
	/**
	 * 
	 * @author 01456231650
	 *
	 */
	@Component
	static class SpringbootWildflyHomeComponent {
		private static final Logger log = LoggerFactory.getLogger(SpringbootWildflyApplication.SpringbootWildflyHomeComponent.class);

		@Autowired
		private EntidadeDao dao;
		
		@PostConstruct
		public void init() {
			List<Entidade> lst = Arrays.asList(
				new Entidade(100L, "ent1"),
				new Entidade(200L, "ent2"),
				new Entidade(300L, "ent3"));
			dao.saveAll(lst);
			log.info("Salvando Entidades");
		}
	}
}
