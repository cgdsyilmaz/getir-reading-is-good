package com.example.getirreadingisgood.configuration;

import com.example.getirreadingisgood.util.SwaggerConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(readingIsGoodApiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo readingIsGoodApiInfo() {
        return new ApiInfo(
                SwaggerConstants.API_TITLE,
                SwaggerConstants.API_DESCRIPTION,
                SwaggerConstants.API_VERSION,
                SwaggerConstants.API_TERMS_URL,
                new Contact(SwaggerConstants.API_CONTACT_NAME,
                        SwaggerConstants.API_CONTACT_URL,
                        SwaggerConstants.API_CONTACT_EMAIL),
                SwaggerConstants.API_LICENSE,
                SwaggerConstants.API_LICENSE_URL,
                Collections.emptyList());
    }
}
