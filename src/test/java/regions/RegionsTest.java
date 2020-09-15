package regions;

import base.BaseTest;
import framework.Helper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assume;
import pages.AddRegionPage;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PortalsPage;
import pages.RegionsEditPage;
import pages.RegionsPage;
import pages.SignaturesPage;
import pages.SourcesPage;

public class RegionsTest extends BaseTest{
    private static RegionsPage regionsPage;

    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        DashboardPage dashboardPage = new DashboardPage(driver, wait);
        regionsPage = dashboardPage.clickOnRegionsNavLink();
    }
    
    @After
    public void tearDown() {
        regionsPage.logout();
    }
    
    @Test
    public void TestDashboardLink(){
        DashboardPage dashboardPage = regionsPage.ClickOnDashboardNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
               
        String expectedDashboardPanelHeadingText = "Dashboard";
        String actualDashboardPanelHeadingText = dashboardPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualDashboardPanelHeadingText.contains(expectedDashboardPanelHeadingText));        
    }
    
    @Test
    public void TestSignaturesLink(){
        SignaturesPage signaturesPage = regionsPage.ClickOnSignaturesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedSignaturesPanelHeadingText = "Signatures";
        String actualSignaturesPanelHeadingText = signaturesPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualSignaturesPanelHeadingText.contains(expectedSignaturesPanelHeadingText));
    }
    
    @Test
    public void TestCategoriesLink(){
        CategoriesPage categoriesPage = regionsPage.ClickOnCategoriesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedCategoriesPanelHeadingText = "Categories";
        String actualCategoriesPanelHeadingText = categoriesPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualCategoriesPanelHeadingText.contains(expectedCategoriesPanelHeadingText));
    }
    
    @Test 
    public void TestRegionsLink(){
        regionsPage.clickOnRegionsNavLink();

        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedRegionsPanelHeadingText = "Regions";
        String actualRegionsPanelHeadingText = regionsPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualRegionsPanelHeadingText.contains(expectedRegionsPanelHeadingText));        
    }
    
    @Test 
    public void TestPortalsLink(){
        PortalsPage portalsPage = regionsPage.ClickOnPortalsNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedPortalsPanelHeadingText = "Portals";
        String actualPortalsPanelHeadingText = portalsPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualPortalsPanelHeadingText.contains(expectedPortalsPanelHeadingText));
    }
    
     @Test
    public void TestSourcesLink(){
        SourcesPage sourcesPage = regionsPage.ClickOnSourcesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);                
    }
    @Test
    public void testDisableFirstCategory(){
        String startingStatus = regionsPage.getStatusLetter();
        Assume.assumeTrue("Preconditions is not met, category is already disabled", startingStatus.equals("E"));
        
        regionsPage.clickOnDisableIcon();
        regionsPage.clickOnDisableButton();
        
        String titleName = regionsPage.getTitleName();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Region \"" + titleName + "\" has been disabled";
        String actualMessage = regionsPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));
        
        String expectedStatusCharacter = "D";
        String actualStatusCharacter = regionsPage.getStatusLetter();
        assertTrue("Failed - status letter hasn't changed", expectedStatusCharacter.equals(actualStatusCharacter));
    }
    @Test
    public void testEnableFirstCategory(){
        String startingStatus = regionsPage.getStatusLetter();
        Assume.assumeTrue("Preconditions is not met, category is already enabled", startingStatus.equals("D"));
        
        regionsPage.clickOnEnableIcon();
        regionsPage.clickOnEnableButton();
        
        String titleName = regionsPage.getTitleName();
 
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Region \"" + titleName + "\" has been enabled";
        String actualMessage = regionsPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));
        
        String expectedStatusCharacter = "E";
        String actualStatusCharacter = regionsPage.getStatusLetter();
        
        assertTrue("Failed - status character doesn't match", expectedStatusCharacter.equals(actualStatusCharacter));
    }
    @Test
    public void testDeleteFirstCategory(){
        String titleName = regionsPage.getTitleName();
        regionsPage.clickOnDeleteIcon();
        regionsPage.clickOnDeleteButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Region \"" + titleName + "\" has been successfully deleted!";
        String actualMessage = regionsPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));
    }
    @Test
    public void testEditFirstRegion(){
        RegionsEditPage regionsEditPage = regionsPage.clickOnEditFirstRegionIcon();
        String newTitle = Helper.getRandomText();
        regionsEditPage.enterTitleName(newTitle);
        regionsEditPage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Region \"" + newTitle + "\" has been successfully saved!";
        String actualMessage = regionsPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));
    }
    @Test
    public void testBacktoRegionButton(){
        RegionsEditPage regionsEditPage = regionsPage.clickOnEditFirstRegionIcon();
        regionsEditPage.clickOnBackToRegionsButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
    }
    @Test
    public void testAddRegion(){
        AddRegionPage addRegionPage = regionsPage.clickOnAddRegionButton();
        String newTitle = Helper.getRandomText();
        addRegionPage.enterTitleName(newTitle);
        addRegionPage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Region \"" + newTitle + "\" has been successfully saved!";
        String actualMessage = regionsPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));        
    }
}
