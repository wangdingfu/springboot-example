package com.fuge.example.pdf;

import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.SecureUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wangdingfu
 * @date 2022-11-16 11:20:21
 */
public class Md5FileUtil {
    /**
     * 解密秘钥
     */
    private static final String PRIMARY_KEY = "dfe68b77d54943fc8d481c6ae80a2a9d";
    private static final String bathPath = "C:\\Users\\fuge\\Desktop\\";


    public static void main(String[] args) {
        //加密
//        encrypt();

        //解密
        decrypt();
    }

    public static void encrypt() {
        byte[] bytes = FileUtil.readBytes(bathPath + "1.zip");
        byte[] encrypt = SecureUtil.aes(PRIMARY_KEY.getBytes()).encrypt(bytes);
        FileUtil.writeBytes(encrypt, new File(bathPath + "2.zip"));
    }


    public static void decrypt() {
        byte[] bytes = FileUtil.readBytes(bathPath + "2.zip");
        byte[] encrypt = SecureUtil.aes(PRIMARY_KEY.getBytes()).decrypt(bytes);
        FileUtil.writeBytes(encrypt, new File(bathPath + "3.zip"));
    }

}
