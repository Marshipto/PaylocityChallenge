package pages;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BenefitsDashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(id = "add") private WebElement addEmployeeButton;
    @FindBy(id = "firstName") private WebElement firstNameField;
    @FindBy(id = "lastName") private WebElement lastNameField;
    @FindBy(id = "dependants") private WebElement dependantsField;
    @FindBy(id = "addEmployee") private WebElement addButton;
    @FindBy(id = "employeeModal") private WebElement employeeModal;
    
    
    public BenefitsDashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
   
    public void FillemployeeDetails(String firstName, String lastName, String dependants)
    {
    	
    	addEmployeeButton.click();
    	firstNameField.sendKeys(firstName);
    	lastNameField.sendKeys(lastName);
    	dependantsField.sendKeys(dependants);
    	addButton.click();
    	
    }
   public boolean VerifyModalClosed() {
	   boolean closed  =false;
	   try {
		wait.until(ExpectedConditions.invisibilityOf(employeeModal));
		closed = true;
	} catch (Exception e) {
		
	}
	   return closed;
   }
}
