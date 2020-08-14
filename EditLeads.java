package testcase2withexcel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLeads extends BaseClass1 {

	@BeforeTest
	public void setFile() {
	excelName= "EditLead";
	}
	
	@Test(dataProvider="fetchdata")  // getting reference from @DAtaProvider annotation
	
	public void runEditLeads(String phno, String companyname) throws InterruptedException {
		
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(phno);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		driver.findElementByLinkText("Edit").click();
		driver.findElementById("updateLeadForm_companyName").sendKeys(companyname);
		driver.findElementByName("submitButton").click();
		//driver.close();
}
}






