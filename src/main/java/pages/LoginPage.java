package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	private WebDriver driver;

	public LoginPage() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	public void navigateTo() {
		driver.get("http://localhost:4200");
		driver.findElement(By.className("login")).click();
	}

	public void enterUsername(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(By.className("login")).click();
	}

	public String getWelcomeMessage() {
		return driver.findElement(By.xpath("/html/body/app-root/app-meeting-schedule/body/p")).getText();
	}

	public String getErrorMessage() {
		return driver.findElement(By.xpath("/html/body/app-root/app-client-login/body/div/form/p")).getText();
	}
	
	public void logout() throws InterruptedException {
		driver.findElement(By.className("logout")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("home")).click();
	}

	public void closeBrowser() {
		driver.quit();
	}

}
