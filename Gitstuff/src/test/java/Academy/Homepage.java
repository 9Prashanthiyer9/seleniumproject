package Academy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class Homepage extends base {
	@BeforeTest

	public void initialize() throws IOException
	{
		
		 driver =initializeDriver();
			
		driver.get(prop.getProperty("url"));
	}
	@Test(dataProvider="getData")
	public void basepagenavigation(String username, String password, String text) throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		l.getlogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		System.out.println("text");
		lp.getLogin().click();
		
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];
		data[0][0]="nonrestrciteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="restricted user";
		
		
		data[1][0]="restrciteduser@qw.com";
		data[1][1]="456788";
		data[1][2]="non restricted user";
		
		return data;
		
		
		
	}
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	}
	
	
	


}
