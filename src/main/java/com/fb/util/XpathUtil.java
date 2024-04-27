package com.fb.util;

/**
 * @author Chanukya Vempati
 * @since 26 Apr 2024
 */
public class XpathUtil {

	public static String getLocByText(String tag, String text) {
		return getLocByText(tag, text, false);
	}

	public static String getLocByText(String tag, String text, boolean contains) {
		String loc = contains ? "//" + tag + "[contains(text(), '" + text + "')]" : "//" + tag + "[text()='" + text + "']";
		return loc;
	}
}
