package portals;

import base.BaseTest;
import framework.Helper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assume;
import pages.AddPortalsPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PortalsEditPage;
import pages.PortalsPage;

public class PortalsTest extends BaseTest{
       private static PortalsPage portalsPage;
       
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        DashboardPage dashboardPage = new DashboardPage(driver, wait);
        portalsPage = dashboardPage.clickOnPortalsNavLink();
    }
    
    @After
    public void tearDown() {
        portalsPage.Logout();
    }
    
    @Test
    public void TestAddNewPortal(){
        AddPortalsPage addPortalPage = portalsPage.clickOnAddPortal();
        String newTitle = Helper.getRandomText();
        addPortalPage.enterTitleName(newTitle);        
        addPortalPage.enterUrl();
        String optionName = addPortalPage.getOptionDropDownName();
        addPortalPage.selectFromPortalsDropdown(optionName);
        addPortalPage.clickOnSaveButton();

        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Portal \"" + newTitle + "\" has been successfully saved!";
        String actualMessage = portalsPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage)); 
    }
    @Test
    public void TestEditFirstPortal(){
        PortalsEditPage portalsEditPage = portalsPage.ClickOnEditFirstPortal();
        String newTitle = Helper.getRandomText();
        portalsEditPage.enterTitleName(newTitle);
        portalsEditPage.enterUrl();
        String optionName = portalsEditPage.getOptionDropDownName();
        portalsEditPage.selectRegionFromPortals(optionName);
        portalsEditPage.clickOnSaveButton();
 
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl); 
        
        String expectedMessage = "Portal \"" + newTitle + "\" has been successfully saved!";
        String actualMessage = portalsPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));
    }
    @Test
    public void TestDisableFirstPortal(){
        
        String startingStatus = portalsPage.getStatusLetter();
        Assume.assumeTrue("Preconditions is not met, category is already disabled", startingStatus.equals("E"));

        portalsPage.clickOnDisableIcon();
        portalsPage.clickOnDisableButton();
        
        String titleName = portalsPage.getTitleName();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Portal \"" + titleName + "\" has been disabled";
        String actualMessage = portalsPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));
        
        String expectedStatusLetter = "D";
        String actualStatusLetter = portalsPage.getStatusLetter();
        assertTrue("Failed - status letter hasn't changed", expectedStatusLetter.equals(actualStatusLetter));      
    }
    @Test
    public void testEnableFirstPortal(){
        
        String startingStatus = portalsPage.getStatusLetter();
        Assume.assumeTrue("Preconditions is not met, category is already disabled", startingStatus.equals("D"));
        
        portalsPage.clickOnEnableIcon();        
        portalsPage.clickOnEnableButton();
        
        String titleName = portalsPage.getTitleName();
 
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Portal \"" + titleName + "\" has been enabled";
        String actualMessage = portalsPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));
        
        String expectedStatusLetter = "E";
        String actualStatusLetter = portalsPage.getStatusLetter();
        
        assertTrue("Failed - status character doesn't match", expectedStatusLetter.equals(actualStatusLetter));                
    }
    
    
    @Test
    public void TestDeleteFirstPortal(){
        String titleName = portalsPage.getTitleName();
        portalsPage.clickOnDeleteIcon();
        portalsPage.clickOnDeleteButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Portal \"" + titleName + "\" has been successfully deleted!";
        String actualMessage = portalsPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage)); 
    }

}