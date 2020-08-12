package categories;

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

public class CategoriesTest extends BaseTest {
    private static CategoriesPage categoriesPage;
            
            
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        DashboardPage dashboardPage = new DashboardPage(driver);
       // categoriesPage = dashboardPage.clickOnCategoriesNavLink();
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testEditFirstCategory(){
        
    }
}
