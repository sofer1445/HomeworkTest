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
            Thread.sleep(3000);
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
    public void makingPurchase(){
        System.out.println("makingPreschase");
        try {
            WebElement whatNew = driver.findElement(By.id("ui-id-3"));
            whatNew.click();
            WebElement addToCart = driver.findElement(By.cssSelector("a[href='https://magento.softwaretestingboard.com/phoebe-zipper-sweatshirt.html']"));
            addToCart.click();
            sleep();
            driver.findElement(By.id("option-label-size-143-item-167")).click();//product size
            driver.findElement(By.id("option-label-color-93-item-52")).click();//product color
            driver.findElement(By.id("product-addtocart-button")).click();//add to cart
        } catch (Exception e) {
            System.out.println("the product is not available");
        }
        try {
            sleep();
            WebElement anotherProduct = driver.findElement(By.cssSelector("a[href='https://magento.softwaretestingboard.com/aeon-capri.html']"));
            anotherProduct.click();
            sleep();
            driver.findElement(By.id("option-label-size-143-item-171")).click();//product size
            driver.findElement(By.id("option-label-color-93-item-49")).click();//product color
            driver.findElement(By.id("product-addtocart-button")).click();//add to cart
        } catch (Exception e) {
            System.out.println("the product is not available");
        }
    }
    public void buyProduct() {
        sleep();
        WebElement cart = driver.findElement(By.cssSelector("a[href='https://magento.softwaretestingboard.com/checkout/cart/']"));
        cart.click();
        driver.findElement(By.cssSelector("button[title='Proceed to Checkout']")).click();
        sleep();
        driver.findElement(By.cssSelector("input[name='company']")).sendKeys("israel");//company details
        driver.findElement(By.cssSelector("input[name='street[0]']")).sendKeys("123");//street address
        driver.findElement(By.cssSelector("input[name='city']")).sendKeys("jerusalem");//city
        sleep();
        driver.findElement(By.cssSelector("select[name='region_id']")).click();//state dropdown
        driver.findElement(By.cssSelector("option[data-title='North Carolina']")).click();//california
        driver.findElement(By.cssSelector("input[name='postcode']")).sendKeys("0764567");//postal code
        sleep();
        driver.findElement(By.cssSelector("select[name='country_id']")).click();//country dropdown
        driver.findElement(By.cssSelector("option[data-title='Israel']")).click();//country
        driver.findElement(By.cssSelector("input[name='telephone']")).sendKeys("0123456879");//telephone number
        WebElement shippingMethod = driver.findElement(By.cssSelector("input[value='flatrate_flatrate']"));
        shippingMethod.click();
        sleep();
//        driver.findElement(By.cssSelector("button[data-role='opc-continue']")).click();
//        sleep();
        driver.findElement(By.cssSelector("button[data-role='opc-continue']")).click();
        sleep();
        driver.findElement(By.cssSelector("button[title='Place Order']")).click();
    }

}

