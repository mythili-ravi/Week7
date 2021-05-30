package pages;

import hooks.TestNgHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ViewLead extends TestNgHooks {
	@And ("getthe lead value")
	public ViewLead gettheleadnumber(){
		getText(locateElement("id","viewLead_companyName_sp"));
		
return this;
}
	 @Then ("close the browser")
	public void closethebrowser() {
		closeActiveBrowser();
	}
}