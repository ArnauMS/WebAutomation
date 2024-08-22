package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps 
{
	private UtilsSteps utilsSteps;
	WebElement elem;
	
	public HomePageSteps(UtilsSteps utilsSteps) 
	{
		this.utilsSteps = utilsSteps;
	}

	@When("el usuari mou el carrusel {string} cap a la {string}")
	public void el_usuari_mou_el_carrusel_cap_a_la_direccio(String carr, String dir) throws InterruptedException 
	{ 
		if (carr.equals("Inicial"))
		{
			if (dir.equals("Dreta"))
				// Fletxa dreta
				utilsSteps.getDriver().findElement(By.cssSelector(".control-carousel > .fa-angle-right")).click();
			else if (dir.equals("Esquerra"))
				// Fletxa esquerra
				utilsSteps.getDriver().findElement(By.cssSelector(".control-carousel > .fa-angle-left")).click();
		} 
		else if (carr.equals("Items recomenats"))
		{
			if (dir.equals("Dreta"))
				// Fletxa dreta
				utilsSteps.getDriver().findElement(By.cssSelector(".recommended-item-control > .fa-angle-right")).click();
			else if (dir.equals("Esquerra"))
				// Fletxa esquerra
				utilsSteps.getDriver().findElement(By.cssSelector(".recommended-item-control > .fa-angle-left")).click();
		}
	}
	 
	@Then("es valida que el producte ha estat afegit correctament")
	public void es_valida_que_el_producte_ha_estat_afegit_correctament()
	{
		// Text que mostra -> Added
		// Si l'element està actiu -> hem afegit el producte
		boolean isAdded = utilsSteps.getDriver().findElement(By.cssSelector(".modal-title")).isDisplayed();
		Assert.assertTrue(isAdded);
	}
	
	@After
	public void close() {
		utilsSteps.getDriver().quit();
	}
	
	
}
