package run.wyatt.codecenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Name PageController
 * @Description 页面路由
 * @Auther Wyatt
 * @Log 2022-07-23 新建
 */
@Controller
public class PageController {
    /**
     * @Description 密码中心主页
     * @Log 2022/7/23 Wyatt 新建
     */
    @GetMapping("/")
    public String index() {
        return "/code-center/index";    // 这里加上/code-center是为了匹配addResourceHandler的一个/code-center配置项，这样就能和swagger-ui页面并存了
    }

    /**
     * @Description DES加密页面
     * @Log 2022/7/23 Wyatt 新建
     */
    @GetMapping("/des/encryption/")
    public String desEncryption() {
        return "/code-center/des/encryption";   // 要不在ViewResolver设置前缀/，要不这里带上前缀/
    }

    /**
     * @Description DES解密页面
     * @Log 2022/7/23 Wyatt 新建
     */
    @GetMapping("/des/decryption/")
    public String desDecryption() {
        return "/code-center/des/decryption";
    }
}
