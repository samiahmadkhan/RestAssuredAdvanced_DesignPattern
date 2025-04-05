package Listners;

import io.qameta.allure.Allure;
import org.testng.*;

import java.util.Arrays;

public class TestListners implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        Allure.step("📦 Starting test suite: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        Allure.step("📦 Finished test suite: " + suite.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        Allure.step("🚀 Starting test: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Allure.step("✅ Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Allure.step("❌ Test failed: " + result.getMethod().getMethodName());
        Allure.step(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Allure.step("⚠️ Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
