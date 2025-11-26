package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 연습 26: 정렬 알고리즘 성능 비교
 */
public class SortingAlgorithm4 {

    static int bubbleSwaps = 0;
    static int selectionSwaps = 0;
    static int insertionShifts = 0;

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

        // 1. 버블 정렬
        int[] arr1 = arr.clone();
        long start1 = System.nanoTime();
        bubbleSort(arr1);
        long end1 = System.nanoTime();

        sb.append("=== 버블 정렬 ===\n");
        sb.append("결과: ").append(Arrays.toString(arr1)).append("\n");
        sb.append("시간: ").append((end1 - start1) / 1000).append(" μs\n");
        sb.append("교환: ").append(bubbleSwaps).append("회\n\n");

        // 2. 선택 정렬
        int[] arr2 = arr.clone();
        long start2 = System.nanoTime();
        selectionSort(arr2);
        long end2 = System.nanoTime();

        sb.append("=== 선택 정렬 ===\n");
        sb.append("결과: ").append(Arrays.toString(arr2)).append("\n");
        sb.append("시간: ").append((end2 - start2) / 1000).append(" μs\n");
        sb.append("교환: ").append(selectionSwaps).append("회\n\n");

        // 3. 삽입 정렬
        int[] arr3 = arr.clone();
        long start3 = System.nanoTime();
        insertionSort(arr3);
        long end3 = System.nanoTime();

        sb.append("=== 삽입 정렬 ===\n");
        sb.append("결과: ").append(Arrays.toString(arr3)).append("\n");
        sb.append("시간: ").append((end3 - start3) / 1000).append(" μs\n");
        sb.append("이동: ").append(insertionShifts).append("회\n\n");

        // 4. Arrays.sort() (내장 정렬)
        int[] arr4 = arr.clone();
        long start4 = System.nanoTime();
        Arrays.sort(arr4);
        long end4 = System.nanoTime();

        sb.append("=== Arrays.sort() (Dual-Pivot QuickSort) ===\n");
        sb.append("결과: ").append(Arrays.toString(arr4)).append("\n");
        sb.append("시간: ").append((end4 - start4) / 1000).append(" μs\n\n");

        // 성능 비교
        sb.append("=== 성능 순위 ===\n");
        long[] times = {end1 - start1, end2 - start2, end3 - start3, end4 - start4};
        String[] names = {"버블 정렬", "선택 정렬", "삽입 정렬", "Arrays.sort()"};

        for (int i = 0; i < 4; i++) {
            sb.append((i + 1)).append(". ").append(names[i]).append(": ");
            sb.append(times[i] / 1000).append(" μs\n");
        }

        System.out.println(sb);
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        bubbleSwaps = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    bubbleSwaps++;
                }
            }
        }
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;
        selectionSwaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
                selectionSwaps++;
            }
        }
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;
        insertionShifts = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                insertionShifts++;
                j--;
            }

            arr[j + 1] = key;
        }
    }
}
