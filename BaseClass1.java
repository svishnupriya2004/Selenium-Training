package testcase2withexcel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass1 {
	
	public ChromeDriver driver;  // Set globally

	public String excelName;
	
	@Parameters({"username" , "password"})     //giving paramaters
	@BeforeMethod
	//giving attributes
	public void login( String uname, String pword) {    
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();  //Remove local declaration
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys(uname);
		driver.findElementById("password").sendKeys(pword);
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();

	}
	
	@AfterMethod
	public void close() {
		driver.close();

	}
	
	@DataProvider(name="fetchdata")         //annotations used to give different datas for Companyname, firstname & lastname
	//passing these value in STring arrays
	public String[][] sendData() throws IOException {
			
		return ReadExcel1.excelData(excelName);  // Need to return data when we use String array datatype ... Then giving reference dataprovider to @Test
		
	}
	
}
