import java.util.Random; // Import thư viện Random để tạo ngẫu nhiên các giá trị trong mảng
import java.util.Scanner; // Import thư viện Scanner để đọc giá trị từ bàn phím

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng scanner để đọc giá trị từ bàn phím
        System.out.print("Nhập số phần tử của mảng: "); // Hiển thị thông báo để yêu cầu người dùng nhập số phần tử của mảng
        int n = scanner.nextInt(); // Đọc số phần tử của mảng từ bàn phím
        int[] arr = new int[n]; // Khai báo một mảng số nguyên có độ dài là n
        Random random = new Random(); // Khởi tạo đối tượng random để tạo ngẫu nhiên các giá trị trong mảng
        for (int i = 0; i < n; i++) { // Lặp qua từng phần tử trong mảng
            arr[i] = random.nextInt(n*10); // Gán giá trị ngẫu nhiên cho phần tử tại vị trí i
        }
        System.out.println("Mảng chưa sắp xếp: "); // Hiển thị thông báo để thông báo mảng chưa được sắp xếp
        printArray(arr); // Gọi hàm printArray để in ra các phần tử trong mảng
        mergeSort(arr, 0, n-1); // Sử dụng thuật toán Merge Sort để sắp xếp mảng
        System.out.println("Mảng đã sắp xếp: "); // Hiển thị thông báo để thông báo mảng đã được sắp xếp
        printArray(arr); // Gọi hàm printArray để in ra các phần tử trong mảng đã được sắp xếp

    }

    public static void mergeSort(int[] arr, int left, int right) {
        // Kiểm tra điều kiện dừng đệ quy, chỉ sắp xếp mảng khi left < right
        if (left < right) {
            // Tìm chỉ số giữa của mảng
            int mid = (left + right) / 2;
            // Đệ quy sắp xếp nửa đầu của mảng từ left đến mid
            mergeSort(arr, left, mid);
            // Đệ quy sắp xếp nửa sau của mảng từ mid+1 đến right
            mergeSort(arr, mid + 1, right);
            // Trộn hai nửa đã sắp xếp thành một mảng đã sắp xếp
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // Tính kích thước của hai mảng con để trộn
        int n1 = mid - left + 1;
        int n2 = right - mid;
        // Tạo hai mảng con
        int[] L = new int[n1];
        int[] R = new int[n2];
        // Sao chép dữ liệu từ mảng ban đầu sang hai mảng con
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];
        // Trộn hai mảng con thành một mảng đã sắp xếp
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // Sao chép các phần tử còn lại của mảng L (nếu có)
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // Sao chép các phần tử còn lại của mảng R (nếu có)
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] arr) {
        // Duyệt và in các phần tử của mảng
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        // Xuống dòng để hiển thị kết quả cho rõ ràng
        System.out.println();
    }
}