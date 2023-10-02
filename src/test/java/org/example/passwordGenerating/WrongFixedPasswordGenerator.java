package org.example.passwordGenerating;

public class WrongFixedPasswordGenerator implements PasswordGeneratePolicy {
    @Override
    public String generatePassword() {
        return "ab"; // 2글자
    }
}
