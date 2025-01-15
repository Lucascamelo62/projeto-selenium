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
	
	private LoginPage paginaLogin;
	
	@BeforeEach
	public void beforeEach() {
		this.paginaLogin = new LoginPage();
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaLogin.fecharBrowser();
	}
	
	@Test
	public void loginValido() {
		paginaLogin.preencheFormularioLogin("fulano", "pass");
		paginaLogin.submmitForm();
		Assert.assertFalse(paginaLogin.isPaginaLogin());
		Assert.assertTrue(paginaLogin.isLogado());
	}
	
	@Test
	public void loginInvalido() {
		paginaLogin.preencheFormularioLogin("usuario_errado", "senha_errada");
		paginaLogin.submmitForm();
		Assert.assertFalse(paginaLogin.isErro());
	}
//	
//	@Test
//	public void loginInvalido() {
//		this.browser.findElement(By.id("username")).sendKeys("login_errado");
//		this.browser.findElement(By.id("password")).sendKeys("teste");
//		this.browser.findElement(By.id("login-submit")).submit();
//		Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
//		Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
//	}
//	
//	@Test
//	public void acessarPaginaRestrita () {
//		this.browser.navigate().to("http://localhost:8080/leiloes/1/form");
//		Assert.assertTrue(browser.getPageSource().contains("Login")); //Garantindo que o mesmo foi direcionado para a página de Login.
//	}
	
}
