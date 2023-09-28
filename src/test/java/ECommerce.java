import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ECommerce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		//launching the URL
		driver.get("https://www.flaschenpost.de");
		driver.manage().window().maximize();
		
		//delivery area
		driver.findElement(By.id("zipcode")).click();
		
		//entering the postal code
		WebElement postalcode = driver.findElement(By.xpath("//input[@class='fp_input']"));
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(postalcode)).sendKeys("48143");	
		
		//click on go on button
		driver.findElement(By.xpath("//button[text()=' Geht klar ']")).click();
		
		//click on beer category
        //i have added try catch block to handle the stale element exception - "https://stackoverflow.com/questions/18225997/stale-element-reference-element-is-not-attached-to-the-page-document"
/*		try {
		    WebElement beer = driver.findElement(By.xpath("//span[contains(text(), 'Bier')]"));
		    beer.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
		    WebElement beer = driver.findElement(By.xpath("//span[contains(text(), 'Bier')]"));
		    beer.click();
		} */
			
		//another workaround for stale element exception
		int attempts = 0;
		while (attempts < 3) {
		    try {
		        WebElement beer = driver.findElement(By.xpath("//span[contains(text(), 'Bier')]"));
		        beer.click();
		        break;
		    } catch (StaleElementReferenceException e) {
		        // Handle the exception or simply retry
		    }
		    attempts++;
		}
		
		//select pills
		driver.findElement(By.xpath("//a[@href='/bier/pils']")).click();
		
		//This Element is inside single shadow DOM.
		String cssSelectorForHost1 = "body > div:nth-child(6) > div:nth-child(4) > main:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > mfe-products-display:nth-child(1)";
	//	Thread.sleep(1000);
		SearchContext shadow = driver.findElement(By.cssSelector("body > div:nth-child(6) > div:nth-child(4) > main:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > mfe-products-display:nth-child(1)")).getShadowRoot();
	//	Thread.sleep(1000);
		shadow.findElement(By.cssSelector(" div:nth-child(10) > section:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1)")).click();
		
		
	}
	

}
