package pageObjects.google;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import utils.core.BasePage;


/**
 * Created with IntelliJ IDEA.
 * User: glebeda
 * Date: 06.07.16
 * Time: 15:03
 * To change this template use File | Settings | File Templates.
 */

public class GooglePage extends BasePage {

    public GooglePage(WebDriver driver) {
        super(driver);

        //Check that we`re on the right page.
        try {
            getSearchInput();
        } catch (TimeoutException e) {
            throw new IllegalStateException("This is not the google page!", e);
        }
    }

    By searchInput = By.cssSelector("[id='lst-ib']");
    By searchButtonLocator = By.cssSelector("[name='btnK']");

    @Step("Search in google")
    public SearchResultPage search(String searchStr) {
        WebElement search = getSearchInput();
        search.click();
        getSearchInput().sendKeys(searchStr);
        return searchButtonClick();
    }

    private WebElement getSearchButton() {
        return driver.findElement(searchButtonLocator);
    }

    private SearchResultPage searchButtonClick() {
        //TODO: this method needs to be reworked
        //getSearchButton().click(); not stable solution because of dropdown
        getSearchInput().sendKeys(Keys.RETURN);
        return new SearchResultPage(driver);
    }

/*
    @Step("Check google field displayed property")
    public Boolean getLoginFieldDisplayedProperty() {
        return getLoginField().isDisplayed();
    }

    @Step("Check password field displayed property")
    public Boolean getPassFieldDisplayedProperty() {
        return getPasswordField().isDisplayed();
    }

    @Step("Check google button displayed property")
    public Boolean getLoginBtnDisplayedProperty() {
        return getLoginBtn().isDisplayed();
    }

    @Step("Login Into Application")
    public DashboardPage loginIntoApplication(String username, String password) throws InterruptedException {
        typeLogin(username);
        typePassword(password);
        return loginBtnClick();
    }

    @Step("Login Into Application expecting error")
    public GooglePage loginIntoApplicationExpectingError(String username, String password) throws InterruptedException {
        typeLogin(username);
        typePassword(password);
        return loginBtnClickExpectingError();
    }

    @Step("Login button click expecting error")
    public GooglePage loginBtnClickExpectingError() throws InterruptedException {
        WebElement loginBtn = getLoginBtn();
        loginBtn.click();
        Utils.waitForCertainTime(3000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(loginBtn));
        return this;
    }

    @Step("Login button click")
    public DashboardPage loginBtnClick() throws InterruptedException {
        getLoginBtn().click();
        Utils.waitForCertainTime(3000);
        return new DashboardPage(driver);
    }
	
    @Step("Enter password")
    public GooglePage typePassword(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
        return this;
    }

    @Step("Check google button enabled property")
    public boolean getLoginBtnEnabledProperty() {
        return getLoginBtn().isEnabled();
    }

    @Step("Enter google")
    public GooglePage typeLogin(String username) {
        getLoginField().clear();
        getLoginField().sendKeys(username);
        return this;
    }

    public WebElement getErrorMessage() {
        return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
    }

    public WebElement getLoginField() {
        return driver.findElement(loginFieldLocator);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passFieldLocator);
    }
*/

    private WebElement getSearchInput() {
        return new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(searchInput));
    }
/*
    @Step("CleanUp all google fields")
    public void cleanupAllFields() {
        getLoginField().clear();
        getPasswordField().clear();
    }
    @Step("Verify that user name is displayed")
    public void verifyLoggedUserName(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        Assert.assertEquals(driver.findElement(fullNameLocator).getText(), fullName);
    }*/
}

