# Course Center

A simple Java console application created as a learning project to practice core Java concepts such as classes, objects, arrays, validation, methods, encapsulation, and object comparison.

The project represents a small course or training center where students can be created, validated, stored, and managed.

## Project Goals

The main goal of this project is to practice Java fundamentals by building a small application step by step.

The project focuses on:

- Object-Oriented Programming
- creating classes and objects
- constructors
- fields and methods
- encapsulation
- validation
- arrays
- loops
- conditional statements
- static methods
- `equals()` and `hashCode()`
- working with object references
- basic data processing

## Main Features

The application allows you to:

- create students
- validate student data
- define a minimum allowed student age
- add scores to students
- validate score values
- store students in arrays
- search for students
- compare student objects
- process student data
- calculate basic statistics
- manage simple course-related data

## Project Structure

Example structure:

```text
src
└── main
    └── java
        └── ...
            ├── Student.java
            ├── Course.java
            ├── StudentArrayUtils.java
            └── TrainingCenterApp.java
```

### Student

Represents a student registered in the training center.

The class contains student-related data and logic such as:

- personal information
- age validation
- score storage
- adding new scores
- score validation
- object comparison using `equals()`
- generation of hash codes using `hashCode()`

Example:

```java
Student student = new Student("John", "Smith", 25);
```

## Score Validation

Scores can only be added when they are within the accepted range.

Example:

```java
student.addScore(85);
```

Invalid values are rejected by the application.

This helps demonstrate how validation logic can protect an object from incorrect data.

## Minimum Student Age

The application contains validation that prevents creating students who are younger than the required minimum age.

Example concept:

```java
private static final int MIN_STUDENT_AGE = 18;
```

This demonstrates the use of constants and business rules inside Java classes.

## Student Arrays

Students can be stored inside arrays:

```java
Student[] students = new Student[10];
```

The project uses arrays to practice:

- storing object references
- iterating through objects
- searching for objects
- checking empty positions
- adding students
- analysing stored data

## StudentArrayUtils

The `StudentArrayUtils` class contains utility methods responsible for operations on student arrays.

Depending on the project version, these methods may include operations such as:

```java
findStudent(...)
```

```java
addStudent(...)
```

```java
findOldestStudent(...)
```

```java
calculateAverage(...)
```

The purpose of this class is to separate data-processing logic from the main application.

## equals() and hashCode()

The `Student` class implements:

```java
equals()
```

and

```java
hashCode()
```

These methods allow Java to determine whether two student objects should be treated as equal.

Example:

```java
Student student1 = new Student("John", "Smith", 25);
Student student2 = new Student("John", "Smith", 25);

student1.equals(student2);
```

This part of the project demonstrates the difference between:

```java
==
```

and:

```java
equals()
```

when working with objects.

## Course

The `Course` class represents a course available in the training center.

It can contain information such as:

- course name
- assigned students
- course-related configuration

The class demonstrates relationships between different Java objects.

## TrainingCenterApp

`TrainingCenterApp` is the main entry point of the application.

Example:

```java
public static void main(String[] args) {
    // application logic
}
```

The class is used to create objects and test the functionality implemented in other parts of the project.

## Technologies

- Java
- Maven
- IntelliJ IDEA
- Git

## Requirements

To run the project you need:

- JDK 17 or newer
- Maven
- IDE such as IntelliJ IDEA

Check your Java version:

```bash
java -version
```

Check Maven:

```bash
mvn -version
```

## Running the Project

Clone the repository:

```bash
git clone <repository-url>
```

Go to the project directory:

```bash
cd course-center
```

Compile the project:

```bash
mvn compile
```

Run the main application from your IDE using:

```java
TrainingCenterApp.main()
```

## What I Practiced

During this project I practiced:

- designing Java classes
- creating constructors
- working with object state
- implementing validation rules
- using arrays of objects
- passing objects to methods
- returning objects from methods
- writing reusable utility methods
- comparing Java objects
- understanding references
- using loops and conditions
- separating responsibilities between classes

## Example

```java
Student student = new Student("Alice", "Brown", 22);

student.addScore(80);
student.addScore(90);
student.addScore(75);

Student[] students = new Student[5];

students[0] = student;
```

The example shows how objects can be created, modified, and stored inside arrays.

## Learning Project

This repository was created as part of my Java learning process.

The project was developed incrementally, with each part introducing new Java concepts and extending previously implemented functionality.

The main purpose is not to build a production-ready application, but to develop a strong understanding of Java fundamentals and Object-Oriented Programming.
