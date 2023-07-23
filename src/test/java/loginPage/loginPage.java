package loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver driver;
	
	loginPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="Email")
	WebElement txt_emailfields;
	
	@FindBy(id="Password") WebElement txt_passwordfields;
	
	@FindBy(id="RememberMe") WebElement rememberme_checbox;
	
	@FindBy(xpath="//button[@type='submit']") WebElement submit_btn;
	
	
	public void setusername(String username) {
		txt_emailfields.clear();
		txt_emailfields.sendKeys(username);
	}

	public void setpassword(String password) {
		txt_passwordfields.clear();
		txt_passwordfields.sendKeys(password);
	}
	
	public void remeberchecbox() {
		rememberme_checbox.click();
	}
	
	public  void submitbutton() {
		submit_btn.click();
	}
}
