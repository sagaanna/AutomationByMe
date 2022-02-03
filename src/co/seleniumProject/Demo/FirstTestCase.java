package co.seleniumProject.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstTestCase {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP-Launch Browser");
		System.setProperty("webdriver.chrome.driver","D:\\Projects\\July'21\\Eclipse\\SeleniumProject\\resources\\chromeDriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		System.out.println("STEP-Create New Account");
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Thread.sleep(2000);
		System.out.println("STEP-Enter First Name");
		driver.findElement(By.name("firstname")).sendKeys("Sagar");
		System.out.println("STEP-Enter Last Name");
		driver.findElement(By.name("lastname")).sendKeys("Anasane");
		System.out.println("STEP-Enter Email ID");
		driver.findElement(By.name("reg_email__")).sendKeys("anasane.sagar@gmail.com");
		System.out.println("STEP-RE-enter Email ID");
		driver.findElement(By.xpath("//input[@name=\"reg_email_confirmation__\"]")).sendKeys("anasane.sagar@gmail.com");
		System.out.println("STEP-Enter Password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Guitarist@2021");
		System.out.println("STEP-Enter Date of Birth");
		WebElement birthDayElement=driver.findElement(By.xpath("//select[@title=\"Day\"]"));
		Select dateOfBirth=new Select(birthDayElement);
		dateOfBirth.selectByVisibleText("20");
		WebElement birthMonthElement=driver.findElement(By.xpath("//select[@title=\"Month\"]"));
		Select monthOfBirth=new Select(birthMonthElement);
		monthOfBirth.selectByVisibleText("Oct");
		WebElement birthYearElement=driver.findElement(By.xpath("//select[@title=\"Year\"]"));
		Select yearOfBirth=new Select(birthYearElement);
		yearOfBirth.selectByVisibleText("1994");
		System.out.println("STEP-Enter Gender");
		driver.findElement(By.xpath("//input[@value='2']")).click();
		System.out.println("STEP-Click Sign UP Button");
		//driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		
		WebElement newText= driver.findElement(By.xpath("//a[contains(@class,'_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy')]"));
		String latestText=newText.getText();
		if(latestText.equals("Create New Account")) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Fail");
		}
		//driver.close();
		
		String expectedText="Forgotten password?";
		String actualText=driver.findElement(By.xpath("//a[text()='Forgotten password?']")).getText();
		if(expectedText.equals(actualText))
			System.out.println("Again the test is passed");
		else
			System.out.println("Test Failed");
	}
}
