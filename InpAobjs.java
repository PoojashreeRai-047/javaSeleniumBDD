package pageObjs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InpAobjs 
{
	WebDriver driver;
	public InpAobjs(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Post Matric')]")
	WebElement PostMat;
	public WebElement getPostMat()
	{
		return PostMat;		
	}
	
	@FindBy(xpath="/html/body/div[4]/div/div/table/tbody/tr[8]/td[2]/a")
	WebElement StuSrvc;
	public WebElement getStusrvc()
	{
		return StuSrvc;		
	}

	
	@FindBy(xpath="/html/body/div[4]/div/div/form/fieldset/div[2]/div/div[1]/div[2]/input")
	WebElement Appno;
	public WebElement getApno()
	{
		return Appno;		
	}
	
	@FindBy(xpath="/html/body/div[4]/div/div/form/fieldset/div[2]/div/div[1]/div[4]/select")
	WebElement StYr;
	public Select getYrr(String Yrr)
	{
		Select Acyr=new Select(StYr);
		Acyr.selectByVisibleText(Yrr);
		return Acyr;
	}
	
	@FindBy(xpath="/html/body/div[4]/div/div/form/fieldset/div[2]/div/div[3]/div[4]/input")
	WebElement DOOB;
	public WebElement getDOB()
	{
		return DOOB;		
	}
		
	@FindBy(xpath="/html/body/div[4]/div/div/form/fieldset/div[2]/div/div[3]/div[2]/select") 
	WebElement SSctype;
	public Select getSSCtype(String ssCtype)
	{		
		Select ssctype = new Select(SSctype);
		ssctype.selectByVisibleText(ssCtype);		
		return ssctype;		
	}
			
	@FindBy(xpath="/html/body/div[4]/div/div/form/fieldset/div[2]/div/div[2]/div[2]/input")
	WebElement SSCHLno;
	public WebElement getSSCno()
	{
		return SSCHLno ;		
	}
	
	@FindBy(xpath="/html/body/div[4]/div/div/form/fieldset/div[2]/div/div[2]/div[4]/input")
	WebElement SSCYr;
	public WebElement getSSCyr()
	{
		return SSCYr;
	}
	
	//8888888888888888888888888888888888888
	
	@FindBy(xpath="//button[normalize-space()='Get Status']"
			//"//button[@type='button']"
		//	"/html/body/div[4]/div/div/form/fieldset/div[2]/div/div[4]/div/center/button"
			)
	WebElement Submitbuton;
	public WebElement getSubmitbtn()
	{
		return Submitbuton;
	}
	
	
	
	
	
	
	
	
	
	
	
}
