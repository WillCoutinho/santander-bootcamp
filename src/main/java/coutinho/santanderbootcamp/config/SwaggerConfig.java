package coutinho.santanderbootcamp.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info().title("Springboot API - Demo")
                        .description("Projeto para o Santander Bootcamp 2023")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Projeto para o Santander Bootcamp 2023")
                        .url("https://app.becas-santander.com/pt-BR/program/bolsas-santander-santander-bootcamp-2023"));
    }
}