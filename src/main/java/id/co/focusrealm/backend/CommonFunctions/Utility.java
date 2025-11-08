package id.co.focusrealm.backend.CommonFunctions;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Utility {

    public static String generateNextId(String lastId) {
        String prefix = lastId.replaceAll("\\d", "");
        String numberPart = lastId.replaceAll("\\D", "");

        int nextNumber = Integer.parseInt(numberPart) + 1;

        String newNumberPart = String.format("%0" + numberPart.length() + "d", nextNumber);

        return prefix + newNumberPart;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new Argon2PasswordEncoder(16, 32, 1, 1 << 13, 3);
    }

}
