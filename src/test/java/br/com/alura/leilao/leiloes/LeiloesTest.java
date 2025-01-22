package br.com.alura.leilao.leiloes;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage paginaLeiloes;
	
	@AfterAll
	public void afterAll() {
		this.paginaLeiloes.fecharBrowser();
	}
	
	@Test
	public void openFormNewLeilao() {
		LoginPage paginaLogin = new LoginPage();
		paginaLogin.preencheFormularioLogin("fulano", "pass");
	    this.paginaLeiloes = paginaLogin.submmitForm();
	}
	
}
