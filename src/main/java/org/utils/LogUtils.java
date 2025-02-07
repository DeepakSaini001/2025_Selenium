package org.utils;

import java.text.SimpleDateFormat;
import org.apache.log4j.MDC;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogUtils {

	private static Logger logger = Logger.getLogger(LogUtils.class);

	static {
		PropertyConfigurator.configure(
				"//Users//deepaksaini//eclipse-workspace//2024_MyProtien_9_Sep//src//main//resources//log4j.properties");
	}

	public static Logger getLogger() {
		return logger;
	}
}
