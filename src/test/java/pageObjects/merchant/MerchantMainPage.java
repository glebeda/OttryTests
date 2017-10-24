package pageObjects.merchant;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import utils.core.BasePage;

public class MerchantMainPage extends BasePage {
    public MerchantMainPage(WebDriver driver) {
        super(driver);
        try {
            getBookOrder();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Book order field is not present. It is not main merchant page", e);
        }
    }

    By bookOrderLocator = By.cssSelector("[href='/management/bookorder");

    private WebElement getBookOrder() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(bookOrderLocator));
    }

    @Step("Click on book order button")
    public MerchantBookOrderPage bookOrderClick() {
        getBookOrder().click();
        return new MerchantBookOrderPage(driver);
    }
}
