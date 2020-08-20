package 有效括号;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isValid("[{()}](){[()]}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for(int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);

            if(stack.isEmpty()) {
                stack.push(str);
            }
            else if(stack.peek() == map.get(str)) {
                stack.pop();
            }
            else {
                stack.push(str);
            }
        }

        return stack.isEmpty();
    }
}
