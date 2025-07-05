# 🧪 String Calculator – TDD 

This project implements the **String Calculator** using **Java** & **JUnit** and follows the principles of **Test-Driven Development (TDD)**. Each feature was developed iteratively using the red-green-refactor cycle and committed at each meaningful test milestone.

---

## 📌 Problem Statement

Implement a method:

```java
public int add(String numbers)
````

This method should take a string of numbers separated by delimiters and return their sum, handling various input formats and constraints. Each enhancement is driven through TDD.

---

## ✅ Features Implemented (by TDD Steps)

| Step | Feature                                                                                             |
| - |-----------------------------------------------------------------------------------------------------|
| 1 | Return 0 for empty string, number itself for a single number and sum for two comma-separated numbers |
| 2 | Support unknown count of comma-separated numbers                                                    |
| 3 | Support newline (`\n`) as a valid delimiter                                                         |
| 4 | Support custom delimiter (e.g. `//;\n1;2`)                                                          |
| 5 | Throw exception for negative numbers                                                                |
| 6 | Show **all** negative numbers in the exception                                                      |
| 7 | Add `GetCalledCount()` method to return `add()` call count                                          |
| 8 | Ignore numbers greater than 1000                                                                    |
| 9 | Support delimiters of any length (e.g. `//[***]\n1***2***3`)                                        |
| 10 | Support multiple custom delimiters (e.g. `//[+][$]\n1+2$3`)                                         |
| 11 | Support multiple custom delimiters of any length (e.g. `//[**][%%]\n1**2%%3`)                                                                                                    |

---

## 🛠️ Tools

* Java
* JUnit (Jupiter)
* Maven
* IntelliJ IDEA

---

## 🧱 Project Structure

```
StringCalculator/
├── src/
│   ├── main/
│   │   └── java/com.anmol.stringcalculator/StringCalculator.java
│   └── test/
│       └── java/com.anmol.stringcalculator/StringCalculatorTest.java
├── pom.xml
├── .gitignore
└── README.md
```
---

## 🔁 TDD Commit Workflow

Every feature was developed and committed using TDD in **Red → Green → Refactor** steps. Examples:

```text
[Step-1] Failed Test: Support for empty string input returning 0
[Step-1] Passes Test: Support for empty string input returning 0

[Step-5] Failed Test: Throw exception for multiple negative numbers
[Step-5] Passes Test: Throw exception for multiple negative numbers

[Step-12] Failed Test: Support multiple custom delimiters of any length
[Step-12] Passes Test: Support multiple custom delimiters of any length
```

This allows for **traceable progress** and ensures that **every feature is test-driven**.

---

## 🧠 TDD Principles Demonstrated

* **Fail-first tests**: Every test was written before implementation.
* **Minimal implementation**: Code was added only to pass the current test.
* **Continuous refactoring**: Code was improved after tests passed.
* **Regression safety**: A growing test suite ensures nothing breaks.

---

## 💡 Additional Notes

* Every requirement was implemented using **pair of commits**: one failing and one passing.
* This project demonstrates **unit testing**, **string parsing**, and **clean design**.



