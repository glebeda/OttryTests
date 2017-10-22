package pageObjects.ottry.ticket;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.ottry.BaseServicePage;
import pageObjects.ottry.ServiceStart;
import ru.yandex.qatools.allure.annotations.Step;
import testDataConstructors.BookingData;
import utils.Utils;
import utils.core.Config;

public class TicketStartPage extends BaseServicePage<TicketStartPage> implements ServiceStart {

    public TicketStartPage(WebDriver driver, Config config) {
        super(driver);
        navigateToPage(config.getTicketURL());
        try {
            getGoBtn();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Go button is not present. Considering that this is not ticekt page", e);
        }
    }

    By phoneFieldLocator = By.cssSelector("[id='bo-av-592e72b926b2458726557d7f']");

    private WebElement getPhoneField() {
        return driver.findElement(phoneFieldLocator);
    }

    @Override
    public void navigateToPage(String URL) {
        driver.get(URL);
        super.switchToIframe();
    }

    @Step("Click on Go button")
    public ConfirmationPage goBtnClick() {
        super.goBtnClickGeneral();
        return new ConfirmationPage(driver);
    }

    @Step("Enter phone number")
    public TicketStartPage fillPhoneField(String phone) {
        getPhoneField().sendKeys(phone);
        return this;
    }

    @Step("Book a ticket")
    public TicketStartPage bookTicket(BookingData data) throws InterruptedException {
        selectEndpoint(data.getEndpoint()).
                fillPhoneField(data.getPhone()).
                fillEmailField(data.getEmail()).
                fillCommentField(data.getComment()).
                goBtnClick().
                continueBtnClick().
                bookBtnClick();
        return this;
    }
}


