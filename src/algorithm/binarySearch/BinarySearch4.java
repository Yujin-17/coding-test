package algorithm.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 연습 32: 파라메트릭 서치 (결정 문제)
 * 개념: "조건을 만족하는 최솟값/최댓값 찾기"
 * 예시) 나무 자르기 문제:
 *
 * M미터의 나무가 필요할 때
 * 절단기 높이를 최대 몇으로 설정할 수 있을까?
 *
 * 파라메트릭 서치 핵심 패턴:
 * int left = 최솟값;
 * int right = 최댓값;
 * int answer = 0;
 *
 * while (left <= right) {
 *     int mid = (left + right) / 2;
 *
 *     if (조건을_만족하는가(mid)) {
 *         answer = mid;      // 일단 저장
 *         // 더 나은 답 찾기
 *         left = mid + 1;    // 최댓값 구하기
 *         // 또는
 *         right = mid - 1;   // 최솟값 구하기
 *     } else {
 *         // 조건 만족 못함
 *         right = mid - 1;   // 또는 left = mid + 1;
 *     }
 * }
 * ```
 */
public class BinarySearch4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("=== 나무 자르기 문제 ===");
        System.out.println("절단기로 나무를 자를 때, 높이 H 이상은 잘림");
        System.out.println("M미터가 필요할 때, M의 최댓값은?\n");

        System.out.println("나무 개수 입력: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println(n + "개의 나무 높이 입력 (공백 구분): ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] trees = new int[n];
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, trees[i]);
        }

        System.out.println("필요한 나무 길이 M: ");
        long m = Long.parseLong(br.readLine());

        sb.append("\n나무들: ").append(Arrays.toString(trees)).append('\n');
        sb.append("필요한 길이: ").append(m).append("m\n\n");

        // 파라메트릭 서치
        sb.append("=== 파라메트릭 서치 과정 ===\n\n");

        int left = 0;
        int right = maxHeight;
        int answer = 0;
        int step = 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            long cut = getCutLength(trees, mid);

            sb.append("Step ").append(step++).append(":\n");
            sb.append("  범위: [").append(left).append(", ").append(right).append("]\n");
            sb.append("  시도 높이 H = ").append(mid).append("\n");
            sb.append("  잘린 나무 합: ").append(cut).append("m\n");

            if (cut > m) {
                // 충분히 자를 수 있음 -> 높이를 더 올려보자
                answer = mid;
                left = mid + 1;
                sb.append("  → ").append(cut).append(" >= ").append(m).append(" (충분!) ");
                sb.append("→ 높이를 더 올려봄\n\n");
            } else {
                // 부족함 → 높이를 낮춰야 함
                right = mid - 1;
                sb.append("  → ").append(cut).append(" < ").append(m).append(" (부족!) ");
                sb.append("→ 높이를 낮춤\n\n");
            }
        }

        sb.append("=== 결과 ===\n");
        sb.append("최대 높이: ").append(answer).append("\n");
        sb.append("이 높이로 자르면: ").append(getCutLength(trees, answer)).append("m 얻음\n\n");

        // 검증
        sb.append("=== 검증 ===\n");
        for (int i = 0; i < n; i++) {
            int cutAmount = Math.max(0, trees[i] - answer);
            sb.append("나무 ").append(i + 1).append(": ").append(trees[i]).append("m");
            if (cutAmount > 0) {
                sb.append(" → ").append(cutAmount).append("m 잘림");
            } else {
                sb.append(" → 안 잘림");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    // H 높이로 잘랐을 때 얻을 수 있는 나무 길이
    static long getCutLength(int[] trees, int height) {
        long sum = 0;
        for (int tree : trees) {
            if (tree > height) {
                sum += (tree - height);
            }
        }
        return sum;
    }
}
