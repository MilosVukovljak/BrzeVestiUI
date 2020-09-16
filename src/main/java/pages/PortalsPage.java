package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortalsPage {
    
    private WebDriver driver;
    private final WebDriverWait wait; 
    
    private final By panelHeadingLocator = By.className("panel-heading");
    private final By dashboardLinkLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[1]/a");
    private final By signaturesLinkLocator = By.linkText("Signatures");
    private final By categoriesLinkLocator = By.linkText("Categories");
    private final By regionsLinkLocator = By.linkText("Regions");
    private final By portalsLinkLocator = By.linkText("Portals");
    private final By sourcesLinkLocator = By.linkText("Sources");
    private final By alertMessageLocator = By.className("alert-success");
    private final By addPortalLocator = By.className("pull-right");
    private final By portalTitleNameLocator = By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[1]/td[3]");//pogledati
    private final By editFirstPortalIconLocator = By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[1]/td[5]/div/a/span");
    private final By disableFirstPortalIconLocator = By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[1]/td[5]/div/button[1]");
    private final By disableButtonLocator = By.xpath("//*[@id=\"portalDisableDialog\"]/div/div/div[3]/button[2]");
    private final By enableFirstPortalIconLocator = By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[1]/td[5]/div/button[1]/span");
    private final By enableButtonLocator = By.xpath("//*[@id=\"portalEnableDialog\"]/div/div/div[3]/button[2]");
    private final By statusLetterLocator = By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[1]/td[4]/span");
    private final By titleNameLocator = By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[1]/td[3]");
    private final By deleteFirstPortalLocator = By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[1]/td[5]/div/button[2]/span");
    private final By deleteButtonLocator = By.xpath("//*[@id=\"portalDeleteDialog\"]/div/div/div[3]/button[2]"); 
    private final By optionDropDownListLoctar = By.className("dropdown-toggle");
    private final By logoutButtonLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[2]/li/ul/li/a");

    public PortalsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public String getPanelHeadingText(){
        return driver.findElement(panelHeadingLocator).getText();
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
    public void clickOnPortalsNavLink(){
        driver.findElement(portalsLinkLocator).click();
    }
    public SourcesPage clickOnSourcesNavLink(){
        driver.findElement(sourcesLinkLocator).click();
        return new SourcesPage(driver, wait);
    }
    public AddPortalsPage clickOnAddPortal(){
        driver.findElement(addPortalLocator).click();
        return new AddPortalsPage(driver, wait);
    }
    public String getPortalTitleName(){
        return driver.findElement(portalTitleNameLocator).getText();
    }
    public PortalsEditPage ClickOnEditFirstPortal(){
        driver.findElement(editFirstPortalIconLocator).click();
        return new PortalsEditPage(driver, wait);
    }
    public void clickOnDisableIcon(){
        driver.findElement(disableFirstPortalIconLocator).click();
    }
    public void clickOnDisableButton(){
        wait.until(ExpectedConditions.elementToBeClickable(disableButtonLocator)).click();
    }
    public void clickOnEnableIcon(){
        driver.findElement(enableFirstPortalIconLocator).click();
    }
    public void clickOnEnableButton(){
        wait.until(ExpectedConditions.elementToBeClickable(enableButtonLocator)).click();
    }
    public String getStatusLetter(){
        return driver.findElement(statusLetterLocator).getText();
    }
    public String getTitleName(){
        return driver.findElement(titleNameLocator).getText();
    }
    public void clickOnDeleteIcon(){
        driver.findElement(deleteFirstPortalLocator).click();
    }
    public void clickOnDeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteButtonLocator)).click();
    }
    public void clickOnDropDownList(){
        driver.findElement(optionDropDownListLoctar).click();
    }
    public void clickOnLogoutButton(){
       driver.findElement(logoutButtonLocator).click(); 
    }
    public void Logout(){
        clickOnDropDownList();
        clickOnLogoutButton();
    }
}
