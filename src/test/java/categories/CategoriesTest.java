package categories;

import base.BaseTest;
import framework.Helper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assume;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddCategoryPage;
import pages.CategoriesEditPage;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PortalsPage;
import pages.RegionsPage;
import pages.SignaturesPage;
import pages.SourcesPage;

public class CategoriesTest extends BaseTest {
    private static CategoriesPage categoriesPage;
                        
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        DashboardPage dashboardPage = new DashboardPage(driver, wait);
        categoriesPage = dashboardPage.clickOnCategoriesNavLink();
    }    
    @After
    public void tearDown() {
        categoriesPage.logout();
    }
    
    @Test
    public void TestDashboardLink(){
        DashboardPage dashboardPage = categoriesPage.ClickOnDashboardNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
               
        String expectedDashboardPanelHeadingText = "Dashboard";
        String actualDashboardPanelHeadingText = dashboardPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualDashboardPanelHeadingText.contains(expectedDashboardPanelHeadingText));        
    }
    
    @Test
    public void TestSignaturesLink(){
        SignaturesPage signaturesPage = categoriesPage.ClickOnSignaturesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedSignaturesPanelHeadingText = "Signatures";
        String actualSignaturesPanelHeadingText = signaturesPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualSignaturesPanelHeadingText.contains(expectedSignaturesPanelHeadingText));
    }
    @Test 
    public void TestRegionsLink(){
        RegionsPage regionsPage = categoriesPage.clickOnRegionsNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedRegionsPanelHeadingText = "Regions";
        String actualRegionsPanelHeadingText = regionsPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualRegionsPanelHeadingText.contains(expectedRegionsPanelHeadingText));
    }
  
    @Test 
    public void TestPortalsLink(){
        PortalsPage portalsPage = categoriesPage.clickOnPortalsNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedPortalsPanelHeadingText = "Portals";
        String actualPortalsPanelHeadingText = portalsPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualPortalsPanelHeadingText.contains(expectedPortalsPanelHeadingText));
    }
        
    @Test
    public void TestSourcesLink(){
        SourcesPage sourcesPage = categoriesPage.clickOnSOurcesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);                
    }
    @Test 
    public void TestCategoriesLink(){
        categoriesPage.clickOnCategoriesNavLink();

        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedCategoriesPanelHeadingText = "Categories";
        String actualCategoriesPanelHeadingText = categoriesPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualCategoriesPanelHeadingText.contains(expectedCategoriesPanelHeadingText));
        
        }    
    
    @Test
    public void testEditFirstCategory(){
        CategoriesEditPage catEditPage = categoriesPage.clickOnEditCategory();
        String newTitle = Helper.getRandomText();
        catEditPage.enterTitle(newTitle);
        catEditPage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Category \"" + newTitle + "\" has been successfully saved!";
        String actualMessage = categoriesPage.getAlertMessageText();
        
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));        
    }
    //////////////////////////////////
    @Test
    public void testBackButtonFromCategoriesEditPage(){
        CategoriesEditPage catEditPage = categoriesPage.clickOnEditCategory();
        catEditPage.clickOnBackButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
    }
    ////////////////////////////////
    @Test
    public void testDisableFirstCategory() throws InterruptedException {
        
        String startingStatus = categoriesPage.getDisableStatusCharacter();
        Assume.assumeTrue("Preconditions is not met, category is already disabled", startingStatus.equals("E"));
        
        categoriesPage.clickOnDisableIcon();        
        categoriesPage.clickOnDisableButton();
        
        String titleName = categoriesPage.getTitleCategoryName();
        
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Category \"" + titleName + "\" has been disabled";
        String actualMessage = categoriesPage.getAlertMessageText();
        
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));   
        
        String expectedStatusCharacter = "D";
        String actualStatusCharacter = categoriesPage.getDisableStatusCharacter();
        
        assertTrue("Failed - status letter hasn't changed", expectedStatusCharacter.equals(actualStatusCharacter));
    }
    /////////////////////////////////
    @Test
    public void testEnableFirstCategory(){
        
        String startingStatus = categoriesPage.getDisableStatusCharacter();
        Assume.assumeTrue("Preconditions is not met, category is already disabled", startingStatus.equals("D"));
        
        categoriesPage.clickOnEnableIcon();        
        categoriesPage.clickOnEnableButton();
        
        String titleName = categoriesPage.getTitleCategoryName();
 
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Category \"" + titleName + "\" has been enabled";
        String actualMessage = categoriesPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));
        
        String expectedStatusCharacter = "E";
        String actualStatusCharacter = categoriesPage.getDisableStatusCharacter();
        
        assertTrue("Failed - status character doesn't match", expectedStatusCharacter.equals(actualStatusCharacter));                
    }
    @Test
    public void testCloseButtonFromDisableFirstCategory(){
        categoriesPage.clickOnDisableIcon();        
        categoriesPage.clickOnCloseButtonFromDisableCategory();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
    }
    @Test
    public void testDeleteFirstCategory(){
        String titleName = categoriesPage.getTitleCategoryName();
        categoriesPage.clickOnDeleteIcon();
        categoriesPage.clickOnDeleteButton();
    
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Category \"" + titleName + "\" has been successfully deleted!";
        String actualMessage = categoriesPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));       
    }
    @Test
    public void testCloseButtonFromDeleteFirstCategory(){
        categoriesPage.clickOnDeleteIcon();
        categoriesPage.clickOnCloseButtonFromDeleteCategory();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
    }
    @Test
    public void testAddNewCategory(){
        AddCategoryPage addCategoryPage = categoriesPage.clickOnAddCategoryButton();
        String newTitle = Helper.getRandomText();
        addCategoryPage.enterTitleNameInTitlefield(newTitle);
        addCategoryPage.clickOnSaveButton();
        
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Category \"" + newTitle + "\" has been successfully saved!";
        String actualMessage = categoriesPage.getAlertMessageText();
        
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));    
    }
    @Test
    public void testBackToCategoriesButton(){
        AddCategoryPage addCategoryPage = categoriesPage.clickOnAddCategoryButton();
        addCategoryPage.clickOnBackToCategoriesButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);       
    }
    @Test
    public void testSeventhEditCategory(){
        CategoriesEditPage categoriesEditPage = categoriesPage.clickOnEditIconOnSevethCategory();
        String newTitle = Helper.getRandomText();
        categoriesEditPage.enterTitle(newTitle);
        categoriesEditPage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Category \"" + newTitle + "\" has been successfully saved!";
        String actualMessage = categoriesPage.getAlertMessageText();
        
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));     
    }
    @Test
    public void testDisableSeventhCategory(){
        String startingStatus = categoriesPage.getStatusCharacterSeventhCategory();
        Assume.assumeTrue("Preconditions is not met, category is already disabled", startingStatus.equals("E"));
        
        categoriesPage.clickOnDisableIconOnSeventhCategory();
        categoriesPage.clickOnDisableButton();
        
        String titleName = categoriesPage.getTitleSeventhCategoryName();
        
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Category \"" + titleName + "\" has been disabled";
        String actualMessage = categoriesPage.getAlertMessageText();
        
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));   
        
        String expectedStatusCharacter = "D";
        String actualStatusCharacter = categoriesPage.getStatusCharacterSeventhCategory();
        
        assertTrue("Failed - status letter hasn't changed", expectedStatusCharacter.equals(actualStatusCharacter));
    }
    @Test
    public void testEnableSeventhCategory(){
        String startingStatus = categoriesPage.getStatusCharacterSeventhCategory();
        Assume.assumeTrue("Preconditions is not met, category is already enabled", startingStatus.equals("D"));
        
        categoriesPage.clickOnEnableIconOnSeventhCategory();
        categoriesPage.clickOnEnableButton();
        
        String titleName = categoriesPage.getTitleSeventhCategoryName();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Category \"" + titleName + "\" has been enabled";
        String actualMessage = categoriesPage.getAlertMessageText();
        
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));
        
        String expectedStatusCharacter = "E";
        String actualStatusCharacter = categoriesPage.getStatusCharacterSeventhCategory();
        
        assertTrue("Failed - status letter hasn't changed", expectedStatusCharacter.equals(actualStatusCharacter));   
    }
    @Test
    public void testDeleteSeventhCategory(){
        String titleName = categoriesPage.getTitleSeventhCategoryName();
        categoriesPage.clickOnDeleteIconOnSeventhCategory();
        categoriesPage.clickOnDeleteButton();
    
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedMessage = "Category \"" + titleName + "\" has been successfully deleted!";
        String actualMessage = categoriesPage.getAlertMessageText();
        assertTrue("Failed - wrong alert message", expectedMessage.equals(actualMessage));
    }

}