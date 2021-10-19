package top.huhuiyu.springmybatis.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置
 * 
 * @author 胡辉煜
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = { "top.huhuiyu.springmybatis" })
@ConditionalOnProperty(value = { "spring.web.resources.add-mappings" }, havingValue = "true")
public class SwaggerConfig {

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any()).paths(Predicates.not(PathSelectors.regex("/error.*"))).build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("springboot+mybatis演示").description("springboot+mybatis演示").version("1.0.0").build();
  }

}