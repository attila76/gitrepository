package TTMaven.flightsbooking;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class SearchPage {
	public static WebElement element = null;
	
	public static JavascriptExecutor js;
	
	
	
	public static void goToFlights(WebDriver driver) throws InterruptedException {
		Thread.sleep(10000);
		js = (JavascriptExecutor) driver;
		WebElement flightsTab = driver.findElement(By.id("flights"));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()", flightsTab);	
		
		//driver.findElement(By.xpath("//a[@href='/Flights' and @aria-controls='search_form_product_selector_flights']")).click();
		Thread.sleep(2000);
	}
	
	/**
	 * Returns the flight origin text box element
	 * @param driver
	 * @return
	 */
	public static WebElement originTextBox(WebDriver driver) {
		element = driver.findElement(By.id("origin_select"));
		return element;
	}
	
	public static String fillAndReturnOriginTextBox(WebDriver driver, String searchString, int selectedValue) throws InterruptedException {
		String actVal = "";
		element = driver.findElement(By.xpath("//button[@data-ui-name='input_location_from_segment_0']"));
		element.click();
		
		element = driver.findElement(By.xpath("//input[@data-ui-name='input_text_autocomplete']"));
		
		element.sendKeys((CharSequence) searchString);
		
		List<WebElement> eList = driver.findElements(By.xpath("//ul[@id='flights-searchbox_suggestions']/li"));		
		
		System.out.println("Size of elementList: "+ eList.size());
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
			

		
		if ( eList.size()>= selectedValue+1) {
			int i = 0;
			WebElement e1;
			
			for (WebElement elem : eList) {
				if (i == 0) {
					e1 = elem.findElement(By.xpath("//span[4]//div//input"));
					js.executeScript("arguments[0].click()", e1);
					Thread.sleep(2000);
				}
				
				i+=1;
				
				if (i == selectedValue) {
					js.executeScript("window.scrollBy(0, 400);");
					e1 = elem.findElement(By.xpath("//span[4]//div//input"));
					//e1.click();
					js.executeScript("arguments[0].click()", e1);
					Thread.sleep(2000);
					
					System.out.println("Act elem"+ elem.getText());
					break;
				}
			}
			
		}
		else 
			actVal= "";
		
		return actVal;		
	}
	
	
	/**
	 * Returns the flight destination text box element
	 * @param driver
	 * @return
	 */
	public static WebElement destinationTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-destination"));
		return element;
	}
	
	
	/*
	 * Returns the departure date text box element
	 */
	public static WebElement departureDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-departing"));
		return element;
	}
	
	
	/**
	 * Returns the return date text box element
	 * @param driver
	 * @return
	 */
	public static WebElement returnDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-returning"));
		return element;
	}
	
	
	/**
	 * Returns the search button box element
	 * @param driver
	 * @return
	 */
	public static WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.id("search-button"));
		return element;
	}
	
	
	/**
	 * Click on search button
	 * @param driver
	 */
	public static void clickOnSearchButton(WebDriver driver) {
		element = searchButton(driver);
		element.click();
	}
	
	
	/**
	 * Navigate to flights tab
	 * @param driver
	 */
	public static void navigateToFlightsTab(WebDriver driver) {
		driver.findElement(By.id("header-history")).click();
		element = driver.findElement(By.id("tab-flight-tab"));
		element.click();
		
	}

}
