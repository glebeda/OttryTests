package tests.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.ticket.TicketStartPage;
import testDataConstructors.BookingData;
import utils.core.BaseTest;
import io.qameta.allure.*;

import static utils.Utils.verifyBookingOnMerchantPage;

@Feature("ottry ticket booking")

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

    @Description("Complete ticket booking")
    @Story("ID-12")
    @Test
    public void ticketBooking() throws InterruptedException {
        page.bookTicket(ticketSmokeBooking);
        verifyBookingOnMerchantPage(ticketSmokeBooking, driver, config);
    }

    @Description("Pending ticket booking")
    @Story("ID-12")
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
