package utils.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.IHookCallBack;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static utils.Utils.takeScreenShot;

/**
 * Created with IntelliJ IDEA.
 * User: glebeda
 * Date: 05.07.16
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations={"classpath:spring/spring-config.xml"})

public abstract class BaseTest extends AbstractTestNGSpringContextTests {
    protected WebDriver driver;

    @Autowired
    public Config config;

    @BeforeClass
    protected void initialize() {

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", false);

        driver = new FirefoxDriver(capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    protected void navigateToApplication() {
        driver.get(config.getBaseURL());
    }

    //needed for screenshot capture
    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {

        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
            try {
                takeScreenShot(driver);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }
}
