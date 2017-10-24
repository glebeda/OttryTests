package utils;

import org.openqa.selenium.*;
import pageObjects.merchant.MerchantBookOrderPage;
import pageObjects.merchant.MerchantLoginPage;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import testDataConstructors.BookingData;
import utils.core.Config;

import java.io.IOException;

/**
 * Created by glebeda on 15.07.2016.
 */
public class Utils {

    @Step("Verify that booking has correct state on Merchant book order page")
    public static void verifyBookingOnMerchantPage(BookingData booking, WebDriver driver, Config config) {
        MerchantLoginPage merchantLoginPage = new MerchantLoginPage(driver, config);
        MerchantBookOrderPage bookOrderPage = merchantLoginPage.loginToMerchant().
                bookOrderClick();
        assert bookOrderPage.getFirstRowEmail().equalsIgnoreCase(booking.getEmail()) : "Book order is not present in the first row. Email for booking = " + booking.getEmail();
        assert bookOrderPage.getFirstRowStatus().equalsIgnoreCase(booking.getStatus()) : "Book order status is wrong. Expected: " + booking.getStatus();
    }

    public static void scrollIntoView(WebDriver driver, WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitForCertainTime(500);
    }

    @Attachment(value = "Test Screenshot", type = "image/png")
    public static byte[] takeScreenShot(WebDriver driver) throws IOException {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void waitForCertainTime(int mSeconds) throws InterruptedException {
        Thread.sleep(mSeconds);
    }

}
