package tests.ottry.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.ottry.merchant.MerchantBookOrderPage;
import pageObjects.ottry.merchant.MerchantLoginPage;
import pageObjects.ottry.ticket.TicketStartPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;
import testDataConstructors.BookingData;
import utils.core.BaseTest;

@Features("ottry ticket booking")
@Title("Ticket smoke test suite")

public class TicketSmokeTS extends BaseTest {
    private TicketStartPage page;
    private MerchantLoginPage merchantLoginPage;

    @Autowired
    private BookingData ticketSmokeBooking;

    @Autowired
    private BookingData pendingBooking;

    @BeforeMethod
    public void setUp() {
        page = new TicketStartPage(driver, config);
    }

    @TestCaseId("ID-1")
    @Title("Ticket booking")
    @Stories("ID-12")
    @Test
    public void ticketBooking() throws InterruptedException {
        page.bookTicket(smokeBooking);
        merchantPageVerification(pendingBooking);
    }

    @TestCaseId("ID-2")
    @Title("Pending ticket booking")
    @Stories("ID-12")
    @Test
    public void pendingTicketBooking() throws InterruptedException {
        page.selectEndpoint(pendingBooking.getEndpoint()).
                fillPhoneField(pendingBooking.getPhone()).
                fillEmailField(pendingBooking.getEmail()).
                fillCommentField(pendingBooking.getComment()).
                goBtnClick().
                continueBtnClick();
        merchantPageVerification(pendingBooking);
    }

    private void merchantPageVerification(BookingData booking) {
        merchantLoginPage = new MerchantLoginPage(driver, config);
        MerchantBookOrderPage bookOrderPage = merchantLoginPage.loginToMerchant().
                bookOrderClick();
        assert bookOrderPage.getFirstRowEmail().equalsIgnoreCase(booking.getEmail()) : "Book order is not present in the first row. Email for booking = " + booking.getEmail();
        assert bookOrderPage.getFirstRowStatus().equalsIgnoreCase(booking.getStatus()) : "Book order status is wrong. Expected: " + booking.getStatus();
    }

}
