package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddSourcePage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private final By dashboardLinkLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[1]/a");
    private final By signaturesLinkLocator = By.linkText("Signatures");
    private final By categoriesLinkLocator = By.linkText("Categories");
    private final By regionsLinkLocator = By.linkText("Regions");
    private final By portalsLinkLocator = By.linkText("Portals");
    private final By sourcesLinkLocator = By.linkText("Sources");
    private final By portalDropDownListLocator = By.id("sourcePortalSelect");
    private final By optionNameOfPortalDropdownList = By.xpath("//*[@id=\"sourcePortalSelect\"]/option[3]");
    private final By titleFieldLocator = By.id("sourceTitleText");
    private final By urlFieldLocator = By.id("sourceUrlText");
    private final By sourceTypeFieldLocator = By.id("sourceNewsFetcherSelect");
    private final By sourceTypeNameLocator = By.xpath("//*[@id=\"sourceNewsFetcherSelect\"]/option");
    private final By sourceProcessorFieldLocator = By.id("sourceNewsProcessorSelect");
    private final By sourceProcessorNameLocator = By.xpath("//*[@id=\"sourceNewsProcessorSelect\"]/option[3]");
    private final By firstSourceProcessorNameLocator = By.xpath("//*[@id=\"sourceNewsProcessorSelect\"]/option[1]");
    private final By sourceCategoryFieldLocator = By.id("sourceCategorySelect");
    private final By sourceCategoryNameLocator = By.xpath("//*[@id=\"sourceCategorySelect\"]/option[3]");
    private final By saveButtonLocator = By.id("save-source-button");
    private final By dropDownLogoutListLocator = By.className("dropdown-toggle");
    private final By logoutButtonLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[2]/li/ul/li/a");

    public AddSourcePage(WebDriver driver, WebDriverWait wait) {
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
    public void selectPortalFromDropDownList(String portalName){
        Select portalDropdown = new Select(driver.findElement(portalDropDownListLocator));
        portalDropdown.selectByVisibleText(portalName);
    }
    public String getOptionDropDownName(){
        return driver.findElement(optionNameOfPortalDropdownList).getText();
    }
    public void enterTitleName(String newTitle){
        driver.findElement(titleFieldLocator).sendKeys(newTitle);
    }
    public void enterUrl(String newUrl){
        driver.findElement(urlFieldLocator).sendKeys(newUrl);
    }
    public void selectSourceType(String sourceType){
        Select sourceTypeList = new Select(driver.findElement(sourceTypeFieldLocator));
        sourceTypeList.selectByVisibleText(sourceType);
    }
    public String getSourceTypeName(){
        return driver.findElement(sourceTypeNameLocator).getText();
    }
    public void selectSourceProcessor(String sourceProcessor){
        Select sourceProcessorList = new Select(driver.findElement(sourceProcessorFieldLocator));
        sourceProcessorList.selectByVisibleText(sourceProcessor);
    }
    public String getSourceProcessorName(){
        return driver.findElement(sourceProcessorNameLocator).getText();
    }
    public String getFirstSourceProcessorName(){
        return driver.findElement(firstSourceProcessorNameLocator).getText();
    }
    public void selectSourceCategory(String sourceCategory){
        Select sourceCategoryList = new Select(driver.findElement(sourceCategoryFieldLocator));
        sourceCategoryList.selectByVisibleText(sourceCategory);
    }
    public String getSourceCategoryName(){
        return driver.findElement(sourceCategoryNameLocator).getText();
    }
    public void clickOnSaveButton(){
        driver.findElement(saveButtonLocator).click();
    }
}
