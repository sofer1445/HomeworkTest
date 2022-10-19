import javax.swing.*;

public class Tests {
    private String EMAIL;
    private String PASSWORD;
    private String PASSWORD_VERIFICATION;

    public Tests(String EMAIL, String PASSWORD, String PASSWORD_VERIFICATION) {
        System.out.println("Tests");
        this.EMAIL = EMAIL;
        this.PASSWORD = PASSWORD;
        this.PASSWORD_VERIFICATION = PASSWORD_VERIFICATION;

    }

    public boolean correctEmail() {
        System.out.println("correctEmail: start");
        boolean legal = false;
        try {
            if (this.EMAIL.contains("@") && this.EMAIL.contains(".")) {
                System.out.println("correct email");
                legal = true;
            }
            else {
                JOptionPane.showMessageDialog(null, "Please enter a valid email");
                legal = false;
            }
            return legal;
        } catch (Exception e) {
            System.out.println("incorrect email");
            return false;
        }
    }

    public boolean strongPassword() {
        System.out.println("strongPassword: start");
        boolean strong = false;
        int count = 0;
        try {
            if (this.PASSWORD.length() >= 8) {
                if (lowerCase()) {
                    count++;
                }
                if (upperCase()) {
                    count++;
                }
                if (number()) {
                    count++;
                }
                if (specialCharacter()) {
                    count++;
                }
            }else {
                JOptionPane.showMessageDialog(null, "Please enter a password with at least 8 characters");
            }
            if (count >= 3) {
                System.out.println("strong password");
                strong = true;
            }else {
                JOptionPane.showMessageDialog(null, "Please enter a password with at least 3 of the following: lower case, upper case, number, special character");
                strong = false;
            }
            return strong;
        } catch (Exception e) {
            System.out.println("weak password");
            return false;
        }
    }

    public boolean correctPassword() {
        boolean legal = false;
        try {
            if (this.PASSWORD.equals(this.PASSWORD_VERIFICATION)) {
                System.out.println("correct password");
                legal = true;
            }else {
                JOptionPane.showMessageDialog(null, "Please enter the same password");
                legal = false;
            }
            return legal;
        } catch (Exception e) {
            System.out.println("incorrect password");
            return false;
        }
    }

    public boolean lowerCase() {
        for (int i = 0; i < this.PASSWORD.length(); i++) {
            if (this.PASSWORD.charAt(i) >= 'a' && this.PASSWORD.charAt(i) <= 'z') {
                return true;
            }
        }
        return false;
    }

    public boolean upperCase() {
        for (int i = 0; i < this.PASSWORD.length(); i++) {
            if (this.PASSWORD.charAt(i) >= 'A' && this.PASSWORD.charAt(i) <= 'Z') {
                return true;
            }
        }
        return false;
    }

    public boolean number() {
        for (int i = 0; i < this.PASSWORD.length(); i++) {
            if (this.PASSWORD.charAt(i) >= '0' && this.PASSWORD.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }

    public boolean specialCharacter() {
        for (int i = 0; i < this.PASSWORD.length(); i++) {
            if (this.PASSWORD.charAt(i) >= Final.ASCII_37 && this.PASSWORD.charAt(i) <= Final.ASCII_47) {
                return false;
            }
        }
        return false;
    }


}
