package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegionsEditPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    
    private final By titleFieldLocator = By.id("title");
    private final By saveButtonLocator = By.id("save-region-button");
    private final By backToRegionsButtonLocator = By.id("back-button");

    public RegionsEditPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public void enterTitleName(String newTitle){
        WebElement titleField = driver.findElement(titleFieldLocator);
        titleField.clear();
        titleField.sendKeys(newTitle);       
    }
    public void clickOnSaveButton(){
        driver.findElement(saveButtonLocator).click();
    }
    public void clickOnBackToRegionsButton(){
        driver.findElement(backToRegionsButtonLocator).click();
    }
}
