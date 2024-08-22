package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class APITestingSteps 
{
	private UtilsSteps utilsSteps;
	WebElement elem;
	
	public APITestingSteps(UtilsSteps utilsSteps) 
	{
		this.utilsSteps = utilsSteps;
	} 

	@When("el usuari accedeix a la API {string}")
	public void el_usuari_selecciona_diversos_tests_cases(String apiNum) throws InterruptedException 
	{
		// Obrim / Tanquem els diferents casos de prova
		
		// Primera API
		if (apiNum.equals("1"))
		{
			// Despleguem la API
			utilsSteps.getDriver().findElement(By.cssSelector(".panel:nth-child(2) u")).click();
			
		} else 
		{
			int apiParsed = Integer.parseInt(apiNum);
			String cssElem = ".panel-group:nth-child(%s) u".formatted(apiParsed+1);
			elem = utilsSteps.getDriver().findElement(By.cssSelector(cssElem));
			((JavascriptExecutor) utilsSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", elem);
			utilsSteps.getDriver().findElement(By.cssSelector(cssElem)).click();
		}
	}
	
	@Then("es valida que es mostra la API {string} correctament")
	public void es_valida_que_es_mostra_la_api_correctament(String apiNum) 
	{
		boolean apiValid = false;
		
		String cssFormated = "#collapse%s .list-group-item:nth-child(1) > b".formatted(apiNum);
		apiValid = utilsSteps.getDriver().findElement(By.cssSelector(cssFormated)).isDisplayed();
		Assert.assertTrue(apiValid);
	}
	
	@After
	public void close() {
		utilsSteps.getDriver().quit();
	}
	
	
}
