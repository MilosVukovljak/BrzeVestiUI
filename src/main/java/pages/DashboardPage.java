package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private WebDriver driver;
    private final WebDriverWait wait;
    
    private final By dropDownLogoutListLocator = By.className("dropdown-toggle");
    private final By logoutButtonLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[2]/li/ul/li/a");
    private final By dashboardLinkLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[1]/a");
    private final By signaturesLinkLocator = By.linkText("Signatures");
    private final By categoriesLinkLocator = By.linkText("Categories");
    private final By regionsLinkLocator = By.linkText("Regions");
    private final By portalsLinkLocator = By.linkText("Portals");
    private final By sourcesLinkLocator = By.linkText("Sources");
    private final By panelHeading = By.className("panel-heading");
    
    public DashboardPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    public void clickOnOptionsDropdown(){
        driver.findElement(dropDownLogoutListLocator);
    }
    public void clickOnLogoutButtonFromDropdown(){
     driver.findElement(logoutButtonLocator);
    }
    public void logout(){
      clickOnOptionsDropdown();
      clickOnLogoutButtonFromDropdown();
    }
   public void clickOnDashboardNavLink(){
       driver.findElement(dashboardLinkLocator).click();
   }
   public SignaturesPage clickOnSignaturesNavLink(){
       driver.findElement(signaturesLinkLocator).click();
       return new SignaturesPage(driver, wait);////******
   }
   public CategoriesPage clickOnCategoriesNavLink(){
       driver.findElement(categoriesLinkLocator).click();
       return new CategoriesPage(driver, wait);
   }
   public RegionsPage clickOnRegionsNavLink(){
       driver.findElement(regionsLinkLocator).click();
       return new RegionsPage(driver, wait);
   }
   public PortalsPage clickOnPortalsNavLink(){
       driver.findElement(portalsLinkLocator).click();
       return new PortalsPage(driver, wait);
   }
   public SourcesPage clickOnSourcesNavLink(){
       driver.findElement(sourcesLinkLocator).click();
       return new SourcesPage(driver, wait);
   }
   public String getPanelHeadingText(){
      return driver.findElement(panelHeading).getText();
   }
}
