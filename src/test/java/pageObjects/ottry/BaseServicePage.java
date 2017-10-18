package pageObjects.ottry;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ottry.ticket.BookingPage;
import ru.yandex.qatools.allure.annotations.Step;
import utils.core.BasePage;

public abstract class BaseServicePage<T extends BaseServicePage> extends BasePage {

    public BaseServicePage(WebDriver driver) {
        super(driver);

        //Check that we`re on the right page and it is loaded.
        if (frameIsNotSelected()) {
            try {
                driver.switchTo().frame(getIframe());
            } catch (TimeoutException e) {
                throw new IllegalStateException("Iframe was not found", e);
            }
        } else System.out.println("Frame is already selected");
    }

    By iframeLocator = By.cssSelector("[src*='booking.ottry.com']");
    By endpointSelectorLocator = By.cssSelector("[id='bo-ev-endpoint']");
    By goBtnLocator = By.cssSelector("[class='bo-ev-sb btn waves-effect waves-light']");

    public WebElement getIframe() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(iframeLocator));
    }

    public WebElement getGoBtn() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(goBtnLocator));
    }

    @Step("Go button click")
    public T goBtnClick() {
        getGoBtn().click();
        return (T)this;
    }

    public WebElement getEndpointSelector() {
        return driver.findElement(endpointSelectorLocator);
    }

    @Step("Select endpoint")
    public T selectEndpoint(String endpoint) {
        Select select = new Select(getEndpointSelector());
        select.selectByVisibleText(endpoint);
        return (T)this;
    }

    private boolean frameIsNotSelected() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        String currentFrame = String.valueOf(jsExecutor.executeScript("return self.name"));
        if (currentFrame.equals("")) {
            return true;
        } else
            return false;
    }
}
