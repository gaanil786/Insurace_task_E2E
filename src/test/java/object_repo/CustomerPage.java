package object_repo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class CustomerPage {

	 WebDriver driver;
	By firstName = By.xpath("//*[@id=\"input-createCertificate_firstName\"]/../input");
	By Last_name = By.xpath("//input[@id='input-createCertificate_lastName']");
	By Email = By.xpath("//input[@id='input-createCertificate_email']");
	By Street = By.xpath("//input[@id='input-createCertificate_streetName']");
	By H_no = By.xpath("//input[@id='input-createCertificate_streetNumber']");
	By postal_code = By.xpath("//input[@id='input-createCertificate_zip']");
	By city = By.xpath("//input[@id='input-createCertificate_city']");
	By country = By.xpath("//input[@id='input-createCertificate_country']");
	// By tax_code = By.xpath("//*[@id=\"input-createCertificate_taxCode\"]");
	By next = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/form/div[11]/div/div[3]/button");

	
	By preFirstClick = By.xpath("//*[@id=\"input-createCertificate_firstName-label\"]/span[1]");
	
	public CustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clicknext() {
		driver.findElement(this.next).click();
	}
	
	
	
	public void customerdetails(String First_name, String Last_name, String Email, String Street, String H_no, String postal_code, String city, String country) throws InterruptedException {
		
		
			// driver.findElement(preFirstClick).click();
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));  
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(this.firstName));
	    	 driver.findElement(this.firstName).sendKeys("Gaurav");
	    
		
		// driver.findElement(this.First_name).sendKeys("Gaurav");
		driver.findElement(this.Last_name).sendKeys(Last_name);
		driver.findElement(this.Email).sendKeys(Email);
		driver.findElement(this.Street).sendKeys(Street);
		driver.findElement(this.H_no).sendKeys(H_no);
		driver.findElement(this.postal_code).sendKeys(postal_code);
		driver.findElement(this.city).sendKeys(city);
		driver.findElement(this.country).sendKeys(country);
		clicknext();
	}
	

}
