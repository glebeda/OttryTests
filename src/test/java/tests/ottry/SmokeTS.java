package tests.ottry;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.ottry.merchant.MerchantLoginPage;
import pageObjects.ottry.ticket.TicketPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;
import testDataConstructors.BookingData;
import utils.core.BaseTest;
import utils.core.Config;

@Features("ottry ticket booking")
@Title("Ticket smoke test suite")

public class SmokeTS extends BaseTest {
    private TicketPage page;
    private MerchantLoginPage merchantLoginPage;

    @Autowired
    private BookingData smokeBooking;

    @BeforeMethod
    public void setUp() {
        page = new TicketPage(driver);
    }

    @TestCaseId("ID-1")
    @Title("Ticket booking")
    @Stories("ID-12")
    @Test
    public void ticketBooking() throws InterruptedException {
        /*page.selectEndpoint(smokeBooking.getEndpoint()).
                fillPhoneField(smokeBooking.getPhone()).
                fillEmailField(smokeBooking.getEmail()).
                fillCommentField(smokeBooking.getComment()).
                goBtnClick().
                continueBtnClick().
                bookBtnClick();*/
        page.bookTicket(smokeBooking);
        merchantLoginPage = new MerchantLoginPage(driver);
        merchantLoginPage.loginToMerchant(config.MerchantLogin, config.MerchantPassword);
    }
}
