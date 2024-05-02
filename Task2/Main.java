package Task2;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter name of input file, or leave blank to generate 1000 random requests: ");
        String fileName = kb.nextLine();


        // create an array of size 1000 to hold requests
        int[] requests = new int[1000];

        if(fileName.isEmpty()) {
            System.out.println("No file name given, will generate random requests.");
            requests = generateRandomRequests();
        }
        else {
            // read from file, place results in requests array
            try {
                File file = new File(fileName);
                Scanner fileScanner = new Scanner(file);
                int lineNum = 0;
                // read lines from the file
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    requests[lineNum++] = Integer.parseInt(line);
                }
                fileScanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.print("Enter previous cylinder location (0-4999): ");
        int prevCyl = kb.nextInt();
        if (prevCyl < 0 || prevCyl > 5000) {
            System.out.print("Invalid cylinder location.\n");
            System.exit(1);
        } 

        System.out.print("Enter current cylinder location (0-4999): ");
        int thisCyl = kb.nextInt();
        if (thisCyl < 0 || thisCyl > 5000) {
            System.out.print("Invalid cylinder location.\n");
            System.exit(1);
        } 

        kb.close();

        FCFS a1 = new FCFS(requests, thisCyl);
        SSTF a2 = new SSTF(requests, thisCyl);
        SCAN a3 = new SCAN(requests, thisCyl, prevCyl);
        C_SCAN a4 = new C_SCAN(requests, thisCyl, prevCyl);
        a1.schedule();
        System.out.println("FCFS total head movement: " + a1.getTotalMovement());
        System.out.println("FCFS total head switches: " + a1.getHeadSwitches());
        a2.schedule();
        System.out.println("SSTF total head movement: " + a2.getTotalMovement());
        System.out.println("SSTF total head switches: " + a2.getHeadSwitches());
        a3.schedule();
        System.out.println("SCAN total head movement: " + a3.getTotalMovement());
        System.out.println("SCAN total head switches: " + a3.getHeadSwitches());
        a4.schedule();
        System.out.println("C-SCAN total head movement: " + a4.getTotalMovement());
        System.out.println("C-SCAN total head switches: " + a4.getHeadSwitches());


    }

    public static int[] generateRandomRequests() {
        int min = 0;
        int max = 4999;
        Random random = new Random();
        int[] randomNumbers = new int[1000];

        for (int i = 0; i < 1000; i++) {
            randomNumbers[i] = random.nextInt(max - min + 1) + min;
        }

        return randomNumbers;
    }
}