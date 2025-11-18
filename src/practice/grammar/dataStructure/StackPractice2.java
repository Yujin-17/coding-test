package practice.grammar.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 연습 7: Stack으로 괄호 검사 (실전 문제!)
 */
public class StackPractice2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("괄호 문자열 입력: ");
        String str = br.readLine();

        if (isValid(str)) {
            System.out.println("올바른 괄호 문자열입니다.");
        } else {
            System.out.println("올바르지 않은 괄호 문자열입니다.");
        }

        // 여러 개 테스트
        System.out.println("\n여러 개의 괄호 문자열 테스트:");
        String[] testCases = {
                "()",
                "(())",
                "()()",
                "((()))",
                "(()",
                "())(",
                "()()())",
                "()(()())"
        };

        for (String testCase : testCases) {
            System.out.println(testCase + " -> " + (isValid(testCase) ? "올바름" : "올바르지 않음"));
        }
    }

    static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                // 여는 괄호면 스택에 push
                stack.push(c);
            } else if (c == ')') {
                // 닫는 괄호인데 스택이 비어있으면 false
                if (stack.isEmpty()) {
                    return false;
                }
                // 짝 맞춰서 pop
                stack.pop();
            }
        }

        // 모든 결과가 짝이 맞으면 스택이 비어있어야 함
        return stack.isEmpty();
    }
}
