package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 📚 알고리즘 Day 4: 재귀 (Recursion)
 * 재귀 = 함수가 자기 자신을 호출하는 것!
 * 핵심 요소:
 *
 * Base Case (종료 조건) - 재귀를 멈추는 조건
 * Recursive Case (재귀 호출) - 자기 자신을 호출
 *
 *
 * 연습 34: 재귀 기초 - 팩토리얼
 *
 * 재귀 함수 기본 구조:
 * int function(int n) {
 *     // Base Case (필수!)
 *     if (종료_조건) {
 *         return 값;
 *     }
 *
 *     // Recursive Case
 *     return function(n - 1);  // 자기 자신 호출
 * }
 * ```
 *
 * **팩토리얼 예시:**
 * ```
 * 5! = 5 × 4!
 *    = 5 × (4 × 3!)
 *    = 5 × (4 × (3 × 2!))
 *    = 5 × (4 × (3 × (2 × 1!)))
 *    = 5 × (4 × (3 × (2 × 1)))
 *    = 120
 * ```
 */
public class Recursion {

    static StringBuilder process = new StringBuilder();
    static int depth = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("팩토리얼 계산할 숫자 입력 (10 이하): ");
        int n = Integer.parseInt(br.readLine());

        sb.append("\n=== 팩토리얼 재귀 (").append(n).append("!) ===\n\n");

        // 재귀 과정 추적
        process = new StringBuilder();
        depth = 0;

        long result = factorial(n);

        sb.append(process);
        sb.append("\n결과: ").append(n).append("! = ").append(result).append("\n\n");

        // 반복문과 비교
        sb.append("=== 반복문 방식 ===\n");
        long iterResult = 1;
        for (int i = 1; i <= n; i++) {
            iterResult *= i;
            sb.append(i);
            if (i < n) sb.append(" × ");
        }
        sb.append(" = ").append(iterResult).append("\n");

        System.out.println(sb);

    }

    static long factorial(int n) {
        String indent = " ".repeat(depth);

        // Base Case: 종료 조건
        if (n <= 1) {
            process.append(indent).append("factorial(").append(n).append(") = 1 (Base Case)\n");
            return 1;
        }

        // Recursive Case: 재귀 호출
        process.append(indent).append("factorial(").append(n).append(") 호출\n");
        depth++;

        long result = n * factorial(n - 1);

        depth--;
        process.append(indent).append("factorial(").append(n).append(") = ").append(n).append(" × factorial(").append(n - 1).append(") = ").append(result).append("\n");

        return result;
    }
}
