package com.silence.useradmin.infrastructure.interceptor.mybatis.impl;

import com.silence.useradmin.infrastructure.interceptor.mybatis.Crypt;

public class AESCryptImpl implements Crypt {
    @Override
    public String encrypt(String plain) {
        return plain + "AES";
    }

    @Override
    public String decrypt(String cipher) {
        return cipher + "AES";
    }
}
