package pageObjects.ottry;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.core.BasePage;
import utils.core.Config;

public abstract class BaseServicePage extends BasePage {

    public BaseServicePage(WebDriver driver) {
        super(driver);

        //Check that we`re on the right page and it is loaded.
        try {
            //driver.switchTo().frame(getIframe());
        } catch (TimeoutException e) {
            throw new IllegalStateException("Iframe was not found", e);
        } catch (NoSuchFrameException e) {
            System.out.println("Frame is already selected");
        }
    }

    By iframeLocator = By.cssSelector("[src*='booking.ottry.com']");

    public WebElement getIframe() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(iframeLocator));
    }

}
