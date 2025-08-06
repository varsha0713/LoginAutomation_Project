
package com.janitri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Correct locators based on your HTML
    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginBtn = By.cssSelector("#root > div > div > div.login-form > div > div > form > button");
    By errorMessage = By.xpath("//p[contains(text(), 'Invalid Credentials')]");
    By eyeIcon = By.cssSelector("button[type='button'] i[class*='eye']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        button.click();
    }

    public String getErrorMessage() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
    return error.getText();
}


    public boolean isLoginButtonEnabled() {
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn));
        return button.isEnabled();
    }

public boolean isPasswordMasked() {
    WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
    String type = passwordField.getAttribute("type");
    return "password".equalsIgnoreCase(type);
}



public void clickEyeIcon() {
    WebElement eyeIcon = wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector("img.passowrd-visible")
    ));
    eyeIcon.click();
    // Small wait to allow toggle
    try {
        Thread.sleep(500); // 0.5 sec
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}




}
