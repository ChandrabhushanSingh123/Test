package CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.xml.dom.Tag;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;;

@RunWith(Cucumber.class)		
@CucumberOptions(features="C:\\love\\Test\\CucumberFramework\\src\\test\\java\\Features",
glue="StepDefinition", tags= {"@smoke1","@smoke"}, monochrome=true
)

public class TestRunner {

}
