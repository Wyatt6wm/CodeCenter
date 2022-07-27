package run.wyatt.codecenter.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import run.wyatt.codecenter.controller.service.DesService;

/**
 * @Name DesServiceTest
 * @Description
 * @Auther Wyatt
 * @Log 2022-07-24 新建
 */
@SpringBootTest
public class DesServiceTest {
    @Autowired
    private DesService desService;
    private String keyString = "12345678";
    private String plaintext = "123456";
    private String ciphertext = "";

    private void runEncrypt() {
        this.ciphertext = desService.encrypt(this.keyString, this.plaintext);
    }

    @Test
    public void testDecrypt() {
        runEncrypt();
        String plaintext = desService.decrypt(this.keyString, this.ciphertext);
        System.out.println("key: " + this.keyString);
        System.out.println("plaintext: " + this.plaintext);
        System.out.println("ciphertext: " + this.ciphertext);
        Assertions.assertEquals(this.plaintext, plaintext);
    }
}
