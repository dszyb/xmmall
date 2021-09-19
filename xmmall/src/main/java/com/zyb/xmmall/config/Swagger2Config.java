package com.zyb.xmmall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {

    /*封装接口文档信息*/
        @Bean
        public Docket getDocket(){
            return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                    .apis(RequestHandlerSelectors.basePackage("com.zyb.xmmall.controller"))
                    .paths(PathSelectors.any())
                    .build();
        }

        private ApiInfo apiInfo(){
            return new ApiInfoBuilder().title("《小米商城后端接口说明》")
                    .description("详细描述了后端提供给前端的接口的说明")
                    .contact(new Contact("管理员","",""))
                    .version("v 1.0.0")
                    .build();
        }
    }