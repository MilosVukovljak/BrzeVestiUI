package login;

import org.junit.Test;
import base.BaseTest;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTests extends BaseTest{
    boolean loggedIn = false;

    @Before
    public void setUp(){
    }
    @After
    public void tearDown(){
        driver.get("http://bvtest.school.cubes.rs/login");
    }
    
   
    @Test
    public void testValidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        String expectedURL = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();        
         assertEquals("Url's does not match.", expectedURL, actualUrl);
         
         DashboardPage dashboardPage = new DashboardPage(driver);
         String expectedPanelHeadingText = "Dashboard";
         String actualPanelHeadingText = dashboardPage.getPanelHeadingText();
         assertTrue("Failed - panel heading texts doesnt't match", expectedPanelHeadingText.equals(actualPanelHeadingText));
                 
         dashboardPage.logout();
         
         //dashboardPage
        
    }
    @Test
    public void testEmptyFieldsLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        
        String expectedURL = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();        
        assertEquals("Url's does not match.", expectedURL, actualUrl);
        
        String expectedEmailMessage = "The email field is required.";
        String actualEmailMessage = loginPage.getEmailMessageText();
        Assert.assertTrue("Failed - Email message's doesn't match",expectedEmailMessage.equals(actualEmailMessage));
              
    }
    
    @Test 
    public void testInvalidEmailInvalidPasswordLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfNonExistingUser();
        loginPage.enterPasswordOfNonExistingUser();
        loginPage.clickLoginButton();
        
        String expectedURL = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();
        
        assertEquals("Url's does not match.", expectedURL, actualUrl);
        
        String expectedEmailMessage = "These credentials do not match our records.";
        String actualEmailMessage = loginPage.getEmailMessageText();
        Assert.assertTrue("Failed - Email message's doesn't match",expectedEmailMessage.equals(actualEmailMessage));        
    }
    @Test
    public void testValidEmailInvalidPasswordLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfNonExistingUser();
        loginPage.clickLoginButton();
        
        String expectedURL = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();
        
        assertEquals("Url's does not match.", expectedURL, actualUrl);
        
        String expectedEmailMessage = "These credentials do not match our records.";
        String actualEmailMessage = loginPage.getEmailMessageText();
        Assert.assertTrue("Failed - Email message's doesn't match",expectedEmailMessage.equals(actualEmailMessage)); 
    }
    @Test
    public void testInvalidEmailValidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfNonExistingUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        
        String expectedURL = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();
        
        assertEquals("Url's does not match.", expectedURL, actualUrl);
        
        String expectedEmailMessage = "These credentials do not match our records.";
        String actualEmailMessage = loginPage.getEmailMessageText();
        Assert.assertTrue("Failed - Email message's doesn't match",expectedEmailMessage.equals(actualEmailMessage)); 
    }
    
    @Test
    public void testCustomDataLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("hello@milos.rs");
        loginPage.enterPassword("123456");
        loginPage.clickLoginButton();
        
        String expectedURL = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();        
        assertEquals("Url's does not match.", expectedURL, actualUrl);
        
        String expectedEmailMessage = "These credentials do not match our records.";
        String actualEmailMessage = loginPage.getEmailMessageText();
        Assert.assertTrue("Failed - Email message's doesn't match",expectedEmailMessage.equals(actualEmailMessage));
    }
    
    @Test
    public void testValidEmailEmptyPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.clickLoginButton();
        
        String expectedURL = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();        
        assertEquals("Url's does not match.", expectedURL, actualUrl);
        
        String expectedPasswordMessage = "The password field is required.";
        String actualPasswordMessage = loginPage.getPasswordMessageText();
        Assert.assertTrue("Failed - Password message's doesn't match",expectedPasswordMessage.equals(actualPasswordMessage));        
    }
    
    @Test 
    public void testEmptyEmailValidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        String expectedURL = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();        
        assertEquals("Url's does not match.", expectedURL, actualUrl);
        
        String expectedEmailMessage = "The email field is required.";
        String actualEmailMessage = loginPage.getEmailMessageText();
        Assert.assertTrue("Failed - Email message's doesn't match",expectedEmailMessage.equals(actualEmailMessage));
    }
    @Test
    public void testInvalidEmailEmptyPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfNonExistingUser();
        loginPage.clickLoginButton();  
        
        String expectedURL = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();        
        assertEquals("Url's does not match.", expectedURL, actualUrl);
        
        String expectedPasswordMessage = "The password field is required.";
        String actualPasswordMessage = loginPage.getPasswordMessageText();
        Assert.assertTrue("Failed - Password message's doesn't match",expectedPasswordMessage.equals(actualPasswordMessage));
    }
    @Test
    public void testEmptyEmailInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPasswordOfNonExistingUser();
        loginPage.clickLoginButton();  
        
        String expectedURL = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();        
        assertEquals("Url's does not match.", expectedURL, actualUrl);
        
        String expectedEmailMessage = "The email field is required.";
        String actualEmailMessage = loginPage.getEmailMessageText();
        Assert.assertTrue("Failed - Email message's doesn't match",expectedEmailMessage.equals(actualEmailMessage));        
    }
    
}
