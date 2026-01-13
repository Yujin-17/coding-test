package algorithm.graph;

import java.io.*;
import java.util.*;

/**
 * 연습 41: DFS (Depth-First Search) - 깊이 우선 탐색
 * DFS = 한 방향으로 깊게 탐색!
 * 동작 방식:
 *
 * 시작 노드 방문
 * 인접한 노드 중 방문 안 한 노드로 이동
 * 더 갈 곳이 없으면 되돌아감 (백트래킹!)
 * 반복
 *
 * 구현 방법:
 *
 * 재귀 (추천!)
 * 스택
 *
 * DFS 핵심 코드:
 * void dfs(int node) {
 *     visited[node] = true;  // 방문 처리
 *
 *     // 현재 노드 처리 (출력 등)
 *     System.out.print(node + " ");
 *
 *     // 인접 노드 탐색
 *     for (int next : graph.get(node)) {
 *         if (!visited[next]) {
 *             dfs(next);  // 재귀!
 *         }
 *     }
 * }
 * ```
 *
 * **DFS 특징:**
 * - **스택** 또는 **재귀** 사용
 * - **깊이** 우선 탐색
 * - 시간복잡도: **O(V + E)**
 * - 백트래킹과 비슷!
 */
public class DFS {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static StringBuilder process = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.print("정점 개수 입력: ");
        int n = Integer.parseInt(br.readLine());

        System.out.print("간선 개수 입력: ");
        int m = Integer.parseInt(br.readLine());

        // 그래프 초기화 (인접 리스트)
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("\n" + m + "개의 간선 입력 (from to 형식):");
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        // 정렬 (작은 번호부터 방문하기 위해)
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        System.out.print("\n시작 노드 입력: ");
        int start = Integer.parseInt(br.readLine());

        // 그래프 출력
        sb.append("\n=== 그래프 (인접 리스트) ===\n");
        for (int i = 1; i <= n; i++) {
            sb.append(i).append(": ").append(graph.get(i)).append("\n");
        }
        sb.append("\n");

        // DFS 실행
        sb.append("=== DFS 탐색 (시작: ").append(start).append(") ===\n\n");

        visited = new boolean[n + 1];
        process = new StringBuilder();

        dfs(start, 0);

        sb.append(process);
        sb.append("\n=== DFS 방문 순서 ===\n");

        // 다시 DFS 실행해서 순서만 출력
        visited = new boolean[n + 1];
        ArrayList<Integer> order = new ArrayList<>();
        dfsOrder(start, order);

        sb.append(order).append("\n");

        System.out.println(sb);
    }

    /**
     * DFS 재귀 구현 (과정 출력)
     */
    static void dfs(int node, int depth) {
        String indent = "  ".repeat(depth);

        // 방문 처리
        visited[node] = true;
        process.append(indent).append("방문: ").append(node).append("\n");

        // 인접 노드 탐색
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                process.append(indent).append(node).append(" → ").append(next).append(" 이동\n");
                dfs(next, depth + 1);
                process.append(indent).append(next).append(" → ").append(node).append(" 돌아옴\n");
            } else {
                process.append(indent).append(next).append("는 이미 방문함 (스킵)\n");
            }
        }
    }

    /**
     * DFS 방문 순서만 기록
     */
    static void dfsOrder(int node, ArrayList<Integer> order) {
        visited[node] = true;
        order.add(node);

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfsOrder(next, order);
            }
        }
    }
}