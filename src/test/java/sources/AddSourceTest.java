package sources;

import base.BaseTest;
import framework.Helper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pages.AddSourcePage;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PortalsPage;
import pages.RegionsPage;
import pages.SignaturesPage;
import pages.SourcesPage;

public class AddSourceTest extends BaseTest{
        private static AddSourcePage addSourcePage;
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        DashboardPage dashboardPage = new DashboardPage(driver, wait);
        dashboardPage.clickOnSourcesNavLink();
        SourcesPage sourcesPage = new SourcesPage(driver, wait);
        addSourcePage = sourcesPage.clickOnAddSourceButton();
    }
    
    @After
    public void tearDown() {
        addSourcePage.logout();
    }
    
    @Test
    public void TestDashboardLink(){
        DashboardPage dashboardPage = addSourcePage.clickOnDashboardNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
               
        String expectedDashboardPanelHeadingText = "Dashboard";
        String actualDashboardPanelHeadingText = dashboardPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualDashboardPanelHeadingText.contains(expectedDashboardPanelHeadingText));
    }
    @Test
    public void TestSignaturesLink(){
        SignaturesPage signaturesPage = addSourcePage.clickOnSignaturesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedSignaturesPanelHeadingText = "Signatures";
        String actualSignaturesPanelHeadingText = signaturesPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualSignaturesPanelHeadingText.contains(expectedSignaturesPanelHeadingText));
    }
    @Test
    public void TestCategoriesLink(){
        CategoriesPage categoriesPage = addSourcePage.clickOnCategoriesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedCategoriesPanelHeadingText = "Categories";
        String actualCategoriesPanelHeadingText = categoriesPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualCategoriesPanelHeadingText.contains(expectedCategoriesPanelHeadingText));
    }
    @Test
    public void TestRegionsLink(){
        RegionsPage regionsPage = addSourcePage.clickOnRegionsNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedRegionsPanelHeadingText = "Regions";
        String actualRegionsPanelHeadingText = regionsPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualRegionsPanelHeadingText.contains(expectedRegionsPanelHeadingText));
    }
    @Test
    public void TestPortalsLink(){
        PortalsPage portalsPage = addSourcePage.clickOnPortalsNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedPortalsPanelHeadingText = "Portals";
        String actualPortalsPanelHeadingText = portalsPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualPortalsPanelHeadingText.contains(expectedPortalsPanelHeadingText));
    }
    @Test
    public void TestSourcesLink(){
        SourcesPage sourcesPage = addSourcePage.clickOnSourcesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
    }
    @Test
    public void TestEmptyFields(){
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
    }
    @Test
    public void TestSelectedPortalFieldAndRestEmptyFields(){
        String optionName = addSourcePage.getOptionDropDownName();
        addSourcePage.selectPortalFromDropDownList(optionName);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
    }
    @Test
    public void TestFilledTitleFieldAndRestEmptyFields(){
        String newTitle = Helper.getRandomText();
        addSourcePage.enterTitleName(newTitle);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
    }
    @Test
    public void TestFilledUrlFieldAndRestEmptyFields(){
        String newUrl = Helper.getRandomUrl();
        addSourcePage.enterUrl(newUrl);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
    }
    @Test
    public void TestSelectedAnotherProccesorAndRestEmptyFields(){
        String sourceProcessorName = addSourcePage.getSourceProcessorName();
        addSourcePage.selectSourceProcessor(sourceProcessorName);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
    }
    @Test
    public void TestSelectedCategoryAndRestEmptyFields(){
        String categoryName = addSourcePage.getSourceCategoryName();
        addSourcePage.selectSourceCategory(categoryName);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
    }
    @Test
    public void TestSelectedPortalFilledTitleAndRestEmptyFields(){
        String optionName = addSourcePage.getOptionDropDownName();
        addSourcePage.selectPortalFromDropDownList(optionName);
        String newTitle = Helper.getRandomText();
        addSourcePage.enterTitleName(newTitle);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);        
    }
    @Test
    public void TestSelectedPortalFilledTitleUrlFieldsAndRestEmptyFields(){
        String optionName = addSourcePage.getOptionDropDownName();
        addSourcePage.selectPortalFromDropDownList(optionName);
        String newTitle = Helper.getRandomText();
        addSourcePage.enterTitleName(newTitle);
        String newUrl = Helper.getRandomUrl();
        addSourcePage.enterUrl(newUrl);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
    }
    @Test
    public void TestFilledTitleUrlFieldsAndRestEpmtyFields(){
        String newTitle = Helper.getRandomText();
        addSourcePage.enterTitleName(newTitle);
        String newUrl = Helper.getRandomUrl();
        addSourcePage.enterUrl(newUrl);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
    @Test
    public void TestFilledTitleUrlFieldsSelectedProcessorAndRestEmptyFields(){
        String newTitle = Helper.getRandomText();
        addSourcePage.enterTitleName(newTitle);
        String newUrl = Helper.getRandomUrl();
        addSourcePage.enterUrl(newUrl);
        String sourceProcessorName = addSourcePage.getSourceProcessorName();
        addSourcePage.selectSourceProcessor(sourceProcessorName);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
    @Test
    public void TestFilledTitleUrlFieldsSelectedCategoryAndRestEmptyFields(){
        String newTitle = Helper.getRandomText();
        addSourcePage.enterTitleName(newTitle);
        String newUrl = Helper.getRandomUrl();
        addSourcePage.enterUrl(newUrl);
        String categoryName = addSourcePage.getSourceCategoryName();
        addSourcePage.selectSourceCategory(categoryName);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
    @Test
    public void TestSelectedPortalFilledUrlFieldAndRestEmptyFields(){
        String optionName = addSourcePage.getOptionDropDownName();
        addSourcePage.selectPortalFromDropDownList(optionName);
        String newUrl = Helper.getRandomUrl();
        addSourcePage.enterUrl(newUrl);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
    @Test
    public void TestSelectedPortalFilledUrlFieldSelectedProcessorAndRestEmptyFields(){
        String optionName = addSourcePage.getOptionDropDownName();
        addSourcePage.selectPortalFromDropDownList(optionName);
        String newUrl = Helper.getRandomUrl();
        addSourcePage.enterUrl(newUrl);
        String sourceProcessorName = addSourcePage.getSourceProcessorName();
        addSourcePage.selectSourceProcessor(sourceProcessorName);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
    @Test
    public void TestSelectedPortalFilledUrlFieldSelectedCategoryAndRestEmptyFields(){
        String optionName = addSourcePage.getOptionDropDownName();
        addSourcePage.selectPortalFromDropDownList(optionName);
        String newUrl = Helper.getRandomUrl();
        addSourcePage.enterUrl(newUrl);
        String categoryName = addSourcePage.getSourceCategoryName();
        addSourcePage.selectSourceCategory(categoryName);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
    @Test
    public void TestSelectedPortalFilledTitleFieldAndRestEmptyFields(){
        String optionName = addSourcePage.getOptionDropDownName();
        addSourcePage.selectPortalFromDropDownList(optionName);
        String newTitle = Helper.getRandomText();
        addSourcePage.enterTitleName(newTitle);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
    @Test
    public void TestSelectedPortalFilledTitleFieldSelectedProcessorAndRestEmptyFields(){
        String optionName = addSourcePage.getOptionDropDownName();
        addSourcePage.selectPortalFromDropDownList(optionName);
        String newTitle = Helper.getRandomText();
        addSourcePage.enterTitleName(newTitle);
        String sourceProcessorName = addSourcePage.getSourceProcessorName();
        addSourcePage.selectSourceProcessor(sourceProcessorName);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
    @Test
    public void TestSelectedPortalFilledTitleFieldSelectedCategoryAndRestEmptyFields(){
        String optionName = addSourcePage.getOptionDropDownName();
        addSourcePage.selectPortalFromDropDownList(optionName);
        String newTitle = Helper.getRandomText();
        addSourcePage.enterTitleName(newTitle);
        String categoryName = addSourcePage.getSourceCategoryName();
        addSourcePage.selectSourceCategory(categoryName);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
    @Test
    public void TestSelectedPortalFilledTitleUrlFieldAndLeaveUnchoosenCategory(){
        String optionName = addSourcePage.getOptionDropDownName();
        addSourcePage.selectPortalFromDropDownList(optionName);
        String newTitle = Helper.getRandomText();
        addSourcePage.enterTitleName(newTitle);
        String newUrl = Helper.getRandomUrl();
        addSourcePage.enterUrl(newUrl);
        addSourcePage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources/insert";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
    }
}
