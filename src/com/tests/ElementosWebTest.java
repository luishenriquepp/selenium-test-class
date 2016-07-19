package com.tests;

import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementosWebTest {
	
	public WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://treinoautomacao.hol.es/elementsweb.html");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testInputName() {
		 WebElement txtNome = driver.findElement(By.name("txtbox1"));
		 txtNome.sendKeys("Henrique");
 		 String nome = txtNome.getAttribute("value");
 		 assertEquals("Henrique", nome); 
	}
	
	@Test
	public void testAcessaRadioButton() {
		List<WebElement> elementsRadio = driver.findElements(By.name("radioGroup1"));
		
		for(WebElement radios : elementsRadio) {
			System.out.println(radios.getAttribute("value").toString());
			
			if(radios.getAttribute("value").equals("Radio Button 3 Selected")) {
				radios.click();
				assertEquals("Opcao 3 deveria estar checkada!", "true", radios.getAttribute("checked"));
			}
		}
	}
	
	@Test
	public void testAcessaCheckBox() {
		List<WebElement> elementsCheck = driver.findElements(By.name("chkbox"));
		
		for(WebElement checkBoxes : elementsCheck) {
			System.out.println(checkBoxes.getAttribute("value").toString());
			
			if(checkBoxes.getAttribute("value").equals("Check Box 3 Selected")){
				checkBoxes.click();
				assertEquals("true", checkBoxes.getAttribute("checked"));
			}
		}
	}
}
