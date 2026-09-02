package com.coursecenter;

public class StudentArrayUtils {

    // constructor
    private StudentArrayUtils() {
    }


    // count
    public static int countStudents(Student[] students) {
        int count = 0;

        for (Student student : students) {
            if (student != null) {
                count++;
            }
        }

        return count;
    }


    // oldest
    public static Student findOldestStudent(Student[] students) {
        Student oldest = null;

        for (Student student : students) {
            if (student != null) {
                if (oldest == null || student.getAge() > oldest.getAge()) {
                    oldest = student;
                }
            }
        }

        return oldest;
    }


    // youngest
    public static Student findYoungestStudent(Student[] students) {
        Student youngest = null;

        for (Student student : students) {
            if (student != null) {
                if (youngest == null || student.getAge() < youngest.getAge()) {
                    youngest = student;
                }
            }
        }

        return youngest;
    }


    // average age
    public static double calculateAverageAge(Student[] students) {
        int sum = 0;
        int count = 0;

        for (Student student : students) {
            if (student != null) {
                sum += student.getAge();
                count++;
            }
        }

        if (count == 0) {
            return 0.0;
        }

        return (double) sum / count;
    }


    // above average
    public static Student[] findStudentsAboveAverage(
            Student[] students,
            double minimumAverage
    ) {

        int matchCount = 0;

        for (Student student : students) {
            if (student != null
                    && student.getAverageScore() > minimumAverage) {

                matchCount++;
            }
        }

        Student[] result = new Student[matchCount];

        int resultIndex = 0;

        for (Student student : students) {
            if (student != null
                    && student.getAverageScore() > minimumAverage) {

                result[resultIndex] = student;
                resultIndex++;
            }
        }

        return result;
    }


    // copy
    public static Student[] copyStudents(Student[] students) {
        Student[] copy = new Student[students.length];

        for (int i = 0; i < students.length; i++) {
            copy[i] = students[i];
        }

        return copy;
    }


    // reverse
    public static Student[] reverse(Student[] students) {
        Student[] reversed = new Student[students.length];

        for (int i = 0; i < students.length; i++) {
            reversed[i] = students[students.length - 1 - i];
        }

        return reversed;
    }


    // sort
    public static Student[] sortByAverageScoreDescending(Student[] students) {
        Student[] sorted = copyStudents(students);

        for (int i = 0; i < sorted.length - 1; i++) {

            for (int j = 0; j < sorted.length - 1 - i; j++) {

                if (sorted[j] == null) {
                    Student temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;

                } else if (sorted[j + 1] != null
                        && sorted[j].getAverageScore()
                        < sorted[j + 1].getAverageScore()) {

                    Student temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }

        return sorted;
    }
}