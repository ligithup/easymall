package com.easymall.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * Swagger2的接口配置
 *
 * @author
 */

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig
{

    @Bean(value = "defaultApi")
    @Order(value = 4)
    public Docket defaultApi() {
//        ParameterBuilder parameterBuilder=new ParameterBuilder();
        List<Parameter> parameters= Lists.newArrayList();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("默认接口")
                .select()
                .apis(basePackage("com.easymall.controller"))//多个用;号隔开
                .paths(PathSelectors.any())
                .build().globalOperationParameters(parameters)
                .securityContexts(Lists.newArrayList(securityContext())).securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey()));
    }

	    /**
	     * 重写basePackage方法，使能够实现多包访问
	     * @author
	     * @date
	     * @param
	     * @return com.google.common.base.Predicate<springfox.documentation.RequestHandler>
	     */
	 public static Predicate<RequestHandler> basePackage(final String basePackage) {
	     return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
	 }

	 private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
	     return input -> {
	         // 循环判断匹配
	         for (String strPackage : basePackage.split(";")) {
	             boolean isMatch = input.getPackage().getName().startsWith(strPackage);
	             if (isMatch) {
	                 return true;
	             }
	         }
	         return false;
	     };
	 }

	 private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
	     return Optional.fromNullable(input.declaringClass());
	 }



    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("测试 RESTful APIs")
                .description("测试 RESTful APIs")
                .termsOfServiceUrl("http://www.000.net/")
                .contact(new Contact("联系人","www.123.com","123@qq.com"))
                .version("1.0")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("BearerToken", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }

}
