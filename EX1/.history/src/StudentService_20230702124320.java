import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentService {
    public void printStudent(ArrayList<Student> students) {
        System.out.println("----------------------------------------------------");
        System.out.printf("| %-19s| %-6s| %-20s|\n", "Tên sinh viên", "Học kỳ", "Tên khóa học");
        System.out.println("----------------------------------------------------");

        for (Student student : students) {
            String name = student.getName();
            String semester = student.getSemester();
            String course = student.getCourse();

            System.out.printf("| %-19s| %-6s| %-20s|\n", name, semester, course);
            System.out.println("----------------------------------------------------");
        }
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
            printStudent(searchResults);
            
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
            System.out.println("Báo cáo sinh viên:");
            System.out.println("Tên sinh viên\t\tKhóa học\t\tTổng số khóa học");
            System.out.println("----------------------------------------");
            ArrayList<String> processedStudents = new ArrayList<>();

            for (Student student : students) {
                String key = student.getName() + student.getCourse();
                if (!processedStudents.contains(key)) {
                    processedStudents.add(key);
                    int count = getCountByStudent(students, student);
                    System.out.println(student.getName() + "\t\t" + student.getCourse() + "\t\t" + count);
                }
            }
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
