package com.baohua.common.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SignatureException;
import java.util.Base64;

/**
 *
 * @author $Id$
 */
public class SaltedPassword {

    private String salt;

    public SaltedPassword() {
        this.salt = null;
    }

    public SaltedPassword(String salt) {
        this.salt = salt;
    }

    public String create(String password)
            throws SignatureException {
        if (this.salt == null) {
            this.salt = this.generateSalt();
        }
        return this.calcHash(password, this.salt);
    }

    public boolean verify(String password, String hash)
            throws SignatureException {
        return hash.equals(this.calcHash(password, this.salt));
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    protected String generateSalt() {
        return StringUtils.generateMixedString(16);
    }

    private String calcHash(String password, String salt)
            throws SignatureException {
        String encode = "UTF-8";
        String algorithm = "HmacMD5";
        try {
            SecretKeySpec key = new SecretKeySpec(salt.getBytes(encode), algorithm);
            Mac mac = Mac.getInstance(algorithm);
            mac.init(key);
            byte[] bytes = mac.doFinal(password.getBytes(encode));
            return Base64.getEncoder().encodeToString(bytes);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | IllegalStateException e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
    }

}
