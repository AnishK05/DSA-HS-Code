class Main {
    
    public static void main(String[] args) {
        
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(90);
        tree.add(100);
        tree.add(80);
        tree.add(70);
        tree.add(85);
        tree.add(98);
        tree.add(120);

        System.out.println();
        System.out.println("IN ORDER         " + tree.inOrder());
        System.out.println("PRE ORDER        " + tree.preOrder());
        System.out.println("POST ORDER       " + tree.postOrder());
        System.out.println("");
        System.out.println("Contains 80      " + tree.contains(80));
        System.out.println("Contains 30      " + tree.contains(30));
        System.out.println();
        System.out.println("Tree size        " + tree.size());
        System.out.println("Tree height      " + tree.getHeight());
        System.out.println("Tree width       " + tree.getWidth());
        System.out.println();
        System.out.println("Number of leaves " + tree.getNumLeaves());
        System.out.println("Number of levels " + tree.getNumLevels());
        System.out.println("Tree as a string " + tree.toString());
        System.out.println("");
    }
}