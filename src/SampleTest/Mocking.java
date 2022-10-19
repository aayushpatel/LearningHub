package SampleTest;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.fetch.Fetch;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mocking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Devtool Objevt
		DevTools devtools = driver.getDevTools();
		// Create session
		devtools.createSession();
		devtools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devtools.addListener(Fetch.requestPaused(), request -> {

			if (request.getRequest().getUrl().contains("=shetty")) {
				String newUrl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println(newUrl);
				devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(newUrl),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(),
						Optional.empty()));
			}

			else {
				devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(),
						Optional.empty()));
			}
		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5));
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()]")));
		driver.findElement(By.xpath("//button[text()]")).click();
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
	}

}
