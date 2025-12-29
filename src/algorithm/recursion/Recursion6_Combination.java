package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 연습 38: 백트래킹 - 조합 (Combination)
 * 순열 vs 조합:
 *
 * 순열: 순서 O (12 ≠ 21)
 * 조합: 순서 X (12 = 21)
 *
 * 조합 백트래킹 핵심:
 *
 * <p>
 *     void combination(int depth, int start, int n, int r) {
 *     // 종료 조건
 *     if (depth == r) {
 *         // 결과 출력
 *         return;
 *     }
 *
 *     // start부터 시작 (이전 것은 다시 안 봄!)
 *     for (int i = start; i < n; i++) {
 *         output[depth] = arr[i];  // 선택
 *
 *         combination(depth + 1, i + 1, n, r);  // 다음은 i+1부터!
 *     }
 * }
 * </p>
 *
 * 순열 vs 조합 코드 비교:
 *
 * 순열:
 * for (int i = 0; i < n; i++) {      // 0부터 시작
 *     if (!visited[i]) {              // visited 필요
 *         visited[i] = true;
 *         permutation(depth + 1, r);
 *         visited[i] = false;
 *     }
 * }
 *
 * 조합:
 * for (int i = start; i < n; i++) {  // start부터 시작
 *     output[depth] = arr[i];
 *     combination(depth + 1, i + 1, n, r);  // i+1로 넘김
 *     // visited 불필요!
 * }
 */
public class Recursion6_Combination {

    static int[] arr;
    static int[] output;
    static int count = 0;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("배열 크기 입력 (10 이하 권장): ");
        int n = Integer.parseInt(br.readLine());

        System.out.println(n + "개의 정수 입력 (공백 구분): ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb.append("\n배열: ").append(Arrays.toString(arr)).append("\n\n");

        System.out.print("몇 개 뽑을까요? (r): ");
        int r = Integer.parseInt(br.readLine());

        // 조합 생성
        sb.append("=== ").append(n).append("C").append(r).append(" 조합 ===\n\n");

        output = new int[r];
        count = 0;
        result = new StringBuilder();

        combination(0, 0, n, r);

        sb.append(result);
        sb.append("\n총 ").append(count).append("개의 조합\n");
        sb.append("이론값: ").append(n).append("C").append(r).append(" = ");
        sb.append(combinationCount(n, r)).append("\n\n");

        // 순열과 비교
        sb.append("=== 순열 vs 조합 비교 ===\n");
        sb.append("순열 ").append(n).append("P").append(r).append(" = ").append(permutationCount(n, r)).append(" (순서 O)\n");
        sb.append("조합 ").append(n).append("C").append(r).append(" = ").append(combinationCount(n, r)).append(" (순서 X)\n");

        System.out.println(sb);
    }

    /**
     * 조합 생성 (백트래킹)
     * @param depth 현재 깊이
     * @param start 시작 인덱스 (중복 방지!)
     * @param n 전체 개수
     * @param r 뽑을 개수
     */
    static void combination(int depth, int start, int n, int r) {
        // Base Case: r개를 다 뽑았으면
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

        // Recursive Case: start부터 시작해서 선택
        for (int i = start; i < n; i++) {
            output[depth] = arr[i]; // 선택

            combination(depth + 1, i + 1, n, r); // 다음은 i + 1 부터!

            // 조합은 visited 배열 필요 없음!
        }
    }

    static int combinationCount(int n, int r) {
        if (r == 0 || r == n) return 1;
        return combinationCount(n - 1, r - 1) + combinationCount(n - 1, r);
    }

    static int permutationCount(int n, int r) {
        int result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
        }
        return result;
    }

}
