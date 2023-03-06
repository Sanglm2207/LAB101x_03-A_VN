import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo đối tượng Scanner để nhận đầu vào từ người dùng.
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu người dùng nhập số thập phân dương và lưu giá trị vào biến num.
        System.out.print("Nhập số thập phân dương: ");
        double num = scanner.nextDouble();

        // Gọi hàm displayAndSortArray với đối số là giá trị num đã nhập.
        displayAndSortArray(num);
    }

    public static void displayAndSortArray(double num) {
        // Chuyển đổi giá trị num thành một số nguyên và lưu vào biến n.
        int n = (int) num;

        // Khởi tạo một mảng các số nguyên có kích thước là n.
        int[] arr = new int[n];

        // Khởi tạo một đối tượng Random để tạo các số nguyên ngẫu nhiên cho mảng.
        Random random = new Random();

        // Tạo mảng và hiển thị các phần tử chưa được sắp xếp.
        System.out.print("Mảng chưa được sắp xếp: ");
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n); // Tạo số nguyên ngẫu nhiên trong phạm vi từ 0 đến n-1.
            System.out.print(arr[i] + " "); // Hiển thị các phần tử của mảng.
        }

        // Sử dụng phương pháp Bubble Sort để sắp xếp mảng.
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // Hiển thị các phần tử đã được sắp xếp.
        System.out.print("\nMảng đã được sắp xếp: " + Arrays.toString(arr));
    }
}