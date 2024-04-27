package com.fb.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.FbBrowser;
import com.fb.SUT;
import com.microsoft.playwright.Locator;

/**
 * @author Chanukya Vempati
 * @since 26 Apr 2024
 */
public class VerifyFbLogin {
	
	private SUT sut;
	private FbBrowser browser;
	
	@BeforeMethod
	public void setup() {
		sut = new SUT();
		browser = sut.getBrowser();
		browser.open();
	}

	@Test
	public void verifyLoginSuccess() {
		browser.login();
		Locator loc = sut.getPage().getByText(" on your mind");
		Assert.assertTrue(loc.isVisible());
	}
	
	@AfterMethod
	public void teardown() {
		browser.close();
		sut.terminate();
	}
	

}
