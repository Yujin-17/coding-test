package practice.grammar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 연습 13: 배열 정렬 (Arrays.sort)
 *
 * **⚠️ 주의:**
 * - `int[]` 내림차순 불가 → `Integer[]` 변환 필요!
 * - `Arrays.binarySearch()` 는 **정렬된 배열**에서만 사용!
 */
public class SortingPractice {
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

        sb.append("원본 배열: ").append(Arrays.toString(arr)).append("\n\n");

        // 1. 오름차순 정렬;
        int[] arr1 = arr.clone();
        Arrays.sort(arr1);
        sb.append("=== 오름차순 정렬 ===\n");
        sb.append(Arrays.toString(arr1)).append("\n\n");

        // 2. 내림차순 정렬 (Integer[] 필요)
        Integer[] arr2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = arr[i];
        }
        Arrays.sort(arr2, Collections.reverseOrder());
        sb.append("=== 내림차순 정렬 ===\n");
        sb.append(Arrays.toString(arr2)).append("\n\n");

        // 3. 부분 정렬
        int[] arr3 = arr.clone();
        System.out.println("\n부분 정렬 시작 인덱스: ");
        int start = Integer.parseInt(br.readLine());
        System.out.println("부분 정렬 끝 인덱스: ");
        int end = Integer.parseInt(br.readLine());

        Arrays.sort(arr3, start, end);
        sb.append("=== 부분 정렬 (" + start + " to " + end + ") ===\n");
        sb.append(Arrays.toString(arr3)).append("\n\n");

        // 4. 이진 탐색 (정렬된 배열에서만)
        System.out.println("\n탐색할 숫자 입력: ");
        int target = Integer.parseInt(br.readLine());

        int index = Arrays.binarySearch(arr1, target);
        sb.append("=== 이진 탐색 ===\n");
        if (index >= 0) {
            sb.append(target).append("은(는) ").append(index).append("번 인덱스에 있습니다.\n");
        } else {
            sb.append(target).append("은(는) 배열에 없습니다.\n");
        }

        System.out.println("\n" + sb);
    }
}
