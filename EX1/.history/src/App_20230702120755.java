import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Student> students;
    private static Scanner scanner;
    private static StudentService studentService;

    public static void main(String[] args) throws Exception {
         students = new ArrayList<>();
        scanner = new Scanner(System.in);
        studentService = new StudentService();
        System.out.println("Hello, World!");
    }
}
