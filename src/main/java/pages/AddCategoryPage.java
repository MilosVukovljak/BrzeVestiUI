package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCategoryPage {
   private WebDriver driver;
   private final By titleFieldLocator = By.id("title");
   private final By saveButtonLocator = By.id("save-category-button");
   private final By backToCategoriesButtonLocator = By.id("back-button");
   
   public AddCategoryPage(WebDriver driver){
       this.driver = driver;
   }
   public void enterTitleNameInTitlefield(String newTitle){
       driver.findElement(titleFieldLocator).sendKeys(newTitle);
   }
   public String getTitleNameOfCategory(){
       return driver.findElement(titleFieldLocator).getText();
   }
   public void clickOnSaveButton(){
       driver.findElement(saveButtonLocator).click();
   }
   public void clickOnBackToCategoriesButton(){
       driver.findElement(backToCategoriesButtonLocator).click();
   }
}

