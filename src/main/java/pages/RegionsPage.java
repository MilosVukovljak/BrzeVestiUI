package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegionsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    
    private final By panelHeadingLocator = By.className("panel-heading");
    private final By dropDownLogoutListLocator = By.className("dropdown-toggle");
    private final By logoutButtonLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[2]/li/ul/li/a"); 
    private final By editFirstRegionIconLocator = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr/td[5]/div/a/span");
    private final By addRegionButtonLocator = By.className("pull-right");
    private final By alertMessageLocator = By.className("alert-success");
    private final By dashboardLinkLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[1]/a");//**
    private final By signaturesLinkLocator = By.linkText("Signatures");
    private final By categoriesLinkLocator = By.linkText("Categories");
    private final By regionsLinkLocator = By.linkText("Regions");
    private final By portalsLinkLocator = By.linkText("Portals");
    private final By sourcesLinkLocator = By.linkText("Sources");//**
    private final By statusLetterLocator = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[4]/span");
    private final By disableIconLocator = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[5]/div/button[1]/span");
    private final By disableButtonLocator = By.xpath("//*[@id=\"regionDisableDialog\"]/div/div/div[3]/button[2]");
    private final By enableIconLocator = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr/td[5]/div/button[1]/span");
    private final By enableButtonLocator = By.xpath("//*[@id=\"regionEnableDialog\"]/div/div/div[3]/button[2]");
    private final By deleteIconLocator = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[5]/div/button[2]/span");
    private final By deleteButtonLocator = By.xpath("//*[@id=\"regionDeleteDialog\"]/div/div/div[3]/button[2]");
    private final By titleNameLocator = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[3]");
    

    public RegionsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public String getPanelHeadingText(){
        return driver.findElement(panelHeadingLocator).getText();
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
    
    public DashboardPage ClickOnDashboardNavLink(){
        driver.findElement(dashboardLinkLocator).click();
        return new DashboardPage(driver, wait);
    }
    
    public SignaturesPage ClickOnSignaturesNavLink(){
        driver.findElement(signaturesLinkLocator).click();
        return new SignaturesPage(driver, wait);
    }
    
    public CategoriesPage ClickOnCategoriesNavLink(){
        driver.findElement(categoriesLinkLocator).click();
        return new CategoriesPage(driver, wait);
    }
    
    public void clickOnRegionsNavLink(){
       driver.findElement(regionsLinkLocator).click();
   } 
    
    public PortalsPage ClickOnPortalsNavLink(){
        driver.findElement(portalsLinkLocator).click();
        return new PortalsPage(driver, wait);
    }
    
    public SourcesPage ClickOnSourcesNavLink(){
        driver.findElement(sourcesLinkLocator).click();
        return new SourcesPage(driver, wait);
    }
    public String getStatusLetter(){
        return driver.findElement(statusLetterLocator).getText();
    }
    public void clickOnDisableIcon(){
        driver.findElement(disableIconLocator).click();
    }
    public void clickOnDisableButton(){
        wait.until(ExpectedConditions.elementToBeClickable(disableButtonLocator)).click();
    }
    public void clickOnEnableIcon(){
        driver.findElement(enableIconLocator).click();
    }
    public void clickOnEnableButton(){
        wait.until(ExpectedConditions.elementToBeClickable(enableButtonLocator)).click();
    }
    public void clickOnDeleteIcon(){
        driver.findElement(deleteIconLocator).click();
    }
    public void clickOnDeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteButtonLocator)).click();
    }
    public RegionsEditPage clickOnEditFirstRegionIcon(){
        driver.findElement(editFirstRegionIconLocator).click();
        return new RegionsEditPage(driver, wait);
    }
    public AddRegionPage clickOnAddRegionButton(){
        driver.findElement(addRegionButtonLocator).click();
        return new AddRegionPage(driver, wait);
    }
    public String getTitleName(){
        return driver.findElement(titleNameLocator).getText();
    }
    
    
    
    
}
