package grammar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 연습 17: Stream API
 *
 * list.stream()           // 1. 스트림 생성
 *     .filter(...)        // 2. 중간 연산 (필터링, 변환, 정렬 등)
 *     .map(...)           // 2. 중간 연산
 *     .sorted()           // 2. 중간 연산
 *     .collect(...);      // 3. 최종 연산 (리스트로 변환)
 * ```
 */
public class LambdaPractice2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("숫자 개수 입력: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println(n + "개의 정수 입력 (공백 구분): ");
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        sb.append("원본 리스트: ").append(list).append("\n\n");

        // 1. filter - 조건에 맞는 것만 필터링
        List<Integer> evens = list.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        sb.append("=== 짝수 필터링 ===\n");
        sb.append(evens).append("\n\n");

        // 2. map - 모든 원소 변환
        List<Integer> doubled = list.stream()
                .map(num -> num * 2)
                .collect(Collectors.toList());
        sb.append("=== 모든 원소 2배 ===\n");
        sb.append(doubled).append("\n\n");

        // 3. sorted - 정렬
        List<Integer> sorted = list.stream()
                .sorted()
                .collect(Collectors.toList());
        sb.append("=== 오름차순 정렬 ===\n");
        sb.append(sorted).append("\n\n");

        List<Integer> reverseSorted = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        sb.append("=== 내림차순 정렬 ===\n");
        sb.append(reverseSorted).append("\n\n");

        // 4. distinct - 중복 제거
        List<Integer> unique = list.stream()
                .distinct()
                .collect(Collectors.toList());
        sb.append("=== 중복 제거 ===\n");
        sb.append(unique).append("\n\n");

        // 5. limit, skip
        List<Integer> first3 = list.stream()
                .limit(3)
                .collect(Collectors.toList());
        sb.append("=== 앞에서 3개 ===\n");
        sb.append(first3).append("\n\n");

        List<Integer> skip2 = list.stream()
                .skip(2)
                .collect(Collectors.toList());
        sb.append("=== 앞에서 2개 제외 ===\n");
        sb.append(skip2).append("\n\n");

        // 6. 체이닝 - 여러 연산 연결
        List<Integer> result = list.stream()
                .filter(num -> num > 3) // 3보다 큰 것만
                .map(num -> num * 2)    // 2배
                .sorted()               // 오름차순
                .distinct()             // 중복제거
                .collect(Collectors.toList());
        sb.append("=== 체이닝 결과 (3보다 큰 것 2배 오름차순 중복제거) ===\n");
        sb.append(result).append("\n\n");

        System.out.println(sb);
    }
}
