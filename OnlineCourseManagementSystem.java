import java.util.Scanner;

class Course {
    String courseName;
    String courseId;
    String duration;

    Course(String courseName, String courseId, String duration) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.duration = duration;
    }

    void displayCourse() {
        System.out.println("Course Name : " + courseName);
        System.out.println("Course ID   : " + courseId);
        System.out.println("Duration    : " + duration);
    }
}

class Student {
    String studentName;
    String studentId;
    int progress;
    Course enrolledCourse;

    Student(String studentName, String studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.progress = 0;
    }

    void enroll(Course course) {
        enrolledCourse = course;
    }

    void updateProgress(int progress) {
        this.progress = progress;
    }

    void displayStudent() {
        System.out.println("\nStudent Name : " + studentName);
        System.out.println("Student ID   : " + studentId);

        if (enrolledCourse != null) {
            System.out.println("Enrolled In  : " + enrolledCourse.courseName);
        }

        System.out.println("Progress     : " + progress + "%");
    }
}

public class OnlineCourseManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Course[] courses = new Course[3];
        Student[] students = new Student[3];

        courses[0] = new Course("Java Programming", "C101", "3 Months");
        courses[1] = new Course("Python Programming", "C102", "2 Months");
        courses[2] = new Course("Web Development", "C103", "4 Months");

        System.out.println("===== ONLINE COURSE MANAGEMENT SYSTEM =====");

        for (int i = 0; i < students.length; i++) {

            System.out.println("\nEnter Student " + (i + 1) + " Details");

            System.out.print("Student Name: ");
            String name = sc.nextLine();

            System.out.print("Student ID: ");
            String id = sc.nextLine();

            students[i] = new Student(name, id);

            System.out.println("\nAvailable Courses");
            for (int j = 0; j < courses.length; j++) {
                System.out.println((j + 1) + ". " + courses[j].courseName);
            }

            System.out.print("Choose Course (1-3): ");
            int choice = sc.nextInt();

            students[i].enroll(courses[choice - 1]);

            System.out.print("Enter Progress (%): ");
            int progress = sc.nextInt();

            students[i].updateProgress(progress);

            sc.nextLine();
        }

        System.out.println("\n====================================");
        System.out.println("          COURSE DETAILS");
        System.out.println("====================================");

        for (int i = 0; i < courses.length; i++) {

            courses[i].displayCourse();

            System.out.println("Enrolled Students:");

            for (int j = 0; j < students.length; j++) {

                if (students[j].enrolledCourse == courses[i]) {
                    System.out.println(
                            students[j].studentName +
                            " - Progress: " +
                            students[j].progress + "%");
                }
            }

            System.out.println("------------------------------------");
        }

        System.out.println("\n====================================");
        System.out.println("          STUDENT DETAILS");
        System.out.println("====================================");

        for (int i = 0; i < students.length; i++) {
            students[i].displayStudent();
            System.out.println("------------------------------------");
        }

        sc.close();
    }
}