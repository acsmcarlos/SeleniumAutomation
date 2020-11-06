package pages;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArrecEstadualPage {

	public static void captureScreenshot() throws IOException {
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		java.io.File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("C:\\WorkspaceSpring\\ArrecEstadualSelenium\\screenshot\\" + fileName));
	}

	public void Aguardar() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(7, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}

	static WebDriver driver;

	public ArrecEstadualPage(WebDriver driver) {
		ArrecEstadualPage.driver = driver;
	}

	public void preencherCampos() throws InterruptedException, IOException, AWTException {

		// Clicar em ICMS
		driver.findElement(
				By.xpath("//*[@id=\"containerConteudoPrincipal\"]/div/form/table[2]/tbody/tr[2]/td[2]/div/input"))
				.click();

		// Escolher ICMS
		driver.findElement(By.xpath(
				"//*[@id=\"containerConteudoPrincipal\"]/div/form/table[2]/tbody/tr[2]/td[2]/div/div[2]/span[3]"))
				.click();
/*01*/	System.out.println("01...Seleção ok");

		// clicar botão Confirmar
		driver.findElement(By.xpath("//*[@id=\"containerConteudoPrincipal\"]/div/form/table[3]/tbody/tr/td/a/img"))
				.click();
/*02*/	System.out.println("02...Botão ok");

		// Tipo de Identificação:
		driver.findElement(By.xpath("//*[@id=\"divTipoIdentificacao\"]/div/input")).click();
/*03*/	System.out.println("03...Identificação ok");

		// Selecionar CNPJ
		driver.findElement(By.xpath("//*[@id=\"divTipoIdentificacao\"]/div/div[2]/span[2]")).click();
/*04*/	System.out.println("04...Tipo OK");

		// Digitar cnpj
		driver.findElement(
				By.xpath("//*[@id=\"containerConteudoPrincipal\"]/div/form/table[2]/tbody/tr[3]/td[2]/input"))
				.sendKeys("11304411000197");
/*05*/	System.out.println("05...Tipo Identificação ok");

		// Clicar botão pesquisar
		driver.findElement(
				By.xpath("//*[@id=\"containerConteudoPrincipal\"]/div/form/table[2]/tbody/tr[3]/td[3]/a/img")).click();
/*06*/	System.out.println("06...Botão ok");

		// clicar uma receita
		driver.findElement(By.xpath("//*[@id=\"divReceita\"]/div/input")).click();

		// Selecionar Receita
		driver.findElement(By.xpath("//*[@id=\"divReceita\"]/div/div[2]/span[11]")).click();
/*07*/	System.out.println("07...Tipo receita ok");

		// DATA Vencimento
		WebElement dataVencimento = driver.findElement(By.xpath("//*[@id=\"dtVencimento\"]"));
		dataVencimento.sendKeys("03112020");
/*08*/	System.out.println("08...Data de vencimento ok");

		// DATA Pagamento
		WebElement dataPagamento = driver.findElement(By.xpath("//*[@id=\"dtPagamento\"]"));
		dataPagamento.sendKeys("03112020");
/*09*/	System.out.println("09...Data de pagamento ok");

		// Clicar Periodo
		driver.findElement(
				By.xpath("//*[@id=\"containerConteudoPrincipal\"]/div/form/table[4]/tbody/tr[6]/td[3]/div/input"))
				.click();

		// Escolher Periodo
		driver.findElement(By.xpath(
				"//*[@id=\"containerConteudoPrincipal\"]/div/form/table[4]/tbody/tr[6]/td[3]/div/div[2]/span[2]"))
				.click();
/*10*/	System.out.println("10...Período ok");

		// Mes
		driver.findElement(
				By.xpath("//*[@id=\"containerConteudoPrincipal\"]/div/form/table[4]/tbody/tr[7]/td[2]/div/input"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\"containerConteudoPrincipal\"]/div/form/table[4]/tbody/tr[7]/td[2]/div/div[2]/span[11]"))
				.click();
/*11*/	System.out.println("11...Mês ok");

		// ano
		driver.findElement(
				By.xpath("//*[@id=\"containerConteudoPrincipal\"]/div/form/table[4]/tbody/tr[8]/td[2]/div/input"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\"containerConteudoPrincipal\"]/div/form/table[4]/tbody/tr[8]/td[2]/div/div[2]/span[2]"))
				.click();
/*12*/	System.out.println("12...Ano ok");

		// Numero documento de origem
		driver.findElement(
				By.xpath("//*[@id=\"containerConteudoPrincipal\"]/div/form/table[4]/tbody/tr[10]/td[2]/input"))
				.sendKeys("156565");
/*13*/	System.out.println("13...Número do documento ok!");
		
		// Receita R$
		WebElement receita = driver
				.findElement(By.xpath("//*[@id=\"divMultaJurosCalcular\"]/table/tbody/tr[1]/td[2]/input"));
		receita.sendKeys("100");
/*14*/	System.out.println("14...Valor da Receita ok!");
		
		//Botão Calcular Multa/Juros
		if(driver.findElement(By.xpath("//*[@id=\"divMultaJurosCalcular\"]/table/tbody/tr[2]/td[3]/a/img")).isSelected()) {
			Thread.sleep(3000);
			Alert alert = driver.switchTo().alert(); //se não houver juros, prosseguir
			String alertMessage = driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			Thread.sleep(3000);
			alert.accept();
			Thread.sleep(3000);
			
/*15*/	System.out.println("15...Cálculo ok!");
			
		} else {
			
			// Informações complementares
			driver.findElement(
					By.xpath("//*[@id=\"containerConteudoPrincipal\"]/div/form/table[4]/tbody/tr[12]/td[2]/textarea"))
					.sendKeys(
							"Deverá ser informado um número de uma Nota Fiscal, Declaração de Importação (DI), Declaração "
									+ "Simplificada de Importação (DSI), Nota de Tributação Simplificada, DUIMP ou DIRE. Os valores "
									+ "serão validados conforme receita selecionada no ato da solicitação de emissão do DAE.");
		// captureScreenshot();
		}
		
		// BOTÃO GERAR DAE
		driver.findElement(By.xpath("//*[@id=\"containerConteudoPrincipal\"]/div/form/table[5]/tbody/tr/td[1]/a/img"))
				.click();
		// captureScreenshot();
/*16*/	System.out.println("16...Gerando DAE");

		// clicar em Emitir DAE
		driver.findElement(By.xpath("//*[@id=\"containerConteudoPrincipal\"]/div/form/table/tbody/tr[2]/td[1]/a/img"))
				.click();// Link download
		// captureScreenshot();

/*17*/	System.out.println("17...Download da GUIA realizado!");
		System.out.println("-------------------------------------");
		Thread.sleep(6000);
/*18*/	System.out.println("18...Automação finalizada com sucesso!");

	}
}
