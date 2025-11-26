package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 연습 27: 병합 정렬 (Merge Sort) - O(n log n)
 * 개념: 분할 정복 (Divide and Conquer)
 *
 * 배열을 반으로 나눔 (Divide)
 * 각각을 정렬 (Conquer)
 * 합침 (Merge)
 *
 * 병합 정렬 핵심:
 * // 재귀적으로 분할
 * void mergeSort(int[] arr, int left, int right) {
 *     if (left < right) {
 *         int mid = (left + right) / 2;
 *         mergeSort(arr, left, mid);       // 왼쪽 정렬
 *         mergeSort(arr, mid + 1, right);  // 오른쪽 정렬
 *         merge(arr, left, mid, right);    // 병합
 *     }
 * }
 * ```
 *
 * **왜 O(n log n)인가?**
 * - 분할: log n 단계
 * - 각 단계마다 병합: n번 비교
 * - 총: n × log n
 */
public class SortingAlgorithm5 {

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

        // 병합 정렬
        sb.append("=== 병합 정렬 과정 ===\n\n");
        process = new StringBuilder();
        depth = 0;

        long start = System.nanoTime();
        mergeSoar(arr, 0, n - 1);
        long end = System.nanoTime();

        sb.append(process);

        sb.append("\n최종 결과: ").append(Arrays.toString(arr)).append("\n");
        sb.append("시간: ").append((end - start) / 1000).append(" μs\n\n");

        // 시간복잡도 정보
        sb.append("=== 병합 정렬 특징 ===\n");
        sb.append("시간복잡도: O(n log n)\n");
        sb.append("최선/평균/최악 모두: O(n log n) - 항상 일정!\n");
        sb.append("공간복잡도: O(n) - 추가 배열 필요\n");
        sb.append("안정 정렬: Yes\n");
        sb.append("특징: 큰 데이터에 효율적, 외부 정렬에 사용\n");

        System.out.println(sb);
    }

    static void mergeSoar(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // 들여쓰기
            String indent = " ".repeat(left);
            process.append(indent).append("분할: [").append(left).append("~").append(right).append("] ");
            process.append(arrayToString(arr, left, right)).append("\n");

            // 왼쪽 절반 정렬
            depth++;
            mergeSoar(arr, left, mid);

            // 오른쪽 절반 정렬
            mergeSoar(arr, mid + 1, right);
            depth--;

            // 병합
            merge(arr, left, mid, right);

            process.append(indent).append("병합: [").append(left).append("~").append(right).append("] ");
            process.append(arrayToString(arr, left, right)).append("\n");
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        // 임시 배열 생성
        int[] temp = new int[right - left + 1];

        int i = left;    // 왼쪽 부분 시작
        int j = mid + 1; // 오른쪽 부분 시작
        int k = 0;       // 임시 배열 인덱스

        // 두 부분을 비교하며 병합
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 왼쪽 부분 남은 것 복사
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // 오른쪽 부분 남은 것 복사
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // temp를 원본 배열에 복사
        for (int idx = 0; idx < temp.length; idx++) {
            arr[left + idx] = temp[idx];
        }
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
