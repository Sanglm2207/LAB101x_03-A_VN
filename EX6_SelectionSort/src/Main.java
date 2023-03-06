import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số phần tử của mảng từ người dùng
        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();

        // Tạo mảng và khởi tạo giá trị ngẫu nhiên cho từng phần tử
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100); // Giới hạn phạm vi số từ 0 đến 99
        }

        // Hiển thị mảng chưa được sắp xếp
        System.out.println("Mảng chưa được sắp xếp: " + Arrays.toString(arr));

        // Sắp xếp mảng bằng thuật toán sắp xếp lựa chọn
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        // Hiển thị mảng đã được sắp xếp
        System.out.println("Mảng đã được sắp xếp: " + Arrays.toString(arr));
    }
}
