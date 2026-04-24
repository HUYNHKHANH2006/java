package day3;
import java.util.*;
// Bài 1: Sử dụng HashMap để quản lý sách
public class Bai1 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Java"); map.put(2, "C++"); 
        System.out.println("Xuất: " + map);
        map.put(1, "Java Nâng cao");           
        map.remove(2);                         
        System.out.println("Tìm sách mã 1: " + map.get(1)); 
    }
}