package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Wikipedia;



public class wikiPediaTest extends BaseTest {
	
	
	@Test
	public void foreginPlayer() throws InterruptedException {
		Wikipedia wiki = new Wikipedia(driver);
		wiki.search();
		wiki.contextMenu();
		wiki.releaseDate();
		wiki.country();
	}
	
	
	@Test(enabled = false)
	public void foreginPlayers() throws InterruptedException {
		String Actualtext = "17 December 2021";
		 String baseUrl = "https://en.wikipedia.org/wiki/Main_Page";
		driver.get(baseUrl);
		Thread.sleep(4000);
		WebElement search = driver.findElement(By.id("searchInput"));
		Assert.assertTrue(search.isDisplayed());

		//search operation
		 search.sendKeys("Pushpa:The Rise");
		 String text;
		 do{ //whereas do while loop will execute the statement(s) at least once, then the condition is checked
		     search.sendKeys(Keys.ARROW_DOWN);
		     text = search.getAttribute("value");
		     if(text.equals("Pushpa:The Rise")){
		         search.sendKeys(Keys.ENTER);
		         break;
		     }
		 }while(!text.isEmpty());
		 //menuclick
		 WebElement contextMenu=driver.findElement(By.xpath("//div[@class=\"mw-search-result-heading\"]/a[@title =\"Pushpa: The Rise\"]"));
		 contextMenu.click();
		 WebElement firstHeading = driver.findElement(By.id("firstHeading"));
		 WebDriverWait waits = new WebDriverWait(driver,10);
		 waits.until(ExpectedConditions.visibilityOf(firstHeading));
		 //Release date text
		 WebElement releasedate = driver.findElement(By.xpath("//div[text()='Release date']"));
		 WebElement date = driver.findElement(By.xpath("//span[contains(@class,'dtstart')]//parent::span//parent::li"));
		 System.out.println("The Extract Release date ::::::::"+releasedate.getText()+" "+date.getText());
		 Assert.assertTrue(date.getText().contains("17 December 2021"));
	}
}
