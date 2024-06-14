/**
 * @author Swetambari
 */

package com.alliance.reports;

import static com.alliance.constants.FrameworkConstants.*;

import java.util.Objects;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.alliance.enums.AuthorType;
import com.alliance.enums.CategoryType;
import com.alliance.utils.BrowserInfoUtils;
import com.alliance.utils.IconUtils;
import com.alliance.utils.ReportUtils;

//final -> We do not want any class to extend this class
public final class ExtentReport {

    //private -> We do not want anyone to create the object of this class
    private ExtentReport() {
    }

    private static ExtentReports extent;

    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(getExtentReportFilePath());
            extent.attachReporter(spark);

            // spark.config().setEncoding("utf-8");
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle(PROJECT_NAME + " - ALL");
            spark.config().setReportName(PROJECT_NAME + " - ALL");

            extent.setSystemInfo("Organization", "AAH");
            extent.setSystemInfo("Skill", "Test Automation");
        }
    }

    public static void flushReports() {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unload();
        ReportUtils.openReports();
    }

    public static void createTest(String testCaseName) {
        // ExtentManager.setExtentTest(extent.createTest(testCaseName));
        ExtentManager.setExtentTest(extent.createTest(IconUtils.getBrowserIcon() + " : " + testCaseName));
    }

    synchronized public static void addAuthors(AuthorType[] authors) {
        for (AuthorType author : authors) {
            ExtentManager.getExtentTest().assignAuthor(author.toString());
        }
    }

    // public static void addCategories(String[] categories) {
    synchronized public static void addCategories(CategoryType[] categories) {
        // for (String category : categories) {
        for (CategoryType category : categories) {
            ExtentManager.getExtentTest().assignCategory(category.toString());
        }
    }

    synchronized public static void addDevices() {
        ExtentManager.getExtentTest().assignDevice(BrowserInfoUtils.getBrowserInfo());
    }
}
