import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HeaderUITest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Configurar o driver (neste caso, Edge)
        System.setProperty("webdriver.edge.driver", "/usr/Applications/msedgedriver");
        driver = new EdgeDriver();
    }

    @Test
    public void testLogoAndSloganClickable() {
        // Abra a página
        driver.get("http://exemplo.com");

        // Encontre o logotipo e o slogan pelos seus elementos HTML
        WebElement logo = driver.findElement(By.cssSelector(".logo a:first-child"));
        WebElement slogan = driver.findElement(By.cssSelector(".logo a:last-child"));

        // Verifique se os elementos são clicáveis
        logo.click();
        assertEquals("http://exemplo.com/", driver.getCurrentUrl());

        // Volte à página anterior
        driver.navigate().back();

        // Clique no slogan
        slogan.click();
        assertEquals("http://exemplo.com/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        // Feche o navegador após o teste
        driver.quit();
    }
}
