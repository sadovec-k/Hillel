package Pages;

import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends Tools {
    private String Login_URL = "https://www.google.com/drive/";
    private String enterButton = "//a[contains(@href,'ServiceLogin')][@data-g-action='Intro']";
    private String LOGIN = "testusermail2017@gmail.com";
    private String PASS = "Password11";
    private String enterEmailField = "identifier";
    private String enterPassField = "password";
    private String passEnterButton = "passwordNext";
    private String emailEnterButton = "identifierNext";
    private String outButton = "//a[contains(@href,'SignOutOption')]";

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void doLogin(String PASS){
        driver.get(Login_URL);
        sleep(2);
        driver.findElement(By.xpath(enterButton)).click();
        sleep(2);
        driver.findElement(By.name(enterEmailField)).sendKeys(LOGIN);
        sleep(1);
        driver.findElement(By.id(emailEnterButton)).click();
        driver.findElement(By.name(enterPassField)).sendKeys(PASS);
        sleep(2);
        driver.findElement(By.id(passEnterButton)).click();
        sleep(2);
    }

    public void successLogin (){
        doLogin(PASS);
        Assert.assertTrue(driver.findElement(By.xpath(outButton)).isEnabled());
    }

    public void unsuccessfulLogin (){
        doLogin("123321");
        Assert.assertTrue(driver.findElement(By.name(enterPassField)).isEnabled());
    }
}