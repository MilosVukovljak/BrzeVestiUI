package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private final By optionsDropDownLocator = By.className("dropdown-toggle");
    private final By logoutButtonLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[2]/li/ul/li/a");
    private final By dashboardLinkLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[1]/a");
    private final By signaturesLinkLocator = By.linkText("Signatures");
    private final By categoriesLinkLocator = By.linkText("Categories");
    private final By regionsLinkLocator = By.linkText("Regions");
    private final By portalsLinkLocator = By.linkText("Portals");
    private final By sourcesLinkLocator = By.linkText("Sources");
    private final By panelHeading = By.className("panel-heading");
    
    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }
    private void clickOnOptionsDropdown(){
        driver.findElement(optionsDropDownLocator);
    }
    private void clickOnLogoutButtonFromDropdown(){
     driver.findElement(logoutButtonLocator);
    }
    public void logout(){
      clickOnOptionsDropdown();
      clickOnLogoutButtonFromDropdown();
    }
   public void clickOnDashboardNavLink(){
       driver.findElement(dashboardLinkLocator).click();
   }
   public void clickOnSignaturesNavLink(){
       driver.findElement(signaturesLinkLocator).click();
   }
   public SignaturesPage clickOnSignaturesNavLink2(){
       driver.findElement(signaturesLinkLocator).click();
       return new SignaturesPage(driver);////******
   }
   public void clickOnCategoriesNavLink(){
       driver.findElement(categoriesLinkLocator).click();
   }
   public void clickOnRegionsNavLink(){
       driver.findElement(regionsLinkLocator).click();
   }
   public void clickOnPortalsNavLink(){
       driver.findElement(portalsLinkLocator).click();
   }
   public void clickOnSourcesNavLink(){
       driver.findElement(sourcesLinkLocator).click();
   }
   public String getPanelHeadingText(){
      return driver.findElement(panelHeading).getText();
   }
}
