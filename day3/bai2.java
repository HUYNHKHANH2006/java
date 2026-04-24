package day3;

import java.util.*;
//ArrayList (Số nguyên)
public class bai2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 8)); // Nhập
        list.add(9);                       // Thêm
        list.set(0, 10);                   // Sửa (tại index 0)
        list.remove(Integer.valueOf(2));   // Xóa (số 2)
        System.out.println("Vị trí số 8: " + list.indexOf(8)); 
        Collections.sort(list);            // Sắp xếp
        System.out.println("Đã sắp xếp: " + list);
    }
}
