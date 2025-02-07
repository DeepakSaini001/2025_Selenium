package org.DriverFactory;

import org.Constants.DriverType;

public class DriverManagerFactory {
	private static DriverManager chromeManager = null;
	private static DriverManager firefoxManager = null;


	private DriverManagerFactory() {
		// Private constructor to prevent instantiation, so that we cannot create object.
	}

	public static synchronized DriverManager getManager(DriverType driverType) {

		switch (driverType) {
		case CHROME -> {
			if (chromeManager == null) {
				chromeManager = new ChromeDriverManager();
				 System.out.println("Chrome DriverManager initialized.");
			}

			return chromeManager;
		}
		case FIREFOX -> {
			if (firefoxManager == null) {
				firefoxManager = new FireFoxDriverManager(); // Singleton
				 System.out.println("Firefox DriverManager initialized.");
			}
			return firefoxManager;
		}
		default -> throw new IllegalStateException("Invalid Driver" + " : " + driverType);
		}

	}

}
