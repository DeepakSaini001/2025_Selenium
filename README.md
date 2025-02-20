Selenium Java Framework on MyProtien WebSite

📌 Overview
Selenium Java Framework on MyProtien WebSite  a Hybrid Test Automation Framework designed for web application testing using Selenium WebDriver, Java, TestNG, and Cucumber. This framework follows the Page Object Model (POM) for maintainability and integrates with GitHub Actions for CI/CD. Test execution results are logged and generated in Extent Reports.

🛠️ Tech Stack
Programming Language: Java
Testing Framework: TestNG + Cucumber
Automation Tool: Selenium WebDriver
Build Tool: Maven
Data Handling: Apache POI (Excel for test data management)
Logging: Log4j
Reporting: Extent Reports
Version Control: GitHub
CI/CD: GitHub Actions

📂 Folder Structure
P1AutomationSuite/
│-- .github/             # GitHub Actions for CI/CD
│-- extent-reports/      # ExtentReport.html files (Test Execution Reports)
│-- reports/             # Additional test execution reports
│-- screenshots/         # Screenshots for failed tests
│-- src/
│   ├── main/java/
│   │   ├── pages/       # Page Object Model (POM) classes
│   │   ├── utilities/   # Utility classes (Excel Reader, Logger, etc.)
│   ├── test/java/
│   │   ├── tests/       # Test classes with TestNG & Cucumber
│-- target/              # Compiled output files
│-- pom.xml              # Maven dependencies and configurations
│-- README.md            # Project documentation


🚀 How to Set Up and Run the Tests
🔹 Prerequisites
Install Java JDK 17+
Install Maven
Clone the repository
git clone https://github.com/YOUR_USERNAME/2025_Selenium.git
cd 2025_Selenium
Install dependencies
mvn clean install

🔹 Running the Tests
To execute tests, run the following command:
mvn clean test
After execution, reports are generated in:
extent-reports/ExtentReport.html
reports/ExtentReport.html

🔗 CI/CD Pipeline - GitHub Actions
The framework runs automated tests on every push or pull request.
Test reports are uploaded as artifacts.
Email notifications are sent after execution.

📊 Reporting
The framework generates Extent Reports with test execution details.
Failed test cases are captured as screenshots and logged.
📧 Contact
For any queries, reach out at deepak.saini2106@gmail.com.

Feel free to modify any section as needed! 😊
