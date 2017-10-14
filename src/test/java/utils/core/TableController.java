package utils.core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TableController{

    By tableRowsLocator = By.xpath("//*//tr");
    By headerLocator = By.xpath("//th");
    By uniqueCells = By.xpath(".//*/td[1]");
    By tableRows = By.xpath("//tbody/tr");
    By singleCell = By.xpath("td");

    private static final String FIRST_CELL_IN_THE_ROW_PLACEHOLDER = "//tbody//tr[%1$d]//td[1]";
    private static final String SINGLE_ROW_PLACEHOLDER = "//tbody//tr[%1$d]";
    private static final String SINGLE_CELL_PLACEHOLDER = "//tbody//tr[%1$d]//td[%2$d]";

    private List<WebElement> getRows(WebElement table) {
        return table.findElements(tableRowsLocator);
    }

    public WebElement getTableCell(WebElement table, String rowName, String columnName) {
        Integer rowIndex = getRowIndexByName(table, rowName);
        Integer columnIndex = getColumnIndexByName(table, columnName);
        return getTableCell(table, rowIndex, columnIndex);
    }

    public WebElement getTableCell(WebElement table, String rowName, int columnIndex) {
        Integer rowIndex = getRowIndexByName(table, rowName);
        return getTableCell(table, rowIndex, columnIndex);
    }

    private WebElement getTableCell(WebElement table, int rowIndex, int columnIndex) {
        String cellXPath = String.format(SINGLE_CELL_PLACEHOLDER, rowIndex+1, columnIndex);
        WebElement cell = table.findElement(By.xpath(cellXPath));
        return cell;
    }

    public WebElement getDetailsTableCell(WebElement table, String rowName) {
        WebElement cell = table.findElement(By.xpath(String.format(FIRST_CELL_IN_THE_ROW_PLACEHOLDER, getRowIndexByDetailsHeader(table, rowName))));
        return cell;
    }

    public void clickOnCell(WebElement table, String rowName, String columnName) {
        getTableCell(table, rowName, columnName).click();
    }

    public void validateCellValue(WebElement table, String rowName, String columnName, String cellText) {
        Assert.assertEquals(cellText, getTableCell(table, rowName, columnName).getText());
    }

    public void validateDetailsCellValue(WebElement table, String rowName, String cellText) {
        Assert.assertEquals(cellText, getDetailsTableCell(table, rowName).getText());
    }

    private int getColumnIndexByName(WebElement table, String columnName) {
        assert columnName != null;

        List<WebElement> tableRows = getRows(table);
        WebElement header = tableRows.get(0);
        List<WebElement> headerCells = header.findElements(headerLocator);
        int columnIndex = 0;
        for (int i = 0; i < headerCells.size(); i++) {
            String headerValue = headerCells.get(i).getText();
            if (columnName.equals(headerValue)) {
                columnIndex = i+1;
                break;
            }
        }
        return columnIndex;
    }

    private int getRowIndexByName(WebElement table, String rowName) {
        Integer rowsCount = table.findElements(tableRows).size();
        for (int i = 0; i < rowsCount; i++) {
            String rowValue = table.findElement(By.xpath(String.format(FIRST_CELL_IN_THE_ROW_PLACEHOLDER, i+1))).getText();
            if (rowValue.equals(rowName)) {
                return i;
            }
        }
        throw new NoSuchElementException("Row index not found!!!");
    }

    private int getRowIndexByDetailsHeader(WebElement table, String rowName) {
        int rowIndex = 0;
        List<WebElement> rows = table.findElements(headerLocator);
        for (int i = 0; i < rows.size(); i++) {
            String rowValue = rows.get(i).getText();
            if (rowValue.equals(rowName)) {
                rowIndex = i+1;
                break;
            }
        }
        return rowIndex;
    }

    public void verifyRowValues(WebElement table, String rowName, List<String> values){
        List<WebElement> rowCells = table.findElement(By.xpath(String.format(SINGLE_ROW_PLACEHOLDER, getRowIndexByName(table, rowName)+1))).findElements(singleCell);

        for (int i = 0; i <= values.size()-1; i++) {
            Assert.assertEquals(rowCells.get(i).getText().trim(), values.get(i));
        }
    }

    public void verifyDetailsRowValues(WebElement table, List<String> values){
        List<WebElement> rowCells = table.findElements(uniqueCells);


        for (int i = 0; i <= values.size()-1; i++) {
            Assert.assertEquals(rowCells.get(i).getText().trim(), values.get(i));
        }
    }

    public boolean verifyIsRowPresent(WebElement table, String rowName) {
        Integer rows = table.findElements(uniqueCells).size();
        for (int i = 0; i < rows; i++) {
            String elementValue = table.findElement(By.xpath(String.format(FIRST_CELL_IN_THE_ROW_PLACEHOLDER, i+1))).getText();
            if (elementValue.equals(rowName)) {
                return true;
            }
        }
        return false;
    }

}