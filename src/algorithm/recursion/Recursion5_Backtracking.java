package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 📚 백트래킹 (Backtracking)
 * 백트래킹 = 모든 경우를 탐색하되, 조건에 안 맞으면 되돌아가기!
 * 핵심 아이디어:
 *
 * 재귀로 모든 경우 탐색
 * 조건 위반 시 즉시 되돌아감 (가지치기)
 * 완전탐색보다 효율적!
 *
 * 연습 37: 백트래킹 - 순열 (Permutation)
 * 문제: n개의 숫자로 만들 수 있는 모든 순열 구하기
 *
 * 순열 백트래킹 핵심:
 * void permutation(int depth, int r) {
 *     // 종료 조건
 *     if (depth == r) {
 *         // 결과 출력
 *         return;
 *     }
 *
 *     // 모든 원소 시도
 *     for (int i = 0; i < n; i++) {
 *         if (!visited[i]) {
 *             visited[i] = true;      // 선택
 *             output[depth] = arr[i];
 *
 *             permutation(depth + 1, r);  // 재귀
 *
 *             visited[i] = false;     // 백트래킹!
 *         }
 *     }
 * }
 */
public class Recursion5_Backtracking {

    static int[] arr;
    static int[] output;
    static boolean[] visited;
    static int count = 0;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("배열 크기 입력 (5 이하 권장): ");
        int n = Integer.parseInt(br.readLine());

        System.out.println(n + "개의 정수 입력 (공백 구분): ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb.append("\n배열: ").append(Arrays.toString(arr)).append("\n\n");

        // 순열 생성
        sb.append("=== 모든 순열 (").append(n).append(") ===\n\n");

        output = new int[n];
        visited = new boolean[n];
        count = 0;
        result = new StringBuilder();

        permutation(0, n);

        sb.append(result);
        sb.append("\n총 ").append(count).append("개의 순열\n");
        sb.append("이론값: ").append(n).append("! = ").append(factorial(n)).append("\n\n");

        // r개만 뽑는 순열 (nPr)
        System.out.print("\n몇 개 뽑을까요? (r): ");
        int r = Integer.parseInt(br.readLine());

        sb.append("=== ").append(n).append("P").append(r).append(" 순열 ===\n\n");

        output = new int[r];
        visited = new boolean[n];
        count = 0;
        result = new StringBuilder();

        permutation(0, r);

        sb.append(result);
        sb.append("\n총 ").append(count).append("개의 순열\n");
        sb.append("이론값: ").append(n).append("P").append(r).append(" = ");
        sb.append(permutationCount(n, r)).append("\n");

        System.out.println(sb);
    }

    /**
     * 순열 생성 (백트래킹)
     * @param depth 현재 깊이
     * @param r     뽑을 개수
     */
    static void permutation(int depth, int r) {
        // Base Case: r개 뽑았으면
        if (depth == r) {
            count++;
            result.append(count).append(". ");
            for (int i = 0; i < r; i++) {
                result.append(output[i]);
                if (i < r - 1) result.append(" ");
            }
            result.append("\n");
            return;
        }

        // Recursive Case: 하나씩 선택
        for (int i = 0; i < arr.length; i++) {
            // 아직 방문하지 않은 원소라면
            if (!visited[i]) {
                visited[i] = true; // 방문 표시
                output[depth] = arr[i]; // 선택

                permutation(depth + 1, r); // 다음 깊이로

                visited[i] = false; // 백트래킹 (되돌리기)
            }
        }
    }

    static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    static int permutationCount(int n, int r) {
        int result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
        }
        return result;
    }

}
