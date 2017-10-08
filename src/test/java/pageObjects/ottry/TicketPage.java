package pageObjects.ottry;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import utils.core.BasePage;

public class TicketPage extends BasePage {

    public TicketPage(WebDriver driver) {
        super(driver);

        //Check that we`re on the right page and it is loaded.
        try {
            driver.switchTo().frame(driver.findElement(iframeLocator));
            getGoBtn();
        } catch (ElementNotFoundException e) {
            throw new IllegalStateException("Ticket page is not loaded", e);
        } catch (TimeoutException e) {
            throw new IllegalStateException("Ticket page is not loaded", e);
        }
    }

    By iframeLocator = By.cssSelector("[src*='booking.ottry.com']");
    By inlineServiceElementLocator = By.cssSelector("[id='inlineServiceElement']");
    By goBtnLocator = By.cssSelector("[class='bo-ev-nb btn waves-effect waves-light']");
    By endpointSelectorLocator = By.cssSelector("[id='bo-ev-endpoint']");
    By phoneFieldLocator = By.cssSelector("[id='bo-av-592e72b926b2458726557d7f']");
    By emailFieldLocator = By.cssSelector("[id='bo-ev-email']");
    By commentFieldLocator = By.cssSelector("[id='bo-ev-textarea']");


    public WebElement getGoBtn() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(goBtnLocator));
    }

    public WebElement inlineServiceElement() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(inlineServiceElementLocator));
    }

    public WebElement getEndpointSelector() {
        return driver.findElement(endpointSelectorLocator);
    }

    public WebElement getPhoneField() {
        return driver.findElement(phoneFieldLocator);
    }

    public WebElement getEmailField() {
        return driver.findElement(emailFieldLocator);
    }

    public WebElement getCommentField() {
        return driver.findElement(commentFieldLocator);
    }

    @Step("Select endpoint")
    public TicketPage selectEndpoint(String endpoint) {
        //getEndpointSelector().;
        return this;
    }

    @Step("Enter phone number")
    public TicketPage fillPhoneField(String phone) {
        getPhoneField().sendKeys(phone);
        return this;
    }

    @Step("Enter email")
    public TicketPage fillEmailField(String email) {
        getEmailField().sendKeys(email);
        return this;
    }

    @Step("Enter comment")
    public TicketPage fillCommentField(String comment) {
        getCommentField().sendKeys(comment);
        return this;
    }

    @Step("Click on Go button")
    public TicketPage goBtnClick() {
        getGoBtn().click();
        return this;
    }

}


