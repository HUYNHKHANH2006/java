
/*  
Tạo một class (lớp) gọi là Invoice mà cửa hàng bán phần cứng máy tính có thể
sử dụng để làm hóa đơn cho một mặt hàng được bán tại cửa hàng. Một Invoice
gồm có các thông tin sau:
· Mã mặt hàng (a part number - kiểu String)
· Mô tả mặt hàng (a part description - kiểu String)
· Số lượng hàng được mua (quantity of the item being purchased - kiểu int)
· Giá mỗi mặt hàng (a price per item - kiểu double)
Class của bạn vừa tạo cần có constructor (hàm khởi tạo) để khởi tạo giá trị của
các thuộc tính (hay instance variable) này. Bạn cần cung cấp các phương thức
get và set cho mỗi thuộc tính này. Ngoài ra, hãy cung cấp một phương thức có
tên getInvoiceAmount() để tính toán số tiền trên hóa đơn (tức là nhân số lượng
với giá mỗi mặt hàng), sau đó trả về số tiền dưới dạng double. Nếu số lượng là
không dương, nó nên được đặt thành 0. Nếu giá mỗi mặt hàng là không dương,
nó nên được đặt thành 0.0.
Viết 1 class có tên là InvoiceTest dùng để tạo ra dữ liệu giả (mocked data) và
kiểm tra các chức năng của class Invoice. (InvoiceTest tạo ra 1 Arrays hoặc
ArraryList các object có kiểu Invoice và xuất thông tin ra màn hình). Chương
trình dưới dạng menu cho người dùng chọn 1 trong các chức năng cần thực hiện
như hình sau:
· Chương trình nhập vào danh sách (có thể sử dụng Array class hoặc
ArrayList) Invoice (ít nhất là 10 Invoice và không được nhập trùng mã mặt
hàng).
· Xuất thông tin một Invoice từ danh sách đã được nhập vào.
· Vận dụng các thuật toán sắp xếp như sắp xếp nổi bọt (bubble sort), sắp
xếp đổi chỗ trực tiếp (interchange sort), sắp xếp chèn (insertion sort), sắp
xếp phân hoạch (quick sort), sắp xếp chọn lựa, ... (link tham khảo) để sắp
xếp danh sách hóá đơn theo thứ tự tăng dần theo Mã mặt hàng, số lượng
mua.
· Chương trình cũng cho phép tìm một Invoice (được nhập vào bất kỳ) theo
mã mặt hàng (tìm theo phương thức tuyến tính, hoặc tìm kiếm nhị phân
hoặc dùng hàm thư viện đã có sẵn).
· Chương trình cho phép xoá một Invoice theo mã mặt hàng.
*/
package day8.bai1;

public class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.setQuantity(quantity);
        this.setPricePerItem(pricePerItem);
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = (quantity > 0) ? quantity : 0;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = (pricePerItem > 0.0) ? pricePerItem : 0.0;
    }

    public double getInvoiceAmount() {
        return quantity * pricePerItem;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-20s | %-10d | %-12.2f | %-12.2f", 
            partNumber, partDescription, quantity, pricePerItem, getInvoiceAmount());
    }
}
