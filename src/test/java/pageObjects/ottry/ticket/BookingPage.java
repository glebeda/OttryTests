package pageObjects.ottry.ticket;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ottry.BaseServicePage;
import ru.yandex.qatools.allure.annotations.Step;

public class BookingPage extends BaseServicePage {

    public BookingPage(WebDriver driver) {
        super(driver);
        try {
            getGoBtn();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Book button is not present. Considering that this is not a booking page", e);
        }
    }

    By bookBtnLocator = By.cssSelector("[class='bo-ev-sb btn waves-effect waves-light']");

}
