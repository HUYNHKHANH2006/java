package ChuongTrinhDemSoAm;
import java.util.*;
import java.util.regex.*;

public class DemSoAm {

    public static void NegativeNumberInStrings(String str) 
    {
        List<Integer> negatives = new ArrayList<>();

        Pattern pattern = Pattern.compile("(?<![0-9\\-])-[0-9]+");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) 
        {
            negatives.add(Integer.parseInt(matcher.group()));
        }

        System.out.println("Số lượng số nguyên âm: " + negatives.size());
        System.out.print("Các số nguyên âm: ");
        for (int num : negatives) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập chuỗi: ");
            String str = sc.nextLine();

            NegativeNumberInStrings(str);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            System.out.println("Chương trình kết thúc.");
        }
    }
}