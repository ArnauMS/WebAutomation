package Steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContacteSteps {
	private UtilsSteps utilsSteps;
	
	public ContacteSteps(UtilsSteps utilsSteps) 
	{
		this.utilsSteps = utilsSteps;
	}
	
	@When ("el usuari confirma el enviament")
	public void el_usuari_confirma_el_enviament() {
		utilsSteps.getDriver().switchTo().alert().accept();
	}
	
	@Then ("es valida que el missatge esta enviat correctament")
	public void esValidaQueElMissatgeEstaEnviatCorrectament() {
		
		boolean contacte = utilsSteps.getDriver().findElement(By.xpath("//span[contains(.,' Home')]")).isEnabled();
		Assert.assertTrue(contacte);
	}
	
	@After
	public void close() {
		utilsSteps.getDriver().quit();
	}
}
