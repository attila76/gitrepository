package TTMaven.flightsbooking;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameworkTestCase {
	private WebDriver driver;
	private String baseUrl;
	SearchPageFactoryObjectRepository searchPage;

	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://www.booking.com";
		
		searchPage = new SearchPageFactoryObjectRepository(driver);
		
		// Maximize browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(baseUrl);
	}
	

	@Test
	public void test() throws InterruptedException {
		searchPage.clickFlightsTab();
		searchPage.setOriginCity("New York");
		searchPage.setDestinationCity("Chicago");
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		//Thread.sleep(3000);
		//driver.quit();
	}

}
