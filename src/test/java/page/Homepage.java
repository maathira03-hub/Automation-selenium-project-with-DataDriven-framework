package page;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Homepage {
	WebDriver driver;
	@FindBy(xpath="/html/body/div[2]/div/div[1]/div/div/header/div[3]/div[1]/a/picture/img") WebElement logo;
	@FindBy(id="onetrust-accept-btn-handler")WebElement acceptCookies;
	
	
	
	
	@FindBy(xpath="//*[@id=\"splash-popup\"]/div/div/div/button/span") WebElement noti;
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div[2]/a[1]/figure/div/picture/img") WebElement paintingservice;
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div[2]/a[2]/figure/div/picture/img")  WebElement paintingcost;
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div[2]/a[3]/figure/figcaption") WebElement waterproof;
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div[2]/a[4]/figure/div/picture/img") WebElement interiordecore;
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div[2]/a[5]/figure") WebElement personalshade;
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div[2]/a[6]/figure/div/picture/img") WebElement findcontracter;
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div/div[2]/div/a") WebElement  Explorcolour;
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div/div[3]/div/div[1]/div/a") WebElement viewcatalog;
	
	@FindBy(name="ENQUIRE_NAME") WebElement namehome;
	@FindBy(name="ENQUIRE_EMAIL") WebElement emailhome;
	@FindBy(name="ENQUIRE_MOBILE") WebElement phonehome;
	@FindBy(name="ENQUIRE_PINCODE") WebElement pinhome;
	
	
	@FindBy(xpath="//label[.//text()='Construction']//span[2]")WebElement constrhome;
	@FindBy(xpath="//label[.//text()='Local Painter']//span[2]")WebElement localpainter;
	@FindBy(xpath="//button[contains(text(),'Book Free Visit')]")WebElement freebookvisit;
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void logocheck()
	{
	noti.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement logoElement = wait.until( ExpectedConditions.visibilityOf(logo) ); 
		if(logoElement.isDisplayed()) 
		{ System.out.println("logo is present"); 
		}
		else
		{ System.out.println("logo is not present"); }
	}
	
@SuppressWarnings("deprecation")
public void linkcheck() throws IOException 
{
	List<WebElement> links = driver.findElements(By.tagName("a")); 
	int brokenCount = 0;
	for(WebElement link : links)
	{
		try
		{ String url = link.getAttribute("href");
		if
		(url == null || url.isEmpty() || !url.startsWith("http")) 
		{ 
			continue;
			}
		URL linkURL = new URL(url);
		HttpURLConnection con = (HttpURLConnection) linkURL.openConnection();
		con.connect();
		if(con.getResponseCode() >= 400) 
		{
			brokenCount++;
			}
		}
		catch (Exception e)
		{
		}
		}
	if(brokenCount > 0)
	{
		System.out.println("BROKEN LINK IS PRESENT IN THIS SITE ");
		}
	else
	{ System.out.println("NO BROKEN LINKS IN THIS SITE ");
	} 

}
public void handleCookies()
{
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(acceptCookies));
        cookieBtn.click();
    } catch (Exception e) {
        System.out.println("Cookie popup not displayed");
    }
}
public void verificationtransform()
{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    // Painting Service
    WebElement ps = wait.until(ExpectedConditions.visibilityOf(paintingservice));
    Assert.assertTrue(ps.isDisplayed(), "Painting Service NOT visible");

    // Painting Cost
    WebElement pc = wait.until(ExpectedConditions.visibilityOf(paintingcost));
    Assert.assertTrue(pc.isDisplayed(), "Painting Cost NOT visible");

    // Waterproofing
    WebElement wp = wait.until(ExpectedConditions.visibilityOf(waterproof));
    Assert.assertTrue(wp.isDisplayed(), "Waterproofing NOT visible");

    // Interior Decor
    WebElement id = wait.until(ExpectedConditions.visibilityOf(interiordecore));
    Assert.assertTrue(id.isDisplayed(), "Interior Decor NOT visible");

    // Personalised Shade
    WebElement psd = wait.until(ExpectedConditions.visibilityOf(personalshade));
    Assert.assertTrue(psd.isDisplayed(), "Personalised Shade NOT visible");

    // Find Contractor
    WebElement fc = wait.until(ExpectedConditions.visibilityOf(findcontracter));
    Assert.assertTrue(fc.isDisplayed(), "Find Contractor NOT visible");
}
public void scrollup()
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, 0);");	
}
public void click()
{
	paintingservice.click();
	 @Nullable
	String titilepaint = driver.getTitle();
	if(titilepaint.contains("Beautiful Homes Painting Service for Your Home Walls | Asian Paints"))
	{
		System.out.println("Painting service is clickable");
	}
	else
	{System.out.println("Painting service is not clickable");
	}
	 
	driver.navigate().back();
	 paintingcost.click();
	 @Nullable
	String titilepaintcost = driver.getTitle(); 
	if(titilepaintcost.contains("Paint Budget"))
	{
		System.out.println("Painting cost is clickable");
	}
	else
	{
		System.out.println("Painting cost is not clickable");
	}
		driver.navigate().back();
		waterproof.click();
		
		
	
		if(driver.getTitle().contains("Waterproofing Cost"))
		{
			System.out.println("Waterproof cost is clickable");
		}else
		{
			System.out.println("Waterproof cost is not clickable");
		}
			driver.navigate().back();
			
			interiordecore.click();
			if(driver.getTitle().contains("Home Interior Design Solutions"))
			{
				System.out.println("Interior decore solution is clickable");
			}
			else
			{
				System.out.println("Interior decore solution is not clickable");
			}
			driver.navigate().back();
			personalshade.click();
			if(driver.getTitle().contains("Find Your Perfect Colour Palette"))
			{
				System.out.println("Get personalised shade is clickable");
			}
			else
			{
				System.out.println("Get personalised shade is not clickable");
			}
			driver.navigate().back();
			findcontracter.click();
			if(driver.getTitle().contains("Hire Expert Painting Contracter"))
			{
				System.out.println("Find a contractor is clickable");
			}
			else
			{
				System.out.println("Find a contractor is not clickable");
			}
			driver.navigate().back();
			
	}
public void scroll() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,500)");
}
public void viewcolorsec()
{
	viewcatalog.click();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");

	WebDriver driver = new ChromeDriver(options);
	 if (driver.getCurrentUrl().contains("catalogue")) {
	        System.out.println("Colour catalogue is clickable and navigated correctly");
	    } else {
	        System.out.println("Navigation failed");
	    }
	 ChromeOptions options1 = new ChromeOptions();
		options1.addArguments("--disable-notifications");

}

	   
public void Setdatahome(String username, String email, String phone, String pin) throws Exception
{
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");

	
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    JavascriptExecutor js = (JavascriptExecutor) driver;

    wait.until(ExpectedConditions.visibilityOf(namehome));
    namehome.clear();
    namehome.sendKeys(username);

    wait.until(ExpectedConditions.visibilityOf(emailhome));
    emailhome.clear();
    emailhome.sendKeys(email);

    wait.until(ExpectedConditions.visibilityOf(phonehome));
    phonehome.clear();
    phonehome.sendKeys(phone);

    js.executeScript("arguments[0].scrollIntoView(true);", pinhome);

    wait.until(ExpectedConditions.visibilityOf(pinhome));
    pinhome.clear();
    pinhome.sendKeys(pin);
}
public void submit() {
	
    if (!constrhome.isSelected() && !localpainter.isSelected()) {
        constrhome.click();
    }
    freebookvisit.click();
}

}





