import Pages.FilePage;
import Pages.LoginPage;
import org.testng.ITestResult;
import org.testng.annotations.*;
import TestRail.TestRail;

public class Tests extends ChromeConfig {
    private FilePage filePage;
    private LoginPage loginPage;
    private TestRail myTestRail;
    public int testId = 0;

    @BeforeClass
    protected void prepareTestRail() throws Exception {
        myTestRail = new TestRail();
        myTestRail.start();
    }

    @BeforeTest
    protected void initDrivers(){
        loginPage = new LoginPage(driver);
        filePage = new FilePage(driver);
    }

   @AfterMethod
    protected void reportResult(ITestResult testResult) throws Exception {
       myTestRail.sendResult(testId, testResult.getStatus() );
    }

    @AfterClass
    protected void closeTestRailRun() throws Exception {
        myTestRail.closeRun();
    }

    @Test (description = "Unsuccessfull Login")
    void unsuccessfullLogin(){
        testId = 1;
        loginPage.unsuccessfulLogin();
    }

    @Test(description = "Successful Login")
    void successLogin(){
        testId = 2;
        loginPage.successLogin();
    }

    @Test (description = "Upload file ", dependsOnMethods = {"successLogin"})
    void upLoadFile(){
        testId = 3;
        filePage.upLoadSuccess();
    }

    @Test (description = "Delete File", dependsOnMethods = {"successLogin"})
    void deleteFile(){
        testId = 4;
        filePage.upLoad();
        filePage.fileDelete();
    }
}