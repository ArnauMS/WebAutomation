package Steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubscripcioSteps 
{
	private UtilsSteps utilsSteps;
	
	public SubscripcioSteps(UtilsSteps utilsSteps) 
	{
		this.utilsSteps = utilsSteps;
	}
 
	@When("el usuari accepta la subscripcio")
	public void el_usuari_introdueix_el_valor_al_camp_css() 
	{
		// Botó de subscripció
		utilsSteps.getDriver().findElement(By.xpath("//button[@id='subscribe']/i")).click();
	}
	
	@Then("es valida que el usuari estigui subscrit")
	public void es_valida_que_el_usuari_estigui_subscrit() 
	{
		boolean alert = utilsSteps.getDriver().findElement(By.cssSelector(".alert-success")).isDisplayed();
		Assert.assertTrue(alert);
	}
	
	@After
	public void close() {
		utilsSteps.getDriver().quit();
	}
	
	
}
