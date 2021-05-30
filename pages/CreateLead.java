package pages;

import org.openqa.selenium.By;

import hooks.TestNgHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateLead extends TestNgHooks {
	@Then("enter the companyname(.*)$")
	public CreateLead companyname(String data) {
		
		type(locateElement("id", "createLeadForm_companyName"), data);
	return this;
		}
	@And("enter the first name(.*)$")
	public CreateLead firstname(String data) {
		type(locateElement("id", "createLeadForm_firstName"), data);
	return this;
		}
	@And("enter the last name(.*)$")
	public CreateLead lastname(String data) {
		type(locateElement("id", "createLeadForm_lastName"), data);
	return this;
		}
	@Then(" click the submit button")
	public ViewLead submit() {
		
		click(locateElement("class", "smallSubmit"));
	return  new ViewLead();	
		
		}
			
}

	
	
	

