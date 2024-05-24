
class Main {
    public static void main(String[] args) {

        // Use the main method to test and debug your methods
        
        MyDeque listA = new MyDeque();
        MyDeque listB = new MyDeque();

        for (int i = 1; i < 25; i+=3) {
            listA.addEven(i);
            listA.addOdd(i);
        }
        for (int i = 24; i > 0; i-=3) {
            listB.addEven(i);
            listB.addOdd(i);
        }

        System.out.println(listA); // [22, 16, 10, 4, 1, 7, 13, 19]
        System.out.println(listB); // [6, 12, 18, 24, 21, 15, 9, 3]

        

    }
}