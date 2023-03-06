import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private String customerName;
    private Date orderDate;
    private double total;
    private ArrayList<Fruit> fruits;

    public Order(int id, String customerName, Date orderDate, double total, ArrayList<Fruit> fruits) {
        this.id = id;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.total = total;
        this.fruits = fruits;
    }

    //getters and setters methods
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    // các phương thức thêm / xóa trái cây khỏi danh sách đơn hàng
    public void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }

    public void removeFruit(Fruit fruit) {
        fruits.remove(fruit);
    }

    // các phương thức tính toán giá trị đơn hàng
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Fruit fruit : fruits) {
            totalPrice += fruit.getPrice() * fruit.getQuantity();
        }
        return totalPrice;
    }

    public void displayOrderDetails() {
        System.out.println("Khách hàng: " + this.customerName);
        System.out.printf("%-10s | %-10s | %-10s | %-10s%n", "Sản phẩm", "Số lượng", "Giá", "Số tiền");
        double total = 0;
        for (Fruit fruit : fruits) {
            double cost = fruit.getQuantity() * fruit.getPrice();
            System.out.printf("%-10s | %-10d | %-10.2f | %-10.2f%n", fruit.getName(), fruit.getQuantity(), fruit.getPrice(), cost);
            total += cost;
        }
        System.out.println("Tổng cộng: " + total + "$\n");
    }

}

