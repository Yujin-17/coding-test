package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 연습 23: 버블 정렬 (Bubble Sort)
 * 개념: 인접한 두 원소를 비교해서 큰 값을 뒤로 보냄 (거품이 떠오르듯)
 *
 * 버블 정렬 핵심 코드:
 * for (int i = 0; i < n - 1; i++) {
 *     for (int j = 0; j < n - 1 - i; j++) {
 *         if (arr[j] > arr[j + 1]) {
 *             // swap
 *             int temp = arr[j];
 *             arr[j] = arr[j + 1];
 *             arr[j + 1] = temp;
 *         }
 *     }
 * }
 * ```
 *
 * **동작 원리:**
 * 1. 첫 번째 패스: 가장 큰 값이 맨 뒤로
 * 2. 두 번째 패스: 두 번째로 큰 값이 뒤에서 두 번째로
 * 3. 반복...
 */
public class SortingAlgorithm {

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

        sb.append("원본: ").append(Arrays.toString(arr)).append("\n\n");

        // 버블 정렬
        sb.append("=== 버블 정렬 과정 ===\n");
        int[] bubbleArr = arr.clone();
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            sb.append((i + 1)).append("번째 패스:\n");
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (bubbleArr[j] > bubbleArr[j + 1]) {
                    // 교환
                    int temp = bubbleArr[j];
                    bubbleArr[j] = bubbleArr[j + 1];
                    bubbleArr[j + 1] = temp;

                    swapCount++;
                    swapped = true;

                    sb.append("  swap: ").append(bubbleArr[j + 1]).append(" <-> ").append(bubbleArr[j]);
                    sb.append(" → ").append(Arrays.toString(bubbleArr)).append("\n");
                }
            }

            if (!swapped) {
                sb.append("  (교환 없음 - 정렬 완료!)\n");
                break;
            }
            sb.append("\n");
        }

        sb.append("최종 결과: ").append(Arrays.toString(bubbleArr)).append("\n");
        sb.append("총 교환 횟수: ").append(swapCount).append("\n\n");

        // 시간복잡도 정보
        sb.append("=== 버블 정렬 특징 ===\n");
        sb.append("시간복잡도: O(n²)\n");
        sb.append("최선: O(n) - 이미 정렬된 경우\n");
        sb.append("최악: O(n²)\n");
        sb.append("공간복잡도: O(1) - 추가 메모리 필요 없음\n");
        sb.append("안정 정렬: Yes - 같은 값의 순서 유지\n");

        System.out.println(sb);
    }
}
