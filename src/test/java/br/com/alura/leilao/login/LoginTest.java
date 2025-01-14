package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	@Test
	public void loginValido() {
		System.setProperty("webdriver.chrome.driver", "/Users/Foton/Projetos/projeto-selenium/drivers/chromedriver.exe");
		ChromeDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:8080/login");
		browser.findElement(By.id("username")).sendKeys("fulano");
		browser.findElement(By.id("password")).sendKeys("pass");
		browser.findElement(By.id("login-submit")).click();
		Assert.assertFalse(browser.getCurrentUrl().equals("http://localhost:8080/login"));
		
		browser.quit();
	}
	
	@Test
	public void loginInvalido() {
		System.setProperty("webdriver.chrome.driver", "/Users/Foton/Projetos/projeto-selenium/drivers/chromedriver.exe");
		ChromeDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:8080/login");
		browser.findElement(By.id("username")).sendKeys("login_errado");
		browser.findElement(By.id("password")).sendKeys("teste");
		browser.findElement(By.id("login-submit")).click();
		Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
		Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
		
		browser.quit();
	}
	
}
