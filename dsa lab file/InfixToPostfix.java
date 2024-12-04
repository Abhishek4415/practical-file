import java.util.Stack;

public class InfixToPostfix {

    // Function to return the precedence of operators
    private static int precedence(char operator) {
        switch (operator) {
            case '^': return 3;
            case '*': 
            case '/': 
            case '%': return 2;
            case '+': 
            case '-': return 1;
            default: return 0;
        }
    }

    // Function to check if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '^';
    }

    // Function to convert infix to postfix
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // If the character is an operand, add it to the postfix expression
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } 
            // If the character is '(', push it onto the stack
            else if (ch == '(') {
                stack.push(ch);
            } 
            // If the character is ')', pop and append until '(' is found
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    System.out.println("Invalid expression: Mismatched parentheses.");
                    return "";
                }
            } 
            // If the character is an operator
            else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop all the operators remaining in the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                System.out.println("Invalid expression: Mismatched parentheses.");
                return "";
            }
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    // Main function to test the conversion
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter an infix expression: ");
        String infixExpression = scanner.nextLine();

        String postfixExpression = infixToPostfix(infixExpression);

        if (!postfixExpression.isEmpty()) {
            System.out.println("Postfix Expression: " + postfixExpression);
        }

        scanner.close();
    }
}
