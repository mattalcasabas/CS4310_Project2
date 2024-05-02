package Task1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter page size in KB: ");
        int pageSize = 1024 * kb.nextInt();
        System.out.print("Enter virtual address: ");
        int virtAddr = kb.nextInt();

        int pageNum = virtAddr / pageSize;
        int offset = virtAddr % pageSize;

        System.out.println("Page number: " + pageNum);
        System.out.println("Offset: " + offset);
    }
}