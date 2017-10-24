package tests.ottry.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.ticket.TicketStartPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;
import testDataConstructors.BookingData;
import utils.core.BaseTest;

import static utils.Utils.verifyBookingOnMerchantPage;

@Features("ottry ticket booking")
@Title("Ticket smoke test suite")

public class TicketSmokeTS extends BaseTest {
    private TicketStartPage page;

    @Autowired
    private BookingData ticketSmokeBooking;

    @Autowired
    private BookingData ticketPendingBooking;

    @BeforeMethod
    public void setUp() {
        page = new TicketStartPage(driver, config);
    }

    @TestCaseId("ID-1")
    @Title("Complete ticket booking")
    @Stories("ID-12")
    @Test
    public void ticketBooking() throws InterruptedException {
        page.bookTicket(ticketSmokeBooking);
        verifyBookingOnMerchantPage(ticketSmokeBooking, driver, config);
    }

    @TestCaseId("ID-2")
    @Title("Pending ticket booking")
    @Stories("ID-12")
    @Test
    public void pendingTicketBooking() throws InterruptedException {
        page.selectEndpoint(ticketPendingBooking.getEndpoint()).
                fillPhoneField(ticketPendingBooking.getPhone()).
                fillEmailField(ticketPendingBooking.getEmail()).
                fillCommentField(ticketPendingBooking.getComment()).
                goBtnClick().
                continueBtnClick();
        verifyBookingOnMerchantPage(ticketPendingBooking, driver, config);
    }

}
