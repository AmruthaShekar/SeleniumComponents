
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

public class DropDown_Dynamic {
	public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.twoplugs.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();

        WebElement searchBox = driver.findElement(By.id("autocomplete"));
        searchBox.clear();
        searchBox.sendKeys("Toronto");
        List<WebElement> dpValues = driver.findElements(By.xpath("//div[@class='pac-container pac-logo']"));
        for(WebElement item : dpValues) {
        	if(item.getText().contains("Toronto, OH, USA")) {
        		item.click();
        	}
        }
        
       
        
//        String text;
//        do {
//        	searchBox.sendKeys(Keys.ARROW_DOWN);
//        	text=searchBox.getAttribute("value");
//        	
//        	if(text.equals("Toronto, oH, USA")) {
//        		searchBox.sendKeys(Keys.ENTER);
//        		break;
//        	}
//        	
//        	
//        }while(!text.isEmpty());
	}
	
}
