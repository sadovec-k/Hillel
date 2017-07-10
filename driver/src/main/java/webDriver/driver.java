package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class driver {
      private String numGen = "1";
      private String numCol = "1";

    public driver(){
    }

    public boolean generator(int min, int max) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://random.org/integers/");

        WebElement num;
        num = driver.findElement(By.name("num"));
        num.clear();
        num.sendKeys(numGen);
        WebElement col;
        col = driver.findElement(By.name("col"));
        col.clear();
        col.sendKeys(numCol);
        WebElement minVal;
        minVal = driver.findElement(By.name("min"));
        minVal.clear();
        minVal.sendKeys(Integer.toString(min));
        WebElement maxVal;
        maxVal = driver.findElement(By.name("max"));
        maxVal.clear();
        maxVal.sendKeys(Integer.toString(max));
        maxVal.submit();
        try{
        WebElement data;
        data = driver.findElement(By.className("data"));
        int rezOfGenaration = Integer.parseInt(data.getText());
        System.out.println(Integer.parseInt(data.getText()));
        boolean rez = false;
        Thread.sleep(2000);
        if (rezOfGenaration <= max && rezOfGenaration >= min){
            rez = true;
        } else {rez = false;}
        driver.quit();
        return rez;}
        catch (org.openqa.selenium.NoSuchElementException exceptionObject) {
            driver.quit();
            return false;
        }
    }
}
