package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.cucumber.java.After;
import io.cucumber.java.en.When;

public class TestCasesSteps 
{
	private UtilsSteps utilsSteps;
	WebElement elem;
	
	public TestCasesSteps(UtilsSteps utilsSteps) 
	{
		this.utilsSteps = utilsSteps;
	}

	@When("el usuari selecciona diversos tests cases")
	public void el_usuari_selecciona_diversos_tests_cases() 
	{
		// Obrim / Tanquem els diferents casos de prova
		
		// Test Case 1
		utilsSteps.getDriver().findElement(By.cssSelector(".panel:nth-child(2) u")).click();
		utilsSteps.getDriver().findElement(By.cssSelector(".panel:nth-child(2) u")).click();
		
		// Test Case 2

		elem = utilsSteps.getDriver().findElement(By.cssSelector(".panel-group:nth-child(3) u"));
		((JavascriptExecutor) utilsSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", elem);

		utilsSteps.getDriver().findElement(By.cssSelector(".panel-group:nth-child(3) u")).click();
		utilsSteps.getDriver().findElement(By.cssSelector(".panel-group:nth-child(3) u")).click();
		
		// Test Case 9
		elem = utilsSteps.getDriver().findElement(By.cssSelector(".panel-group:nth-child(10) u"));
		((JavascriptExecutor) utilsSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", elem);
		
		utilsSteps.getDriver().findElement(By.cssSelector(".panel-group:nth-child(10) u")).click();
		utilsSteps.getDriver().findElement(By.cssSelector(".panel-group:nth-child(10) u")).click();
		
		// Test Case 24
		elem = utilsSteps.getDriver().findElement(By.cssSelector(".panel-group:nth-child(25) u"));
		((JavascriptExecutor) utilsSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", elem);
		
		utilsSteps.getDriver().findElement(By.cssSelector(".panel-group:nth-child(25) u")).click();
		utilsSteps.getDriver().findElement(By.cssSelector(".panel-group:nth-child(25) u")).click();
	}
	
	@After
	public void close() {
		utilsSteps.getDriver().quit();
	}
	
	
}
