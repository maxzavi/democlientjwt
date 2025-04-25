package pe.maxz.democlientjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(title = "PMM API Security", version = "1.0.0")
)

public class DemoclientjwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoclientjwtApplication.class, args);
	}

}
