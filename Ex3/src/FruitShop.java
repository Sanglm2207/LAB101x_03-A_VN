import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FruitShop {
    static ArrayList<Fruit> fruits = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int option = 0;
        while (option != 4) {
            System.out.println("HỆ THỐNG CỬA HÀNG TRÁI CÂY xin chào!");
            System.out.println("1. Tạo trái cây (Manual)");
            System.out.println("2. Tạo trái cây (Auto");
            System.out.println("3. Xem đơn đặt hàng");
            System.out.println("4. Mua sắm (cho người mua)");
            System.out.println("5. Thoát");
            System.out.print("Vui lòng chọn lại: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    createFruit();
                    break;
                case 2:
                    initData();
                    break;
                case 3:
                    viewOrders();
                    break;
                case 4:
                    buyFruits(input, fruits);
                    break;
                case 5:
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn sai. Vui lòng thủ lại.");
            }
        }
    }

    public static void initData() throws IOException {
        // Khởi tạo đối tượng Gson
        Gson gson = new Gson();

        // Đọc dữ liệu từ file fruits.json
        FileReader reader = new FileReader("/Users/kaidev99/Desktop/funix-edu/LAB101x/Ex3/src/fruits.json");
        Type type = new TypeToken<List<Fruit>>() {}.getType();
        List<Fruit> fruit1 = gson.fromJson(reader, type);
        reader.close();

        // In ra danh sách trái cây
//        for (Fruit fruit : fruits) {
//            System.out.println(fruit);
//        }
        // Lưu danh sách fruits vào field fruits của lớp hiện tại
        fruits.addAll(fruit1);
    }
    public static void createFruit() {
        Scanner sc = new Scanner(System.in);
        String fruitName, fruitOrigin;
        int fruitCode, quantity;
        double price;

        System.out.println("Nhập 1 trái cây:");
        System.out.print("Mã trái cây: ");
        fruitCode = sc.nextInt();
        sc.nextLine();
        System.out.print("Tên trái cây: ");
        fruitName = sc.nextLine();
        System.out.print("Giá bán: ");
        price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Số lượng: ");
        quantity = sc.nextInt();
        sc.nextLine();
        System.out.print("Nguồn gốc: ");
        fruitOrigin = sc.nextLine();

        Fruit fruit = new Fruit(fruitCode, fruitName, price, quantity, fruitOrigin);
        fruits.add(fruit);

        System.out.print("Do you want to continue? (Y/N) ");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            createFruit();
        }
    }

    public static void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("Hiện tại chưa có đơn hàng nào!");
        } else {
            // Hiển thị thông tin các đơn hàng trong danh sách
            for (Order order : orders) {
                System.out.println("Mã đơn hàng: " + order.getId());
                order.displayOrderDetails();
            }
        }
    }

    public static void buyFruits(Scanner scanner, ArrayList<Fruit> fruits) {
        while (true) {
            System.out.println("Danh mục Trái cây:");
            System.out.printf("%-10s | %-20s | %-15s | %-5s%n", "Mục", "Tên trái cây", "Xuất xứ", "Giá");

            for (int i = 0; i < fruits.size(); i++) {
                Fruit fruit = fruits.get(i);
                System.out.printf("%-10d | %-20s | %-15s | %-5.0f$%n", i + 1, fruit.getName(), fruit.getOrigin(), fruit.getPrice());
            }

            System.out.println("Vui lòng chọn một mặt hàng (hoặc 0 để quay lại trang chủ):");
            int selected = scanner.nextInt();

            if (selected == 0) {
                break;
            } else if (selected < 1 || selected > fruits.size()) {
                System.out.println("Mặt hàng không hợp lệ, vui lòng chọn lại.");
                continue;
            }

            Fruit selectedFruit = fruits.get(selected - 1);

            System.out.println("Bạn đã chọn: " + selectedFruit.getName());
            System.out.println("Vui lòng nhập số lượng:");

            int quantity = scanner.nextInt();
            double cost = selectedFruit.getPrice() * quantity;

            System.out.printf("%-10s | %-10d | %-5.0f$ | %-5.0f$%n", selectedFruit.getName(), quantity, selectedFruit.getPrice(), cost);

            System.out.println("Tổng cộng: " + cost + "$");
            System.out.println("Bạn có muốn đặt hàng ngay bây giờ (Y/N)?");
            scanner.nextLine(); // consume the remaining newline character
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("Y")) {
                System.out.println("Nhập tên của bạn:");
                String name = scanner.nextLine();
                System.out.println("Cảm ơn bạn " + name + "đã đặt hàng !");
                break;
            } else if (answer.equalsIgnoreCase("N")) {
                continue;
            } else {
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
                continue;
            }
        }
    }









}