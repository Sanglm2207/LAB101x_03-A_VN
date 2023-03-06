import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Candidate> candidates = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("HỆ THỐNG QUẢN LÝ ỨNG VIÊN");
            System.out.println("1. Tạo ứng viên có kinh nghiệm");
            System.out.println("2. Tạo ứng viên fresher");
            System.out.println("3. Tạo ứng viên thực tập sinh");
            System.out.println("4. Tìm kiếm ứng viên");
            System.out.println("5. Thoát");
            System.out.print("Vui lòng chọn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
//                    candidates.add(createExperienceCandidate(sc));
                    break;
                case 2:
//                    candidates.add(createFresherCandidate(sc));
                    break;
                case 3:
//                    candidates.add(createInternCandidate(sc));
                    break;
                case 4:
//                    searchCandidate(candidates, sc);
                    break;
                case 5:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Vui lòng chọn lại!");
                    break;
            }
        } while (choice != 5);
        sc.close();
    }
}