package main.java.encrption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public final class EncryptDecrypt {
    private static SecureRandom secRand = new SecureRandom();

//    private ApiKeyHashing(){
//        throw new IllegalStateException("Cannot Instantiate ApiKeyHashing class");
//    }

    /**
     * Encrypt the given string using Salt. The method will randomly generate a
     * salt.
     *
     * @param strToEncrypt
     * @param secret
     * @return Encrypted string in the format {salt}:{encryptedKey}
     */
    public static String encryptWithSalt(String strToEncrypt, String secret) {
        try {
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            String saltString = secRand.generateSeed(NumberConstants.TWENTY).toString();
            KeySpec spec = new PBEKeySpec(secret.toCharArray(),
                    saltString.getBytes(Charset.forName(NumberConstants.UTF8)),
                    NumberConstants.INT_MAX_VALUE, NumberConstants.KEY_LENGTH_256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            return saltString + ":" + Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encryption::"+e);
        }
        return null;
    }

    /**
     * Decrypt the string containing salt String to be decrypted should be a
     * combination of {Salt}:{EncryptedString}
     *
     * @param strToDecrypt
     * @param secret
     * @return Decrypted String
     */
    public static String decryptWithSalt(String strToDecrypt, String secret) {
        try {
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            String[] keyArr = strToDecrypt.split(":");
            String salt = keyArr[0];
            String encryptedString = strToDecrypt.substring(salt.length() + 1);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(secret.toCharArray(), salt.getBytes(Charset.forName(NumberConstants.UTF8)),
                    NumberConstants.INT_MAX_VALUE, NumberConstants.KEY_LENGTH_256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedString)));
        } catch (Exception e) {
            System.out.println("Error while decryption::"+e);
        }
        return null;
    }
}
