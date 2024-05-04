package Task2;

public class FCFS {
    private int[] requests;
    private int startCyl;
    private int totalMovement;
    private int totalHeadSwitches;

    public FCFS(int[] a, int startCyl) {
        this.requests = a;
        this.startCyl = startCyl;
    }

    private int getLastIndex() {
        // Find the index of the last non-zero element
        int lastIndex = requests.length - 1;
        while (lastIndex >= 0 && requests[lastIndex] == 0) {
            lastIndex--;
        }
        return lastIndex;
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
        totalMovement = Math.abs(requests[0] - startCyl);
        for (int i = 0; i < this.getLastIndex(); i++) {
            difference = requests[i + 1] - requests[i];
            if ((lastDifference < 0 && difference > 0) || (lastDifference > 0 && difference < 0)) {
                totalHeadSwitches++;
            }
            totalMovement += Math.abs(difference);
            // System.out.println("Move head from " + requests[i] + " to " + requests[i+1]);
            // System.out.println("Head moved " + difference + " cylinders");
            lastDifference = difference;
        }
    }
}