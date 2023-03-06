import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Nhập số phần tử của mảng từ người dùng
        System.out.print("Nhập số phần tử của mảng: ");
        int n = input.nextInt();

        // Khởi tạo mảng
        int[] arr = new int[n];

        // Tạo mảng ngẫu nhiên
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(100); // Phạm vi giá trị từ 0 đến 99
        }

        // Hiển thị mảng trước khi sắp xếp
        System.out.println("Mảng trước khi sắp xếp: " + Arrays.toString(arr));

        // Sắp xếp mảng
        quickSort(arr, 0, n-1);

        // Hiển thị mảng sau khi sắp xếp
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(arr));

    }

    // Thuật toán Quick Sort
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // Chọn phần tử giữa làm phần tử chốt
            int pivot = arr[(left + right) / 2];
            int i = left;
            int j = right;

            // Phân hoạch mảng
            while (i <= j) {
                while (arr[i] < pivot) {
                    i++;
                }
                while (arr[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            }

            // Đệ quy sắp xếp phần tử trái và phải của mảng
            if (left < j) {
                quickSort(arr, left, j);
            }
            if (i < right) {
                quickSort(arr, i, right);
            }
        }
    }
}