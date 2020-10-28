package Dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class main {
    public static void main (String args[]) throws InvalidKeySpecException, NoSuchAlgorithmException {
        PasswordHash ps = new PasswordHash();

        System.out.println(ps.createHash("admin"));
    }
}
