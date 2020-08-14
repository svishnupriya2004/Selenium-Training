package testcase2withexcel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLeads extends BaseClass1 {
	
	@BeforeTest
	public void setFile() {
	excelName= "CreateLead";
	}

	@Test(dataProvider="fetchdata")  // getting reference from @DAtaProvider annotation
	//Giving aruguments to passdata
	public  void runCreateLeads(String company, String fname, String lname) {

		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys(company);  // giving arguments name as it is in public void stmt
		driver.findElementById("createLeadForm_firstName").sendKeys(fname);
		driver.findElementById("createLeadForm_lastName").sendKeys(lname);
		driver.findElementByName("submitButton").click();
		//driver.close();
}
	
	
}






