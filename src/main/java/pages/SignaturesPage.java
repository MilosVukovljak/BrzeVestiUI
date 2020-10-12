package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignaturesPage {
   
    private WebDriver driver;
    private final WebDriverWait wait;
    
    private final By panelHeadingLocator = By.className("panel-heading");
    private final By dashboardLinkLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[1]/a");
    private final By signaturesLinkLocator = By.linkText("Signatures");
    private final By categoriesLinkLocator = By.linkText("Categories");
    private final By regionsLinkLocator = By.linkText("Regions");
    private final By portalsLinkLocator = By.linkText("Portals");
    private final By sourcesLinkLocator = By.linkText("Sources");
    private final By logoutDropDownListLocator = By.className("dropdown-toggle");
    private final By logoutButtonLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[2]/li/ul/li/a");
    private final By changeCategoryIconLocator = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[1]/td[6]/div/button[1]/span");
    private final By categorySelectFieldLocator = By.id("newsProcessorSignatureCategoryApprove");
    private final By categoryOptionNameLocator = By.xpath("//*[@id=\"newsProcessorSignatureCategoryApprove\"]/option[8]");
    private final By approveButtonLocator = By.xpath("//*[@id=\"newsProcessorSignatureApproveDialog\"]/div/div/div[3]/button[2]");
    private final By signatureNameLocator = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[1]/td[3]");
    private final By categoryNameLocator = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[1]/td[4]");
    private final By alertMessageLocator = By.className("alert-success");
    private final By statusLetterLocator = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[1]/td[5]/span");
    private final By ignoreIconLocator = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[1]/td[6]/div/button[2]/span");
    private final By ignoreButtonLocator = By.xpath("//*[@id=\"newsProcessorSignatureIgnoreDialog\"]/div/div/div[3]/button[2]");
    private final By approveIconLocator = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[1]/td[6]/div/button[1]/span");
    private final By deleteIconLocator = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[1]/td[6]/div/button[3]/span");
    private final By deleteButtonLocator = By.xpath("//*[@id=\"newsProcessorSignatureDeleteDialog\"]/div/div/div[3]/button[2]");
    private final By portalsNameLocator = By.xpath("//*[@id=\"newsProcessorSignaturePortalSelect\"]/option[4]");///////////////////////
    private final By sortedPortalNameLocator = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[1]/td[2]");
    private final By portalFieldLocator = By.id("newsProcessorSignaturePortalSelect");
    
    public SignaturesPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public String getPanelHeadingText(){
        return driver.findElement(panelHeadingLocator).getText();
    }
    public void clickOnLogoutDropdownList(){
        driver.findElement(logoutDropDownListLocator).click();
    }
    public void clickOnLogoutButton(){
        driver.findElement(logoutButtonLocator).click();
    }
    public void logout(){
        clickOnLogoutDropdownList();
        clickOnLogoutButton();
    }
    public DashboardPage clickOnDashboardNavLink(){
        driver.findElement(dashboardLinkLocator).click();
        return new DashboardPage(driver, wait);
    }
    public void clickOnSignaturesNavLink(){
        driver.findElement(signaturesLinkLocator).click();
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
    public void clickOnChangeCategoryIcon(){
        driver.findElement(changeCategoryIconLocator).click();
    }
    public void selectCategory(String categoryOptionName){
        Select categoryNameList = new Select(driver.findElement(categorySelectFieldLocator));
        categoryNameList.selectByVisibleText(categoryOptionName);
    }
    public String getSelectedCategoryName(){
        return driver.findElement(categoryOptionNameLocator).getText();
    }
    public void clickOnApproveButton(){
        wait.until(ExpectedConditions.elementToBeClickable(approveButtonLocator)).click();
    }
    public String getSignatureName(){
        return driver.findElement(signatureNameLocator).getText();
    }
    public String getCategoryName(){
        return driver.findElement(categoryNameLocator).getText();
    }
    public String getAlertMessage(){
        return driver.findElement(alertMessageLocator).getText();
    }
    public String getStatusLetter(){
        return driver.findElement(statusLetterLocator).getText();
    }
    public void clickOnIgonreIcon(){
        driver.findElement(ignoreIconLocator).click();
    }
    public void clickOnIgnoreButton(){
        wait.until(ExpectedConditions.elementToBeClickable(ignoreButtonLocator)).click();
    }
    public void clickOnApproveIcon(){
        driver.findElement(approveIconLocator).click();
    }
    public void clickOnDeleteIcon(){
        driver.findElement(deleteIconLocator).click();
    }
    public void clickOnDeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteButtonLocator)).click();
    }
    /////////////////////////////////////////////////////////////////////////////
    public void selectPortal(String portalName){
        Select portalsSortList = new Select(driver.findElement(portalFieldLocator));
        portalsSortList.selectByVisibleText(portalName);
    }
    public String getPortalName(){
        return driver.findElement(portalsNameLocator).getText();
    }
    public String getSortedPortalName(){
        return driver.findElement(sortedPortalNameLocator).getText();
    }
    
   
}
