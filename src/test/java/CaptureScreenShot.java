import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/");
		
		driver.manage().window().maximize();
		
		TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture the screenshot as a file
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        // Define the target location to save the screenshot
        File targetFile = new File(".//Screenshots//" + "homepage" + ".png");

        // Copy the screenshot file to the target location
        FileUtils.copyFile(srcFile, targetFile);
        
        driver.close();
		

	}

}
