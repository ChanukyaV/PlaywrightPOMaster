# PlaywrightPOMaster Framework with TestNG

This repository contains a Maven project implementing a robust automation framework for web application testing using Playwright, Java, Page Object Model (POM), and TestNG. The framework is designed to facilitate efficient and maintainable automated testing practices.

## Key Features
- Page Object Model (POM): Modularizes web pages into separate classes, improving code maintainability and reusability.
- Assertions and Reporting: Provides custom assertion methods and generates detailed test reports with screenshots and logs for effective test result analysis.

## Prerequisites
- Java Development Kit (JDK)
- Maven
- IDE (Eclipse, IntelliJ IDEA, etc.)

## Getting Started

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/ChanukyaV/PlaywrightPOMaster.git
   ```

2. Open the project in your preferred IDE.

3. Review and configure the project settings, dependencies, and browser configurations as needed.

4. Write test cases using TestNG annotations in the `src/test/java` directory.

5. Execute the tests using Maven commands or IDE test runners.

## Project Structure

```
playwright-java-pom-framework/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.fb.pages/           # Page classes
│   │   │   └── com.fb.util/            # Utility classes
│   ├── test/
│   │   ├── java/                 # Test Cases   
├── pom.xml                       # Maven project configuration file
```

## Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for any improvements or feature requests.
