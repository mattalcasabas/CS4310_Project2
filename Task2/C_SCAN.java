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
    private boolean requestProcessed;

    public C_SCAN(int[] requests, int startCyl, int prevCyl) {
        this.requests = new ArrayList<>();
        for (int request : requests) {
            this.requests.add(request);
        }
        this.startCyl = startCyl;
        this.prevCyl = prevCyl;
        // remove trailing zeros
        int lastIndex = this.requests.size() - 1;
        while (lastIndex >= 0 && this.requests.get(lastIndex) == 0) {
            this.requests.remove(lastIndex);
            lastIndex--;
        }
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
        // iterate over the requests
        while (!requests.isEmpty()) {
            Iterator<Integer> iterator = requests.iterator();
            requestProcessed = false;
            while (iterator.hasNext()) {
                int request = iterator.next();
                // check if the request can be serviced based on the direction of head movement
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
            // if no request is processed in the inner loop, move the head to the opposite end of the disk
            if (!requestProcessed) {
                System.out.println("requestProcessed = " + requestProcessed);
                // Head reached end of disk, jump to opposite end and continue in the same direction
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
                // System.out.println("Direction switched to left");
            } else if (direction.equals("left") && currentPos == minCyl) {
                direction = "right";
                totalHeadSwitches++;
                // System.out.println("Direction switched to right");
            }
        }
    }
    
}