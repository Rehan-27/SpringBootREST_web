package rehan.spring.restwebservices.rehanrest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
		info= @Info(
				title ="Spring Boot REST API Document",
				description = "API Doc created by REHAN",

				version = "v1.0.0",
				contact = @Contact(
						email = "rehankhan08976@gmail.com",
						name = "Rehan Khan"
				),
				license = @License(
						name = "Rehan.org"
				)
		)
)
@SpringBootApplication
public class RehanrestApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(RehanrestApplication.class, args);
	}

}
