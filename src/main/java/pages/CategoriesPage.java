package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    
    private final By dropDownLogoutListLocator = By.className("dropdown-toggle");
    private final By logoutButtonLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[2]/li/ul/li/a");
    private final By panelHeadingLocator = By.className("panel-heading");
    private final By editCategoryLocator = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[1]/td[5]/div/a");//****
    private final By editSeventhCategoryLocator = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[7]/td[5]/div/a");
    private final By alertMessageLocator = By.className("alert-success");
    private final By dashboardLinkLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[1]/a");
    private final By signaturesLinkLocator = By.linkText("Signatures");
    private final By categoriesLinkLocator = By.linkText("Categories");
    private final By regionsLinkLocator = By.linkText("Regions");
    private final By portalsLinkLocator = By.linkText("Portals");
    private final By sourcesLinkLocator = By.linkText("Sources");//*****
    private final By disableIconLocator = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[1]/td[5]/div/button[1]");
    private final By disableIconForSeventhCategory = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[7]/td[5]/div/button[1]");
    private final By disableButtonLocator = By.xpath("//*[@id=\"categoryDisableDialog\"]/div/div/div[3]/button[2]");
    private final By statusCharacterLocator = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[1]/td[4]/span");
    private final By statusCharacterForSeventhCategoryLocator = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[7]/td[4]/span");
    private final By enableIconLocator = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[1]/td[5]/div/button[1]");
    private final By enableIconSeventhCategoryLocator = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[7]/td[5]/div/button[1]/span");
    private final By enableButtonLocator = By.xpath("//*[@id=\"categoryEnableDialog\"]/div/div/div[3]/button[2]");
    private final By closeButtonLocator = By.xpath("//*[@id=\"categoryDisableDialog\"]/div/div/div[3]/button[1]");
    private final By titleNameCategoryLocator = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[1]/td[3]");
    private final By titleNameSeventhCategoryLocator = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[7]/td[3]");
    private final By deleteIconLocator = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[1]/td[5]/div/button[2]");
    private final By deleteIconSeventhCategoryLocator = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[7]/td[5]/div/button[2]");
    private final By deleteButtonLocator = By.xpath("//*[@id=\"categoryDeleteDialog\"]/div/div/div[3]/button[2]");
    private final By secondCloseButtonLocator = By.xpath("//*[@id=\"categoryDeleteDialog\"]/div/div/div[3]/button[1]");
    private final By addNewCategoryButtonLocator = By.className("pull-right");
    
    
    
    public CategoriesPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    
    //********************
    public void clickOnOptionsDropdown(){
        driver.findElement(dropDownLogoutListLocator).click();
    }
    public void clickOnLogoutButtonFromDropdown(){
     driver.findElement(logoutButtonLocator).click();
    }
    public void logout(){
      clickOnOptionsDropdown();
      clickOnLogoutButtonFromDropdown();
    }//***************************
    
    public String getPanelHeadingText(){
        return driver.findElement(panelHeadingLocator).getText();
    }  
    public CategoriesEditPage clickOnEditCategory(){
        driver.findElement(editCategoryLocator).click();
        return new CategoriesEditPage(driver);//****
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
    public RegionsPage clickOnRegionsNavLink(){
       driver.findElement(regionsLinkLocator).click();
       return new RegionsPage(driver, wait);
   } 
    public void clickOnCategoriesNavLink(){
       driver.findElement(categoriesLinkLocator).click();
   }
    public PortalsPage clickOnPortalsNavLink(){
        driver.findElement(portalsLinkLocator).click();
        return new PortalsPage(driver, wait);
    }
    public SourcesPage clickOnSOurcesNavLink(){
        driver.findElement(sourcesLinkLocator).click();
        return new SourcesPage(driver, wait);
    }
    ////////////////////////////
    public void clickOnDisableIcon(){
        driver.findElement(disableIconLocator).click();
    }
    public void clickOnDisableIconOnSeventhCategory(){
        driver.findElement(disableIconForSeventhCategory).click();
    }
    public void clickOnDisableButton(){
        wait.until(ExpectedConditions.elementToBeClickable(disableButtonLocator)).click();
    }
    public String getDisableStatusCharacter(){
        return driver.findElement(statusCharacterLocator).getText();
    }
    public String getStatusCharacterSeventhCategory(){
        return driver.findElement(statusCharacterForSeventhCategoryLocator).getText();
    }
    public void clickOnEnableIcon(){
        driver.findElement(enableIconLocator).click();
    }
    public void clickOnEnableIconOnSeventhCategory(){
        driver.findElement(enableIconSeventhCategoryLocator).click();
    }
    public void clickOnEnableButton(){
         wait.until(ExpectedConditions.elementToBeClickable(enableButtonLocator)).click();
    }
    public void clickOnCloseButtonFromDisableCategory(){
        wait.until(ExpectedConditions.elementToBeClickable(closeButtonLocator)).click();
    }
    public String getTitleCategoryName(){
        return driver.findElement(titleNameCategoryLocator).getText();
    }
    public String getTitleSeventhCategoryName(){
        return driver.findElement(titleNameSeventhCategoryLocator).getText();
    }
    public void clickOnDeleteIcon(){
        driver.findElement(deleteIconLocator).click();
    }
    public void clickOnDeleteIconOnSeventhCategory(){
        driver.findElement(deleteIconSeventhCategoryLocator).click();
    }
    public void clickOnDeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteButtonLocator)).click();
    }
    public void clickOnCloseButtonFromDeleteCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(secondCloseButtonLocator)).click();
    }
    public AddCategoryPage clickOnAddCategoryButton(){
        driver.findElement(addNewCategoryButtonLocator).click();
        return new AddCategoryPage(driver);
    }  
    public CategoriesEditPage clickOnEditIconOnSevethCategory(){
        driver.findElement(editSeventhCategoryLocator).click();
        return new CategoriesEditPage(driver);
    }
}
