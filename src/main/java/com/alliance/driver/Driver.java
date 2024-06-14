/**
 * @author Swetambari
 */

package com.alliance.driver;

import com.alliance.config.ConfigFactory;
import org.openqa.selenium.WebDriver;

//final -> We do not want any class to extend this class
public class Driver {

    //private -> We do not want anyone to create the object of this class
    private Driver() {
    }

    public static void initDriver() {//method should do only 1 thing

        String browser = ConfigFactory.getConfig().browser().trim();
        if (DriverManager.getDriver() == null) {
            WebDriver driver = DriverFactory.getDriver(browser);

            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(ConfigFactory.getConfig().url());

        }
    }

    public static void quitDriver() {

        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }
    }
}
