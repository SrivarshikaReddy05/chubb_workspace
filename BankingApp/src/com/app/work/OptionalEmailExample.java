package com.app.work;

import java.util.Optional;

public class OptionalEmailExample {
    public static void main(String[] args) {
        
        // Case 1: email is present
        String email = "srivarshika@example.com";
        Optional<String> optionalEmail = Optional.ofNullable(email);

        // Print email if present, else default message
        System.out.println(optionalEmail.orElse("No email provided"));

        // Case 2: email is null
        email = null;
        optionalEmail = Optional.ofNullable(email);

        // Print email if present, else default message
        System.out.println(optionalEmail.orElse("No email provided"));
    }
}
