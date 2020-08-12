package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PortalsPage {
    private WebDriver driver;
    private final By panelHeadingLocator = By.linkText("Portals");

    public PortalsPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getPanelHeadingText(){
        return driver.findElement(panelHeadingLocator).getText();
    }
    
    
}
