package org.alumno.jose.jose_primer_app_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.alumno.jose")
public class JosePrimerAppSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JosePrimerAppSpringBootApplication.class, args);
	}

}
