package com.hyeran.seminar4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any()) //기본 패키지 설정(any, none, base package, class annotation, method annotations
                .paths(PathSelectors.ant("/api/**"))          //노출할 API 경로 패턴 설정(any, none, regex, ant)
                .build();
    }

    //Swagger UI 페이지에 노출할 내용 커스텀
    @SuppressWarnings("deprecation")
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "혜란이의 REST API",
                "5차 세미나 자료를 보면서 스프링부트 공부중입니다.",
                "1.0",
                "Terms of Service URL",
                "hyeran9712@naver.com",
                "License",
                "License URL"
        );
        return apiInfo;
    }
}