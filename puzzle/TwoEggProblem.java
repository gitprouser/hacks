/**
 * Created on 8/4/16.
 */
public class TwoEggProblem {
    private static final int MAXIMUM_FLOOR = 100;
    private static final int NUM_OF_EGGS = 2;


    static int solvePuzzle(int[] floors) {
        return _solvePuzzleBinary(floors, 0, 0, floors.length, NUM_OF_EGGS);
    }

    // Binary solution to the two egg problem
    static int _solvePuzzleBinary(int[] floors, int cnt, int startIdx, int endIdx, int numbOfEggs) {
        int mid = startIdx + (endIdx - startIdx) / 2;

        if (startIdx >= endIdx)
            return cnt;


        if (dropEgg(floors, mid))
            return _solvePuzzleBinary(floors, cnt + 1, startIdx, mid, numbOfEggs - 1);
        else
            return _solvePuzzleBinary(floors, cnt + 1, mid + 1, floors.length, numbOfEggs);
    }

    static boolean dropEgg(int[] floors, int mid) {
        return floors[mid] == 1;  // egg breaks when floor[i] == 1
    }

    public static void setBreakFloor(int[] floors, int floorAtWhichEggBreaks) {
        for (int i = floorAtWhichEggBreaks; i < floors.length; i++) {
            floors[i] = 1;
        }
    }

    public static void main(String[] args) {
        int[] floors = new int[MAXIMUM_FLOOR];

        for (int i = 0; i < MAXIMUM_FLOOR; i++) {
            setBreakFloor(floors, i);
            System.out.println("floor where egg breaks" + i);
            System.out.println("number of attempts:" + solvePuzzle(floors));
        }

    }
}
