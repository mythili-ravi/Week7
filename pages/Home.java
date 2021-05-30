package pages;

import org.openqa.selenium.By;

import hooks.TestNgHooks;
import io.cucumber.java.en.And;



public class Home extends TestNgHooks {
	@And ("verify the title")
	public Home verifytitle() {
		verifyPartialTitle("Welcome");
		return this;
	}
	@And ("click the crm/sfa")
	public MyHome crmclick() {
		
		click(locateElement("link","CRM/SFA"));
		return new MyHome();
		
}
	
}