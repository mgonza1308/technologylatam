package com.prueba;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void Eje(){
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.xpath("(//*[contains(text(),'Practice Form')])[1]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")));
        driver.findElement(By.id("firstName")).sendKeys("nombredealgiu");
        driver.findElement(By.id("lastName")).sendKeys("apellidoiern");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Male']")));
        boton.click();
        driver.findElement(By.id("userNumber")).sendKeys("9123456789");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
        driver.findElement(By.id("submit")).click();
    }

    @AfterEach
    void tearDown() {
            //driver.quit();
    }

}
