package Task2;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter name of input file, or leave blank to generate 1000 random requests: ");
        String fileName = kb.nextLine();
        kb.close();

        // create an array of size 1000 to hold requests
        int[] requests = new int[1000];

        if(fileName.isEmpty()) {

        }
        else {

        }

        System.out.print("Enter previous cylinder location (0-4999): ");
        int prevCyl = kb.nextInt();
        System.out.print("Enter current cylinder location (0-4999): ");
        int thisCyl = kb.nextInt();
    }

    public int[] generateRandomRequests() {
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