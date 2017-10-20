package tests.ottry.cafe;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.ottry.cafe.CafeStartPage;
import pageObjects.ottry.merchant.MerchantLoginPage;
import pageObjects.ottry.ticket.TicketStartPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;
import utils.core.BaseTest;

@Features("ottry cafe booking")
@Title("Cafe smoke test suite")

public class CafeSmokeTS extends BaseTest {
    private CafeStartPage page;
    private MerchantLoginPage merchantLoginPage;

    @BeforeMethod
    public void setUp() {
        page = new CafeStartPage(driver, config);
    }

    @TestCaseId("ID-3")
    @Title("Cafe booking")
    @Stories("ID-13")
    @Test
    public void cafeBooking() throws InterruptedException {
        page.selectEndpoint("Стол №1").
                fillStartDateField("19.10.2017").
                fillStartTimeField("06:00").
                fillEndDateField("19.10.2017").
                fillEndTimeField("06:30").
                fillEmailField("yaz@yaz.ru").
                fillCommentField("NewComent").
                goBtnClick();

    }
}
