package sources;

import base.BaseTest;
import framework.Helper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assume;
import pages.AddSourcePage;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PortalsPage;
import pages.RegionsPage;
import pages.SignaturesPage;
import pages.SourcesEditPage;
import pages.SourcesPage;

public class SourcesTest extends BaseTest {
    private static SourcesPage sourcesPage;
    
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        DashboardPage dashboardPage = new DashboardPage(driver, wait);
        sourcesPage = dashboardPage.clickOnSourcesNavLink();
    }
    
    @After
    public void tearDown() {
        sourcesPage.logout();
    }
    
    @Test
    public void TestDashboardLink(){
        DashboardPage dashboardPage = sourcesPage.clickOnDashboardNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
               
        String expectedDashboardPanelHeadingText = "Dashboard";
        String actualDashboardPanelHeadingText = dashboardPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualDashboardPanelHeadingText.contains(expectedDashboardPanelHeadingText)); 
    }
    @Test
    public void TestSignaturesLink(){
        SignaturesPage signaturesPage = sourcesPage.clickOnSignaturesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedSignaturesPanelHeadingText = "Signatures";
        String actualSignaturesPanelHeadingText = signaturesPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualSignaturesPanelHeadingText.contains(expectedSignaturesPanelHeadingText));
    }
    @Test
    public void TestCategoriesLink(){
        CategoriesPage categoriesPage = sourcesPage.clickOnCategoriesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedCategoriesPanelHeadingText = "Categories";
        String actualCategoriesPanelHeadingText = categoriesPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualCategoriesPanelHeadingText.contains(expectedCategoriesPanelHeadingText));
    }
    @Test
    public void TestRegionsLink(){
        RegionsPage regionsPage = sourcesPage.clickOnRegionsNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedRegionsPanelHeadingText = "Regions";
        String actualRegionsPanelHeadingText = regionsPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualRegionsPanelHeadingText.contains(expectedRegionsPanelHeadingText));
    }
    @Test
    public void TestPortalsLink(){
        PortalsPage portalsPage = sourcesPage.clickOnPortalsNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedPortalsPanelHeadingText = "Portals";
        String actualPortalsPanelHeadingText = portalsPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualPortalsPanelHeadingText.contains(expectedPortalsPanelHeadingText));
    }
    @Test
    public void TestSourcesLink(){
        sourcesPage.clickOnSourcesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl); 
    }
    @Test
    public void TestAddSource(){
        AddSourcePage addSourcePage = sourcesPage.clickOnAddSourceButton();
        String optionName = addSourcePage.getOptionDropDownName();
        addSourcePage.selectPortalFromDropDownList(optionName);
        String newTitle = Helper.getRandomText();
        addSourcePage.enterTitleName(newTitle);
        String newUrl = Helper.getRandomUrl();
        addSourcePage.enterUrl(newUrl);
        String sourceTypeName = addSourcePage.getSourceTypeName();
        addSourcePage.selectSourceType(sourceTypeName);
        String sourceProcessorName = addSourcePage.getSourceProcessorName();
        addSourcePage.selectSourceProcessor(sourceProcessorName);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
        
        String expectedMessage = "Source \"" + newTitle + "\" has been successfully saved!";
        String actualMessage = sourcesPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));
    }
    @Test
    public void TestAddSourceSecondWay(){
        AddSourcePage addSourcePage = sourcesPage.clickOnAddSourceButton();
        String optionName = addSourcePage.getOptionDropDownName();
        addSourcePage.selectPortalFromDropDownList(optionName);
        String newTitle = Helper.getRandomText();
        addSourcePage.enterTitleName(newTitle);
        String newUrl = Helper.getRandomUrl();
        addSourcePage.enterUrl(newUrl);
        String sourceTypeName = addSourcePage.getSourceTypeName();
        addSourcePage.selectSourceType(sourceTypeName);
        String firstProcessorName = addSourcePage.getFirstSourceProcessorName();
        addSourcePage.selectSourceProcessor(firstProcessorName);
        String categoryName = addSourcePage.getSourceCategoryName();
        addSourcePage.selectSourceCategory(categoryName);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
        
        String expectedMessage = "Source \"" + newTitle + "\" has been successfully saved!";
        String actualMessage = sourcesPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));
    }
    @Test
    public void TestEditFirstSource(){
        SourcesEditPage sourceEditPage = sourcesPage.clickOnFirstEditIcon();
        String portalName = sourceEditPage.getOptionDropDownName();
        sourceEditPage.selectPortalFromDropDownList(portalName);
        String newTitle = Helper.getRandomText();
        sourceEditPage.enterTitleName(newTitle);
        String newUrl = Helper.getRandomUrl();
        sourceEditPage.enterUrl(newUrl);
        String sourceTypeName = sourceEditPage.getSourceTypeName();
        sourceEditPage.selectSourceType(sourceTypeName);
        String sourceProcessorName = sourceEditPage.getSourceProcessorName();
        sourceEditPage.selectSourceProcessor(sourceProcessorName);
        sourceEditPage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
        
        String expectedMessage = "Source \"" + newTitle + "\" has been successfully saved!";
        String actualMessage = sourcesPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));
    }
    @Test
    public void TestDisableFirstSource(){
        String startingStatus = sourcesPage.getStatusLetter();
        Assume.assumeTrue("Precondition is not met, source is already disabled", startingStatus.equals("E"));
        
        sourcesPage.clickOnDisableEnableIcon();
        sourcesPage.clickOnDisableButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
        
        String titleName = sourcesPage.getTitleName();
        String expectedMessage = "Source \"" + titleName + "\" has been disabled";
        String actualMessage = sourcesPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));
        
        String expectedStatusLetter = "D";
        String actualStatusLetter = sourcesPage.getStatusLetter();
        assertTrue("Failed - status letter hasn't changed", expectedStatusLetter.equals(actualStatusLetter));
    }
    @Test 
    public void TestEnableFirstSource(){
        String startingStatus = sourcesPage.getStatusLetter();
        Assume.assumeTrue("Precondition is not met, source is already enabled", startingStatus.equals("D"));
        
        sourcesPage.clickOnDisableEnableIcon();
        sourcesPage.clickOnEnableButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
        
        String titleName = sourcesPage.getTitleName();
        String expectedMessage = "Source \"" + titleName + "\" has been enabled";
        String actualMessage = sourcesPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));
        
        String expectedStatusLetter = "E";
        String actualStatusLetter = sourcesPage.getStatusLetter();
        assertTrue("Failed - status letter hasn't changed", expectedStatusLetter.equals(actualStatusLetter));
    }
    @Test
    public void TestDeleteFirstSource(){
        String titleName = sourcesPage.getTitleName();
        sourcesPage.clickOnDeleteIcon();
        sourcesPage.clickOnDeleteButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
        
        String expectedMessage = "Source \"" + titleName + "\" has been successfully deleted!";
        String actualMessage = sourcesPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));
        
        
        
    }
}
