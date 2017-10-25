package tests.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.cafe.CafeStartPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;
import testDataConstructors.BookingData;
import utils.core.BaseTest;
import static utils.Utils.verifyBookingOnMerchantPage;

@Features("ottry cafe booking")
@Title("Cafe smoke test suite")

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

    @TestCaseId("ID-3")
    @Title("Complete cafe table booking")
    @Stories("ID-13")
    @Test
    public void cafeTableBooking() throws InterruptedException {
        page.bookTable(cafeSmokeBooking);
        verifyBookingOnMerchantPage(cafeSmokeBooking, driver, config);
    }

    @TestCaseId("ID-4")
    @Title("Pending cafe table booking")
    @Stories("ID-13")
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
