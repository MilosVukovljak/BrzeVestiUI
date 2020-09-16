package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddSourcePage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    
    private final By portalDropDownListLocator = By.id("sourcePortalSelect");
    private final By optionNameOfPortalDropdownList = By.xpath("//*[@id=\"sourcePortalSelect\"]/option[3]");
    private final By titleFieldLocator = By.id("sourceTitleText");
    private final By urlFieldLocator = By.id("sourceUrlText");
    private final By sourceTypeFieldLocator = By.id("sourceNewsFetcherSelect");
    private final By sourceTypeNameLocator = By.xpath("//*[@id=\"sourceNewsFetcherSelect\"]/option");
    private final By sourceProcessorFieldLocator = By.id("sourceNewsProcessorSelect");
    private final By sourceProcessorNameLocator = By.xpath("//*[@id=\"sourceNewsProcessorSelect\"]/option[3]");
    private final By sourceCategoryFieldLocator = By.id("sourceCategorySelect");
    private final By sourceCategoryNameLocator = By.xpath("//*[@id=\"sourceCategorySelect\"]/option[3]");
    private final By saveButtonLocator = By.id("save-source-button");

    public AddSourcePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
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
