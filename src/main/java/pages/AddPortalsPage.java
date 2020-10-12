
package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddPortalsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private final By dashboardLinkLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[1]/a");
    private final By signaturesLinkLocator = By.linkText("Signatures");
    private final By categoriesLinkLocator = By.linkText("Categories");
    private final By regionsLinkLocator = By.linkText("Regions");
    private final By portalsLinkLocator = By.linkText("Portals");
    private final By sourcesLinkLocator = By.linkText("Sources");
    private final By titleFieldLocator = By.id("title");
    private final By urlFieldLocator = By.id("url");
    private final By regionDropDown = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/fieldset/div[3]/div/select");
    private final By saveButtonLocator = By.id("save-portal-button");
    private final By optionOfDropDownNameLocator = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/fieldset/div[3]/div/select/option[2]");
    private final By panelHeadingTextLocator = By.cssSelector("panel-heading");
    private final By backToPortalsButtonLocator = By.id("back-button");
    private final By optionDropDownListLoctar = By.className("dropdown-toggle");
    private final By logoutButtonLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[2]/li/ul/li/a");

    public AddPortalsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public void clickOnLogoutDropDownList(){
        driver.findElement(optionDropDownListLoctar).click();
    }
    public void clickOnLogoutButton(){
        driver.findElement(logoutButtonLocator).click();
    }
    public void logout(){
        clickOnLogoutDropDownList();
        clickOnLogoutButton();
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
    public SourcesPage clickOnSourcesNavLink(){
        driver.findElement(sourcesLinkLocator).click();
        return new SourcesPage(driver, wait);
    }
    public void enterTitleName(String newTitle){
       driver.findElement(titleFieldLocator).sendKeys(newTitle);
    }
    
    public void enterUrl(){
        driver.findElement(urlFieldLocator).sendKeys(Helper.getRandomUrl());
    }
    
    public void selectFromPortalsDropdown(String regionName) {
        Select portalsDropdown = new Select(driver.findElement(regionDropDown));
        portalsDropdown.selectByVisibleText(regionName);
    } 
    
    public void clickOnSaveButton(){
        driver.findElement(saveButtonLocator).click();
    }
    public String getOptionDropDownName(){
        return driver.findElement(optionOfDropDownNameLocator).getText();
    }
    public String getPanelHeadingText(){
        return driver.findElement(panelHeadingTextLocator).getText();
    }
    public PortalsPage clickOnBackToPortalsButton(){
        driver.findElement(backToPortalsButtonLocator).click();
        return new PortalsPage(driver, wait);
    }
}
