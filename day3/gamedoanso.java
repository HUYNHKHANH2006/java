/* 
Ví dụ viết Game đoán số
Máy tính sẽ ra 1 số ngẫu nhiên [0..100], yêu cầu người
chơi đoán số này, cho phép đoán sai 7 lần (quá 7 lần thì
Game Over nha thím). Nếu đoán sai thì phải cho người
chơi biết là số Người chơi đoán nhỏ hơn hay lớn hơn số
của máy.
➔sau khi kết thúc game (WIN or LOST)➔hỏi xem Người
chơi có muốn chơi nữa không.
đặt biệt phai dùng try catch
*/
package day3;
import java.util.Random;
import java.util.Scanner;

public class gamedoanso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int may = new Random().nextInt(101), sai = 0;
            System.out.println("\nĐoán số [0..100]. Tối đa 7 lần sai!");
            
            while (sai < 7) {
                int nguoi = -1;
                while (true) {
                    try {
                        System.out.print("Nhập số: ");
                        nguoi = Integer.parseInt(sc.nextLine());
                        break;
                    } catch (Exception e) {
                        System.out.print("Lỗi! Không phải số. ");
                    }
                }

                if (nguoi == may) {
                    System.out.println("WIN! Bạn đã đoán trúng.");
                    break;
                }
                
                sai++;
                if (sai == 7) System.out.println("GAME OVER! Số đúng là: " + may);
                else System.out.println("Sai! Số bạn đoán " + (nguoi < may ? "NHỎ HƠN" : "LỚN HƠN") + " số của máy.");
            }

            System.out.print("Chơi lại? (y/n): ");
            if (!sc.nextLine().equalsIgnoreCase("y")) break;
        }
        sc.close();
    }
}
