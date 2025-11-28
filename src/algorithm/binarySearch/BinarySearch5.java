package algorithm.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 연습 33: 파라메트릭 서치 - 랜선 자르기
 * 문제: K개의 랜선으로 N개를 만들 때, 랜선의 최대 길이는?
 *
 * 파라메트릭 서치 문제 패턴:
 *
 * 1. 이분탐색 범위 설정
 * - left = 가능한 최솟값
 * - right = 가능한 최댓값
 *
 * 2. 조건 함수 작성
 *
 *    boolean canMake(int mid) {
 *        // mid 값으로 조건을 만족하는가?
 *    }
 *
 * 3. 최댓값 구하기
 *
 *    if (조건 만족) {
 *        answer = mid;
 *        left = mid + 1;  // 더 큰 값 시도
 *    }
 *
 * 4. 최솟값 구하기
 *
 *    if (조건 만족) {
 *        answer = mid;
 *        right = mid - 1;  // 더 작은 값 시도
 *    }
 * ```
 */
public class BinarySearch5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("=== 랜선 자르기 문제 ===");
        System.out.println("K개의 랜선을 같은 길이로 잘라서 N개를 만들 때,");
        System.out.println("만들 수 있는 랜선의 최대 길이는?\n");

        System.out.println("가지고 있는 랜선 개수 K: ");
        int k = Integer.parseInt(br.readLine());

        System.out.println("필요한 랜선 개수 N: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println(k + "개의 랜선 길이 입력: ");

        long[] cables = new long[k];
        long maxLength = 0;

        for (int i = 0; i < k; i++) {
            cables[i] = Long.parseLong(br.readLine());
            maxLength = Math.max(maxLength, cables[i]);
        }

        sb.append("\n랜선 길이들: ").append(Arrays.toString(cables)).append("\n");
        sb.append("필요한 개수: ").append(n).append("개\n\n");

        // 파라메트릭 서치
        sb.append("== 파라메트릭 서치 과정 ==\n");

        long left = 1; // 최소 길이
        long right = maxLength; // 최대 길이
        long answer = 0;
        int step = 1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = getCount(cables, mid);

            sb.append("Step ").append(step++).append(":\n");
            sb.append("  범위: [").append(left).append(", ").append(right).append("]\n");
            sb.append("  시도 길이 = ").append(mid).append("cm\n");
            sb.append("  만들 수 있는 개수: ").append(count).append("개\n");

            if (count >= n) {
                // N개 이상 만들 수 있음 → 길이를 더 늘려보자
                answer = mid;
                left = mid + 1;
                sb.append("  → ").append(count).append(" >= ").append(n).append(" (충분!) ");
                sb.append("→ 길이를 더 늘려봄\n\n");
            } else {
                // N개 못 만듦 → 길이를 줄여야 함
                right = mid - 1;
                sb.append("  → ").append(count).append(" < ").append(n).append(" (부족!) ");
                sb.append("→ 길이를 줄임\n\n");
            }
        }

        sb.append("=== 결과 ===\n");
        sb.append("최대 길이: ").append(answer).append("cm\n");
        sb.append("이 길이로 자르면: ").append(getCount(cables, answer)).append("개 만들 수 있음\n\n");

        // 검증
        sb.append("=== 검증 ===\n");
        long total = 0;
        for (int i = 0; i < k; i++) {
            long count = cables[i] / answer;
            sb.append("랜선 ").append(i + 1).append(": ").append(cables[i]).append("cm");
            sb.append(" → ").append(count).append("개\n");
            total += count;
        }
        sb.append("총 ").append(total).append("개 (").append(n).append("개 필요)\n");

        System.out.println(sb);
    }

    // length 길이로 잘랐을 때 만들 수 있는 랜선 개수
    static long getCount(long[] cables, long length) {
        long count = 0;
        for (long cable : cables) {
            count += cable / length;
        }
        return count;
    }
}
