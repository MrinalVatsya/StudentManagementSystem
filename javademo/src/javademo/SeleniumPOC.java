//package javademo;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//
///**
// * @author mrinalvatsya
// *
// */
//public class SeleniumPOC {
//	public static void main(String[] args) throws InterruptedException {
//		try {			
//			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
//			WebDriver driver = new ChromeDriver();
//			driver.get("http://172.29.58.142:8080/Legal1UAT");
//			WebDriverWait wait = new WebDriverWait(driver, 5);
//
//			String cssOfInputField = "input[name='UserId']";
//
//			WebElement inputFieldQ = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfInputField)));
//
//			inputFieldQ.sendKeys("Uploader1");
//
//
//			String cssOfInputField1 = "input[name='Password']";
//			WebElement inputFieldQ1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfInputField1)));
//
//			inputFieldQ1.sendKeys("abc@1234");
//
//			WebElement searchButton = driver.findElement(By.id("loginBtn"));
//			driver.manage().window().maximize();
//			searchButton.click();
//			Thread.sleep(5000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".row.menu-list")));
//			WebElement menuItems = driver.findElement(By.cssSelector(".row.menu-list"));
//
//			//Thread.sleep(5000);
//			List<WebElement> menus = menuItems.findElements(By.tagName("li"));
//			//Thread.sleep(5000);
//			for (WebElement webElement : menus) {
//				// Thread.sleep(5000);
//				WebElement moduleLink = webElement.findElement(By.tagName("a"));
//				// Thread.sleep(5000);
//				String moduleLinkHref = moduleLink.getAttribute("href");
//				// /contract
//				if(moduleLinkHref != null && moduleLinkHref.endsWith("/contract")) {
//					//	Thread.sleep(5000);
//					moduleLink.click();
//					break;
//				}
//			}
//
//
//			Thread.sleep(5000);
//
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Add Contract')]")));
//
//			WebElement addContract = driver.findElement(By.xpath("//button[contains(.,'Add Contract')]"));
//			addContract.click();
//
//			Thread.sleep(5000);
//
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'View Executive Summary')]")));
//
//			JavascriptExecutor jse = (JavascriptExecutor) driver;
//
//			driver.findElement(By.id("111")).sendKeys("Mrinal");//purpose/objective label..
//			driver.findElement(By.id("113")).sendKeys("Mrinal");//Key Terms label..
//List<WebElement> radioControl = driver.findElements(By.tagName("app-radio"));
//	        
//	        for (WebElement webElement : radioControl) {
//	        	
//	        	WebElement labelTag = webElement.findElement(By.tagName("label"));
//	        	
//	        	if(labelTag != null) {
//	        		String labelName = labelTag.getText();
//	        		if(labelName != null && "Transaction Information".equals(labelName)) {
//	        			WebElement businessTransfer = webElement.findElement(By.xpath("//span[contains(.,'Business transferred')]"));
//	        			if(businessTransfer != null) {
//	        				businessTransfer.click();
//	        			}
//	        			
//	        		}else if(labelName != null && "Status".equals(labelName)) {
//	        			WebElement active = webElement.findElement(By.xpath("//span[contains(.,'Active')]"));
//	        			if(active != null) {
//	        				active.click();
//	        			}
//	        		}else if(labelName != null && "Legal Consultant/ Approver".equals(labelName)) {
//	        			WebElement external = webElement.findElement(By.xpath("//span[contains(.,'External')]"));
//	        			if(external != null) {
//	        				//external.click();
//	        			}
//	        		}
//	        	}
//	        
//	        }
//			Thread.sleep(5000);
//			driver.close();
//		}
//		catch(NoClassDefFoundError ex) {
//			System.out.println("error: " + ex.getStackTrace());
//		}
//	}
//}
