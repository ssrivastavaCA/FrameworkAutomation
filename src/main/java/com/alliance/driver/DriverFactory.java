/**
 * @author Swetambari
 */

package com.alliance.driver;

import org.openqa.selenium.WebDriver;

import com.alliance.config.ConfigFactory;

import static com.alliance.constants.FrameworkConstants.LOCAL;
import static com.alliance.constants.FrameworkConstants.REMOTE;

//final -> We do not want any class to extend this class
public class DriverFactory {

    //private -> We do not want anyone to create the object of this class
    private DriverFactory() {
    }

    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;
        String runmode = ConfigFactory.getConfig().runmode();
        if (runmode.equalsIgnoreCase(LOCAL)) {
            driver = DriverFactoryLocal.setupForLocalRunMode(browser);
        }
        return driver;

    }


}
