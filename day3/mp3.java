/* cho chúng ta có đường dẫn sau:
D:/music/bolero/longme.mp3
- Hãy lấy longme.mp3
- Hãy lấy longme
dùng slpit()
 */
package day3;

public class mp3 {
    public static void main(String[] args) {
        String path = "D:/music/bolero/longme.mp3";
        String[] parts = path.split("/");
        String filename = parts[parts.length - 1];
        System.out.println("Filename: " + filename);
        
        String nameWithoutExtension = filename.split("\\.")[0];
        System.out.println("Name without extension: " + nameWithoutExtension);
    }
}
