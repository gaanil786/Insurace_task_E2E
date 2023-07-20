package object_repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

	 WebDriver driver;
	 By checkbox1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[35]/div/div/label[2]/span[1]/span[1]/input");
	 By checkbox2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[35]/div/div/label[3]/span[1]/span[1]/input");
	 By checkbox3 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[35]/div/div/label[4]/span[1]/span[1]/input");
	 By checkbox4 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[35]/div/div/label[5]/span[1]/span[1]/input");
	 By createinsurance = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div/div[3]/button");


	
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void confirmationDetails() {
		driver.findElement(checkbox1).click();
		driver.findElement(checkbox2).click();
		driver.findElement(checkbox3).click();
		driver.findElement(checkbox4).click();
		driver.findElement(createinsurance).click();
	}
}
