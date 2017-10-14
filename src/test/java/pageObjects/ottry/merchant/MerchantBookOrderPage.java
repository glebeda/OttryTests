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

    public boolean verifyBookOrderPresent() {
        TableController tableController = new TableController();
        //WebElement emailCell = tableController.getTableCell(getBookOrderTable(), bookOrderData().getEmail(), EMAIL_TABLE_NAME);
        tableController.getTableCell(getBookOrderTable(), bookOrderData().getEmail(), 1); //need to do the same with rowIndex instead
    }

    private WebElement getBookOrderTable() {
        return driver.findElement(bookOrderTableLocator);
    }

}
