package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utility.BaseClass1;

public class RegistrationUATest extends BaseClass1 {



    @Test(groups = {"smoke"}, priority = 1, invocationCount = 3)
    public void enterLastName() throws InterruptedException{
        WebElement lastName = driver.findElement(By.name("inputlname"));
        lastName.sendKeys("khanam");
        // driver.findElement(By.name("inputlname")).sendKeys("khanam");
    // Assert.assertFalse(true);
    }



    @Test(groups ={"Regression"})
    public void enterFirstName() throws InterruptedException{
        driver.findElement(By.name("inputfname")).sendKeys("sumaia");

    }

    @Test(groups = "Regression", priority = 3)
    public void enterUserName() throws InterruptedException{
        driver.findElement(By.name("inputusername")).sendKeys("ksumaia");
       // Assert.assertTrue(false);  //fail test forcefully
    }

    @Test(priority = 4, dependsOnMethods = "enterUserName")
    public void enterEmail() throws InterruptedException{
        driver.findElement(By.name("inputemail")).sendKeys("ksumaia123@gmail.com");
    }
//
//    @Test
//    public void enterPassword() throws InterruptedException{
//        driver.findElement(By.name("inputPassword4")).sendKeys("Learn@1");
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void enterConfirmPassword() throws InterruptedException{
//        driver.findElement(By.name("inputRePassword4")).sendKeys("Learn@1");
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void enterBD() throws InterruptedException{
//        driver.findElement(By.name("inputbirth")).sendKeys("07/01");
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void enterPhoneNumber() throws InterruptedException{
//        driver.findElement(By.name("inputphone")).sendKeys("3478107394");
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void enterAddress() throws InterruptedException{
//        driver.findElement(By.name("inputaddress")).sendKeys("235 layette street");
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void enterCity() throws InterruptedException{
//        driver.findElement(By.name("inputcity")).sendKeys("Dallas");
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void enterZip() throws InterruptedException{
//        driver.findElement(By.name("inputzip")).sendKeys("10472");
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void enterCountry() throws InterruptedException{
//        driver.findElement(By.name("inputcountry")).sendKeys("USA");
//        Thread.sleep(5000);
//    }


    @Test
    public void enterSubmit() throws InterruptedException{
      WebElement submit =  driver.findElement(By.name("inputsubmit"));
      scrollIntoView(submit);
      submit.click();
        Thread.sleep(5000);
    }


    @AfterMethod
    public void captureScreenShotonFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE){
            try {
                screenshot(result.getName() + "png");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }











}
