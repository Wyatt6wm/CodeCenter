package run.wyatt.codecenter.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import run.wyatt.codecenter.controller.service.DesService;

import java.util.HashMap;
import java.util.Map;

/**
 * @Name DesApiController
 * @Description DES算法操作API
 * @Auther Wyatt
 * @Log 2022-07-23 新建
 */
@RestController
@RequestMapping("/des")
public class DesApiController {
    @Autowired
    DesService desService;

    /**
     * @Description DES加密API
     * @Param query 包含密钥和明文
     * @Return 返回的密文
     * @Log 2022/7/23 Wyatt 新建
     */
    @PostMapping("/encrypt")
    public Map<String, Object> encrypt(@RequestBody Map<String, Object> query) {
        // TODO 参数校验
        Map<String, Object> modelMap = new HashMap<>();
        String keyString = query.get("key").toString();
        String plaintext = query.get("plaintext").toString();
        String ciphertext = desService.encrypt(keyString, plaintext);
        modelMap.put("success", true);
        modelMap.put("ciphertext", ciphertext);
        return modelMap;
    }
    
    /**
     * @Description DES解密API
     * @Param query 包含密钥和密文
     * @Return 返回的明文
     * @Log 2022/7/23 Wyatt 新建
     */
    @PostMapping("/decrypt")
    public Map<String, Object> decrypt(@RequestBody Map<String, Object> query) {
        // TODO 参数校验
        Map<String, Object> modelMap = new HashMap<>();
        String keyString = query.get("key").toString();
        String ciphertext = query.get("ciphertext").toString();
        String plaintext = desService.decrypt(keyString, ciphertext);
        modelMap.put("success", true);
        modelMap.put("plaintext", plaintext);
        return modelMap;
    }
}
