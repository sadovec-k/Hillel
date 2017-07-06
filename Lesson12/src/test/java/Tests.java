import Lesson12.Lesson12;
import org.testng.ITestResult;
import org.testng.annotations.*;

import org.testng.Assert;


public class Tests {
    Lesson12 myValidator;

    @DataProvider(name = "TestData")
    public Object[][] createData(){
        return new Object[][] {
                {"6000", Boolean.TRUE},
                {"6000,1", Boolean.FALSE},
                {"6000,10000", Boolean.TRUE},
                {"6000.10", Boolean.TRUE}
        };
    }

    @DataProvider(name = "TestEmails")
    public Object[][] eMails(){
        return new Object[][] {
                {"Example@gmail.com", Boolean.TRUE},
                {"@gmail.com", Boolean.FALSE},
                {"example1@gmail.com,example2@gmail.com", Boolean.TRUE},
                {"Example1@gmail.com,example2@yahoo.com", Boolean.FALSE}
        };
    }

    @DataProvider(name = "newEmails")
    public Object[][] newEmails(){
        return new Object[][] {
                {"Example@gmail.com", new String("Example@gmail.com")},
                {"example@mail.ru", "example@gmail.com"},
                {"example1@gmail.com,example2@gmail.com", "example1@gmail.com,example2@gmail.com"},
                {"Example1@gmail.com,example2@mail.ru", "Example1@gmail.com,example2@gmail.com"}
        };
    }

    @BeforeTest
    void setUp(){
        System.out.println("Created Object");
        myValidator = new Lesson12();
    }

        @Test(dataProvider = "TestData", description = "Test for Numbers Validation")
        void Positive(String testString, Boolean expectedResult){
        System.out.println(testString);
        Assert.assertEquals( (Boolean) myValidator.numbers(testString), expectedResult,"Bad input " + testString);
        }

        @Test(dataProvider = "TestEmails", description = "Test for Emails Validation")
        void PositiveEmails(String testString, Boolean expectedResult){
        System.out.println(testString);
        Assert.assertEquals( (Boolean) myValidator.emails(testString), expectedResult,"Bad input " + testString);
    }

        @Test(dataProvider = "newEmails", description = "Emails *@mail.ru change to *@gmail.com")
        void ChangeEmails(String testString, String expectedResult){
        System.out.println(testString);
        Assert.assertEquals( (String) myValidator.newEmails(testString), expectedResult,"Bad input " + testString);
    }

        @AfterMethod
        void afterM(ITestResult testResult){
        System.out.println(testResult.isSuccess());
        System.out.println(testResult.getMethod().getDescription());
    }
}