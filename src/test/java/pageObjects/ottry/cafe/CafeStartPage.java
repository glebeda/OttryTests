package pageObjects.ottry.cafe;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ottry.BaseServicePage;
import pageObjects.ottry.ServiceStart;
import ru.yandex.qatools.allure.annotations.Step;
import utils.core.Config;

public class CafeStartPage extends BaseServicePage<CafeStartPage> implements ServiceStart {

    public CafeStartPage(WebDriver driver, Config config) {
        super(driver);
        try {
            getObBtn();
        } catch (TimeoutException e) {
            System.out.println("Seems that cafe page is not displayed. Trying to navigate...");
            navigateToPage(config.getCafeURL());
        }
        try {
            getObBtn();
        } catch (TimeoutException e) {
            throw new IllegalStateException("OB button is not present after navigation attempt. Cafe page is not loaded", e);
        }
        try {
            obBtnClick();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Service is not loaded.", e);
        }
    }

    By obBtnLocator = By.xpath("//button[@class='bo-sbv-b btn waves-effect waves-light']");
    By startDateLocator = By.cssSelector("[id='bo-tv-di-start']");
    By startTimeLocator = By.cssSelector("[id='bo-tv-ti-start']");
    By endDateLocator = By.cssSelector("[id='bo-tv-di-end']");
    By endTimeLocator = By.cssSelector("[id='bo-tv-ti-end']");

    @Override
    public void navigateToPage(String URL) {
        driver.get(URL);
    }

    @Override
    public BaseServicePage goBtnClick() {
        return null;
    }

    private WebElement getObBtn() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(obBtnLocator));
    }

    private WebElement obBtnClick() {
        getObBtn().click();
        super.switchToIframe();
        return super.getGoBtn();
    }

    private WebElement getStartDateField() {
        return driver.findElement(startDateLocator);
    }

    private WebElement getStartTimeField() {
        return driver.findElement(startTimeLocator);
    }

    private WebElement getEndDateField() {
        return driver.findElement(endDateLocator);
    }

    private WebElement getEndTimeField() {
        return driver.findElement(endTimeLocator);
    }

    @Step("Enter start Date")
    public CafeStartPage fillStartDateField(String startDate) {
        getStartDateField().sendKeys(startDate);
        return this;
    }

    @Step("Enter start Time")
    public CafeStartPage fillStartTimeField(String startTime) {
        getStartTimeField().sendKeys(startTime);
        return this;
    }

    @Step("Enter end Date")
    public CafeStartPage fillEndDateField(String endDate) {
        getEndDateField().sendKeys(endDate);
        return this;
    }

    @Step("Enter end Time")
    public CafeStartPage fillEndTimeField(String endTime) {
        getEndTimeField().sendKeys(endTime);
        return this;
    }

}
