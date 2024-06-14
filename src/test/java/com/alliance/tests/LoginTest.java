/**
 * @author Swetambari
 */

package com.alliance.tests;

import com.alliance.annotations.FrameworkAnnotation;
import com.alliance.enums.AuthorType;
import com.alliance.enums.CategoryType;
import com.alliance.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @FrameworkAnnotation(author = {AuthorType.SWETAMBARI},
            category = {CategoryType.REGRESSION})
    @Test(groups = {"BVT","REGRESSION"},description = "To check whether the User can not login with Invalid Credentials"
           )
    public void errorInvalidCredentials() {

        LoginPage loginPage = new LoginPage();

    }
}
