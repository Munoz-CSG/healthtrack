package com.healthtrack;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.nio.file.Paths;

public class UsuarioFlujoTest {
    private WebDriver driver;
    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // sin abrir navegador
        driver = new ChromeDriver(options);
    }

    @Test
    void testActualizarPesoEnSimulacionHTML() {
        // Ruta absoluta al archivo HTML local
        String path = Paths.get("usuario.html").toAbsolutePath().toUri().toString();
        driver.get(path);

        // Interactuar con la UI simulada
        WebElement inputPeso = driver.findElement(By.id("peso"));
        inputPeso.sendKeys("67.8");

        driver.findElement(By.id("btnActualizar")).click();

        WebElement resultado = driver.findElement(By.id("mostrarPeso"));
        String texto = resultado.getText();

        Assertions.assertTrue(texto.contains("67.8"), "Debe mostrar el nuevo peso 67.8 kg");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}