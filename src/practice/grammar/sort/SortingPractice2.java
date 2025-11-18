package practice.grammar.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 연습 14: ArrayList 정렬 & Comparator
 *
 * **핵심 개념:**
 * - `Collections.sort(list)` - 오름차순
 * - `Collections.sort(list, Collections.reverseOrder())` - 내림차순
 * - `Collections.sort(list, (a, b) -> ...)` - 람다식으로 커스텀 정렬
 * - 반환값: 음수(a가 앞), 0(같음), 양수(b가 앞)
 */
public class SortingPractice2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList list = new ArrayList();

        System.out.println("숫자 개수 입력: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println(n + "개의 정수 입력 (공백 구분): ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        sb.append("원본 리스트: ").append(list).append("\n\n");

        // 1. 오름차순 정렬
        ArrayList<Integer> list1 = new ArrayList<>(list);
        Collections.sort(list1);
        sb.append("=== 오름차순 정렬 ===\n");
        sb.append(list1).append("\n\n");

        // 2. 내림차순 정렬
        ArrayList<Integer> list2 = new ArrayList<>(list);
        Collections.sort(list2, Collections.reverseOrder());
        sb.append("=== 내림차순 정렬 ===\n");
        sb.append(list2).append("\n\n");

        // 3. Comparator 사용 (람다식)
        ArrayList<Integer> list3 = new ArrayList<>(list);
        Collections.sort(list3, (a, b) -> b - a); // 내림차순
        sb.append("=== Comparator 람다식 (내림차순) ===\n");
        sb.append(list3).append("\n\n");

        // 4. 절댓값 기준 정렬
        ArrayList<Integer> list4 = new ArrayList<>(list);
        Collections.sort(list4, (a, b) -> Math.abs(a) - Math.abs(b));
        sb.append("=== 절댓값 기준 정렬 ===\n");
        sb.append(list4).append("\n\n");

        // 5. 홀수-짝수 구분 정렬 (홀수 먼저, 각각 오름차순)
        ArrayList<Integer> list5 = new ArrayList<>(list);
        Collections.sort(list5, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // 둘 다 홀수, 또는 둘 다 짝수
                if (a % 2 == b % 2) {
                    return a - b; // 오름차순
                }

                // a가 홀수면 앞으로
                if (a % 2 == 1) {
                    return -1;
                }

                // b가 홀수면 뒤로
                return 1;
            }
        });

        sb.append("=== 홀수-짝수 구분 정렬 (홀수 먼저, 각각 오름차순) ===\n");
        sb.append(list5).append("\n");

        System.out.println(sb);

    }
}
