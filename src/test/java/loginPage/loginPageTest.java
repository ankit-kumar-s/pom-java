package loginPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class loginPageTest {
	
	WebDriver driver;
	loginPage lpage;
	
	@Parameters({"url"})
	@BeforeClass
	public void setupBrowser(String appUrl) {
		driver= new ChromeDriver();
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lpage = new loginPage(driver);
		
	}
	
	
	@Test
	public void setCredentials() {
		lpage.setusername("admin@yourstore.com");
		lpage.setpassword("admin");
		lpage.remeberchecbox();
	}
	
	@Test(priority=1)
	public void submit() {
		lpage.submitbutton();
	}
	
	@AfterClass
	public void browserclose() {
		driver.close();
	}

}
