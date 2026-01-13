package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 연습 39: 백트래킹 - N-Queen 문제
 * 문제: N×N 체스판에 N개의 퀸을 서로 공격할 수 없게 배치하기
 * 퀸의 이동:
 *
 * 가로, 세로, 대각선 모두 이동 가능
 * 서로 공격할 수 없으려면?
 *
 * 같은 행 X
 * 같은 열 X
 * 같은 대각선 X
 *
 * <p>
 *     N-Queen 백트래킹 핵심:
 *     void nQueen(int row) {
 *     // 모든 행 완료
 *     if (row == n) {
 *         count++;
 *         return;
 *     }
 *
 *     // 현재 행의 각 열에 시도
 *     for (int col = 0; col < n; col++) {
 *         if (isSafe(row, col)) {  // 가지치기!
 *             board[row] = col;
 *             nQueen(row + 1);
 *         }
 *     }
 *    }
 *
 *    가지치기 (Pruning):
 *    boolean isSafe(int row, int col) {
 *     for (int i = 0; i < row; i++) {
 *         // 같은 열
 *         if (board[i] == col) return false;
 *
 *         // 같은 대각선 (행차이 == 열차이)
 *         if (Math.abs(board[i] - col) == Math.abs(i - row))
 *             return false;
 *     }
 *     return true;
 * }
 * </p>
 */
public class Backtracking3_NQueen {

    static int n;
    static int [] board; // board[i] = i번째 행의 퀸이 놓인 열
    static int count = 0;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("N-Queen 문제의 N 입력 (8 이하 권장): ");
        n = Integer.parseInt(br.readLine());

        sb.append("\n=== ").append(n).append("-Queen 문제 ===\n\n");

        board = new int[n];
        count = 0;
        result = new StringBuilder();

        long start = System.nanoTime();
        nQueen(0);
        long end = System.nanoTime();

        if (n <= 6) {
            sb.append(result);
        } else {
            sb.append("(해가 너무 많아 처음 10개만 출력)\n\n");
            String[] lines = result.toString().split("\n\n");
            for (int i = 0; i < Math.min(10, lines.length); i++) {
                sb.append(lines[i]).append("\n\n");
            }
        }

        sb.append("총 해의 개수: ").append(count).append("개\n");
        sb.append("소요 시간: ").append((end - start) / 1000000).append(" ms\n\n");

        // N별 해의 개수 (참고)
        sb.append("=== N-Queen 해의 개수 ===\n");
        sb.append("N=1: 1개\n");
        sb.append("N=2: 0개\n");
        sb.append("N=3: 0개\n");
        sb.append("N=4: 2개\n");
        sb.append("N=5: 10개\n");
        sb.append("N=6: 4개\n");
        sb.append("N=7: 40개\n");
        sb.append("N=8: 92개\n");

        System.out.println(sb);
    }

    /**
     * N-Queen 백트래킹
     * @param row 현재 행
     */
    static void nQueen(int row) {
        // Base Case: 모든 행에 퀸을 배치했으면
        if (row == n) {
            count++;
            result.append("해 ").append(count).append(":\n");
            printBoard();
            result.append("\n");
            return;
        }

        // Recursive Case: 현재 행의 각 열에 퀸을 놓아보기
        for (int col = 0; col < n; col++) {
            // 해당 위치에 퀸을 놓을 수 있는지 검사
            if (isSafe(row, col)) {
                board[row] = col;  // 퀸 배치

                nQueen(row + 1);   // 다음 행으로

                // 백트래킹 (board[row] 값은 자동으로 덮어씌워짐)
            }
        }
    }

    /**
     * (row, col) 위치에 퀸을 놓을 수 있는지 검사
     */
    static boolean isSafe(int row, int col) {
        // 이전 행들의 퀸들과 충돌하는지 검사
        for (int i = 0; i < row; i++) {
            // 같은 열에 있는지
            if (board[i] == col) {
                return false;
            }

            // 같은 대각선에 있는지
            // 행의 차이와 열의 차이가 같으면 대각선
            if (Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 체스판 출력
     */
    static void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j) {
                    result.append("Q ");
                } else {
                    result.append(". ");
                }
            }
            result.append("\n");
        }
    }
}
