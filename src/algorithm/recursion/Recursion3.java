package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 연습 36: 재귀 - 하노이 탑
 * 문제: n개의 원판을 A → C로 옮기기 (B를 보조로 사용)
 * 규칙:
 *
 * 한 번에 한 개씩만 이동
 * 작은 원판 위에만 놓을 수 있음
 *
 * 하노이 탑 재귀 구조:
 * void hanoi(int n, char from, char to, char aux) {
 *     if (n == 1) {
 *         // 원판 1개만 옮기기
 *         move(from → to);
 *         return;
 *     }
 *
 *     hanoi(n-1, from, aux, to);     // 1. n-1개를 보조 기둥으로
 *     move(from → to);                // 2. 가장 큰 원판 이동
 *     hanoi(n-1, aux, to, from);      // 3. n-1개를 목적지로
 * }
 * ```
 */
public class Recursion3 {

    static StringBuilder moves = new StringBuilder();
    static int moveCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("원판 개수 입력 (10 이하 권장): ");
        int n = Integer.parseInt(br.readLine());

        sb.append("\n=== 하노이 탑 (").append(n).append("개 원판) ===\n\n");

        moves = new StringBuilder();
        moveCount = 0;

        hanoi(n, 'A', 'C', 'B');

        sb.append(moves);
        sb.append("\n총 이동 횟수: ").append(moveCount).append("번\n\n");

        // 이론적 이동 횟수
        int theoretical = (int)Math.pow(2, n) - 1;
        sb.append("이론적 최소 횟수: 2^").append(n).append(" - 1 = ").append(theoretical).append("번\n\n");

        // 하노이 탑 규칙 설명
        sb.append("=== 하노이 탑 원리 ===\n");
        sb.append("n개의 원판을 A → C로 옮기려면:\n");
        sb.append("1. n-1개를 A → B로 옮김 (C를 보조로)\n");
        sb.append("2. 가장 큰 원판을 A → C로 옮김\n");
        sb.append("3. n-1개를 B → C로 옮김 (A를 보조로)\n\n");

        sb.append("재귀 관계식: T(n) = 2×T(n-1) + 1\n");
        sb.append("시간복잡도: O(2^n)\n");

        System.out.println(sb);
    }

    /**
     * n개의 원판을 from에서 to로 옮기는 재귀 함수 (aux를 보조로 사용)
     */
    static void hanoi(int n, char from, char to, char aux) {
        // Base case
        if (n == 1) {
            moveCount++;
            moves.append(moveCount).append(". 원판 1을 ")
                    .append(from).append(" -> ").append(to).append("\n");
            return;
        }

        // Recursive case
        // 1. n-1개를 from -> aux로 (to를 보조로)
        hanoi(n - 1, from, aux, to);

        // 2. 가장 큰 원판을 from -> to로
        moveCount++;
        moves.append(moveCount).append(". 원판 ").append(n).append("을(를) ")
                .append(from).append(" → ").append(to).append("\n");

        // 3. n-1개를 aux → to로 (from을 보조로)
        hanoi(n - 1, aux, to, from);
    }

}
