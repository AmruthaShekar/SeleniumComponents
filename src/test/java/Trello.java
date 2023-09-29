
import java.time.Duration;
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

public class Trello {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://trello.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")).click();
		driver.findElement(By.id("user")).sendKeys("amruthashekar139@gmail.com");
		driver.findElement(By.id("login")).click();	
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys("Trello@2022");				
		driver.findElement(By.id("login-submit")).click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='szBTSFrvPTLGHM']"))).click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='board-tile mod-add']"))).click();
//		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Create board']"))).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("JustaBoard");
		driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
		
		
	//	Explicit wait syntax
/*		public boolean isOnLoginPage() {
		    WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed.
		    
		    // Wait for a specific element on the login page.
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginForm")));
		    
		    // Check if the page URL matches the expected URL for the login page.
		    return driver.getCurrentUrl().contains("login");
		} */
	}	
}
