package com.healthtrack;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class UsuarioFlujoTest {
    private WebDriver driver;
    private BufferedWriter logWriter;

    @BeforeEach
    void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // sin abrir navegador
        driver = new ChromeDriver(options);

        new File("selenium-tests/logs").mkdirs();

        logWriter = new BufferedWriter(new FileWriter("selenium-tests/logs/selenium-log.txt", true));
        log("=== INICIO DE PRUEBA ===");
    }

    @Test
    void testActualizarPesoEnSimulacionHTML() throws IOException {
        String path = Paths.get("usuario.html").toAbsolutePath().toUri().toString();
        driver.get(path);
        log("Cargó el archivo HTML: " + path);

        WebElement inputPeso = driver.findElement(By.id("peso"));
        inputPeso.sendKeys("67.8");
        log("Ingresó el peso 67.8");

        driver.findElement(By.id("btnActualizar")).click();
        log("Clic en botón Actualizar");

        WebElement resultado = driver.findElement(By.id("mostrarPeso"));
        String texto = resultado.getText();
        log("Texto mostrado: " + texto);

        Assertions.assertTrue(texto.contains("67.8"), "Debe mostrar el nuevo peso 67.8 kg");
        log("Verificación completada correctamente");
    }

    @AfterEach
    void tearDown() throws IOException {
        if (driver != null) {
            driver.quit();
            log("Cerró el navegador");
        }
        log("=== FIN DE PRUEBA ===\n");
        logWriter.close();
    }

    // Método para escribir en el log
    private void log(String mensaje) throws IOException {
        logWriter.write(LocalDateTime.now() + " - " + mensaje);
        logWriter.newLine();
    }
}