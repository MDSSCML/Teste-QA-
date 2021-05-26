package Teste_automatico;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Testes {

	public static void main(String[] args) throws InterruptedException {
		String produto = "Printed Dress";
		String login = "mc872684@gmail.com";
		String senha = "123456789mdssc";
		
		WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        
        driver.get("http://automationpractice.com/index.php");
        
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        
               
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        	WebElement nome_produto = driver.findElement(By.id("search_query_top"));
            nome_produto.sendKeys(produto);
            
           driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
           
          WebElement  dar_submit = driver.findElement(By.name("submit_search"));
          dar_submit.sendKeys(Keys.ENTER);
          driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
          
          
        	 driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
             driver.findElement(By.xpath(".//*[text()='Add to cart']")).click();;
             driver.findElement(By.xpath(".//a[contains(@title,'Proceed to checkout')]")).click();
             
        
            WebElement clicar_botao = driver.findElement(By.cssSelector("a[title*='Log in to your customer account']"));
            clicar_botao.sendKeys(Keys.ENTER);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            
            WebElement campo_login = driver.findElement(By.name("email"));//email
            campo_login.sendKeys(login);
            WebElement campo_senha = driver.findElement(By.name("passwd"));//senha
            campo_senha.sendKeys(senha);
            WebElement submit = driver.findElement(By.id("SubmitLogin"));//submit
            submit.sendKeys(Keys.ENTER);
           
            //Conferir endereço
           
            driver.findElement(By.cssSelector("a[title*='Addresses']")).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
             
             //volta a página
             driver.navigate().back();
             
             //abrir dropdown
           WebElement dropdown = driver.findElement(By.cssSelector("a[title*='View my shopping cart']")); 
           action.moveToElement(dropdown).perform();
           driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
           
           //clica no botão
           driver.findElement(By.cssSelector("a[title*='Check out']")).click();
           driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
           
           //continua processamento
           driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click(); 
           driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
           
           //confirmação endereço entrega
           driver.findElement(By.name("processAddress")).click();
           driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
           
           //confirmar termos de serviços
           driver.findElement(By.name("cgv")).click();
           driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
           
           // confirmar delivery
           driver.findElement(By.name("processCarrier")).click();
           driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
           
           //fazer pagamento
           driver.findElement(By.cssSelector("a[title*='Pay by bank wire']")).click();
           driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
           
           //confirma pagamento
           driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
           driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
           
           driver.quit();
           System.out.println("your order on My Storie complete");
		}  	
	}


