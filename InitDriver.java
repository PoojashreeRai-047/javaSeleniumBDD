package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class InitDriver 
{
	public WebDriver driver;
	
	String DatpropReader(String data) throws IOException 
	{
		Properties prop= new Properties();
		
		FileInputStream filee= new FileInputStream("C:\\Users\\POOJASRA\\AutomationWs2\\eclipse-workspace\\eclipse-workspace\\EpsMvnCuc\\src\\main\\java\\utilities\\data.properties");
		prop.load(filee);
		return prop.getProperty(data);
		
	}
	
	public String getURl() throws IOException 
	{
		
		return this.DatpropReader("url") ;		
	}
	
	public void getBrowserSetup() throws IOException 
	{
		String Browsername= this.DatpropReader("browser");
		
		if(Browsername!="edge")
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\POOJASRA\\OneDrive - Capgemini\\Documents\\ChromeDriver\\chromedriver.exe");
//			driver=new ChromeDriver(); // it may rise error
			
			ChromeOptions co= new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(co);
		}
		else
		{
//			EdgeCode
			System.setProperty("webdriver.edge.driver", "C:\\Users\\POOJASRA\\OneDrive - Capgemini\\Documents\\edgedriver\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
	}
	
}
