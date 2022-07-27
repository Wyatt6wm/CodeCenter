package run.wyatt.codecenter.controller.service;

/**
 * @Name DesService
 * @Description DES算法服务
 * @Auther Wyatt
 * @Log 2022-07-23 新建
 */
public interface DesService {
    /**
     * @Description DES算法加密服务，根据密钥字符串，加密明文字符串，获得密文字符串
     * @Param keyString 密钥(长度>=8), plaintext 明文
     * @Return String 密文
     * @Log 2022/7/23 Wyatt 新建
     */
    String encrypt(String keyString, String plaintext) throws IllegalArgumentException;

    /**
     * @Description DES算法解密服务，根据密钥字符串，解密密文字符串，获得明文字符串
     * @Param keyString 密钥(长度>=8)，ciphertext 密文
     * @Return String 明文
     * @Log 2022/7/23 Wyatt 新建
     */
    String decrypt(String keyString, String ciphertext) throws IllegalArgumentException;
}
