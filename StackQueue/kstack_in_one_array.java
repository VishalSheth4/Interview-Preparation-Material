public class Main {
    int k;
    int n;
    int[] arr;
    int[] top;
    int[] next;
    int free;

    Main(int k, int n) {
        this.k = k;
        this.n = n;
        this.arr = new int[n];
        this.top = new int[k];
        this.next = new int[n];

        // Initialize all stacks as empty 
        for (int i = 0; i < k; i++) { top[i] = -1; }

        // Initialize all spaces as free 
        free = 0;
        for (int i = 0; i < n - 1; i++) { next[i] = i + 1; }
        next[n - 1] = -1;
    }

    // To check whether stack number 'i' is empty or not 
    private boolean isEmpty(int i) { return top[i] == -1; }

    // To check whether stack number 'i' is full or not 
    private boolean isFull(int i) { return free == -1; }

    private void push(int item, int j) {
        if (isFull(j)) {
            System.out.println("Stack overflow");
            return;
        }

        int nextFree = next[free];
        next[free] = top[j];
        top[j] = free;
        arr[free] = item;
        free = nextFree;
    }

    private int pop(int i) {
        if (isEmpty(i)) {
            System.out.println("Stack underflow");
            return Integer.MIN_VALUE;
        }

        int poppedIndex = top[i];
        int poppedElement = arr[poppedIndex];
        top[i] = next[poppedIndex];
        next[poppedIndex] = free;
        free = poppedIndex;

        return poppedElement;
    }

    public static void main(String[] args) {
        int k = 3; // Number of stacks
        int n = 10; // Total size of the array
        Main kStacks = new Main(k, n);

        // Push elements into different stacks
        kStacks.push(15, 2);
        kStacks.push(45, 2);
        kStacks.push(17, 1);
        kStacks.push(49, 1);
        kStacks.push(39, 1);
        kStacks.push(11, 0);
        kStacks.push(9, 0);
        kStacks.push(7, 0);

        // Pop elements from different stacks
        System.out.println("Popped element from stack 2 is " + kStacks.pop(2)); // Output: 45
        System.out.println("Popped element from stack 1 is " + kStacks.pop(1)); // Output: 39
        System.out.println("Popped element from stack 0 is " + kStacks.pop(0)); // Output: 7
    }
}
