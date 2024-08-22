package Steps;

import org.openqa.selenium.By;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;

public class ComandaSteps{
	private UtilsSteps utilsSteps;
	
	public ComandaSteps(UtilsSteps utilsSteps) 
	{
		this.utilsSteps = utilsSteps; 
	}
	
	@Then("es valida que la comanda ha estat realitzada correctament")
	public void es_valida_que_ha_fet_el_login_correctament() 
	{
		// Si apareix el text "ORDER PLACED!" la comanda s'ha fet correctament
		boolean elemText = utilsSteps.getDriver().findElement(By.cssSelector("b:nth-child(1)")).isDisplayed();
		Assert.assertTrue(elemText);
	}
	
	
	@After 
	public void close() {
		utilsSteps.getDriver().quit();
	}
}
