import java.util.ArrayList;
import java.util.List;

/**
 * Created on 7/22/16.
 */
public class TowerOfHanoi {
    static int N;
    static List<List<Integer>> towers;
    static String space = "   ";

    public static void main(String[] args) throws Exception {
        //        Scanner sc = new Scanner(System.in);
        N = 5;  // Integer.parseInt(sc.nextLine());

        towers = new ArrayList<>(N);
        for (int i = 0; i < 3; i++)
            towers.add(new ArrayList<>());

        // Add disks to the starting position
        for (int disk = N; disk > 0; disk--)
            towers.get(0).add(disk);
        print();

        moveTower(N, 'A', 'C', 'B');
        System.out.println("\t\t\tFINAL");
        print();
    }

    static void moveTower(int disk, char from, char to, char spare) throws Exception {
        if (disk == 1) {
            print();
            moveSingeDisk(from, to);
        } else {
            moveTower(disk - 1, from, spare, to);
            moveSingeDisk(from, to);
            moveTower(disk - 1, spare, to, from);
        }
    }

    static void moveSingeDisk(char from, char to) throws Exception {
        int nDisks = towers.get(from - 'A').size();
        if (nDisks == 0) throw new Exception("PEG is empty");
        int disk = towers.get(from - 'A').get(nDisks - 1);
        towers.get(from - 'A').remove(nDisks - 1);
        nDisks = towers.get(to - 'A').size();
        if (nDisks > 0 && disk > towers.get(to - 'A').get(nDisks - 1)) {
            throw new Exception("Cannot add a bigger disk on top of a smaller one");
        }
        towers.get(to - 'A').add(disk);
    }

    static void print() {
        StringBuilder sb = new StringBuilder();

        sb.append("---------------top-----------------\n");
        sb.append("|").append(space).append("|").append(space).append("|").append("\n");
        for (int i = towers.size() - 1; i >= 0; i--) {
            sb.append("|").append(space).append("|").append(space).append("|").append("\n");
            for (int j = towers.get(i).size() - 1; j >= 0; j--) {
                if (i == 0)
                    sb.append(towers.get(i).get(j)).append(space).append("|").append(space).append("|").append("\n");
                if (i == 1)
                    sb.append("|").append(space).append(towers.get(i).get(j)).append(space).append("|").append("\n");
                if (i == 2)
                    sb.append("|").append(space).append("|").append(space).append(towers.get(i).get(j)).append("\n");
            }
        }
        sb.append("--------------bottom----------------\n");
        System.out.println(sb);
    }

}
