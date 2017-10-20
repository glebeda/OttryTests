package pageObjects.ottry.ticket;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ottry.BaseServicePage;
import ru.yandex.qatools.allure.annotations.Step;
import testDataConstructors.BookingData;

public class TicketPage extends BaseServicePage<TicketPage> {

    public TicketPage(WebDriver driver) {
        super(driver);
        try {
            getGoBtn();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Go button is not present. Considering that this is not a ticket page", e);
        }
    }

    By phoneFieldLocator = By.cssSelector("[id='bo-av-592e72b926b2458726557d7f']");
    By emailFieldLocator = By.cssSelector("[id='bo-ev-email']");
    By commentFieldLocator = By.cssSelector("[id='bo-ev-textarea']");

    private WebElement getPhoneField() {
        return driver.findElement(phoneFieldLocator);
    }

    private WebElement getEmailField() {
        return driver.findElement(emailFieldLocator);
    }

    private WebElement getCommentField() {
        return driver.findElement(commentFieldLocator);
    }

    @Step("Click on Go button")
    public ConfirmationPage goBtnClick() {
        super.goBtnClickGeneral();
        return new ConfirmationPage(driver);
    }

    @Step("Enter phone number")
    public TicketPage fillPhoneField(String phone) {
        getPhoneField().sendKeys(phone);
        return this;
    }

    @Step("Enter email")
    public TicketPage fillEmailField(String email) {
        getEmailField().sendKeys(email);
        return this;
    }

    @Step("Enter comment")
    public TicketPage fillCommentField(String comment) {
        getCommentField().sendKeys(comment);
        return this;
    }

    @Step("Book a ticket")
    public TicketPage bookTicket(BookingData data) throws InterruptedException {
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


