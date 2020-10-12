package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    private final By editIconLocator = By.xpath("//*[@id=\"sourcesTable\"]/tbody/tr[1]/td[8]/div/a/span");
    private final By statusLetterLocator = By.xpath("//*[@id=\"sourcesTable\"]/tbody/tr[1]/td[7]/span");
    private final By disableEnableIconLocator = By.xpath("//*[@id=\"sourcesTable\"]/tbody/tr[1]/td[8]/div/button[1]/span");
    private final By disableButtonLocator = By.xpath("//*[@id=\"sourceDisableDialog\"]/div/div/div[3]/button[2]");
    private final By titleNameLocator = By.xpath("//*[@id=\"sourcesTable\"]/tbody/tr[1]/td[2]");
    private final By enableButtonLocator = By.xpath("//*[@id=\"sourceEnableDialog\"]/div/div/div[3]/button[2]");
    private final By deleteIconLocator = By.xpath("//*[@id=\"sourcesTable\"]/tbody/tr[1]/td[8]/div/button[2]/span");
    private final By deleteButtonLocator = By.xpath("//*[@id=\"sourceDeleteDialog\"]/div/div/div[3]/button[2]");
    private final By portalSortField = By.id("sourcePortalSelect");
    private final By portalDropDownNameLocator = By.xpath("//*[@id=\"sourcePortalSelect\"]/option[4]");
    private final By portalNameLocator = By.xpath("//*[@id=\"sourcesTable\"]/tbody/tr[1]/td[1]");
    
    
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
    public SourcesEditPage clickOnFirstEditIcon(){
        driver.findElement(editIconLocator).click();
        return new SourcesEditPage(driver, wait);
    }
    public String getStatusLetter(){
        return driver.findElement(statusLetterLocator).getText();
    }
    public void clickOnDisableEnableIcon(){
        driver.findElement(disableEnableIconLocator).click();
    }
    public void clickOnDisableButton(){
        wait.until(ExpectedConditions.elementToBeClickable(disableButtonLocator)).click();
    }
    public String getTitleName(){
        return driver.findElement(titleNameLocator).getText();
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
    public void selectSortOfPortals(String portalName){
        Select portalsNameList = new Select(driver.findElement(portalSortField));
        portalsNameList.selectByVisibleText(portalName);
    }
    public String getSelectedPortalName(){
        return driver.findElement(portalDropDownNameLocator).getText();
    }
    public String getPortalName(){
        return driver.findElement(portalNameLocator).getText();
    }
}
