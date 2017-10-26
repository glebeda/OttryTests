package tests.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.cafe.CafeStartPage;
import io.qameta.allure.*;
import testDataConstructors.BookingData;
import utils.core.BaseTest;
import static utils.Utils.verifyBookingOnMerchantPage;

@Feature("ottry cafe booking")

public class CafeSmokeTS extends BaseTest {
    private CafeStartPage page;

    @Autowired
    private BookingData cafeSmokeBooking;

    @Autowired
    private BookingData cafePendingBooking;

    @BeforeMethod
    public void setUp() {
        page = new CafeStartPage(driver, config);
    }

    @Description("Complete cafe table booking")
    @Story("ID-13")
    @Test
    public void cafeTableBooking() throws InterruptedException {
        page.bookTable(cafeSmokeBooking);
        verifyBookingOnMerchantPage(cafeSmokeBooking, driver, config);
    }

    @Description("Pending cafe table booking")
    @Story("ID-13")
    @Test
    public void pendingCafeTableBooking() throws InterruptedException {
        page.selectEndpoint(cafePendingBooking.getEndpoint()).
                fillStartDateField(cafePendingBooking.getStartDate()).
                fillStartTimeField(cafePendingBooking.getStartTime()).
                fillEndDateField(cafePendingBooking.getEndDate()).
                fillEndTimeField(cafePendingBooking.getEndTime()).
                fillEmailField(cafePendingBooking.getEmail()).
                fillCommentField(cafePendingBooking.getComment()).
                goBtnClick().
                continueBtnClick();
        verifyBookingOnMerchantPage(cafePendingBooking, driver, config);
    }
}
