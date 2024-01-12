package stepDefintions;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjs.InpAobjs;
import utilities.InitDriver;
import utilities.ReadExcel;

public class StepDefinition extends InitDriver
{
//	 Excel data input pending***
	
	
	InpAobjs Eps;
	ReadExcel rd;
	
	JavascriptExecutor js;
	String Epasspage, Statuspage;
	
	@Before
	public void setup() throws IOException
	{
		this.getBrowserSetup();
		
		Eps=new InpAobjs(driver);
		
//		this.rd.Excelreader();
		System.out.println("***********BrowserSetup***********");
	}
	
//	Only Scenario code with only one data values
	
	@Given("Candidate is on the Epass website")
	public void candidate_is_on_the_Epass_website() throws IOException, InterruptedException 
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10) );
		Thread.sleep(5000);
		driver.get(getURl());
		Thread.sleep(5000);
		System.out.println("***********1***********");
	}

	@When("Goes to Status Page")
	public void goes_to_Status_Page() 
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");

		Eps.getPostMat().click();
		
		js.executeScript("window.scrollBy(0,400)");
		
		Eps.getStusrvc().click();
		
//		As 2 windows are open we need to use Window Handling Concepts 
		Set<String> WindS = driver.getWindowHandles();
		Iterator<String> itr= WindS.iterator();
		
//		now the cntrl is at status page, as v have only 2 winds
//		when itr.next ==> gives cntrl to epasspage, 
//		again itr.next  ==> gives cntrl to statuspage,
		Epasspage=itr.next();
		Statuspage= itr.next();
		
		driver.switchTo().window(Statuspage);
		
		System.out.println("***********2***********");
	}

	
//	@When("User current details are entered")
//	public void user_current_details_are_entered()
	
	@When("User current details like {string} {string} are entered")
	public void user_current_details_like_are_entered(String curApNo, String stsYr)
	{
//		System.out.println("Apno: "+curApNo +" styr:"+ stsYr );
		Eps.getApno().sendKeys(curApNo);
		Eps.getYrr(stsYr);
		
		System.out.println("***********3 cur details***********");
	}
	
	
//	@When("User DOB is entered")
//	public void user_DOB_is_entered()
	
	@When("User DOB {string} is entered")
	public void user_DOB_is_entered(String DOB) throws InterruptedException
	{
//		System.out.println("DOB= "+DOB);
		
		Eps.getDOB().sendKeys(DOB);
		
		System.out.println("***********4 dob***********"); 
//		Thread.sleep(5000);
	}

//	@When("SSC details like are entered")
//	public void ssc_details_like_are_entered()
	
	@When("User enters SSC details like {string} {string} {string}")
	public void user_enters_SSC_details_like(String sscTp, String sscYr, String sschno)
	{
//		System.out.println("ssctype:"+sscTp +" Hno"+ sschno +" year"+ sscYr );
		Eps.getSSCtype(sscTp);
		
		Eps.getSSCno().sendKeys(sschno);
		
		Eps.getSSCyr().sendKeys(sscYr);
		 
		System.out.println("***********5 ssc details***********"); 
	}

	@Then("All details are Submitted")
	public void all_details_are_Submitted() 
	{
		Eps.getSubmitbtn().click();
		
		System.out.println("***********6***********");
	}

	@Then("Status page is visible and scrolled")
	public void status_page_is_visible_and_scrolled() throws InterruptedException 
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		
	    System.out.println("***********7***********");
	    
	    Thread.sleep(15000); // to view the status of an individual
	}
	
	@After
	public void teardown() throws InterruptedException 
	{
		
		driver.close();
		driver.switchTo().window(Epasspage);
		driver.close();	
		
		System.out.println("***********Teardown***********");
	}
	

//	88888***************88888888888888**********************************
//	88888***************88888888888888**********************************
//	88888***************88888888888888**********************************
/*	WebDriver driver;
	String parentWindow, childWindow;
	JavascriptExecutor js;
	@Before
	public void setup() throws InterruptedException 
	{
		System.out.println("%%%%%%%%%%%   setup   %%%%%%%%%%%%%");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\POOJASRA\\OneDrive - Capgemini\\Documents\\ChromeDriver\\chromedriver.exe");
		
//		WebDriver driver=new ChromeDriver();  if error rises
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//		Thread.sleep(3000);
//		driver.get("https://telanganaepass.cgg.gov.in/");
//		Thread.sleep(3000);
		System.out.println("8888888888888888888888888888888888");
//		888888888888888888888888888888888888
	}
	
	@Given("user is on website")
	public void user_is_on_website() throws InterruptedException 
	{   
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		Thread.sleep(3000);
		driver.get("https://telanganaepass.cgg.gov.in/");
//		Thread.sleep(3000);
		
		System.out.println("%%%%%%%%%%%   1   %%%%%%%%%%%%%");
	}

	@Given("user is on status_checking webpage")
	public void user_is_on_status_checking_webpage() throws InterruptedException 
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		
		driver.findElement(By.xpath("//a[contains(text(),'Post Matric')]")).click();
		js.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.xpath("/html/body/div[4]/div/div/table/tbody/tr[8]/td[2]/a")).click();
		
		//window handling
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		parentWindow= it.next();
		childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		driver.switchTo().window(parentWindow);
		driver.switchTo().window(childWindow);
		Thread.sleep(4000);
		
	    System.out.println("%%%%%%%%%%%   2   %%%%%%%%%%%%%");
	}

	@When("user enters data")
	public void user_enters_data() 
	{
		WebElement selectdropdown = driver.findElement(By.xpath("/html/body/div[4]/div/div/form/fieldset/div[2]/div/div[3]/div[2]/select"));
		Select ssctype = new Select(selectdropdown);
		ssctype.selectByVisibleText("SSC Regular");
		
		driver.findElement(By.xpath("/html/body/div[4]/div/div/form/fieldset/div[2]/div/div[2]/div[2]/input")).sendKeys("1502115220");
		driver.findElement(By.xpath("/html/body/div[4]/div/div/form/fieldset/div[2]/div/div[1]/div[2]/input")).sendKeys("202008437870");
		driver.findElement(By.xpath("/html/body/div[4]/div/div/form/fieldset/div[2]/div/div[2]/div[4]/input")).sendKeys("2015");
		driver.findElement(By.xpath("/html/body/div[4]/div/div/form/fieldset/div[2]/div/div[3]/div[4]/input")).sendKeys("04031999");
		
		WebElement selectAcyr= driver.findElement(By.xpath("/html/body/div[4]/div/div/form/fieldset/div[2]/div/div[1]/div[4]/select"));
		Select Acyr=new Select(selectAcyr);
		Acyr.selectByVisibleText("2020-21");
		
	    System.out.println("%%%%%%%%%%%   3   %%%%%%%%%%%%%");
	}

	@Then("status is visible")
	public void status_is_visible() 
	{
		driver.findElement(By.xpath("/html/body/div[4]/div/div/form/fieldset/div[2]/div/div[4]/div/center/button")).click();
//		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,400)");
		
	    System.out.println("%%%%%%%%%%%   4   %%%%%%%%%%%%%");
	}

	@After
	public void teardown() throws InterruptedException 
	{
		Thread.sleep(15000);
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.close();
		System.out.println("%%%%%%%%%%%   teardown   %%%%%%%%%%%%%");
	}
	*/
}
