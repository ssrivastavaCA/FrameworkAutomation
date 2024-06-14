/**
 * @author Swetambari
 */

package com.alliance.pages;

import static com.alliance.utils.SeleniumUtils.*;

import com.alliance.enums.WaitType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    //Naming Convention for private static final fields/variables
    private static final By TXTBOX_USERNAME = By.id("txtUsername"); //100 threads  --> 1 txtBoxUsername
    private static final String TXTBOX_USERNAME_TXT = "Username";
    private static final By TXTBOX_PASSWORD = By.id("txtPassword");
    private static final String TXTBOX_PASSWORD_TXT = "Password";
    private static final By BTN_LOGIN = By.id("btnLogin");
    private static final String BTN_LOGIN_TXT = "Login Button";
    private static final By MSG_ERROR = By.id("spanMessage");

    private LoginPage setUsername(String username) {
        sendKeys(TXTBOX_USERNAME, username, TXTBOX_USERNAME_TXT);
        return this;
    }

    public WebElement getTxtBoxUserame(){
        return getElement(TXTBOX_USERNAME);
    }
    public WebElement getTxtBoxPassword(){
        return getElement(TXTBOX_PASSWORD);
    }
    public WebElement getBtnLogin(){
        return getElement(BTN_LOGIN);
    }

    private LoginPage setPassword(String password) {
        sendKeys(TXTBOX_PASSWORD, password, TXTBOX_PASSWORD_TXT);
        return this;
    }

    public String getErrorMessage(){
        return getElementText(MSG_ERROR);
    }

}
