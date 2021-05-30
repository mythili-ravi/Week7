package hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import wrappers.BaseDriver;

public class TestNgHooks extends BaseDriver {
	/*@BeforeSuite
		public void init() {
		
	}
	@BeforeTest
	public void SetUpTest() {
	
}
	@BeforeClass
	public void beforeClass() {
	
}*/
	@BeforeMethod
	public void invoke() {
		startApp("Chrome","http://leaftaps.com/opentaps" );
	
}
	@AfterMethod
	public void close() {
	closeActiveBrowser();
	}
	/*@AfterClass
	public void afterClass() {
	
}
	@AfterTest
	public void finishedTest() {
	
}
	@AfterSuite
	public void closebrowser() {
	
}*/
	
	

}
