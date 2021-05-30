package tests;

import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.Login;


public class output extends TestNgHooks {
	@Test
public void login() {
		/*new Login()
		.username("DemoSalesManager")
		.password("crmsfa")
		.clicklogin()
		.verifytitle().logout();*/
		
		new Login().username("DemoSalesManager").password("crmsfa").clicklogin()
		.verifytitle()
		.crmclick()
		.createlead()
		.companyname("exela")
		.firstname("mythili")
		.lastname("ravi")
		.submit()
		.gettheleadnumber()
		.closethebrowser();
	}
}
