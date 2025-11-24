package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 연습 20: 완전탐색 - 두 수의 합 (Two Sum)
 *
 * 핵심 패턴:
 * 완전탐색 (이중 for문):
 * for (int i = 0; i < n; i++) {
 *     for (int j = i + 1; j < n; j++) {  // i+1부터 시작! (중복 방지)
 *         if (arr[i] + arr[j] == target) {
 *             // 찾음!
 *         }
 *     }
 * }
 * HashMap 최적화:
 * for (int i = 0; i < n; i++) {
 *     int complement = target - arr[i];  // 필요한 나머지 값
 *     if (map.containsKey(complement)) {
 *         // 찾음!
 *     }
 *     map.put(arr[i], i);
 * }
 * ```
 */
public class BruteForce2 {

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

        // 방법 1: 완전탐색 (O(n^2))
        sb.append("=== 방법 1: 완전탐색 (O(n^2)) ===\n");
        boolean found1 = false;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    sb.append("찾음! arr[").append(i).append("] + arr[").append(j).append("] = ");
                    sb.append(arr[i]).append(" + ").append(arr[j]).append(" = ").append(target).append("\n");
                    found1 = true;
                }
            }
        }

        if (!found1) {
            sb.append("찾을 수 없습니다.\n");
        }
        sb.append("\n");

        // 방법 2: HashMap 사용 (O(n)) - 더 빠름!
        sb.append("=== 방법 2: HashMap 사용 (더 빠름!) ===\n");
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean found2 = false;

        for (int i = 0; i < n; i++) {
            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                sb.append("찾음! arr[").append(map.get(complement)).append("] + arr[").append(i).append("] = ");
                sb.append(complement).append(" + ").append(arr[i]).append(" = ").append(target).append("\n");
                found2 = true;
                break;
            }

            map.put(arr[i], i);
        }

        if (!found2) {
            sb.append("찾을 수 없습니다.\n");
        }
        sb.append("\n");

        // 모든 쌍 찾기
        sb.append("=== 모든 쌍 찾기 ===\n");
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    count++;
                    sb.append(count).append(". ").append(arr[i]).append(" + ").append(arr[j]).append(" = ").append(target).append("\n");
                }
            }
        }

        sb.append("총 ").append(count).append("개의 쌍\n");

        System.out.println(sb);
    }
}
