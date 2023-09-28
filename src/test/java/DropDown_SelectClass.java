
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown_SelectClass {


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
		driver.manage().window().maximize();

		//click on book a demo button
		driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();

		//enter your first name in demo form
		driver.findElement(By.xpath("//input[@id='Form_getForm_FullName']")).sendKeys("Ranga");

		//enter your email
		driver.findElement(By.xpath("//input[@class='email text']")).sendKeys("Ranga@gmail.com");

		//enter your company name
		driver.findElement(By.xpath("//input[@id='Form_getForm_CompanyName']")).sendKeys("tata");		

		//select the country element
		WebElement countryele = driver.findElement(By.xpath("//select[@id='Form_getForm_Country']"));

		//By using select class method selecting the values from dropdown 
		Select country = new Select(countryele);
		/*	country.selectByVisibleText("Hungary");
		country.selectByValue("Belgium");
		country.selectByIndex(6); */

		//selecting value from dropdown without using select method
		/*		String countryToFind = "Europa";
		try {
		    List<WebElement> countrylist = country.getOptions();
		    boolean countryFound = false;

		    for (WebElement item : countrylist) {
		        if (item.getText().equals("countryToFind")) {
		            item.click();
		            countryFound = true;
		            break;
		        }
		    }
		    if (!countryFound) {		       
		        System.out.println("Country '" + countryToFind + "' not found in the list");		        
		    }
		} catch (NoSuchElementException e) {		    
		    System.out.println("Element not found: " + e.getMessage());		    
		} */


		//making sure that dropdown accepts all the values from dropdown		
		List<WebElement> countrylist = country.getOptions();
		for (WebElement item : countrylist) {
		//	item.click();
		country.selectByVisibleText(item.getText());		
		}
		
		
		

	}	
}
