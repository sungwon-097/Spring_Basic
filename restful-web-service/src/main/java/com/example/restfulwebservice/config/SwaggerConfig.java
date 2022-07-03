package com.example.restfulwebservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;

import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    // contact 와 apiInfo 는  한 번 선언 후 바꿀 일이 없기 때문에 private static final 로 선언
    private static final Contact DEFAULT_CONTACT = new Contact("Kennith Lee",
        "http://localhost:8088/swagger-ui/index.html#/", "sungwon@github.com");

    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome ALI title",
            "My User management REST_APi service", "1.0", "uniformResourceName:turmsOfService",
            DEFAULT_CONTACT, "Apache 2.0",
            "http://www.apache.org/licenses/LISENCE-2.0", new ArrayList<>());

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(
            Arrays.asList("application/json", "application/xml")); // 일반 배열 형태의 List 를 ArrayList 로 변환한다.

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}