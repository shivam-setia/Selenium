package testCases;

import BaseClass.DriverInstance;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;


//need driver as argument to be passed in login method and also we need before and
// after method to run before this test method thats why we needed to extend this class
public class TC_01_loginFunctionality extends DriverInstance {
    @Test
    public void login() throws IOException, InterruptedException {
        LoginPage login = new LoginPage(driver);
        Thread.sleep(5000);
        login.enterUserName("shivam.setia2012@gmail.com");
        login.enterPassword("Whitewolf@1998");
        Thread.sleep(5000);
        login.clickLoginButton();
    }
}
