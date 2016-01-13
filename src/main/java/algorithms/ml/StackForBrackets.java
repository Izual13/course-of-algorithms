package algorithms.ml;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * Использование стека
 */
public class StackForBrackets {

    public static void main(String[] args) {
        start(System.in, System.out);
    }


    public static void start(InputStream is, PrintStream out) {
        Scanner in = new Scanner(is);
        String s = in.nextLine();
        out.println(check(s));
    }

    private static String check(String in) {
        Stack<Character> stack = new Stack<>();
        String prefix = "";
        for (char c : in.toCharArray()) {
            switch (c) {
                case '[':
                case '{':
                case '(':
                    stack.push(c);
                    break;
                case ']':
                case '}':
                case ')':
                    if (stack.isEmpty()) {
                        prefix = backCharacter(c) + prefix;
                    } else if (stack.peek() == backCharacter(c)) {
                        stack.pop();
                    } else {
                        return "IMPOSSIBLE";
                    }
                    break;
            }
        }
        in = prefix + in;

        String postfix = "";
        while (!stack.isEmpty()) {
            Character character = stack.pop();
            postfix += backCharacter(character);
        }
        return in + postfix;
    }

    private static char backCharacter(char c) {
        switch (c) {
            case '[':
                return ']';
            case '{':
                return '}';
            case '(':
                return ')';
            case ']':
                return '[';
            case '}':
                return '{';
            case ')':
                return '(';
            default:
                return c;
        }
    }
}
