package BaseClass;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utility.utils;

import java.io.IOException;

public class DriverInstance {
    public WebDriver driver;
    @BeforeMethod
    public void initiateDriver() throws IOException {
        if(utils.fetchDataFromProperty("browserName").toString().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(utils.fetchDataFromProperty("browserName").toString().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.get(utils.fetchDataFromProperty("applicationUrl").toString());
    }
    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }
}
