package object_repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProductsPage {
	
	 WebDriver driver;
	 WebDriverWait wait;
	 By countryDropdown = By.xpath("//div[@id='country-select']");
	 String dropdownOption = "//li[contains(normalize-space(),'%s')]";
	 By productNameDropdown = By.id("product-name-select");
	 By tariffDropdown = By.id("tariff-name-select");
	 By insuranceCategoryDropdown = By.id("category-name-select");
	 By periodDropdown = By.id("duration-select");
	 By paymentTypeDropdown = By.id("frequency-select");
	 By productClassDropdown = By.id("class-name-select");
	 By serialNumberInput = By.id("input-createCertificate_serialNumber");
	 By next = By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[2]/form/div[5]/div/div[3]/button");
	 
	 
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofMillis(200));
	}
	
	public void clickNext() {
		driver.findElement(this.next).click();
	}

	public void selectDropdownOption(By dropdown, String optionText){
		wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(dropdownOption,optionText))))
				.click();
	}

	public void enterText(By element,String text){
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(text);
	}
	
	public void enterProductDetails(String country, String productName, 
									String tariff, String insuranceCategory, 
									String period, String paymentType, 
									String productClass, String serialNumber) {
		selectDropdownOption(this.countryDropdown,country);
		selectDropdownOption(this.productNameDropdown,productName);
		selectDropdownOption(this.tariffDropdown,tariff);
		selectDropdownOption(this.insuranceCategoryDropdown,insuranceCategory);
		selectDropdownOption(this.periodDropdown,period);
		selectDropdownOption(this.paymentTypeDropdown,paymentType);
		selectDropdownOption(this.productClassDropdown,productClass);
		enterText(this.serialNumberInput,serialNumber);
		clickNext();
	}

}