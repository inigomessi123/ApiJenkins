package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class CucumberReports {
	public static void JVMReport(String json) {
		File file=new File ("C:\\Users\\inigo\\eclipse-workspace\\ApiTest\\target");
		Configuration configuration=new Configuration(file,"velsbusinessclub");
		
		configuration.addClassifications("Browser Name", "Chrome");
		configuration.addClassifications("Sprint No", "07");
		configuration.addClassifications("Platform", "Win-10");
		configuration.addClassifications("Environment", "VAT");

		List<String> li =new ArrayList<String>();
		li.add(json);
		ReportBuilder builder=new ReportBuilder(li,configuration);
		builder.generateReports();
	}

}
