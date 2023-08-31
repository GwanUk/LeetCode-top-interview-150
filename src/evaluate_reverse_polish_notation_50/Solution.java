package evaluate_reverse_polish_notation_50;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int num1, num2;

        for (String token : tokens) {

            switch (token) {
                case "+" -> {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 + num1);
                }
                case "-" -> {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 - num1);
                }
                case "*" -> {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 * num1);
                }
                case "/" -> {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 / num1);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}