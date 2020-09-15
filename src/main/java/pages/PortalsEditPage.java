package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortalsEditPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By titleFieldLocator = By.id("title");
    private final By urlFieldLocator = By.id("url");
    private final By protalDropDownListLocator = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/fieldset/div[3]/div/select");
    private final By saveButtonLocator = By.id("save-portal-button");
    private final By optionOfDropDownNameLocator = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/fieldset/div[3]/div/select/option[2]");
    
     
    
    public PortalsEditPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void enterTitleName(String newTitle){
        WebElement titleField = driver.findElement(titleFieldLocator);
        titleField.clear();
        titleField.sendKeys(newTitle);
        
    }
    public void enterUrl(){
        WebElement urlField = driver.findElement(urlFieldLocator);
        urlField.clear();
        urlField.sendKeys(Helper.getRandomUrl());
    }
    public void selectRegionFromPortals(String regionName) {
        Select portalsDropdown = new Select(driver.findElement(protalDropDownListLocator));
        portalsDropdown.selectByVisibleText(regionName);
    } 
    public void clickOnSaveButton(){
        driver.findElement(saveButtonLocator).click();
    }
    public String getOptionDropDownName(){
        return driver.findElement(optionOfDropDownNameLocator).getText();
    }

}
