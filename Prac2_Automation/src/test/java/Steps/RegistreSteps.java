package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RegistreSteps 
{
	private UtilsSteps utilsSteps;
	
	public RegistreSteps(UtilsSteps utilsSteps) 
	{
		this.utilsSteps = utilsSteps;
	}
	 
	@Given ("el usuari selecciona data de naixement")
	public void el_usuari_selecciona_data_de_naixement() {
		Select dia = new Select(utilsSteps.getDriver().findElement(By.id("days")));
		dia.selectByVisibleText("17");
		
		Select mes = new Select(utilsSteps.getDriver().findElement(By.id("months")));
		mes.selectByVisibleText("February");
		
		Select any = new Select(utilsSteps.getDriver().findElement(By.id("years")));
		any.selectByVisibleText("1995");
	}
	
	
	@Given ("el usuari selecciona el pais")
	public void el_usuari_selecciona_el_pais() {
		Select pais = new Select(utilsSteps.getDriver().findElement(By.id("country")));
		pais.selectByVisibleText("Australia");
	}
	
	
	@Then("es valida que el compte ha sigut creat correctament")
	public void es_valida_que_el_compte_ha_sigut_creat_correctament() 
	{
		boolean msg = utilsSteps.getDriver().findElement(By.linkText("Continue")).isDisplayed();
		Assert.assertTrue(msg);
	}
	
	@Then("es valida que el compte ha sigut eliminat correctament")
	public void es_valida_que_el_compte_ha_sigut_eliminat_correctament() 
	{
		boolean msg = utilsSteps.getDriver().findElement(By.linkText("Continue")).isDisplayed();
		Assert.assertTrue(msg);
	}
	
	@After
	public void close() {
		utilsSteps.getDriver().quit();
	}
	
}
