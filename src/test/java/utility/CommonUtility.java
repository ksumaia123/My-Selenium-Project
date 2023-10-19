package utility;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITest;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class CommonUtility {
    public WebDriver driver;  //package private/no access. that means it will be avaliable only within the package


    public void screenshot(String fileName) throws IOException {
        TakesScreenshot ss = (TakesScreenshot) driver;   // type casting
        File memoryLocation = ss.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(memoryLocation, new File("/Users/sumaiar122/IdeaProjects/Selenium_Batch_6/src/test/ScreenshotFolder/" + fileName));
    }

    public void captureScreenShotonFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                screenshot(result.getName() + ".png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void JSExecutorScrollHeight() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight");
        Thread.sleep(3000);
      //  js.executeScript("window.scrollBy(document.body.scrollHeight, 0");

    }

    public void jsScrollByNumber(){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
    }

    public void scrollIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("argument[0].scrollIntoView();", element);


    }












}
