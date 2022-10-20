import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private ImageIcon imageIcon;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField mail;
    private JTextField password;
    private JTextField passwordVerification;
    private JButton signUp;
    private String firstNameText;
    private String lastNameText;
    private String mailText;
    private String passwordText;
    private String passwordVerificationText;

    public MainPanel(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setVisible(true);
        this.imageIcon = new ImageIcon("Luma.png");
        this.add(new JLabel(imageIcon));
        welcome();
        createLogin();


//        this.add(new ImagePanel(Final.X_AND_Y, Final.X_AND_Y, Final.WINDOW_WIDTH, Final.WINDOW_HEIGHT));
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.imageIcon.paintIcon(this, graphics, 0, 0);
    }

    public void welcome() {
        System.out.println("welcome");
        JLabel welcome = new JLabel("Welcome to the luma website");
        welcome.setBounds(Final.WELECOME_X, Final.WELECOME_Y, Final.WELECOME_WIDTH, Final.WELECOME_HEIGHT);
        welcome.setFont(new Font("Serif", Font.BOLD, 20));
        welcome.setForeground(Color.black);
        this.add(welcome);

        JLabel welcome2 = new JLabel("Please login to continue");
        welcome2.setBounds(Final.WELECOME_X, Final.WELECOME2_Y, Final.WELECOME2_WIDTH, Final.WELECOME2_HEIGHT);
        welcome2.setFont(new Font("Serif", Font.BOLD, 20));
        welcome2.setForeground(Color.black);
        this.add(welcome2);
    }

    public void createLogin() {
        System.out.println("createLogin");
        this.firstName = new JTextField("First name");
        firstName.setBounds(Final.FIRST_NAME_X, Final.FIRST_NAME_Y, Final.FIRST_NAME_WIDTH, Final.FIRST_NAME_HEIGHT);
        this.add(firstName);

        this.lastName = new JTextField("Last name");
        lastName.setBounds(Final.LAST_NAME_X, Final.LAST_NAME_Y, Final.LAST_NAME_WIDTH, Final.LAST_NAME_HEIGHT);
        this.add(lastName);

        this.mail = new JTextField("Mail");
        mail.setBounds(Final.MAIL_X, Final.MAIL_Y, Final.MAIL_WIDTH, Final.MAIL_HEIGHT);
        this.add(mail);

        this.password = new JTextField("Password");
        password.setBounds(Final.PASSWORD_X, Final.PASSWORD_Y, Final.PASSWORD_WIDTH, Final.PASSWORD_HEIGHT);
        this.add(password);

        this.passwordVerification = new JTextField("Password verification");
        passwordVerification.setBounds(Final.PASSWORD_VERIFICATION_X, Final.PASSWORD_VERIFICATION_Y, Final.PASSWORD_VERIFICATION_WIDTH, Final.PASSWORD_VERIFICATION_HEIGHT);
        this.add(passwordVerification);

        JLabel instruction = new JLabel("After each text box typed, please press enter");
        instruction.setBounds(Final.INSTRUCTION_X, Final.INSTRUCTION_Y, Final.INSTRUCTION_WIDTH, Final.INSTRUCTION_HEIGHT);
        instruction.setFont(new Font("Serif", Font.BOLD, 20));
        instruction.setForeground(Color.black);
        this.add(instruction);

        this.signUp = new JButton("Sign up");
        signUp.setBounds(Final.SIGN_UP_X, Final.SIGN_UP_Y, Final.SIGN_UP_WIDTH, Final.SIGN_UP_HEIGHT);
        signUp.setFont(new Font("Serif", Font.BOLD, 20));
        signUp.setForeground(Color.black);
        this.add(signUp);

        signUp.addActionListener(e -> {
            this.firstNameText = firstName.getText();
            System.out.println(this.firstNameText);

            this.lastNameText = lastName.getText();
            System.out.println(this.lastNameText);

            this.mailText = mail.getText();
            System.out.println(this.mailText);

            this.passwordText = password.getText();
            System.out.println(this.passwordText);

            this.passwordVerificationText = passwordVerification.getText();
            System.out.println(this.passwordVerificationText);

            Tests tests = new Tests(mailText, passwordText, passwordVerificationText);
            if (tests.correctEmail() && tests.correctPassword() && tests.strongPassword()) {
                OpeningWebsite openingWebsite = new OpeningWebsite();
                openingWebsite.setVisible(true);
                openingWebsite.sleep();
                try {
                    openingWebsite.createAnAccount();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    openingWebsite.personalInformation(firstNameText, lastNameText, mailText, passwordText, passwordVerificationText);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    openingWebsite.makingPurchase();
                    openingWebsite.buyProduct();
                }catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }

        });

    }


}
