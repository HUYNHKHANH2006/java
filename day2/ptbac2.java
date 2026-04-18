package day2;
//  giải pt bậc 2
public class ptbac2 {
    public static void main(String[] args) {
        double a = 1, b = -3, c = 2;
        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            System.out.println("Phương trình vô nghiệm");
        } else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("Phương trình có nghiệm kép: x = " + x);
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Phương trình có hai nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2);
        }
    }
}
