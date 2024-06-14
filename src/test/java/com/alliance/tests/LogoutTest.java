/**
 * @author Swetambari
 */

package com.alliance.tests;

import com.alliance.annotations.FrameworkAnnotation;
import com.alliance.enums.AuthorType;
import com.alliance.enums.CategoryType;
import com.alliance.pages.LoginPage;
import com.alliance.testdata.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @FrameworkAnnotation(author = {AuthorType.SWETAMBARI},
            category = { CategoryType.SANITY, CategoryType.REGRESSION})
    @Test(groups = {"BVT","SANITY","REGRESSION"},description = "To check whether the User can logout from the application.")
    public void logoutTest(TestData testData) {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginToApplication(testData.getUsername(), testData.getPassword());
        homePage.logoutFromApplication();
        Assert.assertTrue(loginPage.getTxtBoxUserame().isDisplayed(),
                "Assertion for TextBox Username presence");
        Assert.assertTrue(loginPage.getTxtBoxPassword().isDisplayed(),
                "Assertion for TextBox Password presence");
        Assert.assertTrue(loginPage.getBtnLogin().isDisplayed(),
                "Assertion for Button Login presence");
    }
}
