package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 연습 28: 퀵 정렬 (Quick Sort) - O(n log n)
 * 개념: 피벗(pivot)을 기준으로 작은 값은 왼쪽, 큰 값은 오른쪽으로 분할
 *
 * 퀵 정렬 핵심:
 * void quickSort(int[] arr, int left, int right) {
 *     if (left < right) {
 *         int pivotIdx = partition(arr, left, right);  // 분할
 *         quickSort(arr, left, pivotIdx - 1);          // 왼쪽 정렬
 *         quickSort(arr, pivotIdx + 1, right);         // 오른쪽 정렬
 *     }
 * }
 *
 * int partition(int[] arr, int left, int right) {
 *     int pivot = arr[right];
 *     int i = left - 1;
 *
 *     for (int j = left; j < right; j++) {
 *         if (arr[j] < pivot) {
 *             i++;
 *             swap(arr, i, j);
 *         }
 *     }
 *
 *     swap(arr, i + 1, right);
 *     return i + 1;
 * }
 * ```
 *
 * **병합 정렬 vs 퀵 정렬:**
 * - 병합: 항상 O(n log n), 추가 메모리 필요
 * - 퀵: 평균 O(n log n), 제자리 정렬, 최악 O(n²)
 */
public class SortingAlgorithm6 {

    static StringBuilder process = new StringBuilder();
    static int depth = 0;

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

        // 퀵 정렬
        sb.append("=== 퀵 정렬 과정 ===\n\n");
        process = new StringBuilder();
        depth = 0;

        long start = System.nanoTime();
        quickSort(arr, 0, n - 1);
        long end = System.nanoTime();

        sb.append(process);

        sb.append("\n최종 결과: ").append(Arrays.toString(arr)).append("\n");
        sb.append("시간: ").append((end - start) / 1000).append(" μs\n\n");

        // 시간복잡도 정보
        sb.append("=== 퀵 정렬 특징 ===\n");
        sb.append("시간복잡도:\n");
        sb.append("  평균: O(n log n)\n");
        sb.append("  최선: O(n log n) - 피벗이 중간값\n");
        sb.append("  최악: O(n²) - 피벗이 최솟값/최댓값 (이미 정렬된 경우)\n");
        sb.append("공간복잡도: O(log n) - 재귀 호출 스택\n");
        sb.append("안정 정렬: No\n");
        sb.append("특징: 평균적으로 가장 빠른 정렬, 내부 정렬에 최적\n");

        System.out.println(sb);
    }

    static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            String indent = "  ".repeat(depth);
            process.append(indent).append("정렬 전: [").append(left).append("~").append(right).append("] ");
            process.append(arrayToString(arr, left, right));

            // 파티션 수행
            int pivotIdx = partition(arr, left, right);

            process.append(" → 피벗: ").append(arr[pivotIdx]).append(" (인덱스 ").append(pivotIdx).append(")\n");
            process.append(indent).append("정렬 후: ");
            process.append(arrayToString(arr, left, right)).append("\n\n");

            // 피벗 기준 왼쪽 정렬
            depth++;
            quickSort(arr, left, pivotIdx - 1);

            // 피벗 기준 오른쪽 정렬
            quickSort(arr, pivotIdx + 1, right);
            depth--;
        }
    }

    static int partition(int[] arr, int left, int right) {
        // 피벗을 맨 오른쪽 원소로 선택
        int pivot = arr[right];
        int i = left - 1; // 작은 값들의 마지막 인덱스

        for (int j = left; j < right; j++) {
            // 현재 원소가 피벗보다 작으면
            if (arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 피벗을 중간 위치로 이동
        i++;
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;

        return i; // 피벗의 최종 위치
    }

    static String arrayToString(int[] arr, int left, int right) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = left; i <= right; i++) {
            sb.append(arr[i]);
            if (i < right) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
