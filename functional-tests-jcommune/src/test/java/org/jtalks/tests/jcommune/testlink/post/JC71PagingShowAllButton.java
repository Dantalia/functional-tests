package org.jtalks.tests.jcommune.testlink.post;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.StringHelp;

import java.util.ArrayList;

import static org.jtalks.tests.jcommune.assertion.Existance.assertionContainsStringInList;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.*;


/**
 * @author masyan
 */
public class JC71PagingShowAllButton {

    @BeforeMethod(alwaysRun = true, enabled = false)
    @Parameters({"app-url", "uUsername", "uPassword"})
    public void setupCase(String appUrl, String username, String password) {
        driver.get(appUrl);
        signIn(username, password);
        clickOnRandomBranch();
        createTopicForTest();
        createAnswerForTest(StringHelp.getRandomString(10));
        createAnswerForTest(StringHelp.getRandomString(10));
        createAnswerForTest(StringHelp.getRandomString(10));
        createAnswerForTest(StringHelp.getRandomString(10));
        createAnswerForTest(StringHelp.getRandomString(10));
        createAnswerForTest(StringHelp.getRandomString(10));
        System.out.println(driver.getCurrentUrl());
    }

    @AfterMethod(alwaysRun = true, enabled = false)
    @Parameters({"app-url"})
    public void destroy(String appUrl) {
        logOut(appUrl);
    }

    @Test(enabled = false)
    public void pagingShowAllButtonTest() {
        postPage.getShowAllButton().click();
        ArrayList list = new ArrayList<String>();
        list.add("Show pages");
        list.add("Next topic");
        for (WebElement el : postPage.getPagesButtons()) {
            assertionContainsStringInList(list, el.getText());
        }
    }


}