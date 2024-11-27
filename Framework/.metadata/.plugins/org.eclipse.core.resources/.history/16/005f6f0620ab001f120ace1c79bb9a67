package com.qa.webhook;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.qa.Base.BaseClass;

public class TakeScreenshot extends BaseClass{
	public void ScreenShot(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dist = new File("E:\\Framework\\E-commerce\\src\\test\\java\\com\\qa\\util\\ScreenShot\\"
					+ result.getName() + ".jpg");
			try {
				FileUtils.copyFile(src, dist);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
