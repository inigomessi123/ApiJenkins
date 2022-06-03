package api;



import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import com.reports.CucumberReports;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features="src\\test\\resources\\vels.feature",
glue="stefdef",monochrome=true,dryRun=false,
plugin= {"pretty","html:C:\\Users\\inigo\\eclipse-workspace\\ApiTest\\target",
		"json:C:\\Users\\inigo\\eclipse-workspace\\ApiTest\\target\\vels.json",
		"junit:C:\\Users\\inigo\\eclipse-workspace\\ApiTest\\target\\vels.xml",},
snippets=SnippetType.CAMELCASE,strict=true

)

public class ApiVelsRunner {
	@Test
	public static void vels() {
		CucumberReports.JVMReport("C:\\Users\\inigo\\eclipse-workspace\\ApiTest\\target\\vels.json");

	}

	
}
