package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class App {

    public static void main(String[] args) {

        try {

            // =========================
            // FIREFOX HEADLESS SETUP (JENKINS SAFE)
            // =========================
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");

            WebDriver driver = new FirefoxDriver(options);
            driver.manage().window().maximize();

            // ================== SAUCE DEMO ==================
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            Thread.sleep(2000);

            // ================== NEW TAB ==================
            driver.switchTo().newWindow(WindowType.TAB);

            // ================== PRACTICE TEST ==================
            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();

            Thread.sleep(2000);

            // ================== NEW TAB ==================
            driver.switchTo().newWindow(WindowType.TAB);

            // ================== AUTOMATION EXERCISE ==================
            driver.get("https://automationexercise.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Step 1: Products click
            WebElement productsLink = driver.findElement(By.cssSelector("a[href='/products']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productsLink);

            Thread.sleep(2000);

            // Step 2: Add to cart
            WebElement addToCart = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector(".add-to-cart"))
            );
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);

            Thread.sleep(2000);

            // Step 3: Close modal
            WebElement closeBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector(".close-modal"))
            );
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);

            Thread.sleep(2000);

            System.out.println("ALL TESTS COMPLETED SUCCESSFULLY");

            driver.quit();

        } catch (Exception e) {
            System.out.println("ERROR OCCURRED:");
            e.printStackTrace();
        }
    }
}
