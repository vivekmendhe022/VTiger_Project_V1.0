package com.generic.utitlity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * This class contains all peoperty file data for Data Driven Testing.
 * @author vivek
 *
 */
public class PropertyFileUtility {
	
	public String getCommonDataFromPropertyFile(String key) throws IOException {
		FileInputStream file = new FileInputStream(IConstantUtility.PROPERTYFILEPATH);
		Properties properties = new Properties();
		properties.load(file);
		String value = properties.getProperty(key);
		return value;
	}
	
	/**
	 * This method contains all necessary page title for validation of Hard & Soft Assert.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPageTitleFromPropertyFile(String key) throws IOException {
		FileInputStream file = new FileInputStream(IConstantUtility.PAGETITLE);
		Properties properties = new Properties();
		properties.load(file);
		String value = properties.getProperty(key);
		return value;
	}

}
