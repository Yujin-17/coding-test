package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 연습 21: 완전탐색 - 세 수의 합 (Three Sum)
 *
 * 삼중 for문 패턴:
 * for (int i = 0; i < n; i++) {
 *     for (int j = i + 1; j < n; j++) {
 *         for (int k = j + 1; k < n; k++) {
 *             // arr[i], arr[j], arr[k] 세 개 사용
 *         }
 *     }
 * }
 * 시간복잡도: O(n³)** - n이 작을 때만 가능!
 * ```
 */
public class BruteForce3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("배열 크기 입력: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println(n + "개의 정수 입력 (공백 구분): ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println("목표 합 입력: ");
        int target = Integer.parseInt(br.readLine());

        sb.append("배열: ").append(Arrays.toString(arr)).append('\n');
        sb.append("목표: ").append(target).append("\n\n");

        // 1. 정확히 target의 세 수 찾기
        sb.append("=== 정확이 ").append(target).append("인 세 수 ===\n");
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j ++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        count++;
                        sb.append(count).append(". arr[").append(i).append("] + arr[").append(j).append("] + arr[").append(k).append("] = ");
                        sb.append(arr[i]).append(" + ").append(arr[j]).append(" + ").append(arr[k]).append(" = ").append(target).append("\n");
                    }
                }
            }
        }

        if (count == 0) {
            sb.append("찾을 수 없습니다.\n");
        }
        sb.append("총 ").append(count).append("개의 조합\n\n");

        // 2. target에 가장 가까운 세 수의 합
        sb.append("=== ").append(target).append("에 가장 가까운 합 ===\n");
        int clossetSum = arr[0] + arr[1] + arr[2];
        int minDiff = Math.abs(target - clossetSum);
        int bi = 0, bj = 1, bk = 2;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    int diff = Math.abs(target - sum);

                    if (diff < minDiff) {
                        minDiff = diff;
                        clossetSum = sum;
                        bi = i;
                        bj = j;
                        bk = k;
                    }
                }
            }
        }

        sb.append("가장 가까운 합: ").append(clossetSum).append('\n');
        sb.append("조합: ").append(arr[bi]).append(" + ").append(arr[bj]).append(" + ").append(arr[bk]).append('\n');
        sb.append("차이: ").append(minDiff).append("\n\n");

        // 3. target 이하인 세 수의 합 중 최댓값 (블랙잭 문제!)
        sb.append("=== ").append(target).append(" 이하 중 최댓값 (블랙잭) ===\n");
        int maxSum = 0;
        int mi = -1, mj = -1, mk = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];

                    if (sum <= target && sum > maxSum) {
                        maxSum = sum;
                        mi = i;
                        mj = j;
                        mk = k;
                    }
                }
            }
        }

        if (maxSum == 0) {
            sb.append("찾을 수 없습니다.\n");
        } else {
            sb.append("최댓값: ").append(maxSum).append('\n');
            sb.append("조합: ").append(arr[mi]).append(" + ").append(arr[mj]).append(" + ").append(arr[mk]).append('\n');
        }

        System.out.println(sb);
    }
}
