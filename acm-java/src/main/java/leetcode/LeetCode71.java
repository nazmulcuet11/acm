package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode71 {
    private List<String> simplifyPathComponents(List<String> components) {
        var simplifiedComponents = new Stack<String>();
        for (String component: components) {
            if (component.equals("."))
                continue;

            if (component.equals("..")) {
                if (!simplifiedComponents.isEmpty()) {
                    simplifiedComponents.pop();
                }
                continue;
            }

            simplifiedComponents.push(component);
        }
        return simplifiedComponents;
    }

    public String simplifyPath(String path) {
        var components = Arrays.stream(path.split("/"))
            .filter(x -> !x.isEmpty())
            .toList();
        var simplifiedComponents = this.simplifyPathComponents(components);
        return "/" + String.join("/", simplifiedComponents);
    }
}
