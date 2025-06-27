package TTMaven.flightsbooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactoryObjectRepository {
	WebDriver driver;
	
	@FindBy(id="flights")
	WebElement flightsTab;
	
	@FindBy(xpath="//button[@data-ui-name='input_location_from_segment_0']")
	WebElement originCity;
	
	@FindBy(xpath="//input[@class='AutoComplete-module__textInput___Qh3I- ']")
	WebElement inputOrigin;
	
	@FindBy(xpath="//button[@data-ui-name='input_location_to_segment_0']")
	WebElement destinationCity;
	
	@FindBy(xpath="//input[@class='AutoComplete-module__textInput___Qh3I- ']")
	WebElement inputDestination;
	
	

	@FindBy(id="search_type_option_ROUNDTRIP")
	WebElement roundTrip;
	
	@FindBy(id="search_type_option_ONEWAY")
	WebElement oneWay;
	
	@FindBy(id="search_type_option_MULTISTOP")
	WebElement multiStop;
	
	@FindBy(name="sr_cabin_class")
	WebElement classOfTravel;
	
	@FindBy(id="direct_flights_input_checkbox")
	WebElement directFlights;
	
	public SearchPageFactoryObjectRepository(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickFlightsTab() {		
		flightsTab.click();
	}
	
	public void setOriginCity(String origin) {
		originCity.click();
		inputOrigin.sendKeys(origin);
	}
	
	public void setDestinationCity(String destination) {
		destinationCity.click();
		inputDestination.sendKeys(destination);
	}
	
	public void clickRoundTrip() {
		roundTrip.click();
	}
	
	public void clickOneWay() {
		oneWay.click();
	}
	
	
	
}
