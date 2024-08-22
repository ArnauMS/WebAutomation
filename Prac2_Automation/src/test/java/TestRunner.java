import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/features/", 
		glue="Steps",
		tags= "@Registre")

public class TestRunner extends AbstractTestNGCucumberTests{
	

}
