package pageObjects.ottry.merchant;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.core.BasePage;
import utils.core.TableController;

public class MerchantBookOrderPage extends BasePage {

    public static final String EMAIL_TABLE_NAME = "Email";

    public MerchantBookOrderPage (WebDriver driver) {
    super(driver);
        try {
        getCreateBookOrderBtn();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Book order field is not present. It is not main merchant page", e);
        }
    }

    By createBookOrderLocator = By.cssSelector("[href='/management/bookorder/new");
    By bookOrderTableLocator = By.xpath("//table[@class='striped centered']");

    private WebElement getCreateBookOrderBtn() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(createBookOrderLocator));
    }

    public boolean isFirstRowContainsBookOrder(String email) {
        TableController tableController = new TableController();
        WebElement cell = tableController.getTableCell(getBookOrderTable(), 1, EMAIL_TABLE_NAME);
        if (cell.getText().equals(email)) {
            return true;
        } else {
            return false;
        }
    }

    private WebElement getBookOrderTable() {
        return driver.findElement(bookOrderTableLocator);
    }

}
