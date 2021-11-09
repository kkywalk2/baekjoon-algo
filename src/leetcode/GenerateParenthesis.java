package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {
    public boolean validateParenthesis(String combination) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < combination.length(); i++) {
            if (combination.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    public void generateParenthesisBT(int sCount, int eCount, String combination, List<String> list) {
        if (sCount == 0 && eCount == 0) {
            if (validateParenthesis(combination)) {
                list.add(combination);
            }
        } else {
            if (sCount - 1 >= 0)
                generateParenthesisBT(sCount - 1, eCount, combination + "(", list);
            if (eCount - 1 >= 0)
                generateParenthesisBT(sCount, eCount - 1, combination + ")", list);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesisBT(n, n, "", list);
        return list;
    }
}
