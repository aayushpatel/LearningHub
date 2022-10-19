package SampleTest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetGeoLocalizationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Devtool Objevt
		DevTools devtools = driver.getDevTools();
		// Create session
		devtools.createSession();
		Map<String, Object> location = new HashMap<String, Object>();
		location.put("latitude", 40);
		location.put("longitude", 3);
		location.put("accuracy", 1);
		driver.executeCdpCommand("Emulation.setGeolocationOverride", location);
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("Netflix", Keys.ENTER);
		driver.findElement(By.xpath("(//a/h3)[1]")).click();
		String Title = driver.findElement(By.xpath("(//div/h1[@class='our-story-card-title'])[1]")).getText();
		System.out.println(Title);
		
	}

}
