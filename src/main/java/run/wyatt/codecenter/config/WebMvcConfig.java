package run.wyatt.codecenter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Name WebMvcConfig
 * @Description Web MVC配置
 * @Auther Wyatt
 * @Log 2022-07-23 新建
 */
@Configuration
//@EnableWebMvc   // swagger-ui和这个注释冲突：@EnableWebMvc注解会全面接管SpringMVC，加入之后会取消Spring Boot的自动默认配置，只会提供最基础的功能，就需要手动配置swagger-ui了
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * @Description 配置视图解析器
     * @Param [registry]
     * @Return void
     * @Log 2022/7/23 Wyatt 新建
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setCache(false);               // 关闭缓存
        resolver.setContentType("text/html");   // 设置内容类型为text/html
        resolver.setSuffix(".html");            // 设置文件后缀
        registry.viewResolver(resolver);
    }

    /**
     * @Description 添加资源处理器
     * 这是Spring MVC提供的解决静态资源请求的方法之一，直接将资源请求/**与资源目录映射起来，
     * 一个请求可以映射多个资源目录。
     * @Param [registry] 注册器
     * @Return void
     * @Log 2022/7/23 Wyatt 新建
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // <mvc:resources mapping="/code-center/**" location="classpath:html/,classpath:static/,WEB-INF/static/"/>
        registry.addResourceHandler("/code-center/**")  // 因为swagger-ui的页面默认匹配的是/**，所以为了双方都能用，自己写的页面才指定目录
                .addResourceLocations("classpath:html/")
                .addResourceLocations("classpath:static/")
                .addResourceLocations("WEB-INF/static/");   // 没放文件，只是示例
    }
}
