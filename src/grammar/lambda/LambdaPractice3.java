package grammar.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 연습 18: Stream 집계 연산 (sum, max, min, count)
 *
 * // 합계
 * list.stream().mapToInt(Integer::intValue).sum();
 *
 * // 최댓값
 * list.stream().mapToInt(Integer::intValue).max().orElse(0);
 *
 * // 개수
 * list.stream().filter(조건).count();
 *
 * // 곱셈
 * list.stream().reduce(1, (a, b) -> a * b);
 * ```
 */
public class LambdaPractice3 {

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

        // 1. sum - 합계
        int sum = list.stream()
                .mapToInt(Integer::intValue)
                .sum();
        sb.append("=== 합계 ===\n");
        sb.append(sum).append("\n\n");

        // 2. count - 개수
        long count = list.stream()
                .count();
        sb.append("=== 개수 ===\n");
        sb.append(count).append("\n\n");

        // 3. average - 평균
        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        sb.append("=== 평균 ===\n");
        sb.append(String.format("%.2f", avg)).append("\n\n");

        // 4. max - 최대값
        int max = list.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        sb.append("=== 최대값 ===\n");
        sb.append(max).append("\n\n");

        // 5. min - 최소값
        int min = list.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0);
        sb.append("=== 최소값 ===\n");
        sb.append(min).append("\n\n");

        // 6. 조건부 집계 - 짝수의 합
        int evenSum = list.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        sb.append("=== 짝수의 합 ===\n");
        sb.append(evenSum).append("\n\n");

        // 7. 조건부 집계 - 10보다 큰 수의 개수
        long countOver10 = list.stream()
                .filter(num -> num > 10)
                .count();
        sb.append("=== 10보다 큰 수의 개수 ===\n");
        sb.append(countOver10).append("\n\n");

        // 8. anyMatch, allMatch, noneMatch
        boolean hasEven = list.stream().anyMatch(num -> num % 2 == 0);
        boolean allPositive = list.stream().allMatch(num -> num > 0);
        boolean noNegative = list.stream().noneMatch(num -> num < 0);

        sb.append("=== 조건 검사 ===\n");
        sb.append("짝수 존재: ").append(hasEven).append("\n");
        sb.append("모두 양수: ").append(allPositive).append("\n");
        sb.append("음수 없음: ").append(noNegative).append("\n\n");

        // 9. reduce - 직접 연산 정의
        int product = list.stream()
                .reduce(1, (a, b) -> a * b); // 모든 수의 곱
        sb.append("=== 모든 수의 곱 ===\n");
        sb.append(product).append("\n\n");

        // 10. 통계 한번에 - summaryStatistics
        IntSummaryStatistics stats = list.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        sb.append("=== 통계 요약 ===\n");
        sb.append("합계: ").append(stats.getSum()).append("\n");
        sb.append("개수: ").append(stats.getCount()).append("\n");
        sb.append("평균: ").append(String.format("%.2f", stats.getAverage())).append("\n");
        sb.append("최대값: ").append(stats.getMax()).append("\n");
        sb.append("최소값: ").append(stats.getMin()).append("\n\n");

        System.out.println(sb);
    }
}
