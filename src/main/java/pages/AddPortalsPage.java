
package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddPortalsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private final By titleFieldLocator = By.id("title");
    private final By urlFieldLocator = By.id("url");
    private final By regionDropDown = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/fieldset/div[3]/div/select");
    private final By saveButtonLocator = By.id("save-portal-button");
    private final By optionOfDropDownNameLocator = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/fieldset/div[3]/div/select/option[2]");

    public AddPortalsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
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
    
    
    
}
