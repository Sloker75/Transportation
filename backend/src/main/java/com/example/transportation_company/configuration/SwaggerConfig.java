package com.example.transportation_company.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    protected Info apiInfo(){
        return new Info().title("Transportation Company")
                .description("Tutorial project")
                .version("0.1")
                .contact(new Contact().name("Vlad").url("https://github.com/Sloker75").email("vladburilo@gmail.com"));
    }

    @Bean
    public OpenAPI openApiConfig(){
        return new OpenAPI()
                .info(apiInfo());
    }


}
