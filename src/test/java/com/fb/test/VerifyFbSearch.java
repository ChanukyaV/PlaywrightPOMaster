package com.fb.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.FbBrowser;
import com.fb.SUT;
import com.fb.pages.FbHomePage;

/**
 * @author Chanukya Vempati
 * @since 27 Apr 2024
 */
public class VerifyFbSearch {
	
	private SUT sut;
	private FbBrowser browser;
	private FbHomePage homePage;
	
	@BeforeMethod
	public void setup() {
		sut = new SUT();
		browser = sut.getBrowser();
		browser.open();
	}

	@Test
	public void verifySearch() {
		homePage = browser.login();
		homePage.search("Dream11");
		Assert.assertTrue(homePage.verifyElement("//div[contains(@aria-label, 'Join group DREAM11')]"
				+ "//span[text()='Join']"));
	}
	
	@AfterMethod
	public void teardown() {
		browser.close();
		sut.terminate();
	}
	

}
