package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	private ChromeDriver browser;
	
	public LoginPage() {
		System.setProperty("webdriver.chrome.driver", "/Users/Foton/Projetos/projeto-selenium/drivers/chromedriver.exe");
		this.browser = new ChromeDriver();
		this.browser.navigate().to(URL_LOGIN);
		
	}

	public void fecharBrowser() {
		this.browser.quit();
	}

	public void preencheFormularioLogin(String nomeUsuario, String senha) {
		this.browser.findElement(By.id("username")).sendKeys(nomeUsuario);
		this.browser.findElement(By.id("password")).sendKeys(senha);
	}

	public void submmitForm() {
		this.browser.findElement(By.id("login-submit")).click();
	}

	public boolean isPaginaLogin() {
		return this.browser.getCurrentUrl().equals(URL_LOGIN);
	}

	public boolean isLogado() {
		return this.browser.getPageSource().contains("Leilões cadastrados");
	}

	public boolean isErro() {
		return ((this.browser.getCurrentUrl().equals("http://localhost:8080/login?error")) && (browser.getPageSource().contains("Usuário e senha inválidos.")));
		
	}
}
