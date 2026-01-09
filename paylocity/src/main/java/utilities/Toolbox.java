package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Toolbox {

	 private WebDriver driver;
	    private WebDriverWait wait;

	    public void SeleniumUtils(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }

	    // 1. Dropdown difícil (React, Select2, custom, etc.)
	    public void selectDropdownByVisibleText(WebElement dropdown, String visibleText) {
	        try {
	            Select select = new Select(dropdown);
	            select.selectByVisibleText(visibleText);
	        } catch (UnexpectedTagNameException e) {
	            // No es <select> → lo trato como div custom
	            WebElement option = driver.findElement(
	                By.xpath("//*[contains(text(),'" + visibleText + "')]"));
	            jsClick(option);
	        }
	    }

	    // 2. Click con JavaScript (la vieja confiable)
	    public void jsClick(WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	    }

	    // 3. Switch a iframe por índice, nombre o WebElement
	    public void switchToIframe(WebElement iframe) {
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
	    }
	    public void switchToIframe(int index) {
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	    }
	    public void switchBackToMain() {
	        driver.switchTo().defaultContent();
	    }

	    // 4. Espera y click en elemento que aparece/desaparece (shadow DOM, overlays)
	    public void clickWhenReady(By locator) {
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	        element.click();
	    }

	    // 5. Scroll hasta elemento (infinite scroll o tablas largas)
	    public void scrollToElement(WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	    }

	    // 6. Subir archivo (input type=file oculto → JS)
	    public void uploadFile(WebElement inputFile, String filePath) {
	        inputFile.sendKeys(filePath); // si está visible
	        // Si está oculto:
	        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", inputFile);
	        inputFile.sendKeys(filePath);
	    }

	    // 7. Double click
	    public void doubleClick(WebElement element) {
	        new Actions(driver).doubleClick(element).perform();
	    }

	    // 8. Hover 
	    public void hover(WebElement element) {
	        new Actions(driver).moveToElement(element).perform();
	    }
	}