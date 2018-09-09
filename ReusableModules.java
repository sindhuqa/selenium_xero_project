package SeleniumHackathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReusableModules extends ReusableMethods {
	
	public static void LoginModule()
	{

		WebElement userId = driver.findElement(By.xpath("//input[@id='email']"));
		EnterText(userId, "user@email.com", "EmailAddress");
		/* UserName is displayed */
		System.out.println("UserName is displayed on the screen");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(password, "passwordvalue", "Password");
		
		/* Passowrd is entered */
		System.out.println("Password is displayed on the screen");
		
		WebElement loginbtn = driver.findElement(By.xpath("//button[@id='submitButton']"));
		click(loginbtn, "Submit Button");
		
		/* verification of homepage after login */
		String actualhomepage = driver.getTitle();
		String expectedhomepage = "Xero | Dashboard | Teki";
		ComparetwoStrings(actualhomepage, expectedhomepage);
		
	}
	
	public static void SignUpForFreeTrialModule()
	{
		OpenLandingPage();
		
		WebElement Freetrial = driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		click(Freetrial, "FreeTrial");
		
		// 30 days free trial page is displayed
		String expectedTitle = "Signup for Xero - Free Trial | Xero US";
		verifyWebPageTitle(expectedTitle);
	}
	
	public static void Logut()
	{
		WebElement username = driver.findElement(By.xpath("//a[@class='username']"));
		click(username, "UserName");
		
		WebElement logut_btn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		click(logut_btn, "Logout");
		
	}

}
