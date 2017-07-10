import org.testng.Assert;
import webDriver.driver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class Tests {
    driver myDriver;

    @DataProvider(name = "TestData")
    public Object[][] createData(){
        return new Object[][] {
                {1, 99,  Boolean.TRUE},
        };
    }

    @DataProvider(name = "FalseData")
    public Object[][] falseData(){
        return new Object[][] {
                {99, 1,  Boolean.FALSE},
                {1, 1,  Boolean.FALSE},
        };
    }

    @BeforeTest
    void setUp(){
        System.out.println("Created Object");
        myDriver = new driver();
    }

    @org.testng.annotations.Test(dataProvider = "TestData", description = "Test for Random generator")
    void Positive(int testMin, int testMax, Boolean expectedResult) throws InterruptedException {
        System.out.println(testMin +" " + testMax);
        Assert.assertEquals( (Boolean) myDriver.generator(testMin, testMax), expectedResult,"Bad input ");

    }
    @org.testng.annotations.Test(dataProvider = "FalseData", description = "Test for Random generator")
    void Negative(int testMin, int testMax, Boolean expectedResult) throws InterruptedException {
        System.out.println(testMin +" " + testMax);
        Assert.assertEquals( (Boolean) myDriver.generator(testMin, testMax), expectedResult,"Bad input ");
    }
}
