// code này để tìm các số nguyên âm trong một chuỗi nhập từ bàn phím 
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NegativeNumberScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();
        NegativeNumberInStrings(str);
    }

    public static void NegativeNumberInStrings(String str) {
        // Pattern tim dau tru theo sau boi mot hoac nhieu chu so
        Pattern pattern = Pattern.compile("-\\d+");
        Matcher matcher = pattern.matcher(str);
        
        System.out.println("Các số nguyên âm trong chuỗi là:");
        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }
        
        if (!found) {
            System.out.println("(Không tìm thấy số nguyên âm nào)");
        }
    }
}
