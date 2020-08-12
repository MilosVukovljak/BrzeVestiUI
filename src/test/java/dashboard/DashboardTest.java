
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
        
        dashboardPage = new DashboardPage(driver);
    }
    
    @After
    public void tearDown() {
        dashboardPage.logout();
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
        dashboardPage.clickOnSignaturesNavLink();
        SignaturesPage signaturesPage = new SignaturesPage(driver);
        
        //SignaturesPage signaturesPage2 = dashboardPage.clickOnSignaturesNavLink2();
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
        dashboardPage.clickOnCategoriesNavLink();
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedCategoriesPanelHeadingText = "Categories";
        String actualCategoriesPanelHeadingText = categoriesPage.getPanelHeadingText();
        assertTrue("Failed - panel heading texts doesn't match", expectedCategoriesPanelHeadingText.equals(actualCategoriesPanelHeadingText));
    //**
    }
    @Test
    public void testRegionsLink(){
        dashboardPage.clickOnRegionsNavLink();
        RegionsPage regionsPage = new RegionsPage(driver);
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedRegionsPanelHeadingText = "Regions";
        String actualRegionsPanelHeadingText = regionsPage.getPanelHeadingText();
        assertTrue("Failed - panel heading texts doesn't match", expectedRegionsPanelHeadingText.equals(actualRegionsPanelHeadingText));        
    }
    
    @Test
    public void testPortalsLink(){
        dashboardPage.clickOnPortalsNavLink();
        PortalsPage portalsPage = new PortalsPage(driver);
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedPortalsPanelHeadingText = "Portals";
        String actualPortalsPanelHeadingText = portalsPage.getPanelHeadingText();
        assertTrue("Failed - panel heading texts doesn't match", expectedPortalsPanelHeadingText.equals(actualPortalsPanelHeadingText));
    }
    
    @Test
    public void testSourcesLink(){
        dashboardPage.clickOnSourcesNavLink();
        SourcesPage sourcesPage = new SourcesPage(driver);
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
    }
        
     
    

}
