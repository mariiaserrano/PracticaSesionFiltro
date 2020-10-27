package Dao;

import lombok.Data;
import lombok.SneakyThrows;

import java.security.MessageDigest;

@Data
public class PasswordHash {
    @SneakyThrows
    public String hashPassword(String password) {

        MessageDigest md = MessageDigest.getInstance("SHA3-512");

        byte[] hashBytes = md.digest(password.getBytes());
       password = bytesToHex(hashBytes);
       return password;


    }

    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}


