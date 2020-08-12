package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoriesEditPage {
    private WebDriver driver;
    private final By titleFieldLocator = By.id("title");
    private final By backButtonLocator = By.id("back-button");
    private final By saveButtonLocator = By.id("save-category-button");

    public CategoriesEditPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterTitle(String newTitle){
        WebElement titleField = driver.findElement(titleFieldLocator);
        titleField.clear();
        titleField.sendKeys(newTitle);
    }
    public void clickOnBackButton(){
        driver.findElement(backButtonLocator).click();
    }
    public void clickOnSaveButton(){
        driver.findElement(saveButtonLocator).click();
    }
    
    
}
