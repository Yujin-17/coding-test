package grammar.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 연습 16: 람다식 기본
 *
 * 매개변수 1개
 * num -> num * 2
 *
 * 매개변수 2개
 * (a, b) -> a + b
 *
 * 여러 줄
 * (a, b) -> {
 *     int sum = a + b;
 *     return sum;
 * }
 */
public class LambdaPractice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("숫자 개수 입력: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println(n + "개의 정수 입력 (공백 구분): ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        sb.append("원본 리스트: ").append(list).append("\n\n");

        // 1. 기본 반복문 vs forEach
        sb.append("=== 기본 for문 ===\n");
        for (int num : list) {
            sb.append(num).append(" ");
        }
        sb.append("\n\n");

        sb.append("=== forEach 람다식 ===\n");
        list.forEach(num -> sb.append(num).append(" "));
        sb.append("\n\n");

        // 2. removeIf - 조건에 맞는 원소 삭제
        ArrayList<Integer> list2 = new ArrayList<>(list);
        list2.removeIf(num -> num % 2 == 0); // 짝수 제거
        sb.append(list2).append("\n\n");

        // 3. replaceAll - 모든 원소 변환
        ArrayList<Integer> list3 = new ArrayList<>(list);
        list3.replaceAll(num -> num * 2); // 모든 원소 2배
        sb.append("=== 모든 원소 2배 (replaceAll) ===\n");
        sb.append(list3).append("\n\n");

        // 4. sort 람다식 다양한 방법
        ArrayList<Integer> list4 = new ArrayList<>(list);

        // 방법 1: 기본
        list4.sort((a, b) -> a - b); // 오름차순
        sb.append("=== 오름차순 정렬 ===\n");
        sb.append(list4).append("\n\n");

        // 방법 2: Comparator 메서드
        list4.sort(Comparator.naturalOrder()); // 오름차순
        sb.append("=== Comparator.naturalOrder() ===\n");
        sb.append(list4).append("\n\n");

        list4.sort(Comparator.reverseOrder()); // 내림차순
        sb.append("=== Comparator.reverseOrder() ===\n");
        sb.append(list4).append("\n\n");

        System.out.println(sb);
    }
}
