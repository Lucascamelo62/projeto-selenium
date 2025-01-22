package br.com.alura.leilao.leiloes;

import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesPage {
	
	private static final String URL_LEILOES_CADASTRADOS = "http://localhost:8080/leiloes";
	private ChromeDriver browser;

	public LeiloesPage(ChromeDriver browser) {
		this.browser = browser;
	}

	public void fecharBrowser() {
		this.browser.quit();
	}
	
	
}
