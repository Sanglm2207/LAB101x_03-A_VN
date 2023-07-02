import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentService {
    public void printStudent(ArrayList<String[]> students, String[] headers, int[] columnWidths) {
        // In đường kẻ ngang
        printHorizontalLine(columnWidths);
        // In tiêu đề
        printRow(headers, columnWidths);
        // In đường kẻ ngang
        printHorizontalLine(columnWidths);
        // In dữ liệu sinh viên
        for (String[] rowData : students) {
            printRow(rowData, columnWidths);
            // In đường kẻ ngang
            printHorizontalLine(columnWidths);
        }
    }
    
    private void printRow(String[] rowData, int[] columnWidths) {
        StringBuilder rowBuilder = new StringBuilder("|");
        for (int i = 0; i < rowData.length; i++) {
            String columnValue = rowData[i];
            String format = " %" + columnWidths[i] + "s |";
            rowBuilder.append(String.format(format, columnValue));
        }
        System.out.println(rowBuilder.toString());
    }

    private void printHorizontalLine(int[] columnWidths) {
        StringBuilder lineBuilder = new StringBuilder("+");
        for (int width : columnWidths) {
            lineBuilder.append("-".repeat(width + 2)).append("+");
        }
        System.out.println(lineBuilder.toString());
    }

    private void printSeparator(int[] columnWidths) {
        StringBuilder separator = new StringBuilder();
        for (int width : columnWidths) {
            separator.append("-".repeat(Math.max(0, width + 2))); // +2 để tính cả khoảng trắng hai bên
            separator.append("+");
        }
        System.out.println(separator.toString());
    }
    
    public ArrayList<Student> searchAndSortStudents(ArrayList<Student> students, String searchName) {
        ArrayList<Student> searchResults = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(searchName)) {
                searchResults.add(student);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên.");
        } else {
            Collections.sort(searchResults, new StudentNameComparator());
            String[] headers = { "Tên sinh viên", "Học kỳ", "Tên khóa học" };
            int[] columnWidths = { 20, 10, 20 };
            printStudent(searchResults, headers, columnWidths);
            
        }
        return searchResults;
    }

    public void createStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.print("Nhập số lượng sinh viên muốn tạo: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống sau khi nhập số

        for (int i = 0; i < count; i++) {
            System.out.println("Sinh viên #" + (i + 1) + ":");
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Tên sinh viên: ");
            String name = scanner.nextLine();
            System.out.print("Học kỳ: ");
            String semester = scanner.nextLine();
            System.out.print("Tên khóa học: ");
            String course = scanner.nextLine();

            Student student = new Student(id, name, semester, course);
            students.add(student);
            System.out.println("Sinh viên đã được tạo thành công.");
            System.out.println();
        }
        if (count > 10) {
            System.out.print("Bạn có muốn tiếp tục (Y/N)? ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("Y")) {
                return;
            }
        }
    }

    public void updateOrDeleteStudent(ArrayList<Student> students, String id, Scanner scanner) {
        Student student = findStudentById(students, id);
        if (student == null) {
            System.out.println("Không tìm thấy sinh viên với ID đã cho.");
            return;
        }

        System.out.print("Bạn muốn cập nhật (U) hay xóa (D) sinh viên? ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("U")) {
            System.out.print("Nhập thông tin cập nhật cho sinh viên " + student.getName() + ":\n");
            System.out.print("ID: ");
            student.setId(scanner.nextLine());
            System.out.print("Tên sinh viên: ");
            student.setName(scanner.nextLine());
            System.out.print("Học kỳ: ");
            student.setSemester(scanner.nextLine());
            System.out.print("Tên khóa học: ");
            student.setCourse(scanner.nextLine());
            System.out.println("Thông tin sinh viên đã được cập nhật.");
        } else if (choice.equalsIgnoreCase("D")) {
            students.remove(student);
            System.out.println("Sinh viên " + student.getName() + " đã được xóa.");
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
        }
    }

   public void generateReport(ArrayList<Student> students) {
    if (students.isEmpty()) {
        System.out.println("Danh sách sinh viên rỗng.");
    } else {
        String[] headers = { "Tên sinh viên", "Khóa học", "Tổng số khóa học" };
        int[] columnWidths = { 20, 20, 20 };
        System.out.println("Báo cáo sinh viên:");
        printRow(headers, columnWidths);
        printSeparator(columnWidths);
        ArrayList<String> processedStudents = new ArrayList<>();

        for (Student student : students) {
            String key = student.getName() + student.getCourse();
            if (!processedStudents.contains(key)) {
                processedStudents.add(key);
                int count = getCountByStudent(students, student);
                String[] rowData = { student.getName(), student.getCourse(), String.valueOf(count) };
                printRow(rowData, columnWidths);
            }
        }
        printSeparator(columnWidths);
    }
}


    private int getCountByStudent(ArrayList<Student> students, Student student) {
        int count = 0;
        for (Student s : students) {
            if (s.getName().equals(student.getName()) && s.getCourse().equals(student.getCourse())) {
                count++;
            }
        }
        return count;
    }

    private Student findStudentById(ArrayList<Student> students, String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    private class StudentNameComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getName().compareTo(s2.getName());
        }
    }
}
