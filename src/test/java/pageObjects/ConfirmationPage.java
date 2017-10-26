package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.Utils;

public class ConfirmationPage extends BaseServicePage {
    public ConfirmationPage(WebDriver driver) {
        super(driver);
        try {
            getContinueBtn();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Continue button is not present. Considering that this is not confirmation page", e);
        }
    }

    By continueBtnLocator = By.cssSelector("[class ='bo-ev-lb btn waves-effect waves-light']");

    @Step("Click on continue click")
    public BookingPage continueBtnClick() throws InterruptedException {
        WebElement btn = getContinueBtn();
        Utils.waitForCertainTime(500); //TODO: Continue button is not clickable without delay
        btn.click();
        return new BookingPage(driver);
    }

    private WebElement getContinueBtn() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(continueBtnLocator));
    }
}
