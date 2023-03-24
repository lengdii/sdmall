package com.lengdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Date:2022/12/06/ 17:16
 * Author:leng
 * Description:
 */

@Configuration
@EnableSwagger2

public class SwaggerConfig {

    //swagger会帮助我们生成文档

    //Docket封装接口文档信息
    @Bean
    public Docket getDocket(){
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("SD商城后端接口说明")
                .description("此文档详细说明了SD商城项目后端接口规范...")
                .version("v 2.0.1")
                .contact(new Contact("达哥","lengdi","lengdi@wang.com"));

        ApiInfo apiInfo = apiInfoBuilder.build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)//指定文档风格
                .apiInfo(apiInfo) //指定生成的文档桌面信息:文档标题、版本、作者
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lengdi.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }

}
