package com.eurotech.tests.tag_18;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.eurotech.utility.ConfigReader;
import org.testng.annotations.*;

public class _1_ExtentReports {

    ExtentReports reports; // extent report'a ilk atama yapar
    ExtentSparkReporter htmlReporter; // html raporu duzenler(eski sürümde ExtentHtmlReporter;)open in ile de dosyayi acabiliriz
    ExtentTest extentLogger; // test pass veya failed gibi bilgileri kaydeder


    @BeforeTest // test islemine baslamadan önce (tüm test isleminden önce)
    public void setUp() {

        reports = new ExtentReports(); // raporlamayi baslatir- um einige report zu erstellen, müssen wir diese Object benuzen

        String projectPath = System.getProperty("user.dir");
        String path = projectPath+"/test-output/reports.html";
        // olusturmak istedigimiz raporu(html formatinda) baslatiyoruz, path ile de dosya yolunu belirliyoruz

        htmlReporter = new ExtentSparkReporter(path);
        reports.attachReporter(htmlReporter);

        // istedigimiz bilgileri buraya ekleyebiliriz
        htmlReporter.config().setReportName("Batch16 Regression Test");
        reports.setSystemInfo("Enviroment","Produktion");
        reports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        reports.setSystemInfo("OS", System.getProperty("os.name"));
        reports.setSystemInfo("Test Engineer", "Sümeyra");
    }

    @AfterTest
    public void tearDown() {
        reports.flush(); // raporlamayi sonlandirmak icin
    }

    @Test
    public void loginTest() {
        extentLogger = reports.createTest("TC0001 Login Test"); // logger sout gibidir
        // test case'leri yaziyoruz
        extentLogger.info("Open the Browser");
        extentLogger.info("Go to Url" + ConfigReader.getProperty("url"));
        extentLogger.info("Click I understand Button");
        extentLogger.info("Enter username");
        extentLogger.info("Enter password");
        extentLogger.info("Click Login Button");
        extentLogger.pass("Verify Logged In");
    }
    @Test
    public void loginTest2() {
        extentLogger = reports.createTest("TC0001 Login Test"); // logger sout gibidir
        // test case'leri yaziyoruz
        extentLogger.info("Open the Browser");
        extentLogger.info("Go to Url" + ConfigReader.getProperty("url"));
        extentLogger.info("Click I understand Button");
        extentLogger.info("Enter username");
        extentLogger.info("Enter password");
        extentLogger.info("Click Login Button");
        extentLogger.pass("Verify Logged In");
    }
}
