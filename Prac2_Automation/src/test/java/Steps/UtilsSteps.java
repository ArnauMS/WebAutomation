package Steps;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class UtilsSteps {
	private WebDriver driver;
	
	@Given("el usuari accedeix al navegador {string}")
	public void el_usuari_accedeix_a_la_pagina_web(String nav) throws InterruptedException 
	{
		if (nav.equals("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
			driver = new FirefoxDriver(options);
		} else if (nav.equals("Chrome"))
		{
			System.setProperty("webdriver.chromedriver", "Drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless");
			options.addArguments("start-maximized");
			
			// Gestió dels anuncis
			options.addExtensions(new File("Drivers/extension_5_3_2_0.crx"));
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			
			driver = new ChromeDriver(options);
			Thread.sleep(1500);
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
		}
	}
	
	@Given("el usuari accedeix a la pagina web")
	public void el_usuari_accedeix_a_la_pagina_web() 
	{
		driver.navigate().to("https://automationexercise.com/");
	}
	
	// Submenús
	@Given("el usuari accedeix al submenu {string}")
	public void el_usuari_accedeix_al_submenu(String subm) 
	{
		driver.findElement(By.linkText(subm)).click();	
	}
	
	@Given("el usuari clica a la opcio amb text {string}")
	public void el_usuari_accedeix_a_la_opcio_amb_text(String opt) throws InterruptedException 
	{
		WebElement elem = driver.findElement(By.linkText(opt));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
		
		driver.findElement(By.linkText(opt)).click();
	}
	
	@Given("el usuari clica a la opcio amb id {string}")
	public void el_usuari_accedeix_a_la_opcio_amb_id(String opt) throws InterruptedException 
	{
		WebElement elem = driver.findElement(By.id(opt));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
		driver.findElement(By.id(opt)).click();
	}
	
	@Given("el usuari clica a la opcio amb path {string}")
	public void el_usuari_accedeix_a_la_opcio_amb_path(String opt) throws InterruptedException 
	{
		WebElement elem = driver.findElement(By.xpath(opt));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
		driver.findElement(By.xpath(opt)).click();
	}
	
	@Given("el usuari clica a la opcio amb nom {string}")
	public void el_usuari_accedeix_a_la_opcio_amb_nom(String opt) 
	{
		WebElement elem = driver.findElement(By.name(opt));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
		driver.findElement(By.name(opt)).click();		
	}
	
	@Given("el usuari clica a la opcio amb CSS {string}")
	public void el_usuari_accedeix_a_la_opcio_amb_css(String opt) 
	{
		WebElement elem = driver.findElement(By.cssSelector(opt));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
		driver.findElement(By.cssSelector(opt)).click();		
	}
	
	
	@Given("el usuari selecciona el checkbox {string}")
	public void el_usuari_selecciona_el_checkbox(String name) 
	{
		driver.findElement(By.name(name)).click();		
	}
	
	@Given("el usuari introdueix el valor {string} al camp {string}")
	public void el_usuari_introdueix_el_valor_al_camp(String value,  String camp) 
	{
		driver.findElement(By.name(camp)).clear();
		driver.findElement(By.name(camp)).sendKeys(value);		
	}
	 
	@Given("el usuari introdueix el valor {string} al camp ID {string}")
	public void el_usuari_introdueix_el_valor_al_camp_id(String value,  String camp) 
	{
		driver.findElement(By.id(camp)).clear();
		driver.findElement(By.id(camp)).sendKeys(value);		
	}
	
	@Given("el usuari introdueix el valor {string} al camp CSS {string}")
	public void el_usuari_introdueix_el_valor_al_camp_css(String value,  String camp) 
	{
		driver.findElement(By.cssSelector(camp)).clear();
		driver.findElement(By.cssSelector(camp)).sendKeys(value);		
	}

	@Given("el usuari posiciona el ratoli sobre el camp CSS {string}")
	public void el_usuari_posiciona_el_ratoli_sobre_el_camp_css(String camp) throws InterruptedException 
	{
		WebElement elem = driver.findElement(By.cssSelector(camp));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
	}
	
	
	@Given("el usuari accedeix al menu {string}")
	public void el_usuari_accedeix_al_menu(String menu) throws InterruptedException 
	{
		driver.findElement(By.linkText(menu)).click();
		Thread.sleep(1500);
	}
	
	@Given("el usuari espera {int} segons")
	public void el_usuari_espera_x_segons(int segons) throws InterruptedException 
	{
		Thread.sleep(segons*1000);
	}
	
	@Then("es valida que el usuari ha accedit al menú {string} correctament")
	public void es_valida_que_el_usuari_ha_al_menu_correctament(String menu) 
	{
		boolean valid = false;
		if (menu.equals("API Testing"))
		{
			// Es pot validar també amb el text en vermell (Below is the ...)
			valid = driver.getCurrentUrl().contains("api_list");
			Assert.assertTrue(valid);
		} else if(menu.equals("Test Cases"))
		{
			String toComp = driver.findElement(By.cssSelector("b")).getText();
			String exp = "TEST CASES";
			Assert.assertEquals(toComp, exp);
		} else if (menu.equals("Video Tutorials"))
		{
			// Validem la URL (no es pot accedir al canal pel filtre antibots)
			String toComp = "AutomationExercise";
			boolean urlOK = driver.getCurrentUrl().contains(toComp);
			Assert.assertTrue(urlOK);
		}
	}
	
	@When("el cabas conte productes")
	public void el_cabas_conte_productes() throws InterruptedException 
	{ 
		// Accedir al menu productes
		driver.findElement(By.linkText(" Products")).click();
		
		// Posicionem el ratolí
		WebElement elem = driver.findElement(By.cssSelector(".col-sm-4:nth-child(3) .single-products"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
		
		Actions a = new Actions(driver);
		a.moveToElement(elem).perform();
		Thread.sleep(1000);
		
		// Afegim el producte
		driver.findElement(By.cssSelector(".col-sm-4:nth-child(3) .product-overlay .btn")).click();
		Thread.sleep(1*1000);
		
		
		// Accedim al cabàs 
		driver.findElement(By.xpath("//u[contains(.,'View Cart')]")).click();
	}
	
	public WebDriver getDriver() 
	{
		return driver;
	}
	
	@After 
	public void close() {
		getDriver().quit();
	}
}
