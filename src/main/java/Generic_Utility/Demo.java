package Generic_Utility;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;





//https://mictests.com/  -> click on TestMyMic button and handle the popup
//https://demoapps.qspiders.com/ui/datePick?sublist=0  -> select April 5 from the calener
//https://demoapps.qspiders.com/ui/timePick/timeClock?sublist=1  -> select 4 am from the clock



public class Demo {
	

	
	
	public static void main(String[] args) throws AWTException, InterruptedException  {
		

		
		
//		--------------------------------------------------------------------------------------------
//      https://mictests.com/  -> click on TestMyMic button and handle the popup
		
		
        //does not work		
//		ChromeOptions opt = new ChromeOptions();
//		opt.addArguments("--disable-notifications"); // Correct spelling!
//		
//	    WebDriver driver = new ChromeDriver(opt);
//	    driver.manage().window().maximize();
//		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
//
//	    
//	    driver.get("https://mictests.com/");
//	    
//	    driver.findElement(By.xpath("//button[@id='mic-launcher']")).click();
	    
	    
	    //use Robot class and to get focus on browser pop up --> use keyboard TAB using keypress.VK_TAB
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://mictests.com/");
		
		driver.findElement(By.xpath("//button[@id='mic-launcher']")).click();
		
		Robot r = new Robot();
		
		System.out.println("robot created");
		
		Thread.sleep(2000);
		
		// when you press tab for first time : focus goes to -> close pop up button 
		r.keyPress(KeyEvent.VK_TAB); 
        r.keyRelease(KeyEvent.VK_TAB);
        
        // to close pop up : press enter
        //r.keyPress(KeyEvent.VK_ENTER);
        //r.keyRelease(KeyEvent.VK_ENTER);
        
        
        
        // when you press tab for second time : focus goes to -> allow for this site 
		r.keyPress(KeyEvent.VK_TAB); 
        r.keyRelease(KeyEvent.VK_TAB);
        
        //r.keyPress(KeyEvent.VK_ENTER);
        //r.keyRelease(KeyEvent.VK_ENTER);
		
          
        
       // when you press tab for third time : focus goes to -> allow this time 
		r.keyPress(KeyEvent.VK_TAB); 
        r.keyRelease(KeyEvent.VK_TAB);
        
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        
        
        
          
       // when you press tab for fourth time : focus goes to -> never allow	
		r.keyPress(KeyEvent.VK_TAB); 
        r.keyRelease(KeyEvent.VK_TAB);
        
        //r.keyPress(KeyEvent.VK_ENTER);
        //r.keyRelease(KeyEvent.VK_ENTER);
		
		
	   
	    
		
		
		



		
//-----------------------------------------------------------------------------------------------------------

//		WebDriver driver = new EdgeDriver();		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
//		
//		driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
//		
//		Demo d1 = new Demo(driver);
//		
//		
//		driver.findElement(By.xpath("//div[@class='react-datepicker__input-container']/input")).click();
//		
//		while(!d1.currentMonth.getText().equalsIgnoreCase("April 2025")){
//			d1.nextButton.click();
//		}
//		
//		d1.requiredDate.click();
	
		
//-----------------------------------------------------------------------------------------------------------
		
	

//		WebDriver driver = new EdgeDriver();		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
//		driver.get("https://demoapps.qspiders.com/ui/timePick/timeClock?sublist=1");
//		
//		driver.findElement(By.xpath("//input[@id=':r1:']")).click();
//
////		org.openqa.selenium.ElementClickInterceptedException
////		driver.findElement(By.xpath("//div[@class='MuiClock-wrapper css-1nob2mz']//span[text()='4']")).click();
////		driver.findElement(By.xpath("//div[@class='MuiClock-wrapper css-1nob2mz']//span[text()='00']")).click();
//
//		
//		
//		Actions act = new Actions(driver);
//		
//		WebElement hr = driver.findElement(By.xpath("//div[@class='MuiClock-wrapper css-1nob2mz']//span[text()='4']"));
//	
//		act.moveToElement(hr)
//		   .click()
//		   .build()
//		   .perform();
//		
//                  
//		WebElement min = driver.findElement(By.xpath("//div[@class='MuiClock-wrapper css-1nob2mz']//span[text()='00']"));
//	    
//		act.moveToElement(min)
//		   .click()
//		   .build()
//		   .perform();
//
//		driver.findElement(By.xpath("//button[text()='OK']")).click();
	
		
		
		
		
    
		
	}

	
		
	}
	
	
	
    
	
 
	
        	  
           
		
	   



		


	
	
				
        
	

