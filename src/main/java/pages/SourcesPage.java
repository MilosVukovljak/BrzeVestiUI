package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SourcesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    
    private final By dropDownLogoutListLocator = By.className("dropdown-toggle");
    private final By logoutButtonLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[2]/li/ul/li/a");
    private final By alertMessageLocator = By.className("alert-success");
    private final By dashboardLinkLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[1]/a");
    private final By signaturesLinkLocator = By.linkText("Signatures");
    private final By categoriesLinkLocator = By.linkText("Categories");
    private final By regionsLinkLocator = By.linkText("Regions");
    private final By portalsLinkLocator = By.linkText("Portals");
    private final By sourcesLinkLocator = By.linkText("Sources");
    private final By addSourceButtonLocator = By.className("pull-right");
    
    
    public SourcesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    } 
    
    public void clickOnLogoutDropdownList(){
        driver.findElement(dropDownLogoutListLocator).click();
    }
    public void clickOnLogoutButton(){
        driver.findElement(logoutButtonLocator).click();
    }
    public void logout(){
        clickOnLogoutDropdownList();
        clickOnLogoutButton();
    }
    public String getAlertMessageText(){
        return driver.findElement(alertMessageLocator).getText();
    } 
    public DashboardPage clickOnDashboardNavLink(){
        driver.findElement(dashboardLinkLocator).click();
        return new DashboardPage(driver, wait);
    }
    public SignaturesPage clickOnSignaturesNavLink(){
        driver.findElement(signaturesLinkLocator).click();
        return new SignaturesPage(driver, wait);
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
    public void clickOnSourcesNavLink(){
        driver.findElement(sourcesLinkLocator).click();
    }
    public AddSourcePage clickOnAddSourceButton(){
        driver.findElement(addSourceButtonLocator).click();
        return new AddSourcePage(driver, wait);
    }
}
