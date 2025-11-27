package algorithm.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 📚 알고리즘 Day 3: 이진탐색 (Binary Search)
 * 이진탐색 = 정렬된 배열에서 빠르게 찾기!
 * 핵심 아이디어:
 *
 * 중간 값과 비교
 * 찾는 값이 더 작으면 왼쪽 절반만 탐색
 * 찾는 값이 더 크면 오른쪽 절반만 탐색
 * O(log n) - 엄청 빠름!
 *
 * 연습 29: 이진탐색 기본
 * 이진탐색 핵심 코드:
 * int left = 0, right = n - 1;
 *
 * while (left <= right) {
 *     int mid = (left + right) / 2;
 *
 *     if (arr[mid] == target) return mid;      // 찾음!
 *     else if (arr[mid] < target) left = mid + 1;   // 오른쪽
 *     else right = mid - 1;                    // 왼쪽
 * }
 *
 * return -1;  // 못 찾음
 * ```
 */
public class BinarySearch {

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

        // 이진탐색은 정렬된 배열에서만 가능
        Arrays.sort(arr);
        sb.append("정렬된 배열: ").append(Arrays.toString(arr)).append("\n\n");

        System.out.println("찾을 값 입력: ");
        int target = Integer.parseInt(br.readLine());

        // 방법 1: 반복문으로 이진 탐색
        sb.append("=== 방법 1: 반복문 이진탐색 ===\n");
        int result1 = binarySearchIterative(arr, target);
        if (result1 != -1) {
            sb.append("찾음! 인덱스: ").append(result1).append(", 값: ").append(arr[result1]).append("\n");
        } else {
            sb.append("찾을 수 없습니다.\n");
        }
        sb.append("\n");

        // 방법 2: 재귀로 이진탐색
        sb.append("=== 방법 2: 재귀 이진탐색 ===\n");
        int result2 = binarySearchRecursive(arr, target, 0, n - 1);
        if (result2 != -1) {
            sb.append("찾음! 인덱스: ").append(result2).append(", 값: ").append(arr[result2]).append("\n");
        } else {
            sb.append("찾을 수 없습니다.\n");
        }
        sb.append("\n");

        // 방법 3: Arrays.binarySearch() 사용
        sb.append("=== 방법 3: Arrays.binarySearch() ===\n");
        int result3 = Arrays.binarySearch(arr, target);
        if (result3 >= 0) {
            sb.append("찾음! 인덱스: ").append(result3).append(", 값: ").append(arr[result3]).append("\n");
        } else {
            sb.append("찾을 수 없습니다.\n");
        }
        sb.append("\n");

        // 시간복잡도 정보
        sb.append("=== 이진탐색 vs 순차탐색 ===\n");
        sb.append("순차탐색: O(n) - 모든 원소 확인\n");
        sb.append("이진탐색: O(log n) - 절반씩 제거\n");
        sb.append("예시) n=1000일 때:\n");
        sb.append("  순차탐색: 최대 1000번 비교\n");
        sb.append("  이진탐색: 최대 10번 비교!\n");

        System.out.println(sb);
    }

    // 반복문 이진탐색
    static int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid; // 찾음
            } else if (arr[mid] < target) {
                left = mid + 1; // 오른쪽 절반 탐색
            } else {
                right = mid - 1; // 왼쪽 절반 탐색
            }
        }

        return -1; // 못 찾음
    }

    // 재귀 이진탐색
    static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // 못 찾음
        }

        int mid = (left + right) / 2;

        if (arr[mid] == target) {
            return mid; // 찾음
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right); // 오른쪽
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1); // 왼쪽
        }
    }
}
