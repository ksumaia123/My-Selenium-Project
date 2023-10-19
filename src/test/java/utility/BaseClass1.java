package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BaseClass1 extends CommonUtility{

  @Parameters("browser")
    @BeforeClass
    public void appInitialize(String browser) throws InterruptedException, IOException {

// Step - Open the Browser


      FileInputStream fs = new FileInputStream("/Users/sumaiar122/IdeaProjects/Selenium_Batch_6/src/test/java/env.properties");

      Properties prop = new Properties();
      prop.load(fs);
      String myURL = prop.getProperty("url");


     // FileOutputStream

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
// System.setProperty("webdriver.chrome.driver","/Users/sumaiar122/IdeaProjects/Selenium_Batch_6/src/main/java");


            driver = new ChromeDriver(); //This will open the browser
        }

        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        else {
            System.out.println("check back your drivers");
        }

// Step-2 Navigate to the URL
        driver.navigate().to(myURL);
        driver.manage().window().maximize();
//        Thread.sleep(4000);
//        driver.navigate().to("https://uprightforum.tech");
//        Thread.sleep(4000);
//        driver.navigate().back();
//        Thread.sleep(4000);
//driver.navigate().forward();


//driver.get("https://uprightautomation.online/registration/");

//        driver.navigate().refresh();

        String myURl = driver.getCurrentUrl();
        if (myURl.equalsIgnoreCase("https://uprightautomation.online/registrati/")) {
            System.out.println("The URL is good");
        }
        else {
            System.out.println("Please check the URL");
        }

            SoftAssert obj = new SoftAssert();
            obj.assertEquals(myURl, "https://uprightautomation.online/registrati/");
         //   Assert.assertEquals(myURl, "https://uprightautomation.online/registrati/");
            String myTitle = driver.getTitle();
            // Assert.assertEquals(myTitle,"Registration-Upright Automation");
            obj.assertEquals(myTitle, "Registration-Upright Automation");





           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            // obj.assertAll();
            // driver.close();


        }

        @AfterClass
    public void tearDown(){
          //  driver.quit();

        }


    }

