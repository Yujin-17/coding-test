package algorithm.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 연습 30: 이진탐색 과정 상세 보기
 */
public class BinarySearch2 {
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

        Arrays.sort(arr);
        sb.append("정렬된 배열: ").append(Arrays.toString(arr)).append("\n\n");

        System.out.println("찾을 값 입력: ");
        int target = Integer.parseInt(br.readLine());

        sb.append("=== 이진탐색 과정 (목표: ").append(target).append(") ===\n\n");

        int left = 0;
        int right = n - 1;
        int step = 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;

            sb.append("Step ").append(step++).append(":\n");
            sb.append("  left=").append(left).append(", right=").append(right).append(", mid=").append(mid).append("\n");
            sb.append("  탐색 범위: [");

            for (int i = left; i <= right; i++) {
                if (i == mid) {
                    sb.append("(").append(i).append(")");
                } else {
                    sb.append(arr[i]);
                }
                if (i < right) sb.append(", ");
            }
            sb.append("]\n");

            sb.append(" arr[").append(mid).append("] = ").append(arr[mid]);

            if (arr[mid] == target) {
                sb.append(" -> 찾음! \n");
                found = true;
                break;
            } else if (arr[mid] < target) {
                sb.append(" < ").append(target).append(" -> 오른쪽 절반 탐색\n");
                left = mid + 1;
            } else {
                sb.append(" > ").append(target).append(" -> 왼쪽 절반 탐색\n");
                right = mid - 1;
            }

            sb.append("\n");
        }

        if (!found) {
            sb.append("결과: 찾을 수 없습니다.\n");
        } else {
            sb.append("\n결과: ").append(target).append("을(를) 인덱스 ");
            int finalIdx = Arrays.binarySearch(arr, target);
            sb.append(finalIdx).append("에서 찾았습니다\n");
        }

        sb.append("\n총 비교 횟수: ").append(step - 1).append("번\n");
        sb.append("순차탐색이었다면: 최대 ").append(n).append("번\n");

        System.out.println(sb);
    }
}
