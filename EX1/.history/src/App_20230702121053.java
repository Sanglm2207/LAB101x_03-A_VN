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

        boolean exit = false;

        while (!exit) {
            System.out.println("CHÀO MỪNG ĐẾN QUẢN LÝ SINH VIÊN");
            System.out.println("1. Tạo");
            System.out.println("2. Tìm kiếm và Sắp xếp");
            System.out.println("3. Cập nhật/Xóa");
            System.out.println("4. Báo cáo");
            System.out.println("5. Thoát chương trình");
            System.out.print("Hãy chọn một chức năng (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống sau khi nhập số

            switch (choice) {
                case 1:
                studentService.createStudent(students, scanner);
                    break;
                case 2:
                    break;
                case 3:
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
        scanner.close();
    }
}
