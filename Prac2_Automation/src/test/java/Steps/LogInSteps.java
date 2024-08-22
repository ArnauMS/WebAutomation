package Steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInSteps{
	private UtilsSteps utilsSteps;
	
	public LogInSteps(UtilsSteps utilsSteps) 
	{
		this.utilsSteps = utilsSteps;
	}
	
	@When("el usuari clica al boto de LogIn")
	public void el_usuari_fa_el_inici_de_sessio()
	{
		utilsSteps.getDriver().findElement(By.cssSelector(".login-form .btn")).click();
	}
	
	// Inici de sessio directe
	@Given("el usuari inicia sessio amb correu {string} i password {string}")
	public void el_usuari_ha_iniciat_sessio(String user, String pwd)
	{
		utilsSteps.getDriver().findElement(By.linkText("Signup / Login")).click();
		utilsSteps.getDriver().findElement(By.name("email")).sendKeys(user);
		utilsSteps.getDriver().findElement(By.name("password")).sendKeys(pwd);
		utilsSteps.getDriver().findElement(By.cssSelector(".login-form .btn")).click();
	}
	
	@Then("es valida que ha fet login correctament")
	public void es_valida_que_ha_fet_el_login_correctament() 
	{
		// test_auto es el nostre usuari
		boolean elem = utilsSteps.getDriver().findElement(By.linkText("Logout")).isDisplayed();
		Assert.assertTrue(elem);
	}
	
	@Then("es valida que apareix un error de login")
	public void es_valida_que_apareix_un_error_de_login() 
	{
		// Si apareix de nou el botó de Login -> haurà donat error
		boolean error = utilsSteps.getDriver().findElement(By.cssSelector(".login-form .btn")).isDisplayed();
		Assert.assertTrue(error);
	}
	
	@Then("es valida que ha tancat la sessio")
	public void es_valida_que_ha_tancat_la_sessio() 
	{
		boolean elem = utilsSteps.getDriver().findElement(By.linkText("Signup / Login")).isDisplayed();
		Assert.assertTrue(elem);
	}
	
	@After 
	public void close() {
		utilsSteps.getDriver().quit();
	}
	
	
}
