package org.example.passwordGenerating;

public class User {
    private String password;

    public void initPassword(PasswordGeneratePolicy passwordGenerator) {
        String password = passwordGenerator.generatePassword();

        if(password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
