package portals;

import base.BaseTest;
import framework.Helper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pages.AddPortalsPage;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PortalsPage;
import pages.RegionsPage;
import pages.SignaturesPage;
import pages.SourcesPage;

public class AddPortalTest extends BaseTest {
      private static AddPortalsPage addPortalsPage; 
    
      @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        DashboardPage dashboardPage = new DashboardPage(driver, wait);
        dashboardPage.clickOnPortalsNavLink();
        PortalsPage portalsPage = new PortalsPage(driver, wait);
        addPortalsPage = portalsPage.clickOnAddPortal();
    }
    
    @After
    public void tearDown() {
        addPortalsPage.logout();
    }
    
    @Test
    public void TestDashboardLink(){
        DashboardPage dashboardPage = addPortalsPage.clickOnDashboardNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
               
        String expectedDashboardPanelHeadingText = "Dashboard";
        String actualDashboardPanelHeadingText = dashboardPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualDashboardPanelHeadingText.contains(expectedDashboardPanelHeadingText));
    }
    @Test
    public void TestSignaturesLink(){
        SignaturesPage signaturesPage = addPortalsPage.clickOnSignaturesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedSignaturesPanelHeadingText = "Signatures";
        String actualSignaturesPanelHeadingText = signaturesPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualSignaturesPanelHeadingText.contains(expectedSignaturesPanelHeadingText));
    }
    @Test
    public void TestCategoriesLink(){
        CategoriesPage categoriesPage = addPortalsPage.clickOnCategoriesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedCategoriesPanelHeadingText = "Categories";
        String actualCategoriesPanelHeadingText = categoriesPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualCategoriesPanelHeadingText.contains(expectedCategoriesPanelHeadingText));
    }
    @Test
    public void TestRegionsLink(){
        RegionsPage regionsPage = addPortalsPage.clickOnRegionsNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedRegionsPanelHeadingText = "Regions";
        String actualRegionsPanelHeadingText = regionsPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualRegionsPanelHeadingText.contains(expectedRegionsPanelHeadingText));
    }
    @Test
    public void TestPortalsLink(){
        PortalsPage portalsPage = addPortalsPage.clickOnPortalsNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedPortalsPanelHeadingText = "Portals";
        String actualPortalsPanelHeadingText = portalsPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualPortalsPanelHeadingText.contains(expectedPortalsPanelHeadingText));
    }
    @Test
    public void TestSourcesLink(){
        SourcesPage sourcesPage = addPortalsPage.clickOnSourcesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
    }
    @Test
    public void TestEmptyFields(){
        addPortalsPage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
    @Test
    public void TestEmptyFieldsAndSelectedAnotherRegion(){
        String regionName = addPortalsPage.getOptionDropDownName();
        addPortalsPage.selectFromPortalsDropdown(regionName);
        addPortalsPage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
    @Test
    public void TestFilledTitleFieldAndEmptyUrlField(){
        String newTitle = Helper.getRandomText();
        addPortalsPage.enterTitleName(newTitle);
        addPortalsPage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
    @Test
    public void TestFilledTitleFieldAndEmptyUrlFieldAndSelectedAnotherRegion(){
        String newTitle = Helper.getRandomText();
        addPortalsPage.enterTitleName(newTitle);
        String regionName = addPortalsPage.getOptionDropDownName();
        addPortalsPage.selectFromPortalsDropdown(regionName);
        addPortalsPage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
    @Test
    public void TestFilledUrlFieldAndEmptyTitleField(){
        addPortalsPage.enterUrl();
        addPortalsPage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
    @Test
    public void TestFilledUrlFieldAndEmptyTitleFieldAndSelectedAnotherRegion(){
        addPortalsPage.enterUrl();
        String regionName = addPortalsPage.getOptionDropDownName();
        addPortalsPage.selectFromPortalsDropdown(regionName);
        addPortalsPage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
    @Test
    public void TestBackToPortalsButton(){
        addPortalsPage.clickOnBackToPortalsButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
    
}
