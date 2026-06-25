
# Advanced Playwright Automation Framework

<p align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=openjdk)
![Playwright](https://img.shields.io/badge/Playwright-Java-45ba63?style=flat-square&logo=playwright)
![TestNG](https://img.shields.io/badge/TestNG-Framework-red?style=flat-square)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-23D96C?style=flat-square&logo=cucumber)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=flat-square&logo=apachemaven)
![GitHub](https://img.shields.io/badge/Git-Version_Control-black?style=flat-square&logo=github)

</p>

A Java-based automation framework built using **Playwright**, **Cucumber BDD**, **TestNG**, and **Maven** for automating end-to-end web application testing.

The framework follows a modular Page Object Model (POM) architecture with reusable components, centralized utilities, reporting, logging, retry support, and data-driven execution. It has also been designed with an extensible **AI-ready architecture** that allows future integration of intelligent locator recovery and failure analysis without requiring major structural changes.

---

## Features

| Category | Description |
|-----------|-------------|
| UI Automation | Playwright with Java |
| Framework | TestNG |
| BDD | Cucumber |
| Design Pattern | Page Object Model (POM) |
| Build Tool | Maven |
| Data Driven Testing | CSV-based execution |
| Reporting | Extent Reports |
| Logging | Log4j2 |
| Screenshots | Automatic failure screenshots |
| Retry Support | Retry Analyzer & Retry Listener |
| Configuration | External configuration management |
| Recovery | Recovery workflow for execution failures |
| AI-Ready | Extension points for future AI integration |

---

## Automated Modules

| Module | Description |
|----------|-------------|
| Register | User registration workflow |
| Login | User authentication |
| Search | Product search |
| Wishlist | Wishlist operations |
| Cart | Shopping cart management |
| Compare | Product comparison |
| Coupon | Coupon validation |
| Checkout | Complete checkout workflow |
| Logout | Session termination |
| End-to-End | Full user purchase journey |

---

## Technology Stack

| Component | Technology |
|-----------|------------|
| Language | Java |
| Automation | Playwright |
| Test Framework | TestNG |
| BDD | Cucumber |
| Build Tool | Maven |
| Reporting | Extent Reports |
| Logging | Log4j2 |
| IDE | Eclipse |
| Version Control | Git & GitHub |

---

## AI-Ready Design

The framework includes an extensible architecture designed to support future AI integration.

Current implementation provides architectural support for:

- Self-healing locator extension points
- Intelligent recovery workflow
- Smart action abstraction
- Retry orchestration
- Recovery utilities
- Failure analysis extension points

The framework currently executes using standard Playwright automation. Real-time AI/LLM integration (such as OpenAI, Gemini, or similar services) is not included in the current implementation and is planned as a future enhancement.

---

## Architecture

```text
                   Feature Files
                         │
                         ▼
                    Test Runner
                   (TestNG Runner)
                         │
                         ▼
                  Step Definitions
                         │
                         ▼
                    Page Objects
                         │
                         ▼
                      Base Test
                         │
        ┌────────────────┼────────────────┐
        ▼                ▼                ▼
   Browser Layer     Utility Layer    Recovery Layer
                         │                │
                         ▼                ▼
                    Playwright API     AI Extension
                         │
                         ▼
                    Browser Execution
                         │
                         ▼
             Reports • Logs • Screenshots
```

---

## Project Goals

The framework focuses on:

- Modular automation design
- Reusable test components
- Maintainable code structure
- Data-driven execution
- Reliable test execution
- Comprehensive reporting
- Extensible architecture for future enhancements
- AI-ready framework design

---
````
````markdown
## Project Structure

The project is organized into reusable layers that separate test logic, page objects, utilities, and execution components.

```text
Advanced-Playwright-Automation-Framework
│
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   │
│   └── test
│       ├── java
│       │   ├── base
│       │   ├── cucumber
│       │   │   └── runner
│       │   ├── hooks
│       │   ├── pages
│       │   ├── stepdefinitions
│       │   ├── tests
│       │   └── utils
│       │
│       └── resources
│           ├── features
│           ├── log4j2.xml
│           └── testdata.json
│
├── reports
├── screenshots
├── pom.xml
└── README.md
```

---

## Package Overview

### base

Contains the framework initialization classes.

The `BaseTest` class is responsible for:

- Browser initialization
- Playwright setup
- Browser context management
- Common setup and teardown methods

---

### pages

Implements the Page Object Model (POM).

Each page class contains:

- Element locators
- Page actions
- Validation methods
- Business operations

Keeping page logic separate from test logic improves readability and maintainability.

---

### stepdefinitions

Maps Gherkin steps from feature files to Java methods.

Responsibilities include:

- Reading feature steps
- Calling page methods
- Performing validations
- Managing workflow execution

---

### hooks

Contains Cucumber lifecycle hooks executed before and after every scenario.

Typical responsibilities include:

- Browser setup
- Screenshot capture
- Report updates
- Cleanup activities

---

### cucumber.runner

Contains the TestNG runner used to execute Cucumber feature files.

The runner configures:

- Feature locations
- Glue packages
- Reporting plugins
- TestNG integration

---

### tests

Contains reusable TestNG test classes used for individual module validation.

These classes support independent execution outside complete end-to-end scenarios.

---

### utils

Utility classes shared across the framework.

Examples include:

| Utility | Purpose |
|---------|---------|
| ConfigReader | Reads configuration values |
| CSVUtil | Handles CSV test data |
| FakerUtil | Generates dynamic test data |
| ReportUtil | Creates Extent Reports |
| RetryAnalyzer | Retries failed tests |
| RetryListener | Integrates retry with TestNG |
| RecoveryUtil | Recovery workflow |
| StepExecutor | Common execution helper |
| AIUtil | Extension layer for future AI capabilities |

---

## Execution Flow

```text
Feature File
      │
      ▼
TestNG Runner
      │
      ▼
Cucumber Hooks
      │
      ▼
BaseTest
      │
      ▼
Step Definitions
      │
      ▼
Page Objects
      │
      ▼
Playwright
      │
      ▼
Browser
      │
      ▼
Reports + Logs + Screenshots
```

---

## Test Workflow

1. Test execution begins from the TestNG runner.

2. Cucumber loads the feature files.

3. Hooks initialize the browser and reporting components.

4. Step definition classes execute the corresponding business actions.

5. Page Object classes interact with the application through Playwright.

6. Assertions validate the expected behaviour.

7. Reports, logs, and screenshots are generated automatically.

---

## Recovery Workflow

The framework includes a recovery layer that improves execution stability.

Current capabilities include:

- Retry support for transient failures
- Screenshot capture during failures
- Centralized exception handling
- Recovery utility methods
- Consistent execution flow

These components reduce flaky failures and simplify debugging.

---

## AI-Ready Architecture

The framework has been designed to support future AI integration without affecting the existing automation flow.

Current extension points include:

- Locator recovery interfaces
- Smart action abstraction
- Recovery orchestration
- Failure analysis workflow
- Utility layer prepared for AI integration

Future enhancements may include:

- AI-assisted locator recovery
- Intelligent failure analysis
- Automatic locator suggestions
- Adaptive execution strategies

The current implementation does **not** invoke any external AI or LLM services during test execution.

---
````
````markdown
## Reporting

The framework generates execution reports automatically after each test run.

### Extent Reports

Extent Reports provide:

- Execution summary
- Pass/Fail statistics
- Step execution details
- Failure information
- Execution duration
- Screenshot attachments

Example:

```
reports/
└── ExtentReport.html
```

---

## Logging

Log4j2 is used to capture execution logs throughout the framework.

The logs include:

- Browser initialization
- Navigation events
- User actions
- Assertions
- Retry attempts
- Exception details

Example:

```
logs/
└── automation.log
```

---

## Screenshot Capture

Screenshots are captured automatically whenever a test fails.

This helps simplify debugging by preserving the browser state at the point of failure.

Example:

```
screenshots/
├── LoginFailure.png
├── CheckoutFailure.png
└── SearchFailure.png
```

---

## Data-Driven Testing

The framework supports external test data using CSV files.

Typical use cases include:

| Scenario | Data Source |
|----------|-------------|
| Registration | CSV |
| Login | CSV |
| Search | CSV |
| Checkout | CSV |

The CSV utility reads the data and supplies it to the corresponding test scenarios during execution.

---

## Running the Project

### Prerequisites

- Java 17 or later
- Maven
- Playwright
- Eclipse IDE (or IntelliJ IDEA)

---

### Clone the Repository

```bash
git clone https://github.com/Nivetha-6/Advanced-Playwright-Automation-Framework.git
```

---

### Import into Eclipse

```
File
→ Import
→ Existing Maven Project
```

Select the project folder and complete the import.

---

### Install Dependencies

```bash
mvn clean install
```

---

### Install Playwright Browsers

```bash
playwright install
```

or

```bash
mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```

---

### Execute Tests

Run the framework using either:

```bash
mvn test
```

or execute the TestNG runner directly from Eclipse.

---

## Future Roadmap

The current framework provides a modular foundation for future enhancements.

Potential improvements include:

| Area | Planned Enhancement |
|------|---------------------|
| AI Integration | AI-assisted locator recovery |
| Failure Analysis | LLM-assisted debugging support |
| Execution | Parallel cross-browser execution |
| CI/CD | GitHub Actions |
| CI/CD | Jenkins Pipeline |
| Containers | Docker support |
| Cloud | BrowserStack / LambdaTest execution |
| Testing | Visual regression testing |

---

## Repository Structure

```
src/
pom.xml
testng.xml
README.md
.gitignore
```

---

## Contributing

Contributions are welcome.

If you would like to improve the framework, feel free to fork the repository and submit a pull request.

---

## Author

**Nivethasree S**

Automation Engineer | Playwright | Java | TestNG | Cucumber

GitHub:
https://github.com/Nivetha-6

LinkedIn:
https://www.linkedin.com/in/nivethasree54

---

## License

This project is provided for educational and demonstration purposes.

```
Copyright (c) 2026 Nivethasree S
```
````
