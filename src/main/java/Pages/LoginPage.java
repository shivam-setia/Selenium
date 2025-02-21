package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.utils;

import java.io.IOException;

//all things we hv to perform in that page create method for those
//pass values on those methods by reading from property file
//method to read data will be in utils file
public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void enterUserName(String uName) throws IOException {
        driver.findElement(By.xpath(utils.fetchElementLocator("login_userName_id"))).sendKeys(uName);
    }

    public void enterPassword(String pswrd) throws IOException {
        driver.findElement(By.xpath(utils.fetchElementLocator("login_password_id"))).sendKeys(pswrd);
    }

    public void clickLoginButton(){
        try {
            driver.findElement(By.xpath(utils.fetchElementLocator("login_button_id"))).click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
