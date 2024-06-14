/**
 * @author Swetambari
 */

package com.alliance.reports;

import com.aventstack.extentreports.ExtentTest;

//final -> We do not want any class to extend this class
public final class ExtentManager {

    //private -> We do not want anyone to create the object of this class
    private ExtentManager() {
    }

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return extentTest.get();
    }

    static void setExtentTest(ExtentTest test) {
        extentTest.set(test);
    }

    static void unload() {
        extentTest.remove();
    }

}
