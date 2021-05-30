package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import hooks.TestNgHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;




public class Login extends TestNgHooks {
	//Username,password,login
	@And ("Enter the username")
	public Login username( String data) {
		//locateElement("id", "username");
		type(locateElement("id", "username"), data);
		
		return this;
	}
	@And ("Enter the password")
	public Login password(String data) {
		//locateElement("id", "password");
		type(locateElement("id", "password"), data);
		
		return this;
	}
	@When ("click the login")
	public Home clicklogin() {
		click(locateElement("class","decorativeSubmit"));
		return new Home();
	}
	/*public Login clickfailurelogin() {
		click(locateElement("class","decorativeSubmit"));
		return this;
		
	}*/


}
