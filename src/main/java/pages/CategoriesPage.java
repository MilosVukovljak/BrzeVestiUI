package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriesPage {
    private WebDriver driver;
    private final By panelHeadingLocator = By.linkText("Categories");
    private final By editCategoryLocator = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[1]/td[5]/div/a/span");

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getPanelHeadingText(){
      return driver.findElement(panelHeadingLocator).getText();
   }
    public void ClickOnEditCategory(){
        driver.findElement(editCategoryLocator).click();
    }
    
    
    
}
