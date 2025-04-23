package de.ait.javalessons.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptUtil {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "adminpass";
        String encodetPassword = encoder.encode(password);
        System.out.println(password + " --> " + encodetPassword);
    }

    //userpass --> $2a$10$sbe1btR7xkBaO02mOlVh8.l74wZl9CT5Spl9iIoon.Dpd3YIlQSaO
    //adminpass --> $2a$10$duos8YS6OB/m7HHmM5Zwa.1rHV4GEq9yB3N2vTCCR1OqR4OPafFp.
}
