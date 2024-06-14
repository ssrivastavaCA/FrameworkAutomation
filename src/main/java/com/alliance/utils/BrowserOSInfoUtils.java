/**
 * @author Swetambari
 */

package com.alliance.utils;

//final -> We do not want any class to extend this class
public final class BrowserOSInfoUtils {

    //private -> We do not want anyone to create the object of this class
    // Private constructor to avoid external instantiation
    private BrowserOSInfoUtils() {
    }

    public static String getOS_Browser_BrowserVersionInfo() {
        return OSInfoUtils.getOSInfo() + " & " + BrowserInfoUtils.getBrowserInfo() + " - "
                + BrowserInfoUtils.getBrowserVersionInfo();

    }

}
