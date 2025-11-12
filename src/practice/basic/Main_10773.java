package practice.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10773 {

    static FastScanner sc = new FastScanner();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            if (value == 0) {
                sb.delete(sb.lastIndexOf("\n", sb.length() - 2) + 1, sb.length());
            } else {
                sb.append(value).append('\n');
            }
        }

        int sum = 0;
        String[] numbers = sb.toString().split("\n");
        for (String numStr : numbers) {
            if (!numStr.isEmpty()) {
                sum += Integer.parseInt(numStr);
            }
        }
        System.out.println(sum);
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
