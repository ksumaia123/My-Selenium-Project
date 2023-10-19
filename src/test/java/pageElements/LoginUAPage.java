package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginUAPage {
    public LoginUAPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Page elements
    @FindBy(linkText = "Account")
    WebElement accountlocator;

    @FindBy(linkText ="Login")
    WebElement loginlocator;



    //storing page elements
    @FindBy(xpath = "//input[@name ='loginusername']")
    WebElement userNamePath;


    @FindBy(xpath = "//input[@id = 'loginPassword4']")
    WebElement passwordPath;

    @FindBy(xpath = "//input[@class = 'form-control']")
    List<WebElement> emailList;

    @FindBy(xpath = "//button[contains (@class, 'btn-primary')]")
    WebElement loginButtonPath;
    @FindBy(xpath = "")
    WebElement loginTextPath;


    public void clickOnAccount(){
        accountlocator.click();

        // PageFactory
        // all the implementation



   // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    //    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));



}

public void clickOnLogin(){ loginlocator.click();}

//public String getLoginText(){
// String loginText = loginTextPath.getText();
// return loginText;
//}

public boolean loginTextDisplay(){
boolean logintextboolean =loginTextPath.isDisplayed();
 return logintextboolean;
}


public void enterUserName(String user){
        userNamePath.clear();
    userNamePath.sendKeys(user);
}

    public void enterPassWord(String pass){
        passwordPath.clear();
        passwordPath.sendKeys(pass);
    }

    public void emailList(String email){
        List<WebElement> list1 = emailList;
        emailList.get(1).clear();
        emailList.get(1).sendKeys(email);

    }

    public void loginButton(){

    }


}




