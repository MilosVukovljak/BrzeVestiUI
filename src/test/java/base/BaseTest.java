package base;

import framework.Configuration;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

public class BaseTest {
    
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    
    @BeforeClass
    public static void setUpClass() throws IOException {        
        Configuration.init();
        System.setProperty("webdriver.chrome.driver", Configuration.chromeDriverPath);
        driver = new ChromeDriver();
        //Maximize Chrome browser
        driver.manage().window().maximize();
        //Go to login page
        driver.get("http://bvtest.school.cubes.rs/login");
        wait = new WebDriverWait(driver, 2);
    }
    
    @AfterClass
    public static void tearDownClass() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
    

}
