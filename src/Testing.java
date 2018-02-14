
import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Testing
{
    private WebDriver webDriver;
    private static final String BASE_URL = "http://automationpractice.com/index.php";
    private static ExtentReports myReport;

    @BeforeClass // Open variables (URL) (RUNS BEFORE VERY TEST)
    public static void before()
    {
        myReport = new ExtentReports();  //Creating my report
        String fileName = "MyTestReport" + ".html"; //Report file
        String filePath = System.getProperty("user.dir") + File.separatorChar + fileName; //seperate char because to do a gap is different in diff OS
        myReport.attachReporter(new ExtentHtmlReporter(filePath));
    }


    @Before // Open variables (URL) (RUNS BEFORE VERY TEST)
    public void setUp()
    {
        webDriver = new ChromeDriver();
        webDriver.navigate().to(BASE_URL);

        System.out.println("Were ready for the test");

    }


    @Test//Whatever your test needs to do (MULTIPLE)
    public void signIn()
    {
        HomePageControl navHomepage = PageFactory.initElements(webDriver, HomePageControl.class);
        SignInControl signInContol = PageFactory.initElements(webDriver, SignInControl.class);
        ExtentTest test = myReport.createTest("Sign In Test");
        test.log(Status.INFO, "Test Begins ");

        try {TimeUnit.MILLISECONDS.sleep(500); }
        catch(InterruptedException e) { e.printStackTrace(); }

        navHomepage.selectSignIn();
        test.log(Status.DEBUG,  "Selected Sign In Page");


        signInContol.enterEmail();
        test.log(Status.DEBUG,  "Entered Email");

        signInContol.enterPassword();
        test.log(Status.DEBUG,  "Entered Password");


        signInContol.selectSignIn();
        test.log(Status.DEBUG,  "Selected Sign In");


        System.out.println(signInContol.checkLoggedIn());

        if (signInContol.myUser != null && signInContol.myUser == signInContol.myUser)
        {
            test.pass("You Have logged in successfully");
        }
        else
        {
            test.fail("You Have NOT logged in successfully");
        }



    }

    @Test//Whatever your test needs to do (MULTIPLE)
    public void signOutPass()
    {
        HomePageControl navHomepage = PageFactory.initElements(webDriver, HomePageControl.class);
        SignInControl signInContol = PageFactory.initElements(webDriver, SignInControl.class);
        ExtentTest test = myReport.createTest("Sign In Test");
        test.log(Status.INFO, "Test Begins ");

        try {TimeUnit.MILLISECONDS.sleep(500); }
        catch(InterruptedException e) { e.printStackTrace(); }

        navHomepage.selectSignIn();
        test.log(Status.DEBUG,  "Selected Sign In Page");


        signInContol.enterEmail();
        test.log(Status.DEBUG,  "Entered Email");

        signInContol.enterPassword();
        test.log(Status.DEBUG,  "Entered Password");


        signInContol.selectSignIn();
        test.log(Status.DEBUG,  "Selected Sign In");

        signInContol.signOut();
        test.log(Status.DEBUG,  "Selected Sign Out");
        try {TimeUnit.MILLISECONDS.sleep(500); }
        catch(InterruptedException e) { e.printStackTrace(); }
        try
        {
            Camera.take(webDriver, "TestPassed");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


    }

    @Test//Whatever your test needs to do (MULTIPLE)
    public void signOutFail()
    {
        SignInControl signInContol = PageFactory.initElements(webDriver, SignInControl.class);
        signInContol.signOut();
        ExtentTest test = myReport.createTest("Sign In Test");
        test.log(Status.INFO, "Test Begins ");

        test.log(Status.DEBUG,  "Selected Sign Out");
        try {TimeUnit.MILLISECONDS.sleep(500); }
        catch(InterruptedException e) { e.printStackTrace(); }
        try
        {
            Camera.take(webDriver, "Test Failed");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        test.log(Status.DEBUG,  "The sign out buttons css has been replaced with contact page until you sign in");
        test.log(Status.DEBUG,  "You are navigated to contacts page");
        test.pass("You cannot log out before you log in");
    }

    @Test//Whatever your test needs to do (MULTIPLE)
    public void sortByBarTest()
    {
        HomePageControl navHomepage = PageFactory.initElements(webDriver, HomePageControl.class);
        //DressesPageControl dressesHomePage = DressesPageControl.initElements(webDriver, DressesPageControl.class);
        navHomepage.selectDresses();

    }




    @After //clean up any of the connections etc (RUNS AFTER EVERY TEST)
    public void cleanUp()
    {
        webDriver.quit();
    }

    @AfterClass
    public static void flushAway()
    {
        myReport.flush();
    }

}
