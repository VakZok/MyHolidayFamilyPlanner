package Selenium;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
	public WebDriver driver;

	@Test
	public void testFamilienmitglieder() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\chris\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\SelenTest\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://localhost:8080/familienmitglied.html");

		// Prüfung auf richtigen Seitentitle
		String title = driver.getTitle();
		Assertions.assertEquals("MyHFP - Familienmitglied", title);

		// Warten, dass benötigte Elemente geladen werden
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		// Test: Familienmitglied anlegen

		// ID des Familienmitglieds wird eingegeben
		WebElement searchMenschID = driver.findElement(By.name("menschID"));
		searchMenschID.sendKeys("42");

		// Name des Familienmitglieds wird eingegeben
		WebElement searchMenschName = driver.findElement(By.name("menschName"));
		searchMenschName.sendKeys("Max Mustermann");

		// Geburtstag des Familienmitglieds wird eingegeben
		WebElement searchMenschGeburtstag = driver.findElement(By.name("menschGeburtstag"));
		searchMenschGeburtstag.sendKeys("01.01.1999");

		// Es wird für wahr angenommen, dass die ID "42" eingegeben wurde
		String menschID = searchMenschID.getAttribute("value");
		Assertions.assertEquals("42", menschID);

		// Submit button wird betätigt
		WebElement buttonFamMitglied = driver.findElement(By.xpath("//*[@id=\"newMensch\"]/input"));
		buttonFamMitglied.click();

		// Warten, dass die Funktion ausgeführt wird
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		// ID des Familienmitglieds wird eingegeben
		WebElement searchMenschID2 = driver.findElement(By.name("menschID"));
		String menschID2 = searchMenschID2.getAttribute("value");
		Assertions.assertEquals("", menschID2);

		// Test: Familienmitglied löschen
		// ID des Familienmitglieds wird eingegeben
		WebElement searchDeleteMenschID = driver.findElement(By.name("deleteMenschID"));
		searchDeleteMenschID.sendKeys("42");

		// Es wird für wahr angenommen, dass die ID "42" eingegeben wurde
		String menschDeleteID = searchDeleteMenschID.getAttribute("value");
		Assertions.assertEquals("42", menschDeleteID);

		// Submit button wird betätigt
		WebElement buttonDeleteFamMitglied = driver.findElement(By.xpath("//*[@id=\"removeMenschButton\"]"));
		buttonDeleteFamMitglied.click();
	}

	@Test
	public void testDeleteFamilienmitglieder() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\chris\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\SelenTest\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://localhost:8080/familienmitglied.html");

		// Prüfung auf richtigen Seitentitle
		String title = driver.getTitle();
		Assertions.assertEquals("MyHFP - Familienmitglied", title);

		// Warten, dass benötigte Elemente geladen werden
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		// Test: Familienmitglied löschen
		// ID des Familienmitglieds wird eingegeben
		WebElement searchDeleteMenschID = driver.findElement(By.name("deleteMenschID"));
		searchDeleteMenschID.sendKeys("42");

		// Es wird für wahr angenommen, dass die ID "42" eingegeben wurde
		String menschDeleteID = searchDeleteMenschID.getAttribute("value");
		Assertions.assertEquals("42", menschDeleteID);

		// Submit button wird betätigt
		WebElement buttonDeleteFamMitglied = driver.findElement(By.xpath("//*[@id=\"removeMenschButton\"]"));
		buttonDeleteFamMitglied.click();

		// Warten, dass die Funktion ausgeführt wird
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		// driver.quit();
	}
}
