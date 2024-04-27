package com.fb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Chanukya Vempati
 * @since 26 Apr 2024
 */
public class Configuration {

	private Properties prop = null;

	public Configuration() {
		try {
			FileInputStream fis = new FileInputStream(new File("TestRunner.properties"));
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			throw new RuntimeException("Please check for TestRunner.properties file");
		}
	}

	public String getBrowserName() {
		return prop.getProperty("browser");
	}

	public String getEmail() {
		return prop.getProperty("email");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}

	public String getInstanceURL() {
		return prop.getProperty("instance.url");
	}
	
	public boolean getHeadlessMode() {
		return prop.getProperty("headless").equalsIgnoreCase("true");
	}
}
