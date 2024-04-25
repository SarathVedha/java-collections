package com.vedha.collections.encryptdecrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class EncryptDecrypt {

    //Generate a pair of public and private keys. Please note that generating a key pair is going to be a one-time activity.
    public void generateKeyPairs() throws NoSuchAlgorithmException {

        KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
        rsa.initialize(2048);

        KeyPair keyPair = rsa.generateKeyPair();

        PublicKey aPublic = keyPair.getPublic();
        PrivateKey aPrivate = keyPair.getPrivate();

        System.out.println("Public Key: " + aPublic);
        System.out.println("Private Key: " + aPrivate);

        byte[] encoded = aPublic.getEncoded();
        System.out.println("Encoded Public Key: " + Arrays.toString(encoded));

        byte[] encoded1 = aPrivate.getEncoded();
        System.out.println("Encoded Private Key: " + Arrays.toString(encoded1));

        String publicKey = Base64.getEncoder().encodeToString(encoded);
        System.out.println("Encoded Public Key: " + publicKey);

        String privateKey = Base64.getEncoder().encodeToString(encoded1);
        System.out.println("Encoded Private Key: " + privateKey);

    }

    public String encrypt(String plainText, String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKey);
        KeyFactory rsa = KeyFactory.getInstance("RSA");

        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        PublicKey publicKey1 = rsa.generatePublic(x509EncodedKeySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey1);

        byte[] bytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

        String s = Base64.getEncoder().encodeToString(bytes);
        System.out.println("Encrypted Text: " + s);

        return s;
    }

    public String decrypt(String encryptedText, String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey);
        KeyFactory rsa = KeyFactory.getInstance("RSA");

        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        PrivateKey privateKey1 = rsa.generatePrivate(pkcs8EncodedKeySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey1);

        byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));

        String s = new String(bytes);
        System.out.println("Decrypted Text: " + s);

        return s;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {

        EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
        // Call the method to generate the key pairs
//        encryptDecrypt.generateKeyPairs();

        // Encode the public and private keys using Base64 encoding generated from the above method generateKeyPairs() method store in a secure place like properties file or database
        String encodePublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk2/8P4JWLU14+X+LunbaDdGKa6eLKDjh7/haNJ7kfi8D/PCRjMWP/eR2ismoaRcIHi2YjORbEleeo99Zd+6/4S8ja5DYo81EHcV9xRrOITnaDhfyrUGEGZWaiUjY8zG1xh175aUTcMa75y1eN4zWlbRnlr7o5McK480756D6XSdBVPiOnzMRAv1u752kl6d4oFbPSfF/Ky7WVr94RHFyusKiXc7uSNQw5f0lT+zfRlS4LM4jh5Zp0Kn3++OxoT+GgVTgagtmZYGhPDqY+QlFt+DPleoi1BSXMMDSaFkf2hbd9qyL2A5lezsKbmhkT/nGFroeIcuv5r4r7lCYPFWEdQIDAQAB";
        String encodePrivateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCTb/w/glYtTXj5f4u6dtoN0Yprp4soOOHv+Fo0nuR+LwP88JGMxY/95HaKyahpFwgeLZiM5FsSV56j31l37r/hLyNrkNijzUQdxX3FGs4hOdoOF/KtQYQZlZqJSNjzMbXGHXvlpRNwxrvnLV43jNaVtGeWvujkxwrjzTvnoPpdJ0FU+I6fMxEC/W7vnaSXp3igVs9J8X8rLtZWv3hEcXK6wqJdzu5I1DDl/SVP7N9GVLgsziOHlmnQqff747GhP4aBVOBqC2ZlgaE8Opj5CUW34M+V6iLUFJcwwNJoWR/aFt32rIvYDmV7OwpuaGRP+cYWuh4hy6/mvivuUJg8VYR1AgMBAAECggEADjrUdHe6pAgyaRgxjvdaH9PNwYqr4F+vFMdaQ3JjeLdGcgLw9U57EYTbmRUR+0SVDL6XVt/SV2CcB9JucugY3l27lC3obtTIonv1YdDuvJ+2Bz6x9h1Y59Q71Eyy3bP6SIr/coBecjfIGm2TRpbB/jRpfA/kb/Iy/54HDlnH2DYka9hzGupCGJ9SOZf0KEValePtJAmspgziDG1t+X6g/5G+kxRZ8FOW0nOmjOU3LYneG/YOG/eTOmOeK+7npHa+/kNEElrbh9elOBezC6jDJEvqhFoZRUfdR/XcehEwbWQqj34cy1KYNz0LOXOfguDDZ0VU86op4+stUhCCTG0nGQKBgQDKpNusi3FoOYmgQJptgv6c3hZ93VC1slsmptgQodZeirlY7yzyUBMDdHCPzt/GFUxoUadGCEAJeAtKajyi+P3u4tqFrMiRWAj3wyKHDDQjGD20eKR0F/ZjNv6F1KwXAF0fojVormTsdEXORVaz3OGIBS6ep+QLghhq1Mqku3J47QKBgQC6QfOK0DkiYcO/RFmAwI6OlnL9Fzz2sO5QNaWZpGxAkWyM6ttK+jNLXxg+v74kr4SY/0b1DTeWxfaNSjcTih5h+3QZFnIO82uGr+1/TFiHIAOkECobBkIuRqvuLVqsPuS3oqlpv/ERQwymZC+HfbzvTBGtG/u24scnoz0QvMxwqQKBgCxFpDCoLlik6Wp3csWmLtY6txM8fNuVYdCp9t57XQg+qovBhUJTODQzBjyE5+Kw2IaaAD+Ood7vuRfC6gh4+ZFtQmyd+Ru37g2jNjHm+qUIMMLy8IrkiVHXu/elJQvJao70s1Jxd18pb+7Gu1CEW0mKSEslRu80tvzwDG28/h9pAoGAc///HcTw0Gjy8HwxAe7q2gL5OobugPVQdsPyju3IPa5UXK8oRFnu+FIRV4MzeMWXX3IdTyEcLdq84uIFyzWKFpv0gmtoPcd8gDWxREbYG8/kdJlcn9gV/5wkGAJHJl9FMtkriaDxEj8f8cETmN7GfIJzv8xdyFkUj6sqrPHooYECgYACn9c8vmtktPXU6nahNxGHCkQetM1MYUrwtBCUrCQo4wf/PQmKbNNzqcWkqfgNFhIXm7MamZMxF3QnkW/wmZWXpZgOu2swLaIzIsagFJMjz6vvF574dVc8xIhIOSAEbgl9R9sHza7oAh6IlqcYBCz/nVBRDgkc0rMEbtuegdP45g==";

        // Encrypt the text
        String helloWorldEncrypt = encryptDecrypt.encrypt("Hello World", encodePublicKey);
        System.out.println("Encrypted Text: " + helloWorldEncrypt);

        // Decrypt the text
        String decrypt = encryptDecrypt.decrypt(helloWorldEncrypt, encodePrivateKey);
        System.out.println("Decrypted Text: " + decrypt);
    }
}
