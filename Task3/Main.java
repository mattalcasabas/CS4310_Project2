package Task3;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter logical block number: ");
        int lbn = kb.nextInt();
        System.out.print("Enter HD number of cylinders: ");
        int cylinders = kb.nextInt();
        System.out.print("Enter HD number of tracks: ");
        int tracks = kb.nextInt();
        System.out.print("Enter HD number of sectors: ");
        int sectors = kb.nextInt();
        kb.close();

        // divide lbn by tracks * sectors
        int cyl = lbn / (tracks * sectors);
        // find the remainder
        int rem = lbn % (tracks * sectors);
        // find the track
        int trk = rem / sectors;
        // find the sector
        int sec = rem % sectors;

        System.out.printf("The logical block number %d is located at <%d, %d, %d>\n", lbn, cyl, trk, sec);
    }
    
}
