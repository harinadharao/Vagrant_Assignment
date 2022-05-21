package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Wikipedia  {
	private WebDriver driver;

	public Wikipedia(WebDriver driver) {
		this.driver = driver;
	}

	public Wikipedia search() throws InterruptedException {
		WebElement search = driver.findElement(By.xpath("//input[@placeholder=\"Search Wikipedia\"]"));
		Assert.assertTrue(search.isDisplayed());
		search.sendKeys("Pushpa:The Rise");
		String text;
		do {
			search.sendKeys(Keys.ARROW_DOWN);
			text = search.getAttribute("value");
			if (text.equals("Pushpa:The Rise")) {
				search.sendKeys(Keys.ENTER);
		         break;
			}
		} while (!text.isEmpty());
		return this;
		
	}

	public Wikipedia contextMenu() {
		WebElement menu = driver.findElement(By.xpath("//div[@class=\"mw-search-result-heading\"]/a[@title =\"Pushpa: The Rise\"]"));
		menu.click();
		WebElement firstHeading = driver.findElement(By.id("firstHeading"));
		 WebDriverWait waits = new WebDriverWait(driver,10);
		 waits.until(ExpectedConditions.visibilityOf(firstHeading));
		 return this;
	}
	
	public Wikipedia releaseDate() {
		WebElement releasedate = driver.findElement(By.xpath("//div[text()='Release date']"));
		 WebElement date = driver.findElement(By.xpath("//span[contains(@class,'dtstart')]//parent::span//parent::li"));
		 System.out.println("The Extract Release date ::::::::"+releasedate.getText()+" "+date.getText());
		 Assert.assertTrue(date.getText().contains("17 December 2021"));
		 return this;
	}
	
	public Wikipedia country() {
		WebElement Country = driver.findElement(By.xpath("//th[text()='Country']"));
		 WebElement  Cvalue = driver.findElement(By.xpath("//th[text()='Country']/following-sibling::td"));
		 System.out.println("The Country will  ::::::::"+Country.getText()+" "+Cvalue.getText());
		 Assert.assertEquals(Cvalue.getText(), "India");
		 return this;
	}

}
