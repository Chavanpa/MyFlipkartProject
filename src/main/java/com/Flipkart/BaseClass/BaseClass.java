package com.Flipkart.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;




public class BaseClass {
public static WebDriver driver;
	
	
	@BeforeClass
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver",getConfigData("chromepath"));
		driver=new ChromeDriver();
		driver.get(getConfigData("baseurl"));
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getreport() {
		//BaseClass.getHtmlReporter();
	//	BaseClass.getExtentReports();
	
	}
	public static String  getConfigData(String key) throws IOException {
		FileInputStream file = new FileInputStream("configuration\\config.properties");
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}
}
