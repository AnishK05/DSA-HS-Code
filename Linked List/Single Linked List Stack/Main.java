import java.util.Arrays;

class Main {
    
    public static void main(String[] args) {

        SingleLinkedListStack stack = new SingleLinkedListStack();
        for (int i = 0; i < 10; i++) {
            stack.addFirst((int) (Math.random() * 10));
        }
        System.out.println(Arrays.toString(stack.toArray()));

    }
}