class Main {
    public static void main(String[] args) {

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.add(50);
        tree.add(30);
        tree.add(40);
        tree.add(10);
        tree.add(20);
        tree.add(100);
        tree.add(90);
        tree.add(80);
        tree.add(70);
        tree.add(60);
        tree.add(25);

        System.out.println();
        System.out.println("In order     " + tree.inOrder());
        System.out.println("Pre order    " + tree.preOrder());
        System.out.println("Level Order  " + tree.levelOrder());
        System.out.println("Width        " + tree.getWidth());
        System.out.println("Levels       " + tree.getNumLevels());
        System.out.println("isBalanced   " + tree.isBalanced());
        System.out.println(tree.printTree(5));

        tree.reBalanceTree();
        System.out.println("\nRebalanced Tree");
        System.out.println("In order     " + tree.inOrder());
        System.out.println("Pre order    " + tree.preOrder());
        System.out.println("Level Order  " + tree.levelOrder());
        System.out.println(tree.printTree(5));
    }
}