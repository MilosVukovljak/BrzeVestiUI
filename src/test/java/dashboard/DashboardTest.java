
package dashboard;

import base.BaseTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PortalsPage;
import pages.RegionsPage;
import pages.SignaturesPage;
import pages.SourcesPage;

public class DashboardTest extends BaseTest {
    
    private static DashboardPage dashboardPage;
    
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        dashboardPage = new DashboardPage(driver, wait);
    }
    
    @After
    public void tearDown() {
        dashboardPage.clickOnOptionsDropdown();
        dashboardPage.clickOnLogoutButtonFromDropdown();
    }
     
    @Test
    public void testDashboardLink(){  
        dashboardPage.clickOnDashboardNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedPanelHeadingText = "Dashboard";
        String actualPanelHeadingText = dashboardPage.getPanelHeadingText();
        
         assertTrue("Failed - panel heading texts doesnt't match", expectedPanelHeadingText.equals(actualPanelHeadingText));
         //expected result: user is on dashboard page           
    }
    @Test
    public void testSignaturesLink(){  
        
        SignaturesPage signaturesPage = dashboardPage.clickOnSignaturesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        
        String expectedPanelHeadingText = "Signatures";
        String actualPanelHeadingText = signaturesPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesnt't match", expectedPanelHeadingText.equals(actualPanelHeadingText));
         //expected result: user is on signatures page
        
    }
    @Test
    public void testCategoriesLink(){  
        
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedPanelHeadingText = "Categories";
        String actualPanelHeadingText = categoriesPage.getPanelHeadingText();
        assertTrue("Failed - panel heading texts doesn't match", actualPanelHeadingText.contains(expectedPanelHeadingText));
    //**
    }
    @Test
    public void testRegionsLink(){
        
        RegionsPage regionsPage = dashboardPage.clickOnRegionsNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedRegionsPanelHeadingText = "Regions";
        String actualRegionsPanelHeadingText = regionsPage.getPanelHeadingText();
        assertTrue("Failed - panel heading texts doesn't match", actualRegionsPanelHeadingText.contains(expectedRegionsPanelHeadingText));        
    }
    
    @Test
    public void testPortalsLink(){
        
        PortalsPage portalsPage = dashboardPage.clickOnPortalsNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedPortalsPanelHeadingText = "Portals";
        String actualPortalsPanelHeadingText = portalsPage.getPanelHeadingText();
        assertTrue("Failed - panel heading texts doesn't match", actualPortalsPanelHeadingText.contains(expectedPortalsPanelHeadingText));
    }
    
    @Test
    public void testSourcesLink(){
        
        SourcesPage sourcesPage = dashboardPage.clickOnSourcesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
    }
        
     
    

}
