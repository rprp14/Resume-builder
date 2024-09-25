package hms;
import java.util.ArrayList;
import java.util.Scanner;
// Class to represent a course
class Course {
    String code;
    String title;
    String description;
    int capacity;
    int enrolled;
    String schedule;
    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolled = 0;
        this.schedule = schedule;
    }
    public boolean isFull() {
        return enrolled >= capacity;
    }
    public void enroll() {
        if (!isFull()) {
            enrolled++;
        }
    }
    public void drop() {
        if (enrolled > 0) {
            enrolled--;
        }
    }
    @Override
    public String toString() {
        return code + ": " + title + " (" + enrolled + "/" + capacity + " enrolled)\n" + description + "\nSchedule: " + schedule;
    }
}
// Class to represent a student
class Student {
    String id;
    String name;
    ArrayList<Course> registeredCourses;
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
    public void registerCourse(Course course) {
        if (!course.isFull()) {
            registeredCourses.add(course);
            course.enroll();
            System.out.println("Successfully registered for: " + course.title);
        } else {
            System.out.println("Course is full: " + course.title);
        }
    }
    public void dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.drop();
            System.out.println("Successfully dropped: " + course.title);
        } else {
            System.out.println("You are not registered for: " + course.title);
        }
    }
    public void listCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            System.out.println("Registered courses:");
            for (Course course : registeredCourses) {
                System.out.println(course);
            }
        }
    }
}
// Class to manage the course registration system
public class CodsoftTask5 {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Sample courses
        courses.add(new Course("CS101", "Introduction to Computer Science", "Basics of Computer Science", 30, "Mon-Wed-Fri 10:00-11:00"));
        courses.add(new Course("MATH101", "Calculus I", "Introduction to Calculus", 25, "Tue-Thu 9:00-10:30"));
        courses.add(new Course("ENG101", "English Literature", "Study of English Literature", 20, "Mon-Wed 12:00-13:30"));
        // Sample student
        Student student = new Student("S123", "John Doe");
        students.add(student);
        // Main menu
        while (true) {
            System.out.println("\nCourse Registration System");
            System.out.println("1. List available courses");
            System.out.println("2. Register for a course");
            System.out.println("3. Drop a course");
            System.out.println("4. List registered courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            switch (choice) {
                case 1:
                    listAvailableCourses();
                    break;
                case 2:
                    registerCourse(student);
                    break;
                case 3:
                    dropCourse(student);
                    break;
                case 4:
                    student.listCourses();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void listAvailableCourses() {
        System.out.println("\nAvailable courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }
    private static void registerCourse(Student student) {
        System.out.print("Enter course code to register: ");
        String code = scanner.nextLine();
        Course course = findCourse(code);
        if (course != null) {
            student.registerCourse(course);
        } else {
            System.out.println("Course not found.");
        }
    }
    private static void dropCourse(Student student) {
        System.out.print("Enter course code to drop: ");
        String code = scanner.nextLine();
        Course course = findCourse(code);
        if (course != null) {
            student.dropCourse(course);
        } else {
            System.out.println("Course not found.");
        }
    }
    private static Course findCourse(String code) {
        for (Course course : courses) {
            if (course.code.equalsIgnoreCase(code)) {
                return course;
            }
        }
        return null;
    }
}
