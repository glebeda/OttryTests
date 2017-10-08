package pageObjects.google;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import utils.core.BasePage;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
        //Check that we`re on the right page.
        try {
            getResultState();
        } catch (TimeoutException e) {
            throw new IllegalStateException("This is not the google result page!", e);
        }
    }

    By resultStatelocator = By.cssSelector("[id='resultStats']");

    private WebElement getResultState() {
        return new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(resultStatelocator));
    }

    @Step("Check result state displayed property")
    public Boolean getResultStatedDisplayedProperty() {
        return getResultState().isDisplayed();
    }

}
