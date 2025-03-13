package BaseClass;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import utility.utils;

import java.io.IOException;
import java.util.Collections;


public class DriverInstance {
    public WebDriver driver;
    String url;
    @BeforeClass
    public void initiateDriver() throws IOException, InterruptedException {
        if(utils.fetchDataFromProperty("browserName").toString().equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nidhi Upreti\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            //WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            url=utils.fetchurlfromProperty("applicationUrl").toString();
            System.out.println(url);
            driver.get(url);
        }
        else if(utils.fetchDataFromProperty("browserName").toString().equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
            driver.get(url);
        }
        else{
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(options);
            driver.manage().window().maximize();
            driver.get(url);

        }
    }
     @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
