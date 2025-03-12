package Generic_Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;










// for list of methods in any class : right click on class -> open Type Hierarchy 

public class WebDriverUtility {
	
	
	
	private WebDriver driver;
	
	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	
//-----------------------------------------------------------------------------------------------------------------------------
	
	/** 
	 * This method is used to maximize browser window 
	 * 
	 * @return void
	 * @author Viraj
	 * 
	 */
	
	public void maximizeWindow() {
		
		driver.manage().window().maximize();
		
	}
	
//--------------------------------------------------------------------------------------------------------------------------------	
	
	
    /**
     * This method is used to synchronize test execution speed of findElement() method with website loading.
     * Driver will keep searching to locate an element util specified time.
     * 
     * 
     * @param timeInSeconds
     * @exception throws Timeout Exception if the element is not located even after specified time
     * @return void
     * @author Viraj
     * 
     */
	public void implicitlyWait(int timeInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));		
	}

	
//--------------------------------------------------------------------------------------------------------------------------------	

	/**
	 * This method is used to wait for an element to be visible before proceeding with the execution
	 * It uses WebDriverWait and ExpectedConditions to wait for specific conditions.
     * Once the condition is met, execution continues.
	 * @param WebElemnt
	 * @param timeInSeconds
	 * @return void
	 * @exception If the condition isn’t met within the timeout, it throws a TimeoutException
	 * @author Viraj
	 * 
	 * 
	 */
	
	
	// 1. Wait for an element to be visible
	
	public void waitForELementToBeClickable(WebElement element, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	
	/**
	 * This method is used to wait for an element to be clickable before proceeding with the execution
	 * It uses WebDriverWait and ExpectedConditions to wait for specific conditions.
     * Once the condition is met, execution continues.
	 * @param WebElemnt
	 * @param timeInSeconds
	 * @return void
	 * @exception If the condition isn’t met within the timeout, it throws a TimeoutException
	 * @author Viraj
	 * 
	 * 
	 */
	

    // 2. Wait for an element to be clickable
	public void waitForVisibilityOfElement(WebElement element, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	
	/**
	 * This method is used to wait for an element until the page url contains specified text before proceeding with the execution
	 * It uses WebDriverWait and ExpectedConditions to wait for specific conditions.
     * Once the condition is met, execution continues.
	 * @param WebElemnt
	 * @param timeInSeconds
	 * @return void
	 * @exception If the condition isn’t met within the timeout, it throws a TimeoutException
	 * @author Viraj
	 * 
	 * 
	 */
	
	// 3. Wait for a URL to contain a specific text
	public void waitForUrlToContain(String partialUrl, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.urlContains(partialUrl));
	}
	
	
	
	
	/**
	 * This method is used to wait for an element until the page title contains specified text before proceeding with the execution
	 * It uses WebDriverWait and ExpectedConditions to wait for specific conditions.
     * Once the condition is met, execution continues.
	 * @param WebElemnt
	 * @param timeInSeconds
	 * @return void
	 * @exception If the condition isn’t met within the timeout, it throws a TimeoutException
	 * @author Viraj
	 * 
	 * 
	 */
	

	// 4. Wait for the title to contain a specific text
	public void waitForTitleToContain(String partialTitle, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.titleContains(partialTitle));
	}
	
	

	
	
	public List<WebElement> waitForPresenceOfAllElements(By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	
	
	
//--------------------------------------------------------------------------------------------------------------------------------	

	
	
	
	


   /**
    * This method is used to switch WebDriver focus to required window using partial Window title
    * 
    * @param partialWindowTitle
    * @return void
    * @author Viraj
    * 
    * 
    * 
    */
    public void switchWindow(String partialWindowTitle) {
    	
    	Set<String> windowHandles = driver.getWindowHandles();
    	Iterator<String> itr = windowHandles.iterator();
    	
    	while(itr.hasNext()) {
   
    		driver.switchTo().window(itr.next());    		
    		if(driver.getTitle().contains(partialWindowTitle)) {
        		System.out.println("Window Title    :"+driver.getTitle());
    			break;    		
    		}
    	}
    	
//    	while(itr.hasNext() && !driver.getTitle().contains(partialWindowTitle)) {
//    		driver.switchTo().window(itr.next());
//    	    System.out.println("Window Title: "+driver.getTitle());
//    	}
    	
    }
    
//--------------------------------------------------------------------------------------------------------------------------------	
    
    
    
    /**
     * This method is used to switch WebDriver focus to required window using partial Window Url when pop up window does not have a title
     * 
     * @param partialUrl
     * @return void
     * @author Viraj
     * 
     * 
     * 
     */
       
        public void switchWindowUsingUrl(String partialUrl) {
        	
        	Set<String> windowHandles = driver.getWindowHandles();
        	Iterator<String> itr = windowHandles.iterator();
        	
        	while(itr.hasNext()) {
        		driver.switchTo().window(itr.next());
        		if(driver.getCurrentUrl().contains(partialUrl)) {
        			break;
        		}
        	}
        	
//        	while(itr.hasNext() && !driver.getTitle().contains(windowUrl)) {
//    		driver.switchTo().window(itr.next());
//    	    System.out.println("Window Title: "+driver.getCurrentUrl());
//    	}
        }
        
        
        
        
        
//--------------------------------------------------------------------------------------------------------------------------------	

		/**
		 * This method is used to get size and a list of elements like auto-suggestion list, etc
		 * 
		 * 
		 * @param locator
		 * @return void
		 * @author Viraj
		 * 
		 * 
		 * 
		 */

		public void getList(By locator) {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
					
			System.out.println("List Size :" + list.size() + "\n");
			list.forEach(element -> System.out.println(element.getText()));
			
		}
		
		
		
		
		

		/**This method is used to click on an element from a list
		 * @param locator
		 * @param elementText
		 * @return void
		 * @author Viraj
		 * 
		 */
		
		public void clickElementFromList(By locatorForListElements, String elementText) {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorForListElements));

			
//          Approach1 : using stream()
//			WebElement element = list.stream()
//		            .filter(e -> e.getText().contains(elementText))
//		            .findFirst()
//		            .orElseThrow(() -> new RuntimeException("Element with text '" + elementText + "' not found."));
//
//		    element.click();
			
			
//			Approach2 : using if statement inside for loop
			
			for (WebElement element : list) {
				
				if(element.getText().contains(elementText)) {					
					element.click();
					System.out.println("Clicked on: " + element.getText());
					return;                                                   // terminates the whole method 
				}
			}
			throw new RuntimeException("Element with the text: "+elementText+ "not found in the list"); // method not terminated after completion of for loop means no element in the list contains the given text.

			
		}
		
		
		
		/** 
		 * This method is used to verify the presence of an element in the list.
		 * @param locator The locator used to find all the elements in the list
		 * @param elementText The text to search for in the elements.
		 * @return true if the element with the specified text is present in the list, false otherwise.
		 */
		
		public boolean isPresent(By locator, String elementText) {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			

			
//			boolean isPresent = list.stream()
//			                        .anyMatch(element->element.getText().contains(elementText));
//			if(isPresent) {				
//			    return true;
//			}			
//			else {
//				return false;
//			}				
//			
			
			for (WebElement element : list) {				
				if(element.getText().contains(elementText)) {
					return true;
				}				
			}
			return false;
	
		}
		
    	
        
        
      
//--------------------------------------------------------------------------------------------------------------------------------	

    
    
        
        public static String takeScreenshotEx(WebDriver driver, String ScreenshotName) {
    		
        	TakesScreenshot ts = (TakesScreenshot)BaseClass.driver; 
    		
    		File src = ts.getScreenshotAs(OutputType.FILE);
    		File dest = new File("./FailedScript.png");
    		
    		try {
    			FileUtils.copyFile(src, dest);
    		} catch (IOException e) {			
    			e.printStackTrace();
    		}
        	
        	return ScreenshotName;
        }
        
        
    
    }



//-------------------------------------------------------------------------------------------------------------
