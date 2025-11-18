package practice.grammar.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ArrayListPractice3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 2차원 ArrayList 생성
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        System.out.println("노드 개수 입력: ");
        int n = Integer.parseInt(br.readLine());

        // 각 노드마다 ArrayList 생성 (초기화 중요!)
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        System.out.println("간선 개수 입력: ");
        int m = Integer.parseInt(br.readLine());

        System.out.println(m + "개의 간선 입력(from to 형식): ");
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            // 양방향이면: graph.get(to ).add(from);
        }

        // 그래프 출력
        sb.append("\n=== 인접 리스트 ===\n");
        for (int i = 0; i < n; i++) {
            sb.append(i).append("번 노드: ").append(graph.get(i)).append("\n");
        }

        // 특정 노드와 연결된 노드를 확인
        System.out.println("\n확인할 노드 번호: ");
        int node = Integer.parseInt(br.readLine());
        sb.append(node).append("번 노드와 연결된 노드들: ").append(graph.get(node)).append("\n");
        sb.append("연결된 노드 개수: ").append(graph.get(node).size()).append("\n");

        System.out.println(sb);
    }
}
