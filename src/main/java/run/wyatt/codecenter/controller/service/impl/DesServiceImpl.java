package run.wyatt.codecenter.controller.service.impl;

import org.springframework.stereotype.Service;
import run.wyatt.codecenter.controller.service.DesService;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

/**
 * @Name DesServiceImpl
 * @Description DES算法服务实现
 * @Auther Wyatt
 * @Log 2022-07-23 新建
 */
@Service
public class DesServiceImpl implements DesService {
    @Override
    public String encrypt(String keyString, String plaintext) {
        // TODO 参数校验  密钥>=8位
        try {
            // 创建密钥对象
            KeySpec keySpec = new DESKeySpec(keyString.getBytes());     // spec - specification 规范，密钥字符串转换成字节流后按DES算法规范生成密钥规范
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");     // 获取DES算法密钥工厂实例
            SecretKey key = factory.generateSecret(keySpec);    // 用密钥规范生成密钥对象

            // 创建密码对象，加密
            SecureRandom seed = new SecureRandom();     // 随机种子
            Cipher cipher = Cipher.getInstance("DES");  // 初始化设置使用DES算法
            cipher.init(Cipher.ENCRYPT_MODE, key, seed);    // 初始化操作模式（加密）、密钥、随机种子
            return Base64.getEncoder().encodeToString(cipher.doFinal(plaintext.getBytes()));    // 明文字符串转字节流后加密，然后将字节流的结果转换成字符串
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String decrypt(String keyString, String ciphertext) {
        // TODO 参数校验  密钥>=8位
        try {
            KeySpec keySpec = new DESKeySpec(keyString.getBytes());
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            SecretKey key = factory.generateSecret(keySpec);

            // 解密
            SecureRandom seed = new SecureRandom();
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key, seed);    // 初始化操作模式（加密）
            return new String(cipher.doFinal(Base64.getDecoder().decode(ciphertext)));  // 密文字符串解码成字节流，解密，得到的原密码字节流转换成字符串
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
