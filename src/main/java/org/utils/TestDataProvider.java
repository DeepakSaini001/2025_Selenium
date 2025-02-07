package org.utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {

	@DataProvider(name = "loginData")
	public Object[][] provideLoginData() {
		// Create a 2D Object array with 40 data sets
		Object[][] data = new Object[40][2]; // 40 rows, 2 columns (example)

		for (int i = 0; i < 40; i++) {
			data[i][0] = "User" + (i + 1); // Username
			data[i][1] = "Password" + (i + 1); // Password
		}

		return data;
	}

	@Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
	public void testLogin(String username, String password) {
		System.out.println("Testing login with: " + username + " / " + password);

	}
}
