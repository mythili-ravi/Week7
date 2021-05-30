package wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver implements Browser, Element, Select, TargetLocator {

	public static RemoteWebDriver driver;

	@Override
	public boolean startApp(String browser, String url) {

		try {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if(browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			} else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			} else {
				System.err.println("This browser "+browser+" is not supported");
				return false;
			}

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("The browser "+browser+" launched successfully");
			return true;

		} catch (Exception e) {
			System.err.println("The browser "+browser+" could not be launched");
			return false;
		}

	}

	@Override
	public void switchToWindow(int index) {
		
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String>allwindowhandles=new ArrayList<String>(windowHandles);
			String windowHandle = allwindowhandles.get(index);
			driver.switchTo().window(windowHandle);
			System.out.println("The window index"+index);
		} catch (Exception e) {
			System.err.println("The window not switched properly"+index);
		}

	}

	@Override
	public void switchToFrame(WebElement ele) {
		
		try {
			driver.switchTo().frame(ele);
			System.out.println("The testcase switch to frame successfully as" +ele);
		} catch (Exception e) {
			System.err.println("The testcasenot switched frame as"+ele);
		}

	}

	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			System.out.println("Alert message accepted successfully ");
		} catch (Exception e) {
			System.err.println("Alert message accept failure ");
		}
	}

	@Override
	public void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			System.out.println("Alert message dismiss successfully ");
		} catch (Exception e) {
			System.err.println("Alert message dismiss step was failure ");
		}}

	@Override
	public String getAlertText() {
		try {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			System.out.println("Alert text message is"+text);
		} catch (Exception e) {
			System.err.println("Alert  not given any text name");
		} return null;
	}

	@Override
	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		try {
			selectDropDownUsingVisibleText(ele,value);
			System.out.println("selectdropdown" +ele+"using index"+value);
		} catch (Exception e) {
			System.out.println("the dropdown not selected using "+ele+value);
		}
	
		
	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub
		try {
			selectDropDownUsingValue(ele,value);
			System.out.println("selectdropdown" +ele+"using value"+value);
		} catch (Exception e) {
			System.out.println("the dropdown not selected using "+ele+value);
		}

	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			selectDropDownUsingIndex(ele,index);
			System.out.println("selectdropdown" +ele+"using index"+index);
		} catch (Exception e) {
			System.out.println("the dropdown not selected using "+ele+index);
		}

	}

	@Override
	public void type(WebElement ele, String data) {
		
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The element "+ele+" is typed with the value "+ele);
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be typed with the value "+ele);
		}

	}

	@Override
	public void click(WebElement ele) {	
		try {
			ele.click();
			System.out.println("The element "+ele+" is clicked");
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be clicked");
		}

	}

	@Override
	public String getText(WebElement ele) {
		try {
			ele.getText();
			System.out.println("The given text is"+ ele);
		} catch (Exception e) {
			System.err.println("The given text not present");
			
		}
		return null;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		
		try {
			String text = ele.getText();
			if(text.equals(expectedText))
			{System.out.println("print the exactText matched with"+ expectedText);
			}
		} catch (Exception e) {
			System.err.println("print the exactText  not matched with"+ expectedText);
		}
	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			String text = ele.getText();
			if(text.contains(expectedText))
			{System.out.println("print the partialText matched with"+ expectedText);
			}
		} catch (Exception e) {
			System.err.println("print the partialText  not matched with"+ expectedText);
		}
	}


	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			String attribute1= ele.getAttribute(value);
			if(attribute1.equals(value)) {
				System.out.println("verifyExactattribute matched ");
			}
		} catch (Exception e) {
			System.err.println("verifyExactattribute  not matched ");
		}

	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			String attribute1= ele.getAttribute(value);
			if(attribute1.contains(value)) {
				System.out.println("verified partialvattribute matched ");
			}
		} catch (Exception e) {
			System.err.println("verifiedpartialattribute  not matched ");
		}

	}

	@Override
	public void verifySelected(WebElement ele) {
		try {
			boolean selected = ele.isSelected();
			if(selected) {
				System.out.println("element is selected");
			}
		} catch (Exception e) {
			System.err.println("element is not selected");
		}

	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		try {
			boolean displayed = ele.isDisplayed();
			if(displayed) {
				System.out.println("print the displayed value"+ele);
			}
		} catch (Exception e) {
			System.err.println("element vaule is not displayed");;
		}
		
		
		
	}

	@Override
	public WebElement locateElement( String locator, String locValue) {
		try {
			switch(locator.toLowerCase()) {
			case "id": return driver.findElement(By.id(locValue));
			case "name": return driver.findElement(By.name(locValue));
			case "link": return driver.findElement(By.linkText(locValue));
			case "class": return driver.findElement(By.className(locValue));
			case "tag": return driver.findElement(By.tagName(locValue));
			case "xpath": return driver.findElement(By.xpath(locValue));
			case "css": return driver.findElement(By.cssSelector(locValue));
			case "partial": return driver.findElement(By.partialLinkText(locValue));
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element could not be found for the locator "+locator+" with value "+locValue);
		}
		return null;

	}

	@Override
	public boolean verifyExactTitle(String expectedTitle) {
		try {
			String title = driver.getTitle();
			if(title.contentEquals(expectedTitle))
			{System.out.println("Exact title matched with  "+expectedTitle);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("not matched with exact title "+expectedTitle);
		}
		
		
		return false;
	}

	@Override
	public boolean verifyPartialTitle(String expectedTitle) {
		try {
			String title = driver.getTitle();
			if(title.contains(expectedTitle))
			{System.out.println("partially title verified as  "+expectedTitle);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("not matched partially title as"+expectedTitle);
		}
		
		return false;
		
	}

	@Override
	public void closeActiveBrowser() {
		
try {
	driver.close();
	System.out.println("driver closeactivebrowser only");
} catch (Exception e) {
	
	System.err.println("failure to close active browser");
}
		// TODO Auto-generated method stub

	}

	@Override
	public void closeAllBrowsers() {
		
try {
	driver.quit();
	System.out.println("driver closeallbrowser successfully");
} catch (Exception e) {
	
	System.err.println("driver not closed  all browser");
}

	}





}
