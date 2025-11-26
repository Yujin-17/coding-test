package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 연습 24: 선택 정렬 (Selection Sort)
 * 개념: 가장 작은 값을 찾아서 맨 앞으로 보냄
 *
 * 선택 정렬 핵심 코드:
 * for (int i = 0; i < n - 1; i++) {
 *     // 최솟값의 인덱스 찾기
 *     int minIdx = i;
 *     for (int j = i + 1; j < n; j++) {
 *         if (arr[j] < arr[minIdx]) {
 *             minIdx = j;
 *         }
 *     }
 *
 *     // 교환
 *     int temp = arr[i];
 *     arr[i] = arr[minIdx];
 *     arr[minIdx] = temp;
 * }
 * ```
 *
 * **동작 원리:**
 * 1. 0번째 자리에 최솟값
 * 2. 1번째 자리에 두 번째 최솟값
 * 3. 반복...
 *
 * **버블 정렬 vs 선택 정렬:**
 * - 버블: 교환 많음, 조기 종료 가능
 * - 선택: 교환 적음, 항상 O(n²)
 */
public class SortingAlgorithm2 {
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

        // 선택 정렬
        sb.append("=== 선택 정렬 과정 ===\n");
        int[] selectionArr = arr.clone();
        int swapCount = 0;
        int compareCount = 0;

        for (int i = 0; i < n - 1; i++) {
            sb.append((i + 1)).append("번째 패스:\n");

            // 1번째 위치에 올 최솟값 찾기
            int minInx = i;

            for (int j = i + 1; j < n; j++) {
                compareCount++;
                if (selectionArr[j] < selectionArr[minInx]) {
                    minInx = j;
                }
            }

            sb.append(" 최솟값: ").append(selectionArr[minInx]);
            sb.append(" (인덱스 ").append(minInx).append(")\n");

            // 최솟값을 1번째 위치로 이동
            if (minInx != i) {
                int temp = selectionArr[i];
                selectionArr[i] = selectionArr[minInx];
                selectionArr[minInx] = temp;

                swapCount++;
                sb.append(" swap: ").append(selectionArr[i]).append(" <-> ").append(selectionArr[minInx]);
                sb.append(" → ").append(Arrays.toString(selectionArr)).append("\n");
            } else {
                sb.append("  (교환 불필요)\n");
            }

            sb.append(" 현재: ").append(Arrays.toString(selectionArr)).append("\n\n");
        }

        sb.append("최종 결과: ").append(Arrays.toString(selectionArr)).append("\n");
        sb.append("총 비교 횟수: ").append(compareCount).append("\n");
        sb.append("총 교환 횟수: ").append(swapCount).append("\n\n");

        // 시간복잡도 정보
        sb.append("=== 선택 정렬 특징 ===\n");
        sb.append("시간복잡도: O(n²)\n");
        sb.append("최선/최악 모두: O(n²) - 항상 동일\n");
        sb.append("공간복잡도: O(1)\n");
        sb.append("안정 정렬: No - 같은 값의 순서 바뀔 수 있음\n");
        sb.append("교환 횟수: 최대 n-1번 (버블 정렬보다 적음)\n");

        System.out.println(sb);
    }
}
