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
		Assert.assertTrue(paginaLogin.isErro());
	}
	
	@Test
	public void acessarPaginaRestrita() {
		Assert.assertTrue(paginaLogin.isLogin());
	}	
}
