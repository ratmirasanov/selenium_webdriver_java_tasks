Used technologies and patterns:
Java, Selenium WebDriver (Google Chrome), JUnit, Page Object Model, Page Factory.

What should be done before the running tests:
1. Download the latest version of chrome driver from https://sites.google.com/a/chromium.org/chromedriver/downloads according to your OS.

2. Extract the file and copy it to the "/usr/local/bin" folder (Mac or Linux). For Windows -- add the path to the file in Environment Variables ("Path" variable).

3. Also should be installed all required packages (Selenium WebDriver, JUnit). You can find all of them in "libs" folder of the project in GitHub.

Structure of project:
1. "libs" folder -- all required packages for tests (Selenium WebDriver, JUnit).

2. "automations_tests" folder -- all classes for tests.

3. "facebook_page_objects" -- all classes of Page Object Model for Facebook-test.

4. "wallethub_page_objects" -- all classes of Page Object Model for WalletHub-test.

PS: The code has comments for all actions.
