package com.bchen.medium.LC71;

import java.util.List;
import java.util.ArrayList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        StringBuilder result = new StringBuilder();

        if (path == null || path.length() == 0) return result.toString();

        String[] elements = path.split("/");
        List<String> newElements = new ArrayList<String>();

        for (String element: elements) {
            if (element.equals(".")) continue;
            if (element.equals("..")) {
                if (newElements.size() > 0) {
                    newElements.remove(newElements.size() - 1);
                }
                continue;
            }
            if (!element.isEmpty()) {
                newElements.add(element);
            }
        }

        result.append('/');
        result.append(String.join("/", newElements));
        return result.toString();
    }
}
