package SeleniumHackathon;

import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReusableMethods {
	
	public static WebDriver driver;
	
	public static ExtentTest test;
	public static ExtentReports report;
	
	/* Name of the Method: LaunchBowser with the given website
	 * Brief Description: FirefoxBrowser opens with xero login page
	 * Arguments: Not required
	 * Created By: Your Name
	 * Creation Date: month/date/year
	 * Last Modified: month/date/year
	 * Modified By: Your Name */
	
	public static void launchDriver()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}
	
	
	public static void OpenWebpage (String webaddress, String expectedtitle)
	{
//		launchDriver();
		
		driver.get(webaddress);
		
		/* Correct webpage is displayed verification */
		String actualtitle = driver.getTitle();
		ComparetwoStrings(actualtitle, expectedtitle);
		
		driver.manage().window().maximize();
	}
	
	public static void OpenLandingPage()
	{
		OpenWebpage("https://www.xero.com/us/", "Beautiful Business & Accounting Software | Xero US" );
	}
	
	public static void OpenLogginPage()
	{
		OpenWebpage("https://login.xero.com/", "Login | Xero Accounting Software" );
	}

	/* Name of the Method: LaunchBowser with the given website
	 * Brief Description: FirefoxBrowser opens with xero login page
	 * Arguments: Not required
	 * Created By: Your Name
	 * Creation Date: month/date/year
	 * Last Modified: month/date/year
	 * Modified By: Your Name */
	
	public static void ComparetwoStrings(String actualtext, String expectedtext)
	{
		if (actualtext.contentEquals(expectedtext))
		{
			System.out.println("Test: Passed, expected value is same as actual value (" + expectedtext + ")");
			test.log(LogStatus.PASS, "Expected value is same as actual value (" + expectedtext + ")");
		}
		else
		{
			System.out.println("Test: Fail " + expectedtext + " is not same as " + actualtext);
			test.log(LogStatus.FAIL, expectedtext + " is not same as " + actualtext);
		}
	}
	
	public static void EnterText(WebElement obj, String value, String objName)
	{
		if (obj.isDisplayed())
		{
			obj.sendKeys(value);
			System.out.println("Pass: " + value + " is entered in "+ objName + " field");
			test.log(LogStatus.PASS, value + " is entered in "+ objName + " field");
		}
		else
		{
			System.out.println("Fail: " + objName + " object does not exist in the application");
			test.log(LogStatus.FAIL, objName + " object does not exist in the application");
		}
		
	}
	
	public static void click (WebElement obj, String objName)
	{
		if (obj.isDisplayed())
		{
			obj.click();
			System.out.println("Pass: " + objName + " is selected");
			test.log(LogStatus.PASS, objName + " is selected");
		}
		else
		{
			System.out.println("Fail: " + objName + " is not present");
			test.log(LogStatus.FAIL, objName + " is not present");
		}
	}
	
	public static void verifyWebelementText(WebElement obj, String expectedText)
	{
		ComparetwoStrings(obj.getText(), expectedText);
	}
	
	public static void verifyWebPageTitle(String expectedText)
	{
		ComparetwoStrings(driver.getTitle(), expectedText);
	}
	
	public static void radiobuttonSelectDeselect (WebElement obj, String objName)
	{
		if (obj.isDisplayed())
		{
			if (obj.isSelected())
			{
				System.out.println("Pass: " + objName + " is selected");
				test.log(LogStatus.PASS, objName + " is selected");
			}
			else
			{
				obj.click();
				System.out.println("Pass: " + "previoulsy it is not selected " + 
						objName + "now it is selected");
				test.log(LogStatus.PASS, "previoulsy it is not selected " + 
						objName + "now it is selected");
				
			}
		}
			else
			{
				System.out.println("Fail: " + objName + " object does not exist, check your application");
				test.log(LogStatus.FAIL, objName + " object does not exist, check your application");
			}
	}
	
	public static void OperateOnNewWindow () throws InterruptedException
	{
		String parentHandle = driver.getWindowHandle();
        System.out.println(parentHandle);
        
        LinkedHashSet<String> handles = (LinkedHashSet<String>) driver.getWindowHandles();
        System.out.println(handles);

        for (String handle: driver.getWindowHandles()) 
        {

               System.out.println(handle);

               if (handle != parentHandle)
               {
            	   driver.switchTo().window(handle);
            	   Thread.sleep(2000);
//            	   driver.quit();
               }

        }
        
//        driver.switchTo().window(parentHandle);
      
	}
	
	public static String[][] readExcelSheetData(String excelFileName, String sheetName)
	{
		String[][] data = null;
		return data;
	}
	
	

}
