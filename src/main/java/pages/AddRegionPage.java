package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddRegionPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    
    private final By titleNameLocator = By.id("title");
    private final By saveButtonLocator = By.id("save-region-button");

    public AddRegionPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public void enterTitleName(String newTitle){
        driver.findElement(titleNameLocator).sendKeys(newTitle);
    }
    public void clickOnSaveButton(){
        driver.findElement(saveButtonLocator).click();
    }
}
