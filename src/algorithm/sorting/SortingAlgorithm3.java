package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 연습 25: 삽입 정렬 (Insertion Sort)
 * 개념: 카드 정렬하듯이, 하나씩 꺼내서 적절한 위치에 삽입
 *
 * 삽입 정렬 핵심 코드:
 * for (int i = 1; i < n; i++) {
 *     int key = arr[i];  // 삽입할 값
 *     int j = i - 1;
 *
 *     // key보다 큰 값들을 오른쪽으로 이동
 *     while (j >= 0 && arr[j] > key) {
 *         arr[j + 1] = arr[j];
 *         j--;
 *     }
 *
 *     // key를 적절한 위치에 삽입
 *     arr[j + 1] = key;
 * }
 * ```
 *
 * **동작 원리:**
 * 1. 첫 번째 원소는 정렬된 것으로 간주
 * 2. 두 번째 원소를 적절한 위치에 삽입
 * 3. 세 번째 원소를 적절한 위치에 삽입
 * 4. 반복...
 *
 * **언제 유용한가?**
 * - 거의 정렬된 데이터 → 매우 빠름!
 * - 온라인 정렬 (데이터가 들어오는 대로 정렬)
 */
public class SortingAlgorithm3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("배열 크기 입력: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println(n + "개의 정수 입력 (공백 구분): ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb.append("원본: ").append(Arrays.toString(arr)).append("\n\n");

        // 삽입 정렬
        sb.append("=== 삽입 정렬 과정 ===\n");
        int[] insertionArr = arr.clone();
        int shiftCount = 0;
        int compareCount = 0;

        for (int i = 1; i < n; i++) {
            int key = insertionArr[i]; // 현재 삽입할 값
            sb.append((i)).append("번째 패스: key = ").append(key).append("\n");

            int j = i - 1;

            // key보다 큰 값들을 오른쪽으로 이동
            while (j >= 0 && insertionArr[j] > key) {
                compareCount++;
                insertionArr[j + 1] = insertionArr[j];
                shiftCount++;
                sb.append("  ").append(insertionArr[j]).append("을(를) 오른쪽으로 이동\n");
                j--;
            }

            if (j >= 0) {
                compareCount++;
            }

            // key를 적절한 위치에 삽입
            insertionArr[j + 1] = key;
            sb.append("  → ").append(key).append("을(를) ").append(j + 1).append("번 위치에 삽입\n");
            sb.append("  현재: ").append(Arrays.toString(insertionArr)).append("\n\n");
        }
        sb.append("최종 결과: ").append(Arrays.toString(insertionArr)).append("\n");
        sb.append("총 비교 횟수: ").append(compareCount).append("\n");
        sb.append("총 이동 횟수: ").append(shiftCount).append("\n\n");

        // 시간복잡도 정보
        sb.append("=== 삽입 정렬 특징 ===\n");
        sb.append("시간복잡도: O(n²)\n");
        sb.append("최선: O(n) - 이미 정렬된 경우 (가장 빠름!)\n");
        sb.append("최악: O(n²) - 역순 정렬된 경우\n");
        sb.append("공간복잡도: O(1)\n");
        sb.append("안정 정렬: Yes - 같은 값의 순서 유지\n");
        sb.append("특징: 거의 정렬된 데이터에 매우 효율적!\n");

        System.out.println(sb);
    }

}
