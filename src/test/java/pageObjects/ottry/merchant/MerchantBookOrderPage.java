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

    public String getFirstRowEmail() {
        TableController tableController = new TableController();
        return tableController.getTableCell(getBookOrderTable(), 1, ColumnName.EMAIL.toString()).getText();
    }

    public String getFirstRowStatus() {
        TableController tableController = new TableController();
        return tableController.getTableCell(getBookOrderTable(), 1, ColumnName.STATUS.toString()).getText();
    }

    private WebElement getBookOrderTable() {
        return driver.findElement(bookOrderTableLocator);
    }

    private enum ColumnName {
        ID("ID"),
        EMAIL("Email"),
        COMMENTS("Comments"),
        TYPE("Type"),
        ORDER_REFERENCE("Order Reference"),
        LOCALE("Locale"),
        STATUS("Status"),
        START("Start"),
        END("End"),
        TICKET_STATUS("Ticket status"),
        CREATED("Created"),
        BUY_PRICE("Buy price");

        private final String text;

        ColumnName(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

}
