import com.sun.org.apache.xpath.internal.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class googleLogins {
    WebDriver driver;

    @DataProvider(name = "TestData")
    public Object[][] testLogin() {
        return new Object[][]{
                {"sadovec.k@gail.com", " ", Boolean.FALSE},
                {"sadovec.k@gmail.com", "123", Boolean.FALSE},
                {"sadovec.k@gmail.com", "********", Boolean.TRUE},
        };
    }

    @BeforeTest
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "TestData", description = "Login test")
    void positiveTest(String login, String pass, Boolean expectedRezult) throws InterruptedException {
        Assert.assertEquals((Boolean) checkLogin(login, pass), expectedRezult, "Correct login");
    }

    @AfterTest
    void quit()throws InterruptedException {
        driver.quit();
    }

    public boolean checkLogin(String login, String pass) throws InterruptedException {
        driver.manage().deleteAllCookies();
        Thread.sleep(5000);
        driver.get("http://accounts.google.com/");
            WebElement eMail;
                eMail = driver.findElement(By.id("identifierId"));
                eMail.click();
                eMail.sendKeys(login);
            WebElement nextButton;
                nextButton = driver.findElement(By.id("identifierNext"));
                nextButton.click();
        Thread.sleep(5000);
                try {
                    WebElement ePass;
                        ePass = driver.findElement(By.name("password"));
                        ePass.click();
                        ePass.sendKeys(pass);
                    WebElement enterPass;
                        enterPass = driver.findElement(By.id("passwordNext"));
                        enterPass.click();
                    Thread.sleep(5000);
                    try{
                        WebElement img;
                            img = driver.findElement(By.className("DIVANe"));
                        return true;
                    }catch (org.openqa.selenium.NoSuchElementException exceptionObject) {
                        return false;
                    }
                } catch (org.openqa.selenium.NoSuchElementException exceptionObject) {
                    return false;
        }
    }
}