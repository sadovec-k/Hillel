import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.Locatable;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class userTest {
    WebDriver driver;
    String user1 = "newUser1";
    String phone1 = "000 111 22 33";
    String user2 = "newUser2";
    String phone2 = "000 444 55 66";

    void sleep(int sleepTime) throws InterruptedException{
        try{
            Thread.sleep(sleepTime); }
            catch (InterruptedException e){}
    }

    boolean doesElementExist(String name){
        try{
            ((Locatable)driver.findElement(By.xpath("//*[text()='"+name+"']"))).getCoordinates();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException exceptionObject){
            return false;
            }
    }

    void enterUserData(String name, String phone){
            WebElement enterName = driver.findElement(By.id("icon_prefix"));
                enterName.clear();
                enterName.sendKeys(name);
            WebElement enterPhone = driver.findElement(By.id("icon_telephone"));
                enterPhone.clear();
                enterPhone.sendKeys(phone);
        }

    @BeforeTest
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://soft.it-hillel.com.ua:3000/");
    }

    @Test(groups ={"editUser"}, priority = 1, description = "Create new user")
    void addUser() throws InterruptedException {
            sleep(2000);
        driver.findElement(By.className("mdi-content-add")).click();
        enterUserData(user1,phone1);
        driver.findElement(By.xpath("//*[text()='Create']")).click();
            sleep(2000);
        Assert.assertTrue(doesElementExist(user1));
        }

    @Test(groups ={"editUser"}, priority = 2, dependsOnMethods = {"addUser"}, description = "Edit user")
    void editUser() throws InterruptedException {
            sleep(2000);
        driver.findElement(By.xpath("//*[text()='" + user1 + "']")).click();
        enterUserData(user2, phone2);
        driver.findElement(By.xpath("//*[text()='Save']")).click();
            sleep(2000);
        Assert.assertTrue(doesElementExist(user2));
    }

    @Test(priority = 3, dependsOnGroups = {"editUser"}, description = "Delete user")
    void deleteUser() throws InterruptedException {
            sleep(2000);
        WebElement user = driver.findElement(By.xpath("//*[@id=\"user-list\"]/li[last()]"));
        user.findElement(By.className("secondary-content")).click();
        driver.switchTo().alert().accept();
            sleep(2000);
        Assert.assertFalse(doesElementExist(user2));
    }

    @AfterTest
    void quit()throws InterruptedException {
        driver.quit();
    }
}