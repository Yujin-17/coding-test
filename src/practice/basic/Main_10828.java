package practice.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10828 {

    static FastScanner sc = new FastScanner();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int[] stack = new int[n];
        int top = -1; // 스택이 비어있음을 나타내는 인덱스

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            if (cmd.equals("push")) {
                int value = sc.nextInt();
                stack[++top] = value; // 스택에 값 추가
            } else if (cmd.equals("pop")) {
                // pop: 스택이 비어 있으면 -1, 아니면 맨 위 값 출력 후 제거
                if (top == -1) sb.append(-1).append('\n');
                else sb.append(stack[top--]).append('\n');
            }
            else if (cmd.equals("size")) {
                // size: 스택의 크기 = top + 1
                sb.append(top + 1).append('\n');
            }
            else if (cmd.equals("empty")) {
                // empty: 비었으면 1, 아니면 0
                sb.append(top == -1 ? 1 : 0).append('\n');
            }
            else if (cmd.equals("top")) {
                // top: 맨 위 값 출력 (비었으면 -1)
                sb.append(top == -1 ? -1 : stack[top]).append('\n');
            }
        }
        System.out.print(sb);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 스트림 연결
        StringTokenizer st; // 문자열을 공백 기준으로 끊어주는 도구

        String next() throws IOException {
            // 다음 토큰(=공백으로 구분된 문자열)을 반환
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException { return Integer.parseInt(next()); } // 정수 입력
        long nextLong() throws IOException { return Long.parseLong(next()); } // 긴 정수 입력
        String nextLine() throws IOException { return br.readLine(); } // 한 줄 전체 입력
    }

}
