package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest {
	
	protected WebDriver driver; 
	final String pageUrl ="https://en.wikipedia.org/wiki/Main_Page";
	
	@BeforeTest
	public void SetUp() {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(pageUrl);
		
		 
		
	}
	
	@AfterTest
    protected void TearDown()
    {
		driver.quit();
    }
}
