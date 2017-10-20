package utils;

import org.openqa.selenium.*;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;

/**
 * Created by glebeda on 15.07.2016.
 */
public class Utils {

/*    @Step("Login into application if not logged in")
    public static void loginIfNotLoggedIn (WebDriver driver, UserData userData) throws InterruptedException {
        GooglePage loginPage;

        try {
            loginPage = new GooglePage(driver);
        } catch (IllegalStateException e) {
            System.out.println("Already logged in");
            return;
        }
        loginPage.loginIntoApplication(userData.getLogin(), userData.getPass());

    }*/

    @Attachment(value = "Test Screenshot", type = "image/png")
    public static byte[] takeScreenShot(WebDriver driver) throws IOException {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void waitForCertainTime(int mSeconds) throws InterruptedException {
        Thread.sleep(mSeconds);
    }

}
