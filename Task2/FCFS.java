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
        for (int i = 0; i < requests.length - 1; i++) {
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