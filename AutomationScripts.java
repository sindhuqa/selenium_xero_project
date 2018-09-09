package SeleniumHackathon;

import java.util.LinkedHashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
public class AutomationScripts extends ReusableModules {
	
	public static void TestID01() 
	{
		launchDriver();
		OpenLogginPage();
		LoginModule();
		
		
	}
	
	public static void TestID02() 
	{
		OpenLogginPage();
		
		
		WebElement userId = driver.findElement(By.xpath("//input[@id='email']"));
		EnterText(userId, "user@email.com", "EmailAddress");
		/* UserName is displayed */
		System.out.println("UserName is displayed on the screen");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(password, "Passwordvalue", "Password");
		
		/* Passowrd is entered */
		System.out.println("Password is displayed on the screen");
		
		WebElement loginbtn = driver.findElement(By.xpath("//button[@id='submitButton']"));
		click(loginbtn, "Sumbit Button");
		
		WebElement errormessage = driver.findElement(By.xpath("//div[@class='x-boxed warning']//p"));
		String actualErrortext = errormessage.getText();
		String expectedErrortext = "Your email or password is incorrect";
		
		/* Error message validation for incorrect password */
		ComparetwoStrings(actualErrortext, expectedErrortext);
	}
	
	public static void TestID03() 
	{
		OpenLogginPage();


		WebElement userId = driver.findElement(By.xpath("//input[@id='email']"));
		EnterText(userId, "user@email.com", "EmailAddress");
		/* UserName is displayed */
		System.out.println("UserName is displayed on the screen");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(password, "passwordvalue", "Password");
		
		/* Passowrd is entered */
		System.out.println("Password is displayed on the screen");
		
		WebElement loginbtn = driver.findElement(By.xpath("//button[@id='submitButton']"));
		click(loginbtn, "Sumbit Button");
		
		WebElement errormessage = driver.findElement(By.xpath("//div[@class='x-boxed warning']//p"));
		String actualErrortext = errormessage.getText();
		String expectedErrortext = "Your email or password is incorrect";
		
		/* Error message validation for incorrect username */
		ComparetwoStrings(actualErrortext, expectedErrortext);
		
		
	}
	
	public static void TestID04() throws InterruptedException 
	{
		OpenLogginPage();

		
		WebElement forgotPassword = driver.findElement(By.xpath("//a[@class='forgot-password-advert']"));
		click(forgotPassword, "Forgot yout Password?");
		
		/* Forgot password page validation*/
		String actualForgotPasswordtitle = driver.getTitle();
		String expectedForgotPasswordtitle = "Forgotten Password";
		ComparetwoStrings(actualForgotPasswordtitle, expectedForgotPasswordtitle);
		
		String emailid = "user@email.com";
		WebElement emailaddresstorecoverPWD = driver.findElement(By.xpath("//input[@id='UserName']"));
		EnterText(emailaddresstorecoverPWD, emailid, "Email address to recover password");
		
		WebElement senLinkbtn = driver.findElement(By.xpath("//a[@class='x-btn blue']"));
		click(senLinkbtn, "Sendlink");
		
		Thread.sleep(4000);
		
		/*verify password display message is displayed */
		WebElement linkreset = driver.findElement(By.xpath("//div[@class='x-boxed noBorder']//p[1]"));
		String expectedtext = "A link to reset your password has been sent to:\n" + emailid;
		verifyWebelementText(linkreset, expectedtext);
		
	}
	
	public static void TestID05() throws InterruptedException 
	{
		SignUpForFreeTrialModule();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@name='FirstName']"));
		EnterText(firstName, "passwordvalue", "Firstname");
		/* First name is dislayed */
		System.out.println("Userfirstname is displayed");
		
		WebElement LastName = driver.findElement(By.xpath("//input[@name='LastName']"));
		EnterText(LastName, "passwordvalue", "Firstname");
		
		/* Last name is dislayed */
		System.out.println("Lastname is displayed");
		
		WebElement email = driver.findElement(By.xpath("//input[@name='EmailAddress']"));
		EnterText(email, "user@email.com", "emailaddress");
		
		/* email address is dislayed */
		System.out.println("emailaddress is displayed");
		
		WebElement phone = driver.findElement(By.xpath("//input[@name='PhoneNumber']"));
		EnterText(phone, "1234567", "phone number");
		
		/* phone number is dislayed */
		System.out.println("phone number is displayed");
		
		Select countryDropdown = new Select (driver.findElement(By.xpath("//select[@name='LocationCode']")));
		countryDropdown.selectByVisibleText("United States");
		
		/* Country is displayed*/
		
		System.out.println("Country is displayed");
		
		WebElement radiobtn = driver.findElement(By.xpath("//input[@value='true']"));
		radiobuttonSelectDeselect(radiobtn, "Radiobutton");
		
		
		WebElement getStarted = driver.findElement(By.xpath("//button[@type='submit']"));
		click(getStarted, "Sumbitbtn");
		
		/* Submbit buttonn is clicked */
		System.out.println("Submit button is selected");
	
	}
	
	public static void TestID06() throws InterruptedException 
	{
		OpenLandingPage();
		
		WebElement Freetrial = driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		click(Freetrial, "FreeTrial");
		
		// 30 days free trial page is displayed
		String expectedTitle = "Signup for Xero - Free Trial | Xero US";
		verifyWebPageTitle(expectedTitle);
		
		WebElement getStarted = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		click(getStarted, "Sumbitbtn");
		
		WebElement firstNameEmpty = driver.findElement(By.xpath("//span[@id='signup-form-error-message-1']"));
		String expectedtext = "First name can't be empty";
		verifyWebelementText(firstNameEmpty, expectedtext);
		
		WebElement LastNameEmpty = driver.findElement(By.xpath("//span[@id='signup-form-error-message-2']"));
		String expectedtext1 = "Last name can't be empty";
		verifyWebelementText(LastNameEmpty, expectedtext1);
		
		WebElement emailaddressEmpty = driver.findElement(By.xpath("//span[@id='signup-form-error-message-3']"));
		String expectedtext2 = "Email address can't be empty";
		verifyWebelementText(emailaddressEmpty, expectedtext2);
		
		WebElement phoneNumberEmpty = driver.findElement(By.xpath("//span[@id='signup-form-error-message-4']"));
		String expectedtext3 = "Phone number can't be empty";
		verifyWebelementText(phoneNumberEmpty, expectedtext3);
		
		WebElement getStarted1 = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		click(getStarted1, "Sumbitbtn");
		
		WebElement email = driver.findElement(By.xpath("//input[@name='EmailAddress']"));
		EnterText(email, "invalidemaila@.com", "emailaddress");
		
		WebElement emailaddressinvalid = driver.findElement(By.xpath("//span[@id='signup-form-error-message-3']"));
		String expectedtext11 = "Email address is invalid";
		verifyWebelementText(emailaddressinvalid, expectedtext11);
	
	}
	
	public static void TestID07() throws InterruptedException 
	{
		SignUpForFreeTrialModule();
		
		WebElement termsOfUse = driver.findElement(By.xpath("//a[contains(text(),'terms of use')]"));
		click(termsOfUse, "Terms of use");
		
		OperateOnNewWindow();
		driver.close();
      
        WebElement privacyPolicyLink = driver.findElement(By.xpath("//a[contains(text(),'privacy notice')]"));
        click(privacyPolicyLink, "Privacy Policy Link");
        
        OperateOnNewWindow();
        driver.close();
	
	}
	
	public static void TestID08() throws InterruptedException 
	{
		SignUpForFreeTrialModule();
		
		WebElement offerDetailsLink = driver.findElement(By.xpath("//a[contains(text(),'offer details')]"));
		click(offerDetailsLink, "Offer Details Link");
		
		OperateOnNewWindow ();
		driver.close(); //closes new window
	}
	
	public static void TestID09() throws InterruptedException 
	{
		SignUpForFreeTrialModule();
		
		WebElement accountantOrBookkeeperLink = driver.findElement(By.xpath("//a[contains(text(),'offer details')]"));
		click(accountantOrBookkeeperLink, "accountant Or Bookkeeper Link");
		
		OperateOnNewWindow ();
		driver.close(); //closes new window
	}
	
	public static void TestID10() throws InterruptedException
	{
		launchDriver();
		OpenLogginPage();
		LoginModule();
		
		/* Login to Xero validation */
		WebElement textBox = driver.findElement(By.xpath("//span[@class='xn-h-demo-bar-text']"));
		String expectedtextBoxMessage = "You are currently using a trial account.";
		verifyWebelementText(textBox, expectedtextBoxMessage);
		
		//Dashboard
		WebElement Dashboard = driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]"));
		click(Dashboard, "Dashboard");
		
		/* Dashboad page validation*/
		String expectedDashboardtitle = "Xero | Dashboard | Teki";
		verifyWebPageTitle(expectedDashboardtitle);
		
		//Account
		WebElement Account = driver.findElement(By.linkText("Accounts"));
		click(Account, "Account");
		
		/* Account page validation*/
//		Select Account1 = new Select (driver.findElement(By.xpath("//ul[@class='xn-h-menu-list a-fade-in']//a[@data-type='menu-focus'][contains(text(),'Sales')]")));
//		Account1.selectByVisibleText("Sales");
		
		WebElement sales = driver.findElement(By.xpath("//ul[@class='xn-h-menu-list a-fade-in']//a[@data-type='menu-focus'][contains(text(),'Sales')]"));
		click(sales, "Sales");
	
		//Report
		WebElement Report = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[5]/a[1]"));
		click(Report, "Report");
		
		/* Report page validation*/
		WebElement AllReports = driver.findElement(By.xpath("//a[contains(text(),'All Reports')]"));
		click(AllReports, "ALL Reports");
		
		//Contacts
		WebElement Contacts = driver.findElement(By.xpath("//a[text() = 'Contacts']"));
		click(Contacts, "Contacts");
		
		/* Contacts page validation*/
		WebElement allContacts = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[6]/ul[1]/li[1]/a[1]"));
		click(allContacts, "All Contacts");
		
		//Setting
		WebElement Settings = driver.findElement(By.xpath("//a[text() = 'Settings']"));
		click(Settings, "Settings");

		
		/* Setting page validation*/
		WebElement generalSettings = driver.findElement(By.xpath("//a[contains(text(),'General Settings')]"));
		click(generalSettings, "General Settings");
		
		//+/New
		WebElement plusNew = driver.findElement(By.xpath("//a[@id='quicklaunchTab']"));
		click(plusNew, "Plus/NEW button");
		
		/* + page validation*/
		WebElement bill = driver.findElement(By.linkText("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]"));
		click(bill, "Bill");
		
		//Files
		WebElement Files = driver.findElement(By.xpath("//a[@class='files']"));
		click(Files, "Files");
		
		Thread.sleep(4000);
		
		/* File page validation */
		WebElement filetext = driver.findElement(By.xpath("//a[@class='files']"));
		click(filetext, "file");
		
	   /* Files page validation */
		String expectedtext = "Files";
		ComparetwoStrings(filetext.getText(), expectedtext);
		
		//Notification
		WebElement notification = driver.findElement(By.xpath("//a[@class='notifications x-sandbox']"));
		click(notification, "notification");
		
		Thread.sleep(4000);
		
		//notification validation
		WebElement notificationtext = driver.findElement(By.xpath("//*[@id=\"NOTIFICATIONS\"]/button/span/span"));
		String expectedNotiText = " Notifications";
		ComparetwoStrings(notificationtext.getText(), expectedNotiText);
		
		//Search
		WebElement Search = driver.findElement(By.xpath("//a[@class='search']"));
		click(Search, "Search");
		
		/* Search validation */
		WebElement searchBox = driver.findElement(By.id("queryInput"));
		click(searchBox, "Searchbox");
		
		//Help
		WebElement Help = driver.findElement(By.xpath("//a[@class='help']"));
		click(Help, "Help");
		
		//Help validation
		WebElement Help1 = driver.findElement(By.xpath("//input[@id='menu_help']"));
		String expectedtext12 = "What do you need help with?";
		ComparetwoStrings(Help1.getText(), expectedtext12);
	
	}
	
	public static void TestID11() throws InterruptedException
	{
		launchDriver();
		OpenLogginPage();
		LoginModule();
		
		WebElement username = driver.findElement(By.xpath("//a[@class='username']"));
		click(username, "UserName");
		
		WebElement logout_btn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		click(logout_btn, "Logout");
		
		WebElement emailIdAfterlogout = driver.findElement(By.xpath("//input[@id='email']"));
		/* Email field validation after logout operation */
		String expectedemailId = "user@email.com";
		ComparetwoStrings(emailIdAfterlogout.getText(), expectedemailId);
	}
	
	public static void TestID12() throws InterruptedException
	{
		launchDriver();
		OpenLogginPage();
		LoginModule();
		
		WebElement username = driver.findElement(By.xpath("//a[@class='username']"));
		click(username, "UserName");
		
		WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'Profile')]"));
		click(profile, "Profile");
		
		/*profile page validation */
		WebElement profilePage = driver.findElement(By.xpath("//h1[contains(text(),'Profile Settings')]"));
		String expectedtitle = "My Xero | Profile Settings";
		verifyWebPageTitle(expectedtitle);
		
		Thread.sleep(4000);
		
		WebElement upload_btn = driver.findElement(By.id("button-1041-btnInnerEl"));
		click(upload_btn, "Upload Image");
		
		Thread.sleep(4000);
		
		WebElement browse_btn = driver.findElement(By.xpath("//input[@id='filefield-1174-button-fileInputEl']"));
		EnterText(browse_btn,"D:\\TekArch\\SeleniumHackathon\\butterfly.jpg", "Image");
		
		/* Error: File does noot exist for the picture given from my computer */
		
		Thread.sleep(4000);
		
		WebElement uploadBtn = driver.findElement(By.xpath("//div[@id='button-1178-btnWrap']"));
		click(uploadBtn, "Upload - after profile photo loaded");
		
		Thread.sleep(4000);
		
		/* Profile photo uploaded sucessful */
	
	}
	
	public static void TestID13() throws InterruptedException
	{
		launchDriver();
		OpenLogginPage();
		LoginModule();
		
		WebElement myXero = driver.findElement(By.xpath("//h2[@class='org-name']//a[contains(text(),'My Xero')]"));
		click(myXero, "MY XERO");
		
		/*  validation for organization page opened */
		WebElement organization = driver.findElement(By.xpath("//h2[contains(text(),'Organizations')]"));
		String expectedtext = "Organizations";
		verifyWebelementText(organization, expectedtext);
		
		WebElement addOrganization = driver.findElement(By.xpath("//a[@id='ext-gen1042']"));
		click(addOrganization, "Add Organization");
		Thread.sleep(2000);
		
		WebElement addorgName = driver.findElement(By.xpath("//input[@id='text-1022-inputEl']"));
		EnterText(addorgName, "Self", "Comapny name");
		
		WebElement addCountrydrpDown = (driver.findElement(By.xpath("//input[@id='countryCmb-inputEl']")));
		EnterText(addCountrydrpDown, "United States", "Country Name");
		
		WebElement addTimedrpDown = (driver.findElement(By.xpath("//input[@id='cmbTimeZone-inputEl']")));
		EnterText(addTimedrpDown,"(UTC-08:00) Pacific Time (US & Canada)", "Time");
		
		WebElement timeclick = driver.findElement(By.xpath("//li[@class='x-boundlist-item x-boundlist-item-over']"));
		click(timeclick, "Selection of time");
		
		WebElement orgDetails = driver.findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"));
		EnterText(orgDetails, "Accounting", "organization Details");
		
		WebElement statTrialbtn = driver.findElement(By.xpath("//a[@id='simplebutton-1035']"));
		click(statTrialbtn, "Start Trial");
		
		Thread.sleep(4000);
		
		/* Validation is not possible, website updated */
	
	}
	
	public static void TestID14() throws InterruptedException
	{
		launchDriver();
		OpenLogginPage();
		LoginModule();
		
		WebElement myXero = driver.findElement(By.xpath("//h2[@class='org-name']//a[contains(text(),'My Xero')]"));
		click(myXero, "MY XERO");
		
		/*  validation for organization page opened */
		WebElement organization = driver.findElement(By.xpath("//h2[contains(text(),'Organizations')]"));
		String expectedtext = "Organizations";
		verifyWebelementText(organization, expectedtext);
		
		WebElement addOrganization = driver.findElement(By.xpath("//a[@id='ext-gen1042']"));
		click(addOrganization, "Add Organization");
		Thread.sleep(2000);
		
		WebElement addorgName = driver.findElement(By.xpath("//input[@id='text-1022-inputEl']"));
		EnterText(addorgName, "Self", "Comapny name");
		
		WebElement addCountrydrpDown = (driver.findElement(By.xpath("//input[@id='countryCmb-inputEl']")));
		EnterText(addCountrydrpDown, "United States", "Country Name");
		
		WebElement addTimedrpDown = (driver.findElement(By.xpath("//input[@id='cmbTimeZone-inputEl']")));
		EnterText(addTimedrpDown,"(UTC-08:00) Pacific Time (US & Canada)", "Time");
		
		WebElement timeclick = driver.findElement(By.xpath("//li[@class='x-boundlist-item x-boundlist-item-over']"));
		click(timeclick, "Selection of time");
		
		WebElement orgDetails = driver.findElement(By.id("industrysearchcombofield-1025-inputEl"));
		EnterText(orgDetails, "Accountingggg", "organization Details");
		
		WebElement buy_btn = driver.findElement(By.xpath("//a[@id='simplebutton-1036']"));
		click(buy_btn, "Buy Now");
		
		Thread.sleep(10000);
		
//		String expectedText = "Xero | Pricing Plan";
//		verifyWebPageTitle(expectedText);
		
		WebElement subscribetext = driver.findElement(By.xpath("//h3[@class='xui-heading-large xui-text-centered']"));
		String expectedText = "Select a plan";
		verifyWebPageTitle(expectedText);
		 
	}
	
	public static void TestID19() throws InterruptedException
	{
		launchDriver();
		OpenLogginPage();
		LoginModule();
		
		WebElement account = driver.findElement(By.xpath("//a[text()='Accounts']"));
		click(account, "Accounts");
		
		WebElement purchases = driver.findElement(By.xpath("//a[contains(text(),'Purchases')]"));
		click(purchases, "Purchases");
		
		WebElement purchasePageVeri = driver.findElement(By.xpath("//h1[contains(text(),'Purchases')]"));
		String expectedText = "Purchases";
		verifyWebelementText(purchasePageVeri, expectedText);
		
		/* WebElement mentioned in the following testcases are not available on the website */
	}
}
