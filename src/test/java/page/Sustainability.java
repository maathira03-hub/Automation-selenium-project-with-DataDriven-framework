package page;

import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sustainability {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"box-5\"]/a") WebElement Sustainability;
	@FindBy(xpath="/html/body/header/div/div/nav/ul/li[2]/a") WebElement Enviorment;
	@FindBy(xpath="/html/body/header/div/div/nav/ul/li[3]/a")WebElement productstefardship;
	@FindBy(xpath="/html/body/header/div/div/nav/ul/li[4]/a")WebElement community;
	@FindBy(xpath="/html/body/header/div/div/nav/ul/li[5]/a")WebElement healthsafty;
	
	@FindBy(xpath="/html/body/header/div/div/nav/ul/li[2]/ul/li[3]/a")WebElement climatechange;
	@FindBy(xpath="/html/body/header/div/div/nav/ul/li[3]/ul/li[5]/a/span[2]")WebElement elimination;
	@FindBy(xpath="/html/body/header/div/div/nav/ul/li[4]/ul/li[5]/a")WebElement Skilldevelopment;
	@FindBy(xpath="/html/body/header/div/div/nav/ul/li[5]/ul/li[6]/a/span[2]") WebElement proccessafty;
	
	public Sustainability(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void window()
	{
		String Home = driver.getWindowHandle();
		Sustainability.click();
		Set<String> secondwindow = driver.getWindowHandles();
		for(String a :secondwindow)
		{
			if(!a.equalsIgnoreCase(Home))
			{
				driver.switchTo().window(a);
				if(Enviorment.isDisplayed())
				{
					System.out.println("Enviorment section is displayed");
					}
				if(productstefardship.isDisplayed())
				{
					System.out.println("Product stefardship section is displayed ");
					
				}
				if(community.isDisplayed())
				{
					System.out.println("Community section is displayed ");
				}
				if(healthsafty.isDisplayed())
				{
					System.out.println("Health and safty section is displayed");
				}
				Actions Act=new Actions(driver);
				Act.moveToElement(Enviorment).perform();

				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait1.until(ExpectedConditions.elementToBeClickable(climatechange)).click();
				
			@Nullable
			String titileclimate = driver.getTitle();
			if(titileclimate.contains("Climate Change"))
			{
				System.out.println("contents in Enviorment are clickable");
			}
			else
			{
				System.out.println("contents in Enviorment are not clickable");
			}
				driver.navigate().back();
				Act.moveToElement(productstefardship).perform();
				wait1.until(ExpectedConditions.elementToBeClickable(elimination)).click();
			@Nullable
			String eliminationharm = driver.getTitle();
			if(eliminationharm.contains("Elimination of harmful"))
			{
				System.out.println("contents in Product Stewardship are clickable");
			}
			else
			{
				System.out.println("contents in Product Stewardship are not clickable")	;
			}
			driver.navigate().back();
			Act.moveToElement(community).perform();
			wait1.until(ExpectedConditions.elementToBeClickable(Skilldevelopment)).click();
		
			@Nullable
			String skill = driver.getTitle();
			if(skill.contains("Skill Development"))
			{
				System.out.println("Contents in Community section are clickable ");
			}
			else
			{
				System.out.println("Contents in Community are not clickable");
			}
			driver.navigate().back();
			Act.moveToElement(healthsafty).perform();
			wait1.until(ExpectedConditions.elementToBeClickable(proccessafty)).click();
			@Nullable
			String safty = driver.getTitle();
			if(safty.contains("Process Safety"))
			{
				System.out.println("Contents in Health and Safty are clickable ");
			}
			else
			{
				System.out.println("Contents in health and safety are not clickable ");
			}
			driver.navigate().back();
			
				driver.close();
			}
		}
		driver.switchTo().window(Home);
	}
}
