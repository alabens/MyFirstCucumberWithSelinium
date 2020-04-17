package Base;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Driver;

public class ExtentReportUtil extends BaseUtil {
    String filName = reportLocation + "extentreport.html";

    public void ExtentReport() {
        extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Test reporter for selenium Basic");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("TestReport");

        extent.attachReporter(htmlReporter);
    }

    public void ExtentReportScreenShot() throws IOException {
        var src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src.toPath(), new File(reportLocation+ "screenshot.png").toPath());
        scenariodef.fail("details").addScreenCaptureFromPath(reportLocation+ "screenshot.png");
    }
    public void FlushReport(){
        extent.flush();
    }
}
