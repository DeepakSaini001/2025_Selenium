package org.DriverFactory;

import org.Constants.DriverType;

public class DriverManagerFactory_parallel_test_execution {

	public static DriverManager getManager(DriverType driverType) {
		switch (driverType) {
		case CHROME -> {
			return new ChromeDriverManager(); // New instance each time
		}
		case FIREFOX -> {
			return new FireFoxDriverManager(); // New instance each time
		}
		default -> throw new IllegalStateException("Invalid Driver Type: " + driverType);
		}
	}
}
