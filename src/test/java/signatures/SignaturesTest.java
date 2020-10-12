package signatures;

import base.BaseTest;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PortalsPage;
import pages.RegionsPage;
import pages.SignaturesPage;
import pages.SourcesPage;

public class SignaturesTest extends BaseTest{
    private static SignaturesPage signaturesPage;
    
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        DashboardPage dashboardPage = new DashboardPage(driver, wait);
        signaturesPage = dashboardPage.clickOnSignaturesNavLink();
    }
    
    @After
    public void tearDown() {
        signaturesPage.logout();
    } 
    
    @Test
    public void testDashboardLink(){
        DashboardPage dashboardPage = signaturesPage.clickOnDashboardNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedDashboardPanelHeadingText = "Dashboard";
        String actualDashboardPanelHeadingText = dashboardPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualDashboardPanelHeadingText.contains(expectedDashboardPanelHeadingText));
    }
    @Test
    public void testSignaturesLink(){
        signaturesPage.clickOnSignaturesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedSignaturesPanelHeadingText = "Signatures";
        String actualSignaturesPanelHeadingText = signaturesPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualSignaturesPanelHeadingText.contains(expectedSignaturesPanelHeadingText)); 
    }
    @Test
    public void testCategoriesLink(){
        CategoriesPage categoriesPage = signaturesPage.clickOnCategoriesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match", expectedUrl, actualUrl);
        
        String expectedCategoriesPanelHeadingText = "Categories";
        String actualCategoriesPanelHeadingText = categoriesPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualCategoriesPanelHeadingText.contains(expectedCategoriesPanelHeadingText));
    }
    @Test
    public void testRegionsLink(){
        RegionsPage regionsPage = signaturesPage.clickOnRegionsNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedRegionsPanelHeadingText = "Regions";
        String actualRegionsPanelHeadingText = regionsPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualRegionsPanelHeadingText.contains(expectedRegionsPanelHeadingText));  
    }
    @Test
    public void testPortalsLink(){
        PortalsPage portalsPage = signaturesPage.clickOnPortalsNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedPortalsPanelHeadingText = "Portals";
        String actualPortalsPanelHeadingText = portalsPage.getPanelHeadingText();
        
        assertTrue("Failed - panel heading texts doesn't match", actualPortalsPanelHeadingText.contains(expectedPortalsPanelHeadingText));
    }
    @Test
    public void testSourcesLink(){
        SourcesPage sourcesPage = signaturesPage.clickOnSourcesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
    }
    @Test
    public void testChangeCategory(){
        signaturesPage.clickOnChangeCategoryIcon();
        String categoryOptionName = signaturesPage.getSelectedCategoryName();
        signaturesPage.selectCategory(categoryOptionName);
        signaturesPage.clickOnApproveButton();
        String signatureName = signaturesPage.getSignatureName();
        String categoryName = signaturesPage.getCategoryName();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedAlertMessage = "News processor signature \"" + signatureName + "\" has been approved with category \"" + categoryName + "\"";
        String actualAlertMessage = signaturesPage.getAlertMessage();
        assertTrue("Failed - wrong alert message", expectedAlertMessage.equals(actualAlertMessage));
    }
    @Test
    public void testIgnoreSignature(){
        String startingStatusLetter = signaturesPage.getStatusLetter();
        Assume.assumeTrue("Preconditions is not met, category is already disabled", startingStatusLetter.equals("A"));
        
        signaturesPage.clickOnIgonreIcon();
        signaturesPage.clickOnIgnoreButton();
        String signatureName = signaturesPage.getSignatureName();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedAlertMessage = "Status of news processor signature \"" + signatureName + "\" has been set to IGNORE";
        String actualAlertMessage = signaturesPage.getAlertMessage();
        assertTrue("Failed - wrong alert message", expectedAlertMessage.equals(actualAlertMessage));
        
        String expectedStatusCharacter = "I";
        String actualStatusCharacter = signaturesPage.getStatusLetter();
        assertTrue("Failed - status letter hasn't changed", expectedStatusCharacter.equals(actualStatusCharacter));
    }
    @Test 
    public void testApproveSignature(){
        String startingStatusLetter = signaturesPage.getStatusLetter();
        Assume.assumeTrue("Preconditions is not met, category is already disabled", startingStatusLetter.equals("I"));
        
        signaturesPage.clickOnApproveIcon();
        signaturesPage.clickOnApproveButton();
        String signatureName = signaturesPage.getSignatureName();
        String categoryName = signaturesPage.getCategoryName();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedAlertMessage = "News processor signature \"" + signatureName + "\" has been approved with category \"" + categoryName + "\"";
        String actualAlertMessage = signaturesPage.getAlertMessage();
        assertTrue("Failed - wrong alert message", expectedAlertMessage.equals(actualAlertMessage));
        
        String expectedStatusCharacter = "A";
        String actualStatusCharacter = signaturesPage.getStatusLetter();
        assertTrue("Failed - status letter hasn't changed", expectedStatusCharacter.equals(actualStatusCharacter));
    }
    @Test
    public void testDeleteSignature(){
        String signatureName = signaturesPage.getSignatureName();
        signaturesPage.clickOnDeleteIcon();
        signaturesPage.clickOnDeleteButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
        String expectedAlertMessage = "News processor signature \"" + signatureName + "\" has been successfully deleted!";
        String actualAlertMessage = signaturesPage.getAlertMessage();
        assertTrue("Failed - wrong alert message", expectedAlertMessage.equals(actualAlertMessage));
    }
    @Test
    public void testPortalsSortList(){
        String portalName = signaturesPage.getPortalName();
        signaturesPage.selectPortal(portalName);
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesnt' match", expectedUrl, actualUrl);
        
       // String expectedSortedPortalNames = portalName;
      //  String actualSortedPortalNames = signaturesPage.getSortedPortalName();
       // assertTrue("Failed - wrong alert message", expectedSortedPortalNames.equals(actualSortedPortalNames));
    }
    
}