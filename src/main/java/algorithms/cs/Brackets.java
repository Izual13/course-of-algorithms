package algorithms.cs;


import java.util.Scanner;
import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
        char[] line = new Scanner(System.in).nextLine().toCharArray();
        System.out.println(calc(line));
    }


    static String calc(char[] line) {
        Stack<Character> stack = new Stack<>();
        int removed = 0;
        int index = 0;

        for (char c : line) {
            char peek = ' ';
            if (!stack.isEmpty()) {
                peek = stack.peek();
            }
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if ('(' == peek) {
                        stack.pop();
                        removed += 2;
                        if (stack.isEmpty()) {
                            index += removed;
                            removed = 0;
                        }
                    } else {
                        return String.valueOf(stack.size() + index + removed + 1);
                    }
                    break;
                case '}':
                    if ('{' == peek) {
                        stack.pop();
                        removed += 2;
                        if (stack.isEmpty()) {
                            index += removed;
                            removed = 0;
                        }
                    } else {
                        return String.valueOf(stack.size() + index + removed + 1);
                    }
                    break;
                case ']':
                    if ('[' == peek) {
                        stack.pop();
                        removed += 2;
                        if (stack.isEmpty()) {
                            index += removed;
                            removed = 0;
                        }
                    } else {
                        return String.valueOf(stack.size() + index + removed + 1);
                    }
                    break;
                default:
                    index++;
                    break;
            }
        }
        if (stack.empty()) {
            return "Success";
        } else {
            return String.valueOf(stack.size() + index);
        }
    }
}
