package algorithm.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 연습 22: 완전탐색 - 부분집합 (비트마스크)
 *
 * 비트마스크 핵심:
 * // 2^n 개의 부분집합 순회
 * for (int i = 0; i < (1 << n); i++) {
 *     // i의 각 비트가 해당 원소 포함 여부
 *     for (int j = 0; j < n; j++) {
 *         if ((i & (1 << j)) != 0) {
 *             // j번째 원소 포함!
 *         }
 *     }
 * }
 * ```
 * **예시:**
 * - n=3일 때: `{1, 2, 3}`
 * - i=5 (이진수: 101)
 *   - 0번째 비트 1 → 1 포함
 *   - 1번째 비트 0 → 2 미포함
 *   - 2번째 비트 1 → 3 포함
 *   - 결과: `{1, 3}`
 */
public class BruteForce4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("배열 크기 입력 (10 이하 권장): ");
        int n = Integer.parseInt(br.readLine());

        System.out.println(n + "개의 정수 입력 (공백 구분): ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb.append("배열: ").append(Arrays.toString(arr)).append("\n\n");

        // 모든 부분집합 출력
        sb.append("=== 모든 부분집합 (2^").append(n).append(" = ").append((1 << n)).append("개) ===\n");

        // 2^n 개의 부분집합
        for (int i = 0; i < (1 << n); i++) { // 0부터 2^n - 1까지
            sb.append(i).append(": { ");

            ArrayList<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // j번째 비트가 1인지 확인
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }

            if (subset.isEmpty()) {
                sb.append("공집합");
            } else {
                for (int k = 0; k < subset.size(); k++) {
                    sb.append(subset.get(k));
                    if (k < subset.size() - 1) {
                        sb.append(", ");
                    }
                }
            }

            sb.append(" }\n");
        }
        sb.append("\n");

        // 특정 합을 만드는 부분집합 찾기
        System.out.println("\n목표 합 입력: ");
        int target = Integer.parseInt(br.readLine());

        sb.append("=== 합이 ").append(target).append("인 부분집합 ===\n");
        int count = 0;

        for (int i = 1; i < (1 << n); i++) { // 공집합 제외 (1부터 시작)
            ArrayList<Integer> subset = new ArrayList<>();
            int sum = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += arr[j];
                    subset.add(arr[j]);
                }
            }

            if (sum == target) {
                count++;
                sb.append(count).append(": { ");
                for (int k = 0; k < subset.size(); k++) {
                    sb.append(subset.get(k));
                    if (k < subset.size() - 1) {
                        sb.append(", ");
                    }
                }
                sb.append(" } = ").append(sum).append("\n");
            }
        }

        if (count == 0) {
            sb.append("찾을 수 없습니다.\n");
        }
        sb.append("총 ").append(count).append("개\n");

        System.out.println(sb);
    }

}
