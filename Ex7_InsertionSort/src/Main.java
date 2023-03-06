import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Hiển thị màn hình để yêu cầu người dùng nhập số thập phân dương
        System.out.print("Nhập một số thập phân dương: ");
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        while (num <= 0) {
            System.out.print("Số phải là số thập phân dương. Vui lòng nhập lại: ");
            num = scanner.nextDouble();
        }
        scanner.close();

        // Tạo và sắp xếp mảng ngẫu nhiên
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt((int) num) + 1;
        }

        System.out.println("Mảng trước khi sắp xếp: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}