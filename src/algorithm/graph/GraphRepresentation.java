package algorithm.graph;

import java.io.*;
import java.util.*;

/**
 * 연습 40: 그래프 표현 방법
 * 그래프 표현 2가지:
 *
 * 인접 행렬 (Adjacency Matrix) - 2차원 배열
 * 인접 리스트 (Adjacency List) - ArrayList
 */
public class GraphRepresentation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.print("정점(노드) 개수 입력: ");
        int n = Integer.parseInt(br.readLine());

        System.out.print("간선 개수 입력: ");
        int m = Integer.parseInt(br.readLine());

        // 1. 인접 행렬 방식
        int[][] adjMatrix = new int[n + 1][n + 1];

        // 2. 인접 리스트 방식
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.println("\n" + m + "개의 간선 입력 (from to 형식):");
        System.out.println("예: 1 2 (1번 노드와 2번 노드 연결)");

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 인접 행렬에 추가 (무방향 그래프)
            adjMatrix[from][to] = 1;
            adjMatrix[to][from] = 1;

            // 인접 리스트에 추가
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        // 인접 행렬 출력
        sb.append("\n=== 인접 행렬 (Adjacency Matrix) ===\n");
        sb.append("   ");
        for (int i = 1; i <= n; i++) {
            sb.append(i).append(" ");
        }
        sb.append("\n");

        for (int i = 1; i <= n; i++) {
            sb.append(i).append(": ");
            for (int j = 1; j <= n; j++) {
                sb.append(adjMatrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append("\n");

        // 인접 리스트 출력
        sb.append("=== 인접 리스트 (Adjacency List) ===\n");
        for (int i = 1; i <= n; i++) {
            sb.append(i).append(": ");
            Collections.sort(adjList.get(i));  // 정렬
            sb.append(adjList.get(i)).append("\n");
        }
        sb.append("\n");

        // 비교
        sb.append("=== 인접 행렬 vs 인접 리스트 ===\n\n");

        sb.append("[인접 행렬]\n");
        sb.append("장점: 두 노드 연결 여부 O(1)로 확인\n");
        sb.append("단점: 공간복잡도 O(V²), 모든 간선 확인 O(V²)\n");
        sb.append("사용: 간선이 많은 밀집 그래프\n\n");

        sb.append("[인접 리스트]\n");
        sb.append("장점: 공간복잡도 O(V+E), 연결된 노드만 확인\n");
        sb.append("단점: 두 노드 연결 여부 확인 O(V)\n");
        sb.append("사용: 간선이 적은 희소 그래프 (코테에서 주로 사용!)\n");

        System.out.println(sb);
    }
}
