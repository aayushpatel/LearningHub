package aayushpatelframework.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import aayushpatelframework.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	WebDriver driver;
	public LandingPage Lp;

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream(
				System.getProperty("user.dir")
						+ "\\src\\main\\java\\aayushpatelframework\\resources\\GlobalData.properties");
		prop.load(fi);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;

	}

	public String getScreenShot(String Testcasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir") + "//reports//" + Testcasename + ".png");
		FileUtils.copyFile(Source, des);
		return (System.getProperty("user.dir") + "//reports//" + Testcasename + ".png");
	}

	public List<HashMap<String, String>> getJsonMapData(String Filepath) throws IOException {
		// reading json as String
		String content = FileUtils.readFileToString(new File(Filepath),
				StandardCharsets.UTF_8);

		// String To HashMap

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(content,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage goTo() throws IOException {

		driver = initializeDriver();
		Lp = new LandingPage(driver);
		Lp.luanchApplication();
		return Lp;

	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
	

}
