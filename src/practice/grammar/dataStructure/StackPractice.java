package practice.grammar.dataStructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 📚 자료구조 - Stack
 * Stack = 접시 쌓기 (LIFO: Last In First Out)
 * 마지막에 넣은 게 먼저 나와요!
 * 코테에서 언제 쓰나요?
 *
 * 괄호 검사
 * 백트래킹
 * DFS (깊이 우선 탐색)
 * 되돌리기 기능
 */
public class StackPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        System.out.println("명령 개수 입력: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println("\n명령어: ");
        System.out.println("push [숫자] - 스택에 추가");
        System.out.println("pop - 스택에서 제거 및 출력");
        System.out.println("peek - 스택의 최상단 요소 출력(맨 뒤 확인");
        System.out.println("size - 스택의 크기 출력");
        System.out.println("empty - 스택이 비어있는지 확인(1: 비어있음, 0: 안 비어있음)");
        System.out.println();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            String command = st.nextToken();

            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
                sb.append("push ").append(num).append(" -> 스택: ").append(stack).append("\n");
            } else if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    sb.append("pop -> 스택이 비어있습니다!\n");
                } else {
                    int popped = stack.pop();
                    sb.append("pop -> ").append(popped).append(" 제거, 스택: ").append(stack).append("\n");
                }
            } else if (command.equals("peek")) {
                if (stack.isEmpty()) {
                    sb.append("peek -> 스택이 비어있습니다!\n");
                } else {
                    sb.append("peek -> 맨 위: ").append(stack.peek()).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append("size -> 스택 크기: ").append(stack.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append("empty -> ").append(stack.isEmpty() ? "1 (비어있음)" : "0 (안 비어있음)").append("\n");
            }
        }

        System.out.println(sb);
    }
}
