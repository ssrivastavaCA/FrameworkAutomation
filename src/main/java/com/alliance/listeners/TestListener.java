/**
 * @author Swetambari
 */

package com.alliance.listeners;


import java.util.Arrays;

import com.alliance.annotations.FrameworkAnnotation;
import com.alliance.config.ConfigFactory;
import com.alliance.reports.ExtentLogger;
import com.alliance.reports.ExtentReport;
import com.alliance.utils.BrowserOSInfoUtils;
import com.alliance.utils.IconUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import static com.alliance.constants.FrameworkConstants.*;

public class TestListener implements ITestListener, ISuiteListener {

    static int count_passedTCs;
    static int count_skippedTCs;
    static int count_failedTCs;
    static int count_totalTCs;

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {

        count_totalTCs = count_totalTCs + 1;
        ExtentReport.createTest(result.getMethod().getMethodName());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class).author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class).category());
        ExtentReport.addDevices();
        ExtentLogger.info(BOLD_START + IconUtils.getOSIcon() + "  &  " + IconUtils.getBrowserIcon() + " --------- "
                + BrowserOSInfoUtils.getOS_Browser_BrowserVersionInfo() + BOLD_END);
        String url=ConfigFactory.getConfig().url();
        ExtentLogger.info(ICON_Navigate_Right + "  Navigating to : <a href=" + url + "><b>" + url + "</b></a>");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        count_passedTCs = count_passedTCs + 1;
        String logText = "<b>" + result.getMethod().getMethodName() + " is passed.</b>" + "  " + ICON_SMILEY_PASS;
        Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        ExtentLogger.pass(markup_message, true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        count_failedTCs = count_failedTCs + 1;
        ExtentLogger.fail(ICON_BUG + "  " + "<b><i>" + result.getThrowable().toString() + "</i></b>");
        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        String message = "<details><summary><b><font color=red> Exception occured, click to see details: "
                + ICON_SMILEY_FAIL + " </font></b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>")
                + "</details> \n";
        ExtentLogger.fail(message);
        String logText = BOLD_START + result.getMethod().getMethodName() + " is failed." + BOLD_END + "  " + ICON_SMILEY_FAIL;
        Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.RED);
        ExtentLogger.fail(markup_message, true);

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        count_skippedTCs = count_skippedTCs + 1;
        ExtentLogger.skip(ICON_BUG + "  " + "<b><i>" + result.getThrowable().toString() + "</i></b>");
        // ExtentLogger.skip("<b><i>" + result.getThrowable().toString() + "</i></b>");
        String logText = "<b>" + result.getMethod().getMethodName() + " is skipped.</b>" + "  " + ICON_SMILEY_FAIL;
        Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        ExtentLogger.skip(markup_message, true);
    }
}
