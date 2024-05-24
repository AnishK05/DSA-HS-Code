import java.util.*;

class Main {

    public static void main(String[] args) {
        testMakePi();
        testSameFirstLast();
        testSwapEnds();
        testRotateLeft();
        testHas23();
        testDouble45();
        testFix23();
        testBiggerTwo();
        testMaxTriple();
        testMake3();
    }

    public static void testMakePi() {

        System.out.println("\nTesting makePi()... ");
        ArrayList<Integer> result = ArrayListProblems.makePi();
        ArrayList<Integer> goal = new ArrayList<Integer>(Arrays.asList(3, 1, 4));
        if (result == null) {
            System.out.println("\tError: null returned");
            return;
        }
        if (result.equals(goal)) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed: with result " + result);
        }
    }

    public static void testSameFirstLast() {
        System.out.println("\nTesting sameFirstLast()...");

        int[][] cases = {
            {3},
            {3, 4},
            {4, 3},
            {3, 3},
            {1, 2, 3, 4, 3, 2, 1},
            {2, 3, 1, 4, 6, 5, 2, 2},
            {9, 8, 5, 9, 8},
            {1, 2, 3, 4, 1, 6},
            {10000, 5, 10000}
        };

        boolean[] results = {
            true,
            false,
            false,
            true,
            true,
            true,
            false,
            false,
            true
        };

        for (int i = 0; i < cases.length; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int x : cases[i]) {
                list.add(x);
            }
            boolean result = ArrayListProblems.sameFirstLast(list);
            System.out.print("\tCase " + (i + 1) + " of " + cases.length + ": ");
            if (result != results[i]) {
                System.out.println("sameFirstLast(" + Arrays.toString(cases[i]) + ") => " + 
                                   result + ", should be " + results[i] + ".");
            } else {
                System.out.println("Passed!");
            }
        }
    }

    public static void testSwapEnds() {
        System.out.println("\nTesting swapEnds()... ");

        int[][] cases = {
            {1},
            {1, 2},
            {1, 2, 3},
            {4, 3, 2, 1},
            {1, 4, 9, 16, 25}
        };

        int[][] results = {
            {1},
            {2, 1},
            {3, 2, 1},
            {1, 3, 2, 4},
            {25, 4, 9, 16, 1}
        };

        for (int i = 0; i < cases.length; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            ArrayList<Integer> goal = new ArrayList<Integer>();
            for (int x : cases[i]) {
                list.add(x);
            }
            for (int x : results[i]) {
                goal.add(x);
            }

            ArrayList<Integer> result = ArrayListProblems.swapEnds(list);
            if (result == null) {
                System.out.println("\tError: null returned");
                return;
            }
            boolean badMethod = false;
            if (list.size() != cases[i].length) {
                badMethod = true;
            } else {
                if (list != result) {
                    badMethod = true;
                }
            }

            if (badMethod) {
                System.out.println("\tYour method should NOT be creating a new list");
                return;
            }

            System.out.print("\tCase " + (i + 1) + " of " + cases.length + ": ");
            if (!result.equals(goal)) {
                System.out.println("swapEnds(" + Arrays.toString(cases[i]) + ") => " + 
                                   result + ", should be " + goal + ".");
            } else {
                System.out.println("Passed!");
            }
        }
    }

    public static void testRotateLeft() {
        System.out.println("\nTesting rotateLeft()... ");

        int[][] cases = {
            {1, 2, 3},
            {4, 1, 2},
            {1, 1, 1}
        };

        int[][] results = {
            {2, 3, 1},
            {1, 2, 4},
            {1, 1, 1}
        };

        for (int i = 0; i < cases.length; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            ArrayList<Integer> goal = new ArrayList<Integer>();
            for (int x : cases[i]) {
                list.add(x);
            }
            for (int x : results[i]) {
                goal.add(x);
            }

            ArrayList<Integer> result = ArrayListProblems.rotateLeft(list);
            if (result == null) {
                System.out.println("\tError: null returned");
                return;
            }
            System.out.print("\tCase " + (i + 1) + " of " + cases.length + ": ");
            if (!result.equals(goal)) {
                System.out.println("rotateLeft(" + Arrays.toString(cases[i]) + ") => " + 
                                   result + ", should be " + goal + ".");
            } else {
                System.out.println("Passed!");
            }
        }
    }

    public static void testHas23() {
        System.out.println("\nTesting has23()...");

        int[][] cases = {
            {2, 1},
            {1, 2},
            {3, 1},
            {4, 3},
            {5, 4},
            {2, 3},
            {2, 2},
            {3, 2},
            {3, 3}
        };

        boolean[] results = {
            true,
            true,
            true,
            true,
            false,
            false,
            true,
            false,
            true
        };

        for (int i = 0; i < cases.length; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int x : cases[i]) {
                list.add(x);
            }
            boolean result = ArrayListProblems.has23(list);
            System.out.print("\tCase " + (i + 1) + " of " + cases.length + ": ");
            if (result != results[i]) {
                System.out.println("has23(" + Arrays.toString(cases[i]) + ") => " + 
                                   result + ", should be " + results[i] + ".");
            } else {
                System.out.println("Passed!");
            }
        }
    }

    public static void testDouble45() {
        System.out.println("\nTesting double45()...");

        int[][] cases = {
            {2, 1},
            {1, 2},
            {3, 5},
            {4, 3},
            {5, 4},
            {2, 3},
            {4, 4},
            {3, 2},
            {5, 5},
            {3},
            {}
        };

        boolean[] results = {
            false,
            false,
            false,
            false,
            false,
            false,
            true,
            false,
            true,
            false,
            false
        };

        for (int i = 0; i < cases.length; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int x : cases[i]) {
                list.add(x);
            }
            boolean result = ArrayListProblems.double45(list);
            System.out.print("\tCase " + (i + 1) + " of " + cases.length + ": ");
            if (result != results[i]) {
                System.out.println("double45(" + Arrays.toString(cases[i]) + ") => " + 
                                   result + ", should be " + results[i] + ".");
            } else {
                System.out.println("Passed!");
            }
        }
    }

    public static void testFix23() {
        System.out.println("\nTesting fix23()... ");

        int[][] cases = {
            {1, 2, 3},
            {2, 3, 1},
            {2, 2, 3},
            {3, 2, 3},
            {2, 3, 3},
            {2, 3, 2},
            {3, 2, 1},
            {1, 3, 2},
            {4, 5, 6}
        };

        int[][] results = {
            {1, 2, 0},
            {2, 0, 1},
            {2, 2, 0},
            {3, 2, 0},
            {2, 0, 3},
            {2, 0, 2},
            {3, 2, 1},
            {1, 3, 2},
            {4, 5, 6}

        };

        for (int i = 0; i < cases.length; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            ArrayList<Integer> goal = new ArrayList<Integer>();
            for (int x : cases[i]) {
                list.add(x);
            }
            for (int x : results[i]) {
                goal.add(x);
            }

            ArrayList<Integer> result = ArrayListProblems.fix23(list);
            if (result == null) {
                System.out.println("\tError: null returned");
                return;
            }
            boolean badMethod = false;
            if (list.size() != 3) {
                badMethod = true;
            } else {

                if (list != result) {
                    badMethod = true;
                }
            }

            if (badMethod) {
                System.out.println("\tYour method should NOT be creating a new list");
                return;
            }

            System.out.print("\tCase " + (i + 1) + " of " + cases.length + ": ");
            if (!result.equals(goal)) {
                System.out.println("fix23(" + Arrays.toString(cases[i]) + ") => " + 
                                   result + ", should be " + goal + ".");
            } else {
                System.out.println("Passed!");
            }
        }
    }

    public static void testBiggerTwo() {
        System.out.println("\nTesting biggerTwo()... ");

        int[][][] cases = {
            {{1, 5}, {3, 2}},
            {{4, 3}, {1, 9}},
            {{3, 6}, {5, 4}},};

        int[][] results = {
            cases[0][0],
            cases[1][1],
            cases[2][0]
        };

        for (int i = 0; i < cases.length; i++) {
            ArrayList<Integer> listA = new ArrayList<Integer>();
            ArrayList<Integer> listB = new ArrayList<Integer>();
            ArrayList<Integer> goal = new ArrayList<Integer>();
            for (int x : cases[i][0]) {
                listA.add(x);
            }
            for (int x : cases[i][1]) {
                listB.add(x);
            }
            for (int x : results[i]) {
                goal.add(x);
            }

            ArrayList<Integer> result = ArrayListProblems.biggerTwo(listA, listB);
            if (result == null) {
                System.out.println("\tError: null returned");
                return;
            }
            boolean badMethod = false;
            if (listA.size() != 2 || listB.size() != 2) {
                badMethod = true;
            } else {
                int pos = 0;
                for (int x : cases[i][0]) {
                    if (listA.get(pos) != x) {
                        badMethod = true;
                    }
                    pos++;
                }

                pos = 0;
                for (int x : cases[i][1]) {
                    if (listB.get(pos) != x) {
                        badMethod = true;
                    }
                    pos++;
                }

                if (listA != result && listB != result) {
                    badMethod = true;
                }
            }

            if (badMethod) {
                System.out.println("\tYour method should NOT be modifying a list or creating a new list");
                return;
            }

            System.out.print("\tCase " + (i + 1) + " of " + cases.length + ": ");
            if (!result.equals(goal)) {
                System.out.println("biggerTwo(" + Arrays.toString(cases[i][0]) + "," + 
                                   Arrays.toString(cases[i][1]) + ") => " + result + ", should be " + goal + ".");
            } else {
                System.out.println("Passed!");
            }
        }
    }

    public static void testMaxTriple() {
        System.out.println("\nTesting maxTriple()...");

        int[][] cases = {
            {5},
            {1, 3, 5},
            {1, 5, 3},
            {3, 1, 5},
            {3, 5, 1},
            {5, 1, 3},
            {5, 3, 1},
            {1, 1, 3},
            {1, 3, 1},
            {3, 1, 1},
            {1, 3, 3},
            {3, 1, 3},
            {3, 3, 1},
            {1, 1, 1},
            {1, 2, 3, 4, 5},
            {1, 2, 5, 4, 3},
            {3, 2, 1, 4, 5},
            {3, 2, 5, 4, 1},
            {5, 2, 1, 4, 3},
            {5, 2, 3, 4, 1},
            {9, 5, 3, 7, 1, 8, 4, 6, 11, 12, 4, 8, 13},};

        int[] results = {5, 5, 5, 5, 5, 5, 5, 3, 3, 3, 3, 3, 3, 1, 5, 5, 5, 5, 5, 5, 13};

        for (int i = 0; i < cases.length; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int x : cases[i]) {
                list.add(x);
            }
            int result = ArrayListProblems.maxTriple(list);
            System.out.print("\tCase " + (i + 1) + " of " + cases.length + ": ");
            if (result != results[i]) {
                System.out.println("maxTriple(" + Arrays.toString(cases[i]) + ") => " + result + ", should be " + results[i] + ".");
            } else {
                System.out.println("Passed!");
            }
        }
    }

    public static void testMake3() {
        System.out.println("\nTesting make3()... ");

        int[][][] cases = {
            {{1, 2}, {3, 4}},
            {{1, 2}, {3}},
            {{1, 3}, {}},
            {{1, 2, 3}, {5, 4}},
            {{1, 4, 6}, {2, 5, 7, 8}},
            {{1, 9, 9}, {2}},
            {{7, 5, 4, 3}, {}},
            {{6}, {1, 7}},
            {{7}, {2}},
            {{9}, {3, 9, 12, 15}},
            {{}, {7, 9}},
            {{}, {4, 6, 9, 1, 3, 5}},};

        int[][] results = {
            {1, 2},
            {1, 2},
            {1, 3},
            {1, 2},
            {1, 4},
            {1, 9},
            {7, 5},
            {6, 1},
            {7, 2},
            {9, 3},
            {7, 9},
            {4, 6}
        };

        for (int i = 0; i < cases.length; i++) {
            ArrayList<Integer> listA = new ArrayList<Integer>();
            ArrayList<Integer> listB = new ArrayList<Integer>();
            ArrayList<Integer> goal = new ArrayList<Integer>();
            for (int x : cases[i][0]) {
                listA.add(x);
            }
            for (int x : cases[i][1]) {
                listB.add(x);
            }
            for (int x : results[i]) {
                goal.add(x);
            }

            ArrayList<Integer> result = ArrayListProblems.make3(listA, listB);
            if (result == null) {
                System.out.println("\tError: null returned");
                return;
            }
            boolean badMethod = false;
            if (listA.size() != cases[i][0].length || listB.size() != cases[i][1].length) {
                badMethod = true;
            } else {
                int pos = 0;
                for (int x : cases[i][0]) {
                    if (listA.get(pos) != x) {
                        badMethod = true;
                    }
                    pos++;
                }

                pos = 0;
                for (int x : cases[i][1]) {
                    if (listB.get(pos) != x) {
                        badMethod = true;
                    }
                    pos++;
                }
            }

            if (badMethod) {
                System.out.println("\tYour method should NOT be modifying the parameter lists");
                return;
            }

            System.out.print("\tCase " + (i + 1) + " of " + cases.length + ": ");
            if (!result.equals(goal)) {
                System.out.println("make3(" + Arrays.toString(cases[i][0]) + "," +
                                   Arrays.toString(cases[i][1]) + ") => " + result + ", should be " + goal + ".");
            } else {
                System.out.println("Passed!");
            }
        }
    }
}
