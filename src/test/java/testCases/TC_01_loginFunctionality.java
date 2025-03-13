package testCases;

import BaseClass.DriverInstance;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


//need driver as argument to be passed in login method and also we need before and
// after method to run before this test method thats why we needed to extend this class
public class TC_01_loginFunctionality extends DriverInstance{

    @Test(dataProvider = "login data")
    public  void login(String user,String pass) throws IOException, InterruptedException {
        System.out.println("Running login test with user: " + user + " and password: " + pass);
        LoginPage login = new LoginPage(driver);
        Thread.sleep(5000);
        login.enterUserName(user);
        login.enterPassword(pass);
        Thread.sleep(5000);
        login.clickLoginButton();
    }

    @DataProvider(name = "login data")
    public Object[][] testData() throws IOException {
        // Reading data from Excel
        FileInputStream fis = new FileInputStream("./TestData/loginData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("login");

        int numberOfRows = sheet.getLastRowNum();
        int numberOfCells = sheet.getRow(0).getLastCellNum();
        System.out.println(numberOfRows+" rows ");
        System.out.println(numberOfCells+" cells ");
        Object[][] testData = new Object[numberOfRows][numberOfCells];

        for (int i = 0; i < numberOfRows; i++) {
            XSSFRow row = sheet.getRow(i + 1);
            for (int j = 0; j < numberOfCells; j++) {
                DataFormatter formatter = new DataFormatter();
                testData[i][j] = formatter.formatCellValue(row.getCell(j));
                System.out.println(testData[i][j]);
            }
        }

//        wb.close();
        return testData;
    }
}
