package ArrecEstadualTest;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.ArrecEstadualPage;

public class ArrecEstadualTest {
	
	
	// Instanciando a classe webdriver
	public static WebDriver driver;
	static ArrecEstadualPage arrecEstadualPage;

	@BeforeClass
	public static void setUpBeforeClass() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		System.setProperty("webdriver.chrome.driver", "C:\\DriversBrowsers\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
//		driver.manage().window().maximize();
		driver.get("https://www2.fazenda.mg.gov.br/arrecadacao/ctrl/ARRECADA/ARRECADA/DOCUMENTO_ARRECADACAO?ACAO=VISUALIZAR");														// navegador
		arrecEstadualPage = new ArrecEstadualPage(driver);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException, IOException, AWTException {
		arrecEstadualPage.preencherCampos();
	}
}
