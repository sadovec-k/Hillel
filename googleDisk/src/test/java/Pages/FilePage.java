package Pages;

import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FilePage extends Tools {
    String fileName = "idea.png";
    String newButton = "button[aria-label='New']";
    String fileUploadButton = "//div[contains(text(),'File upload')]";
    String filePATH = "D:\\";
    String inputFile = "input[type='file']";
    String fileIco = "//span[contains(text(),'idea.png')]";
    String removeButton = "div[aria-label = 'Remove']";

    public FilePage(WebDriver driver){
        this.driver = driver;
    }
    public void upLoad(){
        driver.findElement(By.cssSelector(newButton)).click();
        sleep(3);
        driver.findElement(By.xpath(fileUploadButton)).click();
        sleep(1);
        driver.findElement(By.cssSelector(inputFile)).sendKeys(filePATH+fileName);
        sleep(5);
    }

    public void upLoadSuccess(){
        upLoad();
        Assert.assertTrue(driver.findElement(By.xpath(fileIco)).isEnabled());
    }

    public void fileDelete(){
        driver.findElement(By.xpath(fileIco)).click();
        driver.findElement(By.cssSelector(removeButton)).click();
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(fileIco)).isEnabled());
    }
}