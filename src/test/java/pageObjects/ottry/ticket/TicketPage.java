package pageObjects.ottry.ticket;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ottry.BaseServicePage;
import ru.yandex.qatools.allure.annotations.Step;

public class TicketPage extends BaseServicePage {

    public TicketPage(WebDriver driver) {
        super(driver);
        try {
            getGoBtn();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Go button is not present. Considering that this is not a ticket page", e);
        }
    }

    By goBtnLocator = By.cssSelector("[class='bo-ev-nb btn waves-effect waves-light']");
    By endpointSelectorLocator = By.cssSelector("[id='bo-ev-endpoint']");
    By phoneFieldLocator = By.cssSelector("[id='bo-av-592e72b926b2458726557d7f']");
    By emailFieldLocator = By.cssSelector("[id='bo-ev-email']");
    By commentFieldLocator = By.cssSelector("[id='bo-ev-textarea']");

    private WebElement getPhoneField() {
        return driver.findElement(phoneFieldLocator);
    }

    private WebElement getEmailField() {
        return driver.findElement(emailFieldLocator);
    }

    private WebElement getCommentField() {
        return driver.findElement(commentFieldLocator);
    }

    public WebElement getGoBtn() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(goBtnLocator));
    }

    public WebElement getEndpointSelector() {
        return driver.findElement(endpointSelectorLocator);
    }

    @Step("Select endpoint")
    public TicketPage selectEndpoint(String endpoint) {
        Select select = new Select(getEndpointSelector());
        select.selectByVisibleText(endpoint);
        return this;
    }

    @Step("Click on Go button")
    public ConfirmationPage goBtnClick() {
        getGoBtn().click();
        return new ConfirmationPage(driver);
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
}


