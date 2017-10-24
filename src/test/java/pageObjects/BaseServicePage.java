package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Utils;
import utils.core.BasePage;

import javax.rmi.CORBA.Util;

import static utils.Utils.scrollIntoView;
import static utils.Utils.waitForCertainTime;

public abstract class BaseServicePage<T extends BaseServicePage> extends BasePage {

    public BaseServicePage(WebDriver driver) {
        super(driver);
    }

    By iframeLocator = By.cssSelector("iframe[src*='booking.ottry.com']");
    By endpointSelectorLocator = By.cssSelector("[id='bo-ev-endpoint']");
    By goBtnLocator = By.cssSelector(".input-field.center.col.s12.m12.l6 > button");
    By emailFieldLocator = By.cssSelector("[id='bo-ev-email']");
    By commentFieldLocator = By.cssSelector("[id='bo-ev-textarea']");

    public void switchToIframe(){
        if (frameIsNotSelected()) {
            try {
                driver.switchTo().frame(getIframe());
            } catch (TimeoutException e) {
                throw new IllegalStateException("Iframe was not found", e);
            }
        } else System.out.println("Frame is already selected");
    }

    public WebElement getIframe() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(iframeLocator));
    }

    public WebElement getGoBtn() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(goBtnLocator));
    }

    public void goBtnClickGeneral() {
        scrollIntoView(driver, getGoBtn());
        getGoBtn().click();
    }

    private WebElement getEmailField() {
        return driver.findElement(emailFieldLocator);
    }

    private WebElement getCommentField() {
        return driver.findElement(commentFieldLocator);
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

    @Step("Enter email")
    public T fillEmailField(String email) {
        getEmailField().sendKeys(email);
        return (T)this;
    }

    @Step("Enter comment")
    public T fillCommentField(String comment) {
        getCommentField().sendKeys(comment);
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
