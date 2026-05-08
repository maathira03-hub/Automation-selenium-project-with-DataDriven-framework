package basepackage;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;

	public class baseclass {
		

	    protected WebDriver driver;

	    @BeforeTest
	    public void setup() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.asianpaints.com/");
	    }

	    @AfterTest
	    public void tearDown() {
	      
	            driver.quit();
	        }
	    }
	

