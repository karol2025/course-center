package com.coursecenter;

public class CourseCenterApp {

    public static void main(String[] args) {

        // students
        Student student1 = new Student("Jan", "Kowalski", 20, "jan@test.pl", 5);
        Student student2 = new Student("Anna", "Nowak", 22, "anna@test.pl");
        Student student3 = new Student("Piotr", "Zielinski", 25);
        Student student4 = new Student("Ola", "Wisniewska", 21, "ola@test.pl");


        // scores
        student1.addScore(80);
        student1.addScore(90);
        student1.addScore(70);

        student2.addScore(95);
        student2.addScore(90);
        student2.addScore(100);

        student3.addScore(60);
        student3.addScore(75);
        student3.addScore(70);

        student4.addScore(85);
        student4.addScore(88);
        student4.addScore(92);


        // courses
        Course javaCourse = new Course(
                "JAVA-01",
                "Java Basics",
                2
        );

        Course testingCourse = new Course(
                "TEST-01",
                "Software Testing",
                3
        );


        // enrollment
        javaCourse.enrollStudent(student1);
        javaCourse.enrollStudent(student2);

        testingCourse.enrollStudent(student2);
        testingCourse.enrollStudent(student3);
        testingCourse.enrollStudent(student4);


        // duplicate enrollment
        try {
            javaCourse.enrollStudent(student1);
        } catch (Exception exception) {
            System.out.println(
                    "Duplicate enrollment: " + exception.getMessage()
            );
        }


        // full course
        try {
            javaCourse.enrollStudent(student3);
        } catch (Exception exception) {
            System.out.println(
                    "Full course: " + exception.getMessage()
            );
        }


        // summaries
        System.out.println("\nStudent summaries:");

        System.out.println(student1.getSummary());
        System.out.println(student2.getSummary());
        System.out.println(student3.getSummary());
        System.out.println(student4.getSummary());


        // counters
        System.out.println("\nStudents created:");
        System.out.println(Student.getStudentCount());

        System.out.println("\nCourses created:");
        System.out.println(Course.getCourseCount());


        // top students
        System.out.println("\nTop student - Java:");

        Student javaTopStudent = javaCourse.getTopStudent();

        if (javaTopStudent != null) {
            System.out.println(javaTopStudent.getSummary());
        }


        System.out.println("\nTop student - Testing:");

        Student testingTopStudent = testingCourse.getTopStudent();

        if (testingTopStudent != null) {
            System.out.println(testingTopStudent.getSummary());
        }


        // course averages
        System.out.println("\nJava course average:");
        System.out.println(javaCourse.getCourseAverage());

        System.out.println("\nTesting course average:");
        System.out.println(testingCourse.getCourseAverage());


        // all students
        Student[] allStudents = {
                student1,
                student2,
                student3,
                student4
        };


        // oldest and youngest
        Student oldest =
                StudentArrayUtils.findOldestStudent(allStudents);

        Student youngest =
                StudentArrayUtils.findYoungestStudent(allStudents);

        System.out.println("\nOldest student:");

        if (oldest != null) {
            System.out.println(oldest.getSummary());
        }

        System.out.println("\nYoungest student:");

        if (youngest != null) {
            System.out.println(youngest.getSummary());
        }


        // above average
        double threshold = 80.0;

        Student[] aboveAverage =
                StudentArrayUtils.findStudentsAboveAverage(
                        allStudents,
                        threshold
                );

        System.out.println(
                "\nStudents with average above " + threshold + ":"
        );

        for (Student student : aboveAverage) {
            System.out.println(student.getSummary());
        }


        // static minimum age
        System.out.println("\nCurrent minimum age:");
        System.out.println(Student.getMinimumAge());

        Student.setMinimumAge(21);

        System.out.println("New minimum age:");
        System.out.println(Student.getMinimumAge());

        try {
            Student invalidStudent =
                    new Student(
                            "Adam",
                            "Testowy",
                            19
                    );

        } catch (IllegalArgumentException exception) {
            System.out.println(
                    "Minimum age validation: "
                            + exception.getMessage()
            );
        }


        // independent score arrays
        System.out.println("\nIndependent score arrays:");

        System.out.println(
                student1.getStudentId()
                        + " first score: "
                        + student1.getScore(0)
        );

        System.out.println(
                student2.getStudentId()
                        + " first score: "
                        + student2.getScore(0)
        );


        // static belongs to class
        System.out.println("\nStatic student counter:");

        System.out.println(
                Student.getStudentCount()
        );


        // invalid operations
        try {
            student1.addScore(150);
        } catch (IllegalArgumentException exception) {
            System.out.println(
                    "Invalid score: "
                            + exception.getMessage()
            );
        }

        try {
            student1.setEmail("incorrect-email");
        } catch (IllegalArgumentException exception) {
            System.out.println(
                    "Invalid email: "
                            + exception.getMessage()
            );
        }

        try {
            new Course(
                    "",
                    "Invalid Course",
                    5
            );
        } catch (IllegalArgumentException exception) {
            System.out.println(
                    "Invalid course: "
                            + exception.getMessage()
            );
        }


        // course summaries
        System.out.println("\nJava course students:");
        javaCourse.printStudentSummaries();

        System.out.println("\nTesting course students:");
        testingCourse.printStudentSummaries();
    }
}