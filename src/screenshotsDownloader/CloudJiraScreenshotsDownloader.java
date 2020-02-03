package screenshotsDownloader;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloudJiraScreenshotsDownloader {

	public static void main(String[] args) throws NoAlertPresentException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"chromedriver_win32\\79\\chromedriver.exe");

		ChromeDriver jiraBrowser = new ChromeDriver();

		jiraBrowser.manage().window().maximize();

		jiraBrowser.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

		jiraBrowser.get(
				"Copy and Paste Your Jira Cloud Shared Link Here");

		jiraBrowser.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

		jiraBrowser.findElementById("profileGlobalItem").click();

		jiraBrowser.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);

		jiraBrowser.findElementById("username").sendKeys("Copy and Paste Your Username");

		jiraBrowser.findElementById("login-submit").click();

		jiraBrowser.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

		jiraBrowser.findElementById("password").click();

		jiraBrowser.findElementById("password").sendKeys("Copy and Paste Your Password");

		jiraBrowser.findElementById("login-submit").click();

		jiraBrowser.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) jiraBrowser;

		WebElement Element = jiraBrowser.findElementByClassName("drop");

		js.executeScript("arguments[0].scrollIntoView();", Element);

		jiraBrowser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		jiraBrowser.findElementByCssSelector("#attachmentmodule_heading > ul > li.drop > div > a").click();

		jiraBrowser.findElementById("aszip").click();

		String totalBug = jiraBrowser.findElementByClassName("showing").getText();

		System.out.println(totalBug);

		int length = totalBug.length();

		System.out.println(length);

		String finalnumber = "";

		for (int i = 1; i < length; i++) {

			char valueAtfinalnumber = totalBug.charAt(i);

			int ascii = (int) valueAtfinalnumber;

			if (ascii >= 47 && ascii <= 57) {

				finalnumber += valueAtfinalnumber;

			}
		}
		System.out.println(finalnumber + " " + "screenshots will start to download now...Have a Coffee");

		int nowWegetNumber = 0;

		while (true) {

			jiraBrowser.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

			jiraBrowser.findElementById("next-issue").click();

			jiraBrowser.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

			js = (JavascriptExecutor) jiraBrowser;

			Thread.sleep(2000);

			Element = jiraBrowser.findElementByClassName("drop");

			js.executeScript("arguments[0].scrollIntoView();", Element);

			jiraBrowser.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

			Thread.sleep(2000);

			jiraBrowser.findElementByCssSelector("#attachmentmodule_heading > ul").click();

			jiraBrowser.findElementById("aszip").click();

			nowWegetNumber++;

			if (nowWegetNumber > Integer.parseInt(finalnumber)) {

				break;

			}
		}

		System.out.println("All screenshots are downloaded");

	}

}