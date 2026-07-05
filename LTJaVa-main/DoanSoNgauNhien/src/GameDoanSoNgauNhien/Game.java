package GameDoanSoNgauNhien;
import java.util.*;
public class Game {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int n = rand.nextInt(100); // so random
        int b = 0;

        System.out.println("Đoán số ngẫu nhiên (0-99)");

        try 
        {
            System.out.print("Nhập số bất kỳ: ");
            b = sc.nextInt(); 
        } 
        catch (InputMismatchException e) 
        {
            System.out.println("Bạn phải nhập số !");
            return; 
        }
   
        if (b == n) 
        {
            System.out.println(" WIN");
        } 
        else 
        {
            System.out.println("LOST");
        }
        System.out.println("Số đúng là: " + n);

	}

}
