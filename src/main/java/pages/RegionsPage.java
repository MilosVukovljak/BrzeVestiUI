package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegionsPage {
    private WebDriver driver;
    private final By panelHeadingLocator = By.linkText("Regions");

    public RegionsPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getPanelHeadingText(){
        return driver.findElement(panelHeadingLocator).getText();
    }
}
