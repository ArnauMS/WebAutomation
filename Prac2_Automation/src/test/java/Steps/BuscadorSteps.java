package Steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;

public class BuscadorSteps {
	private UtilsSteps utilsSteps;
	
	public BuscadorSteps(UtilsSteps utilsSteps) 
	{
		this.utilsSteps = utilsSteps;
	} 
	
	@Then("es valida que la busqueda es un exit")
	public void esValidaQueLaBusquedaEsUnExit() {
		boolean producte = utilsSteps.getDriver().findElement(By.linkText("View Product")).isEnabled();
		Assert.assertTrue(producte);
	}
	
	@Then ("es valida que no apareix cap producte")
	public void esValidaQueNoApareixCapProducte() {
		boolean producte = utilsSteps.getDriver().getPageSource().contains("View Product");
		Assert.assertTrue(!producte);
	}
	
	@After
	public void close() {
		utilsSteps.getDriver().quit();
	}
}
