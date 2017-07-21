import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class uploadFile {
    String email = "rvalek@intersog.de";
    String pass = "welcome2hillel";
    String fileName = "idea.png";
    WebDriver driver;

    void fullSleep(int sleepTime) throws InterruptedException{
        try{
            Thread.sleep(sleepTime); }
        catch (InterruptedException e){}
    }
    void sleep(int sleepTime) throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(sleepTime, TimeUnit.MILLISECONDS);
    }

    boolean doesFileExist(String fileName)throws InterruptedException{
        try{
            fullSleep(5000);
            driver.findElement(By.xpath("//*[text()='" + fileName + "']"));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException exceptionObject){
            return false;
        }
    }
    void login(String email, String pass){
        driver.findElement(By.name("login")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @BeforeTest
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://account.box.com/");
    }

    @Test(description = "Upload file")
    void upLoadFile() throws InterruptedException {
        login(email, pass);
        sleep(2000);
        driver.findElement(By.cssSelector("a[aria-owns='upload-menu']")).click();
        driver.findElement(By.cssSelector("input[type='file']")).sendKeys("D:\\"+fileName);
        Assert.assertTrue(doesFileExist(fileName));
    }

    @AfterTest
    void quit()throws InterruptedException {
        driver.quit();
    }
}