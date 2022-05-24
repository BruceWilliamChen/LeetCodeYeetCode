package com.bchen.easy.LC20;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class ValidParentheses {
    public boolean isValid(String s) {
        //use stack
        if (s == null || s.length() == 0) return true;

        if (s.length()%2 != 0) return false;

        Stack<Character> validator = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item == '(' || item == '{' || item == '[') {
                validator.push(item);
            } else {
                if (validator.isEmpty()) return false;
                char top = validator.pop();
                if (top != map.get(item)) return false;
            }
        }

        return validator.isEmpty();
    }
}
