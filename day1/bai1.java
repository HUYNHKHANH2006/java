/*  viết chương trình nhập vào 1 mãng số tự nhiên . hảy xuất ra màn hình:
dòng 1: các số lẻ của mảng  và có bao nhiêu số lẻ
dòng 2: các số chẵn của mảng và có bao nhiêu số chẵn
dòng 3: gồm các số nguyên tố
dòng 4: gồm các số không phải là số nguyên tố
M[]={3,6,7,8,11,17,2,90,2,5,4,5,8} */

public class bai1 {
    public static void main(String[] args) {
        int[] M = {3, 6, 7, 8, 11, 17, 2, 90, 2, 5, 4, 5, 8};
        int countLe = 0;
        int countChan = 0;
        String le = "";
        String chan = "";
        String nguyenTo = "";
        String khongNguyenTo = "";
        
        for (int num : M) {
            if (num % 2 == 0) {
                chan += num + " ";
                countChan++;
            } else {
                le += num + " ";
                countLe++;
            }
            
            if (isPrime(num)) {
                nguyenTo += num + " ";
            } else {
                khongNguyenTo += num + " ";
            }
        }
        
        System.out.println("so le: " + le.trim() + " - so luong " + countLe);
        System.out.println("so chan: " + chan.trim() + " - so luong " + countChan);
        System.out.println("so nguyen to: " + nguyenTo.trim());
        System.out.println("so khong phai so nguyen to: " + khongNguyenTo.trim());
    }
    
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}   