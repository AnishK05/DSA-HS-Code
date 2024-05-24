import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

class Main {

    public static void main(String[] args) {

        String[] data = new String[6];
        data[0] = "A B C D E";
        data[1] = "E F G H F";
        data[2] = "19 5 11 3 15 17 8 6";
        data[3] = "8 2 11 15 9 17 3";
        data[4] = "1 5 9 7 5 3";
        data[5] = "5 4";

        for (int i = 0; i < data.length; i += 2) {
            SetOperations setOps = new SetOperations(data[i], data[i + 1]);
            System.out.println("Set A:         " + setOps.getSetA());
            System.out.println("Set B:         " + setOps.getSetB());
            System.out.println("Union:         " + setOps.union());
            System.out.println("Intersection:  " + setOps.intersection());
            System.out.println("SymmetricDiff: " + setOps.symmetricDiff());
            System.out.println("Diff A - B:    " + setOps.diffAMinusB());
            System.out.println("Diff B - A:    " + setOps.diffBMinusA());
            System.out.println();
        }
    }
}