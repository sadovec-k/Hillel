package Utils;

import org.openqa.selenium.WebDriver;

public class Tools {

    protected WebDriver driver;
    public void sleep(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
        }
    }
}