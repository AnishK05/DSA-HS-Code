class Main {

    public static void main(String[] args) {

        // You should test your methods here

        MyDoublyLinkedList list = new MyDoublyLinkedList();
        
        list.add("apple");
        list.add("banana");
        
        System.out.println("From Head: " + list.toString());      // aaaabelnnpp
        System.out.println("From Tail: " + list.toStringTail());  // ppnnlebaaaa

        String dups = list.removeDuplicates();
        System.out.println("Duplicates Removed: " + dups);        // aaanp
        System.out.println(list.toString());                      // abelnp
        
    }
}