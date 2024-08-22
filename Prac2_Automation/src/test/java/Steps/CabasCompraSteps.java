package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CabasCompraSteps {
	private UtilsSteps utilsSteps;
	
	public CabasCompraSteps(UtilsSteps utilsSteps) 
	{
		this.utilsSteps = utilsSteps;
	} 
	
	@Then ("es valida que el carrito inicialment està buit")
	public void esValidaQueElCarritoInicialmentEstàBuit() {
		boolean producte = utilsSteps.getDriver().findElement(By.xpath("//b[contains(.,'Cart is empty!')]")).isEnabled();
		Assert.assertTrue(producte);
	}
	
	@Given ("el usuari accedeix al producte {string}")
	public void elUsuariAccedeixAlProducte(String producte) {
		utilsSteps.getDriver().findElement(By.linkText(" Products")).click();
		
		WebElement elem = utilsSteps.getDriver().findElement(By.xpath(producte));
		((JavascriptExecutor) utilsSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", elem);
		utilsSteps.getDriver().findElement(By.xpath(producte)).click();
	}
	
	@Then ("es valida que apareix el missatge")
	public void esValidaQueApareixElMissatge() {
		boolean producte = utilsSteps.getDriver().findElement(By.xpath("//h4[contains(.,'Added!')]")).isEnabled();
		Assert.assertTrue(producte);
	}
	
	@Then ("es valida que apareix el producte {string} al cabas")
	public void esValidaQueApareixElProducteAlCabas(String nomProducte) {
		boolean producte = utilsSteps.getDriver().findElement(By.linkText(nomProducte)).isEnabled();
		Assert.assertTrue(producte);
	}
	
	@Then ("es valida que no apareix el producte")
	public void esValidaQueNoApareixElProducte() throws InterruptedException {
		Thread.sleep(1000);
		boolean producte = utilsSteps.getDriver().getPageSource().contains("Blue Top");
		Assert.assertTrue(!producte);
	}
	
	@After
	public void close() {
		utilsSteps.getDriver().quit();
	}
}
