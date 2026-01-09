package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.BenefitsDashboardPage;
import pages.LoginPage;

public class PaylocitySuite extends BaseTest {

@Test(priority = 1)
public void doLogin() {
	String user = pro.getProperty("user");
	String pass = pro.getProperty("pass");
	driver.get("https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login");
	LoginPage loginPage = new LoginPage(driver);
	loginPage.doLogin(user, pass);
	Assert.assertTrue(driver.getCurrentUrl().contains("Benefits"));
}
@Test (priority = 2)
public void addEmployee() {
	String firstName = pro.getProperty("firstName");
	String lastName = pro.getProperty("lastName");
	String dependants = pro.getProperty("dependants");
	BenefitsDashboardPage dashPage = new BenefitsDashboardPage(driver);
	dashPage.FillemployeeDetails(firstName, lastName, dependants);
	Assert.assertTrue(dashPage.VerifyModalClosed());
}
	
}
