package test_scenarios;


import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import object_repo.ConfirmationPage;
import object_repo.CustomerPage;
import object_repo.LoginDetailsPage;
import object_repo.PaymentsPage;
import object_repo.ProductsPage;
import pojo.CustomerPolicy;
import pojo.Login;
import read_csv.CSVUtils;

public class TestLoginDetails {
	
	WebDriver driver;
	LoginDetailsPage loginDetailsPage;
	ProductsPage productPage;
	CustomerPage customerPage;
	ConfirmationPage confirmationPage;
	PaymentsPage paymentsPage;
	String appUrl = System.getProperty("appUrl");
	CSVUtils complexUserCsvReader = new CSVUtils();
	Login login;


	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(appUrl);
		loginDetailsPage = new LoginDetailsPage(driver);
		productPage = new ProductsPage(driver);
		customerPage = new CustomerPage(driver);
		confirmationPage = new ConfirmationPage(driver);
		paymentsPage = new PaymentsPage(driver);
		login = new Login();
	}

	@Test(dataProvider = "customerDataProvider")
	public void createPolicy(CustomerPolicy customerPolicy) throws InterruptedException {
		loginDetailsPage.login(login.getUsername(), login.getPassword());
		productPage.enterProductDetails("Austria",
				"Nokia_v2Allianz_global",
				"1-34-Nokia_v2Allianz_global-D-EUR-v1-Accidental_damage",
				"CATEGORY_SMARTPHONE",
				"12 month(s)",
				"One-time",
				"Nokia 1/300 - EUR 300.00",
				"pod7736473");
		customerPage.customerdetails(customerPolicy.getCustomer_first_name(),
				customerPolicy.getCustomer_last_name(),
				customerPolicy.getCustomer_email(),
				customerPolicy.getCustomer_street(),
				customerPolicy.getCustomer_street_number(),
				customerPolicy.getCustomer_zip(),
				customerPolicy.getCustomer_city(),
				customerPolicy.getCustomer_country());
		confirmationPage.confirmationDetails();
		paymentsPage.paymentdetails("4242424242424242", "04/24", "777");
	}

	@BeforeTest
	public void tearDown(){
		driver.quit();
	}


	@DataProvider(name = "customerDataProvider")
	public Object[][] customerDataProvider() throws IOException {
		List<CustomerPolicy> customers = complexUserCsvReader.getCustomerDetailsFromCSV();
		Object[][] result = new Object[customers.size()][1];
		Iterator<CustomerPolicy> customerPolicyIterator = customers.iterator();
		for(Object[] row:result){
			row[0] = customerPolicyIterator.next();
		}
		return result;
	}
}
