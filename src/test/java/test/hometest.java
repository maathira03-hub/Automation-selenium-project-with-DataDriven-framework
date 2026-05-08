package test;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basepackage.baseclass;
import page.Homepage;
import page.Sustainability;
import utility.Utilitypage;

public class hometest extends baseclass
{
	  Homepage obj;
	  Sustainability abc;
	@BeforeClass
	public void setupPage() 
	{ 
		obj = new Homepage(driver); 
		abc=new  Sustainability(driver);
		}
	
@Test (priority=2)
public void logo()
{
	obj.logocheck();
	}
@Test(priority=6)
public void linkchecks() throws IOException
{
obj.linkcheck();	
}
@Test(priority=3)
public void verifysection()
{
	obj.verificationtransform();
}
@Test(priority=4)
public void clicktest()
{
	obj.scrollup();
obj.click();	
}
@Test(priority=5)
public void scrollandview()
{
obj.scroll();
obj.viewcolorsec();
}
@Test(priority=1)
public void dataenter() throws Exception
{
	obj.handleCookies();
	obj.scroll();
	obj.scroll();
	 String sheet = "sheet";

     int rows = Utilitypage.getRowCount(sheet);
          Thread.sleep(2000);
     for (int i = 1; i <= rows; i++)   // skip header row
     {
         String name  = Utilitypage.getCellValue(sheet, i, 0);
         String email = Utilitypage.getCellValue(sheet, i, 1);
         String phone = Utilitypage.getCellValue(sheet, i, 2);
         String pin   = Utilitypage.getCellValue(sheet, i, 3);

         // Enter form data
         obj.Setdatahome(name, email, phone, pin);

         // If you have additional steps:
           // optional (if exists)
        obj.submit();
        
        // driver.navigate().refresh(); // reset form
//obj.handleCookies();
         
     }
}
@Test(priority =7)
public void windowhandle()
{
	abc.window();
}
}




