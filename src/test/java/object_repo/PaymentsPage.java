package object_repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentsPage {

	 WebDriver driver;
	 By selectCreditDebit = By.xpath("(//input[@value='STRIPE.CARD'])[1]");
	 By creditcardnumberfield = By.xpath("//*[@id=\"root\"]/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input");
	 By expirydatefield = By.xpath("//input[@data-elements-stable-field-name=\"cardExpiry\"]");
	 By cvv = By.xpath("//input[@name=\"cvc\"]");
	 By button2 = By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[2]/div/div[2]/button[1]");
	 By continueToPay = By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[2]/div/div[2]/button");
 	
	 
	
	
	public PaymentsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public static boolean isNumber(String Number) {
		try {
			Long.parseLong(Number);
			System.out.println("Valid credit card number");
		} catch(NumberFormatException e) {
			System.out.println("Invalid credit card number");
			return false;
		}
		
		return true;
	}
	
	public static boolean isValidCard(String number) {
		if((number.length() == 16 && isNumber(number)) || (number.length() == 22 && !isNumber(number))) {
			System.out.println("Valid Credit/Debit Card");
			return true;
		}
		
		System.out.println("InValid Credit/Debit Card");
		return false;
	}
	
	
	
	public void paymentdetails(String creditcardNumber, String expiryDate, String cvv) throws InterruptedException {
		driver.findElement(selectCreditDebit).click();
		driver.findElement(continueToPay).click();
		Thread.sleep(3000);
		if(isValidCard(creditcardNumber)) {
			Thread.sleep(3000);
			driver.findElement(creditcardnumberfield).sendKeys(creditcardNumber);
			driver.findElement(this.cvv).sendKeys(cvv);
			driver.findElement(creditcardnumberfield).sendKeys(expiryDate);
		}
		
		driver.findElement(button2).click();
	}
	
}
