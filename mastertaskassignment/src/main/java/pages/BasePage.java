package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	
	private WebDriver _driver;

    public BasePage(WebDriver driver) {
       _driver = driver;
    }

    protected WebElement FindElement(By byLocator)
    {
        WebDriverWait webDriverWait = new WebDriverWait( _driver,10);
        WebElement webElement = webDriverWait.until( ExpectedConditions.visibilityOfElementLocated( byLocator ));
        return webElement;
    }
}
