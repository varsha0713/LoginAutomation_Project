// package com.janitri.tests;

// import com.janitri.base.BaseTest;
// import com.janitri.pages.LoginPage;
// import org.testng.Assert;
// import org.testng.annotations.Test;

// public class LoginPageTest extends BaseTest {

//     @Test
//     public void testLoginButtonDisabledWhenFieldsAreEmpty() {
//         LoginPage login = new LoginPage(driver);
//         Assert.assertTrue(login.isLoginButtonEnabled(), "Login button should be enabled when fileds are empty");
//     }

//     @Test
//     public void testPasswordMaskedButton() {
//         LoginPage login = new LoginPage(driver);
//         login.enterPassword("testpass");
//         Assert.assertTrue(login.isPasswordMasked(), "Password should be masked");
//         login.clickEyeIcon();
//         Assert.assertFalse(login.isPasswordMasked(), "Password should be visible after clicking eye icon");
//     }

//     @Test
//     public void testInvalidLoginShowsErrorMsg() {
//         LoginPage login = new LoginPage(driver);
//         login.enterEmail("wrong@email.com");
//         login.enterPassword("wrongpass");
//         login.clickLogin();
//         String error = login.getErrorMessage();
//         System.out.println("Error message: " + error);
//         Assert.assertTrue(error.toLowerCase().contains("invalid") || error.toLowerCase().contains("wrong"), "Error message should appear");
//     }
// }package com.janitri.tests;



package com.janitri.tests;

import com.janitri.base.BaseTest;
import com.janitri.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void testInvalidLoginWithEmptyFieldsShowsError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.toLowerCase().contains("invalid"), "Expected error message for empty login.");
    }
@Test
public void testPasswordMaskedButton() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterPassword("testpass");
    Assert.assertTrue(loginPage.isPasswordMasked(), "Password should be masked by default.");
    
    loginPage.clickEyeIcon();
    Assert.assertFalse(loginPage.isPasswordMasked(), "Password should be visible after clicking eye icon.");
}


   @Test
public void testInvalidLoginShowsErrorMsg() {
    LoginPage login = new LoginPage(driver);
    login.enterEmail("wrong@email.com");
    login.enterPassword("wrongpass");
    login.clickLogin();

    String error = login.getErrorMessage();
    System.out.println("Error message: " + error);
    Assert.assertTrue(error.contains("Invalid Credentials"),
        "Error message should indicate invalid credentials");
}

}
