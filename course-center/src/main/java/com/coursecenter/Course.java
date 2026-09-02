package com.coursecenter;

public class Course {

    // fields
    private final String courseCode;
    private String courseTitle;
    private int maxStudents;

    private final Student[] enrolledStudents;
    private int enrolledStudentCount;

    private static int courseCount;


    // constructors
    public Course(String courseCode, String courseTitle) {
        this(courseCode, courseTitle, 10);
    }

    public Course(String courseCode, String courseTitle, int maxStudents) {
        validateCourseCode(courseCode);
        validateCourseTitle(courseTitle);
        validateMaxStudents(maxStudents);

        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.maxStudents = maxStudents;

        this.enrolledStudents = new Student[maxStudents];
        this.enrolledStudentCount = 0;

        courseCount++;
    }


    // getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public int getEnrolledStudentCount() {
        return enrolledStudentCount;
    }


    // setters
    public void setCourseTitle(String courseTitle) {
        validateCourseTitle(courseTitle);
        this.courseTitle = courseTitle;
    }


    // operations
    public void enrollStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }

        if (isFull()) {
            throw new IllegalStateException("Course is full.");
        }

        if (findStudentById(student.getStudentId()) != null) {
            throw new IllegalArgumentException("Student is already enrolled.");
        }

        enrolledStudents[enrolledStudentCount] = student;
        enrolledStudentCount++;
    }


    public void removeStudentById(String studentId) {
        int index = -1;

        for (int i = 0; i < enrolledStudentCount; i++) {
            if (enrolledStudents[i].getStudentId().equals(studentId)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return;
        }

        for (int i = index; i < enrolledStudentCount - 1; i++) {
            enrolledStudents[i] = enrolledStudents[i + 1];
        }

        enrolledStudents[enrolledStudentCount - 1] = null;
        enrolledStudentCount--;
    }


    public Student findStudentById(String studentId) {
        for (int i = 0; i < enrolledStudentCount; i++) {
            if (enrolledStudents[i].getStudentId().equals(studentId)) {
                return enrolledStudents[i];
            }
        }

        return null;
    }


    public Student findStudentByEmail(String email) {
        for (int i = 0; i < enrolledStudentCount; i++) {
            String studentEmail = enrolledStudents[i].getEmail();

            if (studentEmail != null && studentEmail.equals(email)) {
                return enrolledStudents[i];
            }
        }

        return null;
    }


    public Student getTopStudent() {
        if (enrolledStudentCount == 0) {
            return null;
        }

        Student topStudent = enrolledStudents[0];

        for (int i = 1; i < enrolledStudentCount; i++) {
            if (enrolledStudents[i].getAverageScore()
                    > topStudent.getAverageScore()) {

                topStudent = enrolledStudents[i];
            }
        }

        return topStudent;
    }


    public double getCourseAverage() {
        if (enrolledStudentCount == 0) {
            return 0.0;
        }

        double sum = 0.0;

        for (int i = 0; i < enrolledStudentCount; i++) {
            sum += enrolledStudents[i].getAverageScore();
        }

        return sum / enrolledStudentCount;
    }


    public Student[] getEnrolledStudents() {
        Student[] copy = new Student[enrolledStudentCount];

        for (int i = 0; i < enrolledStudentCount; i++) {
            copy[i] = enrolledStudents[i];
        }

        return copy;
    }


    public boolean isFull() {
        return enrolledStudentCount >= maxStudents;
    }


    public void printStudentSummaries() {
        for (int i = 0; i < enrolledStudentCount; i++) {
            System.out.println(
                    enrolledStudents[i].getSummary()
            );
        }
    }


    // static
    public static int getCourseCount() {
        return courseCount;
    }


    // private
    private static void validateCourseCode(String courseCode) {
        if (courseCode == null || courseCode.isBlank()) {
            throw new IllegalArgumentException(
                    "Course code cannot be null or blank."
            );
        }
    }

    private static void validateCourseTitle(String courseTitle) {
        if (courseTitle == null || courseTitle.isBlank()) {
            throw new IllegalArgumentException(
                    "Course title cannot be null or blank."
            );
        }
    }

    private static void validateMaxStudents(int maxStudents) {
        if (maxStudents <= 0) {
            throw new IllegalArgumentException(
                    "Maximum number of students must be greater than zero."
            );
        }
    }
}