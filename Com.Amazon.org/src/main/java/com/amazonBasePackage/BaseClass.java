package com.amazonBasePackage;

import java.io.FileInputStream;







import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.Logger;
//import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.core.config.Configurator;
import org.ietf.jgss.Oid;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.amazonUtility.Log;

import com.beust.jcommander.Parameter;
import com.amazonActionDriver.Actoin;
import com.amazonUtility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {


	public static Properties prop;
	public static Logger LOGGER;

	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	//loadConfig method is to load the configuration
	@BeforeSuite //(groups = { "Smoke", "Sanity"})
	public void loadConfig() 
	{
		ExtentManager.setExtent();
		Configurator.initialize( "LOGGER","log4j2.xml");
		// LOGGER.info("This is befoe suite method");


		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() 
	{
		// Get Driver from threadLocalmap
		return driver.get();
	}


	
	public void launchApp(String browserName) 
	{
		//String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");

			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver(options));

		} 
		else if (browserName.equalsIgnoreCase("edge")) 
		{


			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable notifications");

			System.setProperty("webdriver.edge.driver", "C:\\Automation\\edgedriver_win64 (1)\\msedgedriver.exe");

			driver.set(new EdgeDriver(options));

		} 
		else if (browserName.equalsIgnoreCase("IE")) 
		{
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}


		//Maximize the screen
		getDriver().manage().window().maximize();

		//Delete all the cookies
		getDriver().manage().deleteAllCookies();

		//Implicit TimeOuts
		getDriver().manage().timeouts().implicitlyWait
		(Duration.ofSeconds(50));

		//PageLoad TimeOuts
		//getDriver().manage().timeouts().pageLoadTimeout
		//(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),Duration.ofSeconds(10));

		//Launching the URL
		getDriver().get(prop.getProperty("url"));
	}

	
	@AfterSuite(groups = { "Smoke","Sanity" })
	public void afterSuite() {
		ExtentManager.endReport();


	}

	public boolean switchToOldWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}
}