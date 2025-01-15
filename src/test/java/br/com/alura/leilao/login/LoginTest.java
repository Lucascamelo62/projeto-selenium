package br.com.alura.leilao.login;

import java.util.NoSuchElementException;

import org.aspectj.lang.annotation.After;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	private ChromeDriver browser;
	
	@BeforeAll
	public static void beforeAll () {
		System.setProperty("webdriver.chrome.driver", "/Users/Foton/Projetos/projeto-selenium/drivers/chromedriver.exe");
	}
	
	@BeforeEach
	public void beforeEach() {
		this.browser = new ChromeDriver();
		this.browser.navigate().to(URL_LOGIN);
	}
	
	@AfterEach
	public void afterEach () {
		this.browser.quit();
	}
	
	@Test
	public void loginValido() {
		browser.findElement(By.id("username")).sendKeys("fulano");
		browser.findElement(By.id("password")).sendKeys("pass");
		browser.findElement(By.id("login-submit")).click();
		Assert.assertFalse(browser.getCurrentUrl().equals(URL_LOGIN));
		Assert.assertTrue(browser.getPageSource().contains("Leilões cadastrados"));
	}
	
	@Test
	public void loginInvalido() {
		browser.findElement(By.id("username")).sendKeys("login_errado");
		browser.findElement(By.id("password")).sendKeys("teste");
		browser.findElement(By.id("login-submit")).submit();
		Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
		Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
	}
	
	@Test
	public void acessarPaginaRestrita () {
		this.browser.navigate().to("http://localhost:8080/leiloes/1/form");
		Assert.assertTrue(browser.getPageSource().contains("Login")); //Garantindo que o mesmo foi direcionado para a página de Login.
	}
	
}
