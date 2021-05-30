package pages;

import org.openqa.selenium.By;

import hooks.TestNgHooks;
import io.cucumber.java.en.And;

public class MyHome extends TestNgHooks {
	
	@And ("click the create lead")
	public CreateLead createlead() {
		click(locateElement("link","Create Lead"));
		return new CreateLead();
		}

}
