package com.service.banking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("BCCS-api")
				.apiInfo(apiInfo()).select().paths(productPaths()).build();
	}

	private Predicate<String> productPaths() {
		return or(regex("/service/report.*"), regex("/service/transaction.*"), regex("/service/dashboard.*"),  regex("/service/hod_authority.*"),  regex("/service/mad.*"), regex("/service/accounts.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("BCCS APIs")
				.description("BCCS API reference for developers").build();
	}

}
