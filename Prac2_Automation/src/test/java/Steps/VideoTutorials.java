package Steps;

import org.openqa.selenium.WebElement;
import io.cucumber.java.After;

public class VideoTutorials 
{
	private UtilsSteps utilsSteps;
	WebElement elem;
	
	public VideoTutorials(UtilsSteps utilsSteps) 
	{
		this.utilsSteps = utilsSteps;
	}
	
	@After
	public void close() {
		utilsSteps.getDriver().quit();
	}
}
