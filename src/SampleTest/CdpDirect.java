package SampleTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CdpDirect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Devtool Objevt
		DevTools devtools = driver.getDevTools();
		// Create session
		devtools.createSession();
		Map deviceMetrices = new HashMap();
		deviceMetrices.put("width", 600);
		deviceMetrices.put("height", 1000);
		deviceMetrices.put("mobile", true);
		deviceMetrices.put("deviceScaleFactor", 50);
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrices);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//*[@class='navbar-toggler-icon']")).click();
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5));
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Library']")));
		driver.findElement(By.xpath("//a[text()='Library']")).click();

	}

}
