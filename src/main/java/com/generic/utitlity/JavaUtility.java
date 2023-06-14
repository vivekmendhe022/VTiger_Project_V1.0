package com.generic.utitlity;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * This method will generate random value.
	 * @return
	 */
	public int getRandom() {
		Random random = new Random();
		return random.nextInt(1000);
	}

	/**
	 * This method will generate system date in required format
	 * 
	 * @return
	 */
	public String getSystemDateInFormate() {
		Date d = new Date();
		String[] split = d.toString().split(" ");
		String date = split[2];
		String month = split[1];
		String year = split[5];
		String time = split[3].replace(":", "-");
		return date + " " + month + " " + year + " " + time;
	}
}
