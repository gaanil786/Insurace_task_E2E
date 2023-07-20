package object_repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginDetailsPage {
	
	 WebDriver driver;
	 WebDriverWait wait;
	By username = By.xpath("//*[@id=\"login_username\"]");
	By password = By.xpath("//*[@id=\"login_password\"]");
	By next = By.xpath("//*[@id=\"root\"]/div/div/div/form/div[4]/button");
	By newList = By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/a[2]/button");
	By changeLanguage = By.xpath("//*[@id=\"root\"]/div/header/div/div/button/span[1]/span");
	By changeToEnglish = By.xpath("//*[@id=\"language-menu\"]/div[3]/ul/li[2]/span[1]");
	public LoginDetailsPage(WebDriver driver) {
		this.driver = driver;
		wait  = new WebDriverWait(driver, Duration.ofSeconds(5),Duration.ofMillis(200));
	}
	

	
	public void login(String uname, String pwd) throws InterruptedException {
		driver.findElement(changeLanguage).click();
		wait.until(ExpectedConditions.elementToBeClickable(changeToEnglish)).click();
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(next).click();
		wait.until(ExpectedConditions.elementToBeClickable(newList)).click();
	}
	
}