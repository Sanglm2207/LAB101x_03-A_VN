import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("CHÀO MỪNG ĐẾN QUẢN LÝ SINH VIÊN");
            System.out.println("1. Tạo");
            System.out.println("2. Tìm kiếm và Sắp xếp");
            System.out.println("3. Cập nhật/Xóa");
            System.out.println("4. Báo cáo");
            System.out.println("5. Thoát");
            System.out.print("Hãy chọn: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    //Them sinh vien
                    manager.addStruent();
                    break;
                case 2:
                    //Tim kiem sinh vien (kèm sort)
                    manager.findAndSortStudentsByName();
                    break;
                case 3:
                    //Cập nhật or Xoá
                    manager.updateAndDelete();
                    break;
                case 4:
                    //xuất báo cáo
                    manager.report();
                    break;
                case 5:
                    //thoát chương trình
                    System.out.println("Cảm ơn đã sử dụng chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (choice != 5);
    }
}