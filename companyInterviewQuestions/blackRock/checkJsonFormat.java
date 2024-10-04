/* To solve the problem of verifying the format of a document containing 
company financial data, you need to ensure that all brackets and 
parentheses in the text are correctly paired and nested. Here’s 
how you can do it using Java, followed by an explanation of alternative 
approaches. */


import java.util.Stack;

public class DocumentFormatVerifier {

    public static boolean isValidFormat(String document) {
        Stack<Character> stack = new Stack<>();

        for (char ch : document.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == '}' || ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char openBracket = stack.pop();
                if (!isMatchingPair(openBracket, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '{' && close == '}') ||
               (open == '(' && close == ')') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String document = """
        [
            {
                company_name: (BlackRock)
                ticker: (BLK)
                stock_price: {
                    2022-04-03: ($930)
                    2022-04-02: ($932)
                }
            },
            {
                company_name: (Apple)
                ticker: (APPL)
                stock_price: {
                    2022-04-03: ($175)
                    2022-04-02: ($178)
                }
            }
        ]
        """;

        boolean isValid = isValidFormat(document);
        if (isValid) {
            System.out.println("The document format is correct.");
        } else {
            System.out.println("The document format is incorrect.");
        }
    }
}
