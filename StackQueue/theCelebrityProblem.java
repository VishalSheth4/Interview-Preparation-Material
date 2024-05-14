import java.util.Stack;

public class CelebrityProblem {
    // A utility function to check if a knows b
    static boolean knows(int a, int b, boolean[][] knowledge) {
        return knowledge[a][b]; // Return true if a knows b, false otherwise
    }

    // Returns the celebrity's ID if celebrity exists, -1 otherwise
    static int findCelebrity(int n, boolean[][] knowledge) {
        Stack<Integer> stack = new Stack<>();

        // Push all people onto stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // While there are more than one person in the stack
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (knows(a, b, knowledge)) {
                // If a knows b, 'a' cannot be the celebrity, push 'b' back
                stack.push(b);
            } else {
                // If a doesn't know b, 'b' cannot be the celebrity, push 'a' back
                stack.push(a);
            }
        }

        // Potential celebrity ID
        int potentialCelebrity = stack.pop();

        // Check if potentialCelebrity is actually the celebrity
        for (int i = 0; i < n; i++) {
            if (i != potentialCelebrity && (knows(potentialCelebrity, i, knowledge) || !knows(i, potentialCelebrity, knowledge))) {
                return -1; // Potential celebrity knows someone or someone doesn't know the potential celebrity
            }
        }

        return potentialCelebrity;
    }

    public static void main(String[] args) {
        int n = 4; // Number of people at the party
        boolean[][] knowledge = {
            {false, true, false, true},
            {false, false, true, false},
            {true, false, false, true},
            {false, false, false, false}
        };

        int celebrity = findCelebrity(n, knowledge);
        if (celebrity == -1) {
            System.out.println("No celebrity found!");
        } else {
            System.out.println("Celebrity found with ID: " + celebrity);
        }
    }
}
