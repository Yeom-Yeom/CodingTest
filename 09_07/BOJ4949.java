import java.io.*;
import java.util.*;

public class BOJ4949 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s;

        while (true) {
            s = scan.nextLine();
            if (s.equals(".")) {
                break;
            } else
                System.out.println(solve(s));
        }
    }

    private static String solve(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[')
                stack.push(c);

            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(')
                    return "no";
                else
                    stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[')
                    return "no";
                else
                    stack.pop();
            }
        }

        if (stack.isEmpty())
            return "yes";
        else
            return "no";
    }
}
