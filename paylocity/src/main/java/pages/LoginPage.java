package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(id ="Username") private WebElement userNameField;
	@FindBy(id ="Password") private WebElement passwordField;
	@FindBy(xpath = "//button[@type=\"submit\"]")  private WebElement loginButton;
		
	public LoginPage (WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}
	public void doLogin(String name, String pass) {
		userNameField.sendKeys(name);
		passwordField.sendKeys(pass);
		loginButton.click();
		//Select select = new Select(azDropdown);
		//select.selectByIndex(2);
	}
	
	
	
}
