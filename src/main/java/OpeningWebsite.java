import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

public class OpeningWebsite extends JPanel {

    private ChromeDriver driver;

    public OpeningWebsite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sofer\\OneDrive\\שולחן העבודה\\שוהם\\taskH\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://magento.softwaretestingboard.com/");
        this.driver.manage().window().maximize();

    }

    public void createAnAccount() throws InterruptedException {
        WebElement signIn = driver.findElement(By.cssSelector("a[href='https://magento.softwaretestingboard.com/customer/account/create/']"));
        signIn.click();
    }

    public void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void personalInformation(String firstName, String lastName, String email, String password, String passwordVerification) throws InterruptedException {
        System.out.println("personalInformation");
        WebElement firstNameField = driver.findElement(By.id("firstname"));
        firstNameField.sendKeys(firstName);
        WebElement lastNameField = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastNameField.sendKeys(lastName);
        WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.cssSelector("input[name='password']"));
        passwordField.sendKeys(password);
        WebElement confirmPasswordField = driver.findElement(By.id("password-confirmation"));
        confirmPasswordField.sendKeys(passwordVerification);
        WebElement submitButton = driver.findElement(By.cssSelector("button[title='Create an Account']"));
        submitButton.click();
        sleep();
    }

}

