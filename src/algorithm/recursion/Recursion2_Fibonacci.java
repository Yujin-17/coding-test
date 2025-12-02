package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 연습 35: 재귀 - 피보나치 수열
 *
 * **피보나치 재귀의 문제점:**
 * ```
 * fibonacci(5) 계산 시:
 *           fib(5)
 *         /        \
 *     fib(4)      fib(3)
 *     /    \      /    \
 * fib(3) fib(2) fib(2) fib(1)
 * ...
 *
 * → fib(3), fib(2) 등이 중복 계산됨!
 * → O(2^n) 시간복잡도
 *
 * 메모이제이션으로 해결:
 * if (memo[n] != 0) return memo[n];  // 이미 계산했으면 재사용
 * memo[n] = fib(n-1) + fib(n-2);     // 계산 후 저장
 * ```
 */
public class Recursion2_Fibonacci {

    static int callCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("피보나치 수열 n번째 항 (20 이하 권장): ");
        int n = Integer.parseInt(br.readLine());

        // 방법 1: 단순 재귀 (느림!)
        sb.append("\n=== 방법 1: 단순 재귀 ===\n");
        callCount = 0;
        long start1 = System.nanoTime();
        int result1 = fibonacci(n);
        long end1 = System.nanoTime();

        sb.append("fibonacci(").append(n).append(") = ").append(result1).append("\n");
        sb.append("함수 호출 횟수: ").append(callCount).append("번\n");
        sb.append("시간: ").append((end1 - start1) / 1000).append(" μs\n\n");

        // 방법 2: 메모이제이션 (빠름!)
        sb.append("=== 방법 2: 메모이제이션 (DP) ===\n");
        callCount = 0;
        memo = new int[n + 1];
        long start2 = System.nanoTime();
        int result2 = fibonacciMemo(n);
        long end2 = System.nanoTime();

        sb.append("fibonacci(").append(n).append(") = ").append(result2).append("\n");
        sb.append("함수 호출 횟수: ").append(callCount).append("번\n");
        sb.append("시간: ").append((end2 - start2) / 1000).append(" μs\n\n");

        // 방법 3: 반복문 (가장 빠름!)
        sb.append("=== 방법 3: 반복문 ===\n");
        long start3 = System.nanoTime();
        int result3 = fibonacciLoop(n);
        long end3 = System.nanoTime();

        sb.append("fibonacci(").append(n).append(") = ").append(result3).append("\n");
        sb.append("시간: ").append((end3 - start3) / 1000).append(" μs\n\n");

        // 피보나치 수열 출력
        sb.append("=== 피보나치 수열 ===\n");
        sb.append("F(0)~F(").append(n).append("): ");
        for (int i = 0; i <= n; i++) {
            sb.append(fibonacciLoop(i));
            if (i < n) sb.append(", ");
        }
        sb.append("\n\n");

        // 성능 비교
        sb.append("=== 성능 비교 ===\n");
        sb.append("단순 재귀: ").append((end1 - start1) / 1000).append(" μs (").append(callCount).append("번 호출)\n");
        sb.append("메모이제이션: ").append((end2 - start2) / 1000).append(" μs\n");
        sb.append("반복문: ").append((end3 - start3) / 1000).append(" μs\n");

        System.out.println(sb);
    }

    // 방법 1: 단순 재귀 - 0(2^n) 느림!
    static int fibonacci(int n) {
        callCount++;

        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 방법 2: 메모이제이션 - O(n) 빠름!
    static int[] memo;

    static int fibonacciMemo(int n) {
        callCount++;

        if (n <= 1) {
            return n;
        }

        // 이미 계산했으면 재사용
        if (memo[n] != 0) {
            return memo[n];
        }

        // 계산 후 저장
        memo[n] = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
        return memo[n];
    }

    // 방법 3: 반복문 - O(n) 가장 빠름!
    static int fibonacciLoop(int n) {
        if (n <= 1) return n;

        int prev2 = 0;
        int prev1 = 1;
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }
}
