package run.wyatt.codecenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Name SwaggerConfig
 * @Description Swagger2配置
 * @Auther Wyatt
 * @Log 2022-07-23 新建
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * @Description 创建REST API摘要Bean
     * @Return Docket docket - 摘要
     * @Log 2022/7/24 Wyatt 新建
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)  // 定义是Swagger2文档
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())    // 所有的API
                .paths(PathSelectors.any())             // 所有的路径
                .build();
    }

    /**
     * @Description 创建swagger-ui页面信息对象
     * @Return ApiInfo 页面信息对象
     * @Log 2022/7/24 Wyatt 新建
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("密码中心 RESTful APIs")
                .description("密码中心接口使用文档")
                .version("0.0.1-SNAPSHOT")
                .build();
    }
}
