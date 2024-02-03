package zzMouseCursor;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mouser 
{
	WebDriver driver;
	ChromeOptions co = new ChromeOptions();
//	WAIT 6 seconds
	int sixSecS=6000; 
	int onemin=sixSecS*10;// may take 10-20 secs
	int thirtysecs=onemin/2;
	int four_mins=onemin *4;
	int sixmin=onemin*6;
	int msgdownwaiter=thirtysecs;
	
	@Before
	public void setup() throws InterruptedException, AWTException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\POOJASRA\\OneDrive - Capgemini\\Documents\\ChromeDriver\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();  if error rises		
	    co.addArguments("--remote-allow-origins=*");
	    driver = new ChromeDriver(co);	
	}
					
	@Test
	public void test() throws InterruptedException, AWTException  //2hr code
	{			
			teamscode(); // 20 secs
			System.out.println("*********Got into Teams**************");
						
			msglooping(); // 1hr 40mins if msgdownwaiter=30secs
			System.out.println("***done msgdown looping***");
	}
	
	public void msglooping() throws InterruptedException, AWTException
	{
		for(int i=0; i<=20; i++) //20 iterations 5 mins, 20*5=100mins, 1hr 40mins
		{
			System.out.println("for loop=20");				
			Thread.sleep(onemin);
			for(int o=0;o<10;o++) // goes down 10 msgs== 5mins
			{
				Robot rb2= new Robot();
				rb2.keyPress(KeyEvent.VK_DOWN);
				System.out.println("***key***down***"+o+"\n Forloop (10)=5mins");
				Thread.sleep(msgdownwaiter);	
			}	
		}
	}
	
	public void teamscode() throws InterruptedException, AWTException  //20secs
	{
		
			
//			opens teams link 
		
		// send any chrome link to ur friend on teams
		// copy that msg link and paste in below string
		// after that msg, chat should also contain 20 test messages 
		String teams_chat_link="https://teams.microsoft.com/l/message/19:83a73176-3585-422a-acc8-f78a5a5b2a86_c1b8e2c2-4d95-4441-b46b-4e697e07da16@unq.gbl.spaces/1700815904557?context=%7B%22contextType%22%3A%22chat%22%7D";
		driver.get(teams_chat_link);
		Thread.sleep(2000);
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_LEFT);
		rb.keyRelease(KeyEvent.VK_LEFT);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		// teams open aythadhi
		
		driver.manage().window().maximize();Thread.sleep(sixSecS);
		driver.manage().window().minimize();
		Thread.sleep(sixSecS);
		driver.close();
	}
	
		public void trail()
 {
			/*
			 * for(int j=0; j<6;j++)
			{
				String somlink="https://www.geeksforgeeks.org/robot-class-java-awt/";

//				try 
				{	driver.get(somlink);
				Thread.sleep(sixSecS);
				driver = new ChromeDriver(co);
				driver.close();}
//				finally 
//				{driver.quit();}
				Thread.sleep(onemin);
			}
			 */
			
			/*
			for(int i=0; i<=10; i++) 
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\POOJASRA\\OneDrive - Capgemini\\Documents\\ChromeDriver\\chromedriver.exe");
//				WebDriver driver=new ChromeDriver();  if error rises		
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(co);		
//				System.out.println("normal webdriver didn't work\n so used chromeOptions");
				
	/
				
				
				
//				location block code
				 Robot robot = new Robot();
				 robot.delay(5000);
				 robot.keyPress(KeyEvent.VK_TAB); 
				 robot.keyPress(KeyEvent.VK_ENTER);
				 robot.keyRelease(KeyEvent.VK_TAB); 
				 robot.keyPress(KeyEvent.VK_ENTER);
				 Thread.sleep(sixmin);
				 
				 System.out.println("-----------------------------------------location blocked------------------");
				 
//				mouse hovering code:
				 Actions act=new Actions(driver);
				 
				 WebElement msr=driver.findElement(By.xpath("//div[normalize-space()='SpiceScreen']"));			 
				 act.moveToElement(msr).build().perform();
				 System.out.println("------------------------------------------performed1-----");
				 Thread.sleep(onemin);
				 
//				
				 WebElement msr2=driver.findElement(By.xpath("//div[normalize-space()='Cargo']"));			 
				 act.moveToElement(msr2).build().perform();
				 System.out.println("-----performed2-----");
				 Thread.sleep(onemin);
				
				driver.close();
//				after
				
				*/
//				Thread.sleep(onemin);
	/*	
		Alert alrtbx=driver.switchTo().alert();
		System.out.println("----------"+alrtbx.getText());
		driver.switchTo().activeElement();
		Actions actn=new Actions(driver);
		actn.keyDown(Keys.ARROW_LEFT).build().perform();
		actn.keyDown(Keys.ENTER).build().perform();
		
		// open teams alert
		 WebElement openTeamsButton = driver.findElement(By.xpath("//button[contains(text(),'Open Microsoft Teams')]"));

	        // Click the button
	        openTeamsButton.click();
		
		
		
		
//		actn.sendKeys(targetElement, Keys.ARROW_LEFT)  // Press the left arrow key
//         .sendKeys(targetElement, Keys.ENTER)       // Press the Enter key
//         .build()
//         .perform();
		
//		String launchitnow="Launch it now";
//		driver.findElement(By.linkText(launchitnow)).click();
//		String launch="//*[@id=\"tryProtocolLaunchTeamsClient\"]";
//		driver.findElement(By.xpath(launch)).click();
		System.out.println("clicked");
//		driver.switchTo().activeElement();
//		Alert alrtbx=driver.switchTo().alert();
//		alrtbx.accept();
 * */
			//public class Mouser 
			//{
//				public static void main(String[] args) throws InterruptedException 
//				{
//					for(int i=0; i<=10; i++) 
//					{
//						Mc m=new Mc();
//						m.setup();
//					}
//				}
			//	
			//}

		}
	
	@After
	public void teardown() 
	{
		
	}

}

