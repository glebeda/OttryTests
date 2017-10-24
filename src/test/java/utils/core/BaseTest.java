package utils.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
    protected Config config;

    @BeforeClass
    protected void initialize() {
        System.setProperty("webdriver.gecko.driver", "h:\\Projects\\OttryTests\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().window().maximize(); //workaround for Firefox 56. See https://github.com/mozilla/geckodriver/issues/993
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
