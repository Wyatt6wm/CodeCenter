package run.wyatt.codecenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Name CodeCenterApplication
 * @Description 密码中心应用启动类
 * @Auther Wyatt
 * @Log 2022-07-22 新建
 */
@SpringBootApplication
public class CodeCenterApplication {
    /**
     * @Description 应用main函数
     * @Param args 命令行参数
     * @Return 
     * @Log 2022/7/22 Wyatt 新建
     */
    public static void main(String[] args) {
        SpringApplication.run(CodeCenterApplication.class, args);
        System.out.println("========== Code Center Started ==========");
    }
}
