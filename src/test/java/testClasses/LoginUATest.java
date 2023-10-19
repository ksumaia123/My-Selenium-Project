package testClasses;

import dataReader.ExcelLoginDataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageElements.LoginUAPage;
import utility.BaseClass1;

import java.io.IOException;
import java.util.List;


public class LoginUATest extends BaseClass1 {
    LoginUAPage loginUAPage;

    // step 1- click on Account link
    // step 2-click on login link


    @Test ()
    public void clickOnAccount() throws IOException, InterruptedException {
        loginUAPage = new LoginUAPage(driver);
        loginUAPage.clickOnAccount();
        Thread.sleep(3000);
        loginUAPage.clickOnLogin();

        //loginPage();  //Funtionality


    }

    /* Test case -validate that user is on the login pae
    step 1- click on account
    step 2-click on login
    step 3- validate that a text "login" is there in the page.

     */


    @Test (priority = 2)
    public void validateLoginpage() throws InterruptedException {
//        loginUAPage.clickOnAccount();
//        Thread.sleep(2000);
//       loginUAPage.clickOnLogin();
//        if (loginUAPage.getLoginText().equalsIgnoreCase("Login")){
//            System.out.println("I am on the right page");
//        }
//    else {
//            System.out.println("I am not on the right page");
//        }
        //  Assert.assertEquals(loginUAPage.getLoginText(), "Login");

        Assert.assertEquals(loginUAPage.loginTextDisplay(), true);
    }


    @Test(dataProvider = "Login Data from Excel", dataProviderClass = ExcelLoginDataReader.class )
    public void enterLoginData(String userName, String password, String email) throws InterruptedException {
        //   formula -- //tagname[@attribute = 'value']
        loginUAPage.enterUserName(userName);
     //   WebElement usernamePath = driver.findElement(By.xpath("//input[@name ='loginusername']"));
    //   usernamePath.clear();
     //   usernamePath.sendKeys(userName);
        Thread.sleep(3000);
        loginUAPage.enterPassWord(password);
       // WebElement passwordPath = driver.findElement(By.xpath("//input[@id = 'loginPassword4']"));
      //  passwordPath.clear();
      //  passwordPath.sendKeys(password);
        Thread.sleep(3000);
        loginUAPage.emailList(email);
     // List<WebElement> inputList = driver.findElements(By.xpath("//input[@class = 'form-control']"));
     // WebElement emailPath = inputList.get(1);
     // emailPath.clear();
     // emailPath.sendKeys(email);
        Thread.sleep(3000);
        loginUAPage.loginButton();
      //  WebElement loginButton = driver.findElement(By.xpath("//button[contains (@class, 'btn-primary')]"));
     //   loginButton.click();

    }
}





