package br.com.servicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "br.com.servicos.domain.model")
@EnableJpaRepositories(basePackages = "br.com.servicos.domain.repository")
@SpringBootApplication(scanBasePackages = "br.com.servicos")
public class ServicosApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ServicosApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ServicosApplication.class);
	}

}
