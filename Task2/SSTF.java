package Task2;
import java.util.ArrayList;

public class SSTF {
    private ArrayList<Integer> requests;
    private int startCyl;
    private int totalMovement;
    private int totalHeadSwitches;

    public SSTF(int[] requests, int startCyl) {
        this.requests = new ArrayList<>();
        for (int request : requests) {
            this.requests.add(request);
        }
        this.startCyl = startCyl;
    }

    public int getTotalMovement() {
        return totalMovement;
    }

    public int getHeadSwitches() { 
        return totalHeadSwitches;
    }

    public void schedule() {
        totalMovement = 0;
        int currentPos = startCyl;
        int previousPos = currentPos;
        while (requests.size() > 0) {
            int closestIndex = 0;
            int closestHeadMovement = Math.abs(requests.get(0) - currentPos);
            for (int i = 0; i < requests.size() - 1; i++) {
                int currentHeadMovement = Math.abs(requests.get(i) - currentPos);
                if (currentHeadMovement < closestHeadMovement) {
                    closestIndex = i;
                    closestHeadMovement = currentHeadMovement;
                }
            }
            totalMovement += closestHeadMovement;
            // Check for head switch
            if ((currentPos < 0 && closestHeadMovement > 0) || (currentPos > 0 && closestHeadMovement < 0)) {
                totalHeadSwitches++;
            }
            currentPos = requests.get(closestIndex);
            requests.remove(closestIndex);
            // Check for head switch after removing the request
            if ((currentPos < 0 && currentPos - previousPos > 0) || (currentPos > 0 && currentPos - previousPos < 0)) {
                totalHeadSwitches++;
            }
            previousPos = currentPos;
        }
    }
}
