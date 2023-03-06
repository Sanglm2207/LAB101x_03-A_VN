import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StudentManager {
    ArrayList<Student> students = new ArrayList<Student>();
    Scanner scanner = new Scanner(System.in);
    public void addStruent() {
        int studentCount = 0;
        while (true) {
            if (studentCount >= 10) {
                System.out.print("Bạn đã tạo 10 sinh viên. Bạn có muốn tiếp tục tạo nữa không (Y/N)? ");
                String option = scanner.nextLine();
                if (!option.equalsIgnoreCase("Y")) {
                    break;
                }
            }
            System.out.print("Nhập ID của sinh viên: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nhập tên của sinh viên: ");
            String name = scanner.nextLine();

            System.out.print("Nhập học kỳ đang học của sinh viên: ");
            String semester = scanner.nextLine();

            System.out.print("Nhập khóa học của sinh viên (Java, .Net, C/C++): ");
            String course = scanner.nextLine();

            Student student = new Student(id, name, semester, course);
            students.add(student);
            studentCount++;
        }
    }

    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void findAndSortStudentsByName() {
        System.out.print("Nhập tên sinh viên hoặc một phần của tên sinh viên: ");
        String name = scanner.nextLine();
        ArrayList<Student> foundStudents = new ArrayList<Student>();

        for (Student student : students) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                foundStudents.add(student);
            }
        }

        foundStudents.sort((Student s1, Student s2) -> s1.getName().compareTo(s2.getName()));

        if (foundStudents.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên nào có tên đó hoặc một phần của tên đó.");
        } else {
            for (Student student : foundStudents) {
                System.out.println("Họ tên: " + student.getName());
                System.out.println("Học kỳ: " + student.getSemester());
                System.out.println("Khoá học: " + student.getCourse());
                System.out.println();
            }
        }
    }

    public void updateAndDelete() {
        System.out.print("Nhập ID sinh viên muốn cập nhật/xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student student = findStudentById(id);

        if (student != null) {
            System.out.print("Bạn muốn cập nhật (U) hay xóa (D) sinh viên này? ");
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("U")) {
                System.out.print("Nhập tên mới của sinh viên: ");
                String name = scanner.nextLine();
                student.setName(name);

                System.out.print("Nhập học kỳ mới của sinh viên: ");
                String semester = scanner.nextLine();
                student.setSemester(semester);

                System.out.print("Nhập khoá học mới của sinh viên: ");
                String course = scanner.nextLine();
                student.setCourse(course);
            } else if (option.equalsIgnoreCase("D")) {
                students.remove(student);
                System.out.println("Sinh viên có id: " + id + " đã xoá.");
            } else {
                System.out.println("Tùy chọn không hợp lệ. Vui lòng thử lại.");
            }
        } else {
            System.out.println("Không tìm thấy sinh viên với ID: " + id);
        }
    }

    public void report() {
        HashMap<String, Integer> coursesCount = new HashMap<String, Integer>();

        for (Student student : students) {
            String course = student.getCourse();
            if (coursesCount.containsKey(course)) {
                int count = coursesCount.get(course);
                count++;
                coursesCount.put(course, count);
            } else {
                coursesCount.put(course, 1);
            }
        }

        for (Student student : students) {
            String name = student.getName();
            String course = student.getCourse();
            int count = coursesCount.get(course);
            System.out.println(name + " | " + course + " | " + count);
        }
    }

}
