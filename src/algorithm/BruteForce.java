package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 연습 19: 완전탐색 - 최댓값/최솟값 찾기
 *
 * 📚 알고리즘 Day 1: 완전탐색 (브루트포스)
 * 완전탐색 = 모든 경우를 다 확인해보기!
 * 코테에서 가장 기본이면서 중요한 알고리즘
 * 언제 쓰나요?
 *
 * 데이터 크기가 작을 때
 * 모든 경우의 수를 확인해야 할 때
 * 다른 최적화가 어려울 때
 *
 * // 모든 원소를 하나씩 확인!
 * for (int i = 0; i < n; i++) {
 *     // 조건 검사
 *     if (조건) {
 *         // 작업 수행
 *     }
 * }
 * ```
 */
public class BruteForce {

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

        sb.append("배열: ").append(Arrays.toString(arr)).append("\n\n");

        // 1. 최댓값 찾기
        int max = arr[0];
        int maxInx = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxInx = i;
            }
        }

        sb.append("=== 최댓값 찾기 ===\n");
        sb.append("최댓값: ").append(max).append("\n");
        sb.append("최댓값 인덱스: ").append(maxInx).append("\n\n");

        // 2. 최솟값 찾기
        int min = arr[0];
        int minInx = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minInx = i;
            }
        }

        sb.append("=== 최솟값 찾기 ===\n");
        sb.append("최솟값: ").append(min).append("\n");
        sb.append("최솟값 인덱스: ").append(minInx).append("\n\n");

        // 3. 두 번째로 큰 수 찾기
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }

        sb.append("=== 두 번째로 큰 수 찾기 ===\n");
        sb.append(second).append("\n\n");

        // 4. 특정 값 찾기
        System.out.println("\n찾을 값 입력: ");
        int target = Integer.parseInt(br.readLine());

        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                positions.add(i);
            }
        }

        sb.append("=== ").append(target).append(" 찾기 ===\n");
        if (positions.isEmpty()) {
            sb.append(target).append("는 배열에 없습니다.\n");
        } else {
            sb.append("위치: ").append(positions).append("\n");
            sb.append("개수: ").append(positions.size()).append("\n");
        }

        System.out.println(sb);
    }
}
