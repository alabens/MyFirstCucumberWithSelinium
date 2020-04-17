package Runner;

import Base.ExtentReportUtil;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.gherkin.model.Feature;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static Base.BaseUtil.features;

public class NGTestListener implements ITestListener {

    ExtentReportUtil extentReportUtil = new ExtentReportUtil();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("On test start");

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("On test success");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("On test Failure");
        try{
            extentReportUtil.ExtentReportScreenShot();
        } catch (IOException e ) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("On test percentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("On start");
        extentReportUtil.ExtentReport();
        //ToDo: features - hardcoding feature name
        features=extentReportUtil.extent.createTest(Feature.class, "Login Feature");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("On finish");
        extentReportUtil.FlushReport();

    }
}
