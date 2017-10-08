package tests.google;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.google.GooglePage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;
import testDataConstructors.SearchRequestData;
import utils.core.BaseTest;
import utils.core.Config;

import javax.naming.directory.SearchResult;
import java.io.IOException;



/**
 * Created with IntelliJ IDEA.
 * User: glebeda
 * Date: 06.07.16
 * Time: 15:21
 * To change this template use File | Settings | File Templates.
 */
@Features("Google search page")
@Title("Search test suite")

public class GoogleTS extends BaseTest {
    private GooglePage page;

    @Autowired
    private SearchRequestData webdriverSearch;

    @BeforeMethod
    public void setUp() {
        page = new GooglePage(driver);
    }

    @TestCaseId("ID-3417")
    @Title("Search for something")
    @Stories("ID-1700")
    @Test
    public void searchTest() throws IOException {
        System.out.println("We`ve done it, Man! Lets start the test...");
        assert(page.search(webdriverSearch.getSearchRequest()).getResultStatedDisplayedProperty());
    }

    @TestCaseId("ID-3418")
    @Title("Second test")
    @Stories("ID-1700")
    @Test
    public void negativeTest() throws InterruptedException {
        System.out.println("Just an empty test");
        //Assert.assertTrue(false, "Wow, something went wrong.");
    }

}

