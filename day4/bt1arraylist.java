/*
Bài tập 1 : Viết chương trình quản lý Tên Sinh Viên dưới dạng
console, yêu cầu sử dụng ArrayList và thực hiện các chức năng
sau (tạo menu):
a) Thêm Sinh viên
b) Xuất danh sách sinh viên
c) Sửa Sinh Viên
d) Xóa Sinh viên chứa tên bất kỳ
e) Tìm Sinh viên mà tên có chữ An
f) Sắp xếp Sinh Viên
g) Xuất ra số lượng sinh viên
làm như menu để người dùng chọn chức năng muốn thực hiện, sau đó thực hiện chức năng đó. và có nút thoát chương trình.
*/
package day4;
import java.util.*;
public class bt1arraylist {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Thêm Sinh viên");
            System.out.println("2. Xuất danh sách sinh viên");
            System.out.println("3. Sửa Sinh Viên");
            System.out.println("4. Xóa Sinh viên chứa tên bất kỳ");
            System.out.println("5. Tìm Sinh viên mà tên có chữ An");
            System.out.println("6. Sắp xếp Sinh Viên");
            System.out.println("7. Xuất ra số lượng sinh viên");
            System.out.println("8. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên sinh viên: ");
                    String name = scanner.nextLine();
                    students.add(name);
                    break;
                case 2:
                    System.out.println("Danh sách sinh viên:");
                    for (String student : students) {
                        System.out.println(student);
                    }
                    break;
                case 3:
                    System.out.print("Nhập tên sinh viên cần sửa: ");
                    String oldName = scanner.nextLine();
                    if (students.contains(oldName)) {
                        System.out.print("Nhập tên mới: ");
                        String newName = scanner.nextLine();
                        students.set(students.indexOf(oldName), newName);
                    } else {
                        System.out.println("Sinh viên không tồn tại.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập tên sinh viên cần xóa: ");
                    String nameToDelete = scanner.nextLine();
                    students.removeIf(student -> student.contains(nameToDelete));
                    break;
                case 5:
                    System.out.println("Sinh viên có chữ 'An':");
                    for (String student : students) {
                        if (student.contains("An")) {
                            System.out.println(student);
                        }
                    }
                    break;
                case 6:
                    Collections.sort(students);
                    break;
                case 7:
                    System.out.println("Số lượng sinh viên: " + students.size());
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Chức năng không hợp le.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
