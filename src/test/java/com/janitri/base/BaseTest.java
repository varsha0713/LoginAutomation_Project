// package com.janitri.base;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.BeforeMethod;

// public class BaseTest {
//     public WebDriver driver;

//     @BeforeMethod
//     public void setUp() {
//         System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
//         driver = new ChromeDriver();
//         driver.manage().window().maximize();
//         driver.get("https://dev-dash.janitri.in/");
//     }

//     @AfterMethod
//     public void tearDown() {
//         driver.quit();
//     }
// }
package com.janitri.base;

import com.janitri.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe"); // ✅ Make sure this path is correct
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev-dash.janitri.in"); // ✅ Check this URL
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
