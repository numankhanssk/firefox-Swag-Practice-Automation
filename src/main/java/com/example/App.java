package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class App 
{
    public static void main(String[] args) throws InterruptedException
    {
        // Initialize FirefoxDriver
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // ================== Sauce Demo ==================
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);

        // Open new tab
        driver.switchTo().newWindow(WindowType.TAB);

        // ================== Practice Test Automation ==================
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);

        // Open another new tab
        driver.switchTo().newWindow(WindowType.TAB);

        // ================== Automation Exercise ==================
        driver.get("https://automationexercise.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 1: Click on Products
        WebElement productsLink = driver.findElement(By.cssSelector("a[href='/products']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productsLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productsLink);
        Thread.sleep(2000);

        // Step 2: Add to Cart
        WebElement addToCart = wait.until(
            ExpectedConditions.elementToBeClickable(By.cssSelector("a.add-to-cart"))
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCart);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);
        Thread.sleep(2000);

        // Step 3: Close Modal
        WebElement closeBtn = wait.until(
            ExpectedConditions.elementToBeClickable(By.cssSelector("button.close-modal"))
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closeBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);
        Thread.sleep(2000);

        // Close browser
        driver.quit();
    }
}
