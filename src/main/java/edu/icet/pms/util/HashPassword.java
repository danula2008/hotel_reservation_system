package edu.icet.pms.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {

    public static byte[] hashPassword(String plainPassword) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(plainPassword.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public static boolean verifyPassword(String plainPassword, byte[] hashedPassword) {
        byte[] hashedPlainPassword = hashPassword(plainPassword);
        return MessageDigest.isEqual(hashedPlainPassword, hashedPassword);
    }
}
