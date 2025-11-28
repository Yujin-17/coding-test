package algorithm.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 연습 31: Lower Bound & Upper Bound
 * 개념:
 *
 * Lower Bound: target 이상인 첫 번째 위치
 * Upper Bound: target 초과인 첫 번째 위치
 *
 * 중복된 값이 있을 때 유용!
 *
 * 핵심 차이:
 * Lower Bound:
 * if (arr[mid] < target)  // '<' 만 왼쪽으로
 *     left = mid + 1;
 * else
 *     right = mid;
 * Upper Bound:
 * if (arr[mid] <= target)  // '<=' 왼쪽으로
 *     left = mid + 1;
 * else
 *     right = mid;
 * ```
 *
 * **활용:**
 * - `upper - lower` = target의 개수
 * - 특정 범위 내 개수 구하기
 */
public class BinarySearch3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("배열 크기 입력: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println(n + "개의 정수 입력 (중복 가능, 공백 구분): ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        sb.append("정렬된 배열: ").append(Arrays.toString(arr)).append("\n\n");

        System.out.println("찾을 값 입력: ");
        int target = Integer.parseInt(br.readLine());

        // Lower Bound
        int lower = lowerBound(arr, target);
        sb.append("=== Lower Bound (").append(target).append(" 이상인 첫 위치) ===\n");
        if (lower < n) {
            sb.append("인덱스: ").append(lower).append(", 값: ").append(arr[lower]).append("\n");
        } else {
            sb.append("모든 값이 ").append(target).append("보다 작습니다.\n");
        }
        sb.append("\n");

        // Upper Bound
        int upper = upperBound(arr, target);
        sb.append("=== Upper Bound (").append(target).append(" 초과인 첫 위치) ===\n");
        if (upper < n) {
            sb.append("인덱스: ").append(upper).append(", 값: ").append(arr[upper]).append("\n");
        } else {
            sb.append("모든 값이 ").append(target).append(" 이하입니다.\n");
        }
        sb.append("\n");

        // target의 개수 구하기
        int count = upper - lower;
        sb.append("=== ").append(target).append("의 개수 ===\n");
        sb.append(count).append("개\n");

        if (count > 0) {
            sb.append("위치: [").append(lower).append("~").append(upper - 1).append("]\n");
        }
        sb.append("\n");

        // 범위 내 개수 구하기
        System.out.print("\n범위 시작 값: ");
        int rangeStart = Integer.parseInt(br.readLine());
        System.out.print("범위 끝 값: ");
        int rangeEnd = Integer.parseInt(br.readLine());

        int startIdx = lowerBound(arr, rangeStart);
        int endIdx = upperBound(arr, rangeEnd);
        int rangeCount = endIdx - startIdx;

        sb.append("=== [").append(rangeStart).append(", ").append(rangeEnd).append("] 범위의 개수 ===\n");
        sb.append(rangeCount).append("개\n");

        System.out.println(sb);
    }

    // Lower Bound : target 이상인 첫 번째 위치
    public static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // Upper Bound : target 초과인 첫 번째 위치
    public static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
