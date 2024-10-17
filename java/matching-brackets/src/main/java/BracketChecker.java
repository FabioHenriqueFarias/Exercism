import java.util.ArrayList;
import java.util.List;

class BracketChecker {

    String expression;
    List<Character> openBrackets = List.of('{', '[', '(');
    List<Character> closeBrackets = List.of('}', ']', ')');

    BracketChecker(String expression) {
        this.expression = expression;
    }

    boolean areBracketsMatchedAndNestedCorrectly() {

        List<Character> stack = new ArrayList<>();

        for (char ch : expression.toCharArray()) {
            if (openBrackets.contains(ch)) {
                stack.add(ch);
            } else if (closeBrackets.contains(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.remove(stack.size() - 1);

                if (!isMatchingPair(last, ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

}