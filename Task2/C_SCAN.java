package Task2;
import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;

public class C_SCAN {
    private ArrayList<Integer> requests;
    private int startCyl;
    private int prevCyl;
    private int totalMovement;
    private int totalHeadSwitches;

    public C_SCAN(int[] requests, int startCyl, int prevCyl) {
        this.requests = new ArrayList<>();
        for (int request : requests) {
            this.requests.add(request);
        }
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
        Collections.sort(requests);
    
        int minCyl = 0;
        int maxCyl = 0;
        int currentPos = startCyl;
        String direction = "";
    
        if (startCyl < prevCyl) {
            direction = "left";
        } else {
            direction = "right";
        }
    
        if (direction.equals("left")) {
            minCyl = Collections.min(requests);
        } else {
            minCyl = currentPos;
        }
    
        if (direction.equals("right")) {
            maxCyl = Collections.max(requests);
        } else {
            maxCyl = currentPos;
        }
    
        while (!requests.isEmpty()) {
            Iterator<Integer> iterator = requests.iterator();
            boolean requestProcessed = false;
            while (iterator.hasNext()) {
                int request = iterator.next();
                if (direction.equals("right") && request >= currentPos) {
                    // System.out.println("Moving " + direction + " from " + currentPos + " to " + request);
                    totalMovement += Math.abs(request - currentPos);
                    currentPos = request;
                    iterator.remove();
                    requestProcessed = true;
                    break;
                } else if (direction.equals("left") && request <= currentPos) {
                    // System.out.println("Moving " + direction + " from " + currentPos + " to " + request);
                    totalMovement += Math.abs(request - currentPos);
                    currentPos = request;
                    iterator.remove();
                    requestProcessed = true;
                    break;
                }
            }
    
            if (!requestProcessed) {
                // Head reached end of disk, jump to opposite end
                if (direction.equals("right")) {
                    totalMovement += Math.abs(maxCyl - currentPos);
                    currentPos = maxCyl;
                    direction = "left";
                } else {
                    totalMovement += Math.abs(minCyl - currentPos);
                    currentPos = minCyl;
                    direction = "right";
                }
            }
    
            if (direction.equals("right") && currentPos == maxCyl) {
                direction = "left";
                totalHeadSwitches++;
                System.out.println("Direction switched to left");
            } else if (direction.equals("left") && currentPos == minCyl) {
                direction = "right";
                totalHeadSwitches++;
                System.out.println("Direction switched to right");
            }
        }
    }
    
}