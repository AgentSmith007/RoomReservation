package com.booking.epam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket hotelApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.booking.epam.controller"))
                .paths(regex("/hotel.*"))
                .build()
                .apiInfo(new ApiInfoBuilder().version("2.0").title("Hotel API").build())
                .groupName("Hotel");
    }

    @Bean
    public Docket roomApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.booking.epam.controller"))
                .paths(regex("/room.*"))
                .build()
                .apiInfo(new ApiInfoBuilder().version("2.0").title("Room API").build())
                .groupName("Room");
    }

    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.booking.epam.controller"))
                .paths(regex("/user.*"))
                .build()
                .apiInfo(new ApiInfoBuilder().version("2.0").title("User API").build())
                .groupName("User");
    }
}
