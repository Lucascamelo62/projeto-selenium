package br.com.alura.leilao;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {
	
	@Test
	public void hello() {
		System.setProperty("webdriver.chrome.driver", "/Users/Foton/Projetos/projeto-selenium/drivers/chromedriver.exe");
		ChromeDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:8081/leiloessss");
//        browser.quit();
	}
}
