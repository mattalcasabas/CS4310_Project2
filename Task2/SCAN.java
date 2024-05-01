package Task2;
import java.util.Arrays;

public class SCAN {
    private int[] requests;
    private int startCyl;
    private int prevCyl;
    private int totalMovement;
    private int totalHeadSwitches;

    public SCAN(int[] a, int startCyl, int prevCyl) {
        this.requests = a;
        this.startCyl = startCyl;
        this.prevCyl = prevCyl;
    }

    public int getTotalMovement() {
        return totalMovement;
    }

    public int getHeadSwitches() { 
        return totalHeadSwitches;
    }

    public void schedule() {
        int difference = 0;
        int lastDifference = 0;
        Arrays.sort(requests);
        if (prevCyl < startCyl) {
            // move towards end of disk
            // then move towards start of disk
        }
        else {
            // move towards start of disk
            // then move towards end of disk
        }
    }
}