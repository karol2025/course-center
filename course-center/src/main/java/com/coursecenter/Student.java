package com.coursecenter;

public class Student {

    // fields
    private final String studentId;

    private String firstName;
    private String lastName;
    private int age;
    private String email;

    private final int[] scores;
    private int scoreCount;

    private static int studentCount;
    private static int minStudentAge;

    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 100;
    private static final int DEFAULT_MAX_SCORES = 10;
    private static final String STUDENT_ID_PREFIX = "STUDENT-";


    // static block
    static {
        minStudentAge = 18;
    }


    // constructors
    public Student(String firstName, String lastName, int age) {
        this(
                firstName,
                lastName,
                age,
                null,
                DEFAULT_MAX_SCORES
        );
    }

    public Student(String firstName, String lastName, int age, String email) {
        this(
                firstName,
                lastName,
                age,
                email,
                DEFAULT_MAX_SCORES
        );
    }

    public Student(
            String firstName,
            String lastName,
            int age,
            String email,
            int maxScores
    ) {

        validateFirstName(firstName);
        validateLastName(lastName);
        validateAge(age);
        validateEmail(email);
        validateMaxScores(maxScores);

        this.studentId = generateNextStudentId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.scores = new int[maxScores];
        this.scoreCount = 0;
    }


    // getters
    public String getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }


    // setters
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public void setAge(int age) {
        validateAge(age);
        this.age = age;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }


    // scores
    public void addScore(int score) {
        validateScore(score);

        if (scoreCount >= scores.length) {
            throw new IllegalStateException("Scores array is full.");
        }

        scores[scoreCount] = score;
        scoreCount++;
    }

    public int getScore(int index) {
        if (index < 0 || index >= scoreCount) {
            throw new IllegalArgumentException("Invalid score index.");
        }

        return scores[index];
    }

    public int[] getScores() {
        int[] copy = new int[scoreCount];

        for (int i = 0; i < scoreCount; i++) {
            copy[i] = scores[i];
        }

        return copy;
    }

    public double getAverageScore() {
        if (scoreCount == 0) {
            return 0.0;
        }

        int sum = 0;

        for (int i = 0; i < scoreCount; i++) {
            sum += scores[i];
        }

        final double average = (double) sum / scoreCount;

        return average;
    }

    public int getHighestScore() {
        if (scoreCount == 0) {
            throw new IllegalStateException("No scores added.");
        }

        int highest = scores[0];

        for (int i = 1; i < scoreCount; i++) {
            if (scores[i] > highest) {
                highest = scores[i];
            }
        }

        return highest;
    }

    public int getLowestScore() {
        if (scoreCount == 0) {
            throw new IllegalStateException("No scores added.");
        }

        int lowest = scores[0];

        for (int i = 1; i < scoreCount; i++) {
            if (scores[i] < lowest) {
                lowest = scores[i];
            }
        }

        return lowest;
    }

    public boolean hasPassedAllExams(final int passingScore) {
        validateScore(passingScore);

        if (scoreCount == 0) {
            return false;
        }

        for (int i = 0; i < scoreCount; i++) {
            if (scores[i] < passingScore) {
                return false;
            }
        }

        return true;
    }


    // static
    public static int getStudentCount() {
        return studentCount;
    }

    public static int getMinimumAge() {
        return minStudentAge;
    }

    public static void setMinimumAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(
                    "Minimum age must be greater than zero."
            );
        }

        minStudentAge = age;
    }

    public static boolean isValidScore(int score) {
        return score >= MIN_SCORE && score <= MAX_SCORE;
    }

    public static Student compareByAverage(Student first, Student second) {
        if (first == null && second == null) {
            return null;
        }

        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        double firstAverage = first.getAverageScore();
        double secondAverage = second.getAverageScore();

        if (firstAverage > secondAverage) {
            return first;
        }

        if (secondAverage > firstAverage) {
            return second;
        }

        return first;
    }


    // summary
    public final String getSummary() {
        return "ID: " + studentId
                + ", name: " + getFullName()
                + ", age: " + age
                + ", email: " + email
                + ", scores: " + scoreCount
                + ", average: " + getAverageScore();
    }


    // private
    private static String generateNextStudentId() {
        studentCount++;

        return STUDENT_ID_PREFIX + studentCount;
    }

    private static void validateFirstName(String firstName) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException(
                    "First name cannot be null or blank."
            );
        }
    }

    private static void validateLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException(
                    "Last name cannot be null or blank."
            );
        }
    }

    private static void validateAge(int age) {
        if (age < minStudentAge) {
            throw new IllegalArgumentException(
                    "Age cannot be lower than " + minStudentAge + "."
            );
        }
    }

    private static void validateEmail(String email) {
        if (email != null && !email.contains("@")) {
            throw new IllegalArgumentException(
                    "Email must contain @."
            );
        }
    }

    private static void validateMaxScores(int maxScores) {
        if (maxScores <= 0) {
            throw new IllegalArgumentException(
                    "Maximum number of scores must be greater than zero."
            );
        }
    }

    private static void validateScore(int score) {
        if (!isValidScore(score)) {
            throw new IllegalArgumentException(
                    "Score must be between "
                            + MIN_SCORE
                            + " and "
                            + MAX_SCORE
                            + "."
            );
        }
    }


    // package-private
    String getDiagnosticInfo() {
        return "ID: " + studentId
                + ", scoreCount: " + scoreCount
                + ", scores capacity: " + scores.length;
    }


    // protected
    protected String getFullName() {
        return firstName + " " + lastName;
    }
}