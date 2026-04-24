package day3;

import java.util.*;
//Mảng Ngẫu Nhiên
public class bai3 {
    public static void main(String[] args) {
        //  0-99
        int[] a = new Random().ints(10, 0, 100).toArray(); 
        
        System.out.println("Mảng: " + Arrays.toString(a));
        System.out.println("Tổng: " + Arrays.stream(a).sum());
        System.out.println("Max: " + Arrays.stream(a).max().getAsInt() + " | Min: " + Arrays.stream(a).min().getAsInt());
        System.out.println("Đếm số 5: " + Arrays.stream(a).filter(x -> x == 5).count());
        
        System.out.print("SNT: ");
        for (int x : a) {
            int dem = 0;
            for (int i = 1; i <= x; i++) if (x % i == 0) dem++;
            if (dem == 2) System.out.print(x + " ");
        }

        Arrays.sort(a);
        System.out.println("\nTăng dần: " + Arrays.toString(a));
        System.out.print("Giảm dần: ");
        for (int i = a.length - 1; i >= 0; i--) System.out.print(a[i] + " ");
    }
}
