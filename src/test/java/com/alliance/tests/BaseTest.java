/**
 * @author Swetambari
 */

package com.alliance.tests;

import com.alliance.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        Driver.initDriver();
    }

    @AfterMethod
    public void afterMethod() {
        Driver.quitDriver();
    }
}
