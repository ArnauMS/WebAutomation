package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProducteSteps {
	private UtilsSteps utilsSteps;
	
	public ProducteSteps(UtilsSteps utilsSteps) 
	{
		this.utilsSteps = utilsSteps;
	}
	
	@When ("el usuari clica {int} cops a la opcio amb id {string}")
	public void elUsuariClicaCopsALaOpcioAmbId(int quantitat, String opt) {
		for(int i = 0; i < quantitat; i++) {
			utilsSteps.getDriver().findElement(By.name(opt)).sendKeys(Keys.ARROW_UP);
		}
	}
	
	@When ("el usuari accedeix a la marca {string}")
	public void elUsuariAccedeixALaMarca(String marca) {
		WebElement elem = utilsSteps.getDriver().findElement(By.xpath("//a[contains(@href, '/brand_products/%s')]".formatted(marca)));
		((JavascriptExecutor) utilsSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", elem);
		
		utilsSteps.getDriver().findElement(By.xpath("//a[contains(@href, '/brand_products/%s')]".formatted(marca))).click();
		
	}
	
	@Then ("es valida que apareixen productes de la categoria {string}")
	public void esValidaQueApareixenProductesDeLaCategoria(String titol) {
		boolean producte = utilsSteps.getDriver().findElement(By.cssSelector(".title")).getText().equals(titol);
		Assert.assertTrue(producte);
	}
	
	@Then ("el usuari accedeix a un producte")
	public void elUsuariAccedeixAUnProducte() {
		WebElement elem = utilsSteps.getDriver().findElement(By.xpath("//a[contains(@href, '/brand_products/Polo')]"));
		((JavascriptExecutor) utilsSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", elem);
		utilsSteps.getDriver().findElement(By.xpath("//a[contains(@href, '/brand_products/Polo')]")).click();
		
		WebElement elem2 = utilsSteps.getDriver().findElement(By.linkText("View Product"));
		((JavascriptExecutor) utilsSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", elem2);
		utilsSteps.getDriver().findElement(By.linkText("View Product")).click();
	}
	
	@Then ("es valida que la quantitat sigui {int}")
	public void esValidaQueLaQuantitatSigui(int quantitat) {
		boolean producte = utilsSteps.getDriver().findElement(By.id("quantity")).getAttribute("value").equals(Integer.toString(quantitat));
		Assert.assertTrue(producte);
	}
	
	@Then ("es valida que el comentari està enviat correctament")
	public void esValidaQueElComentariEstàEnviatCorrectament() {
		boolean producte = utilsSteps.getDriver().findElement(By.xpath("//span[contains(.,'Thank you for your review.')]")).isEnabled();
		Assert.assertTrue(producte);
	}
	
	@After
	public void close() {
		utilsSteps.getDriver().quit();
	}
	
	
}
