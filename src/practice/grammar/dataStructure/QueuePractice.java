package practice.grammar.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 연습 8: Queue 기본
 *
 * 📚 자료구조 - Queue
 * Queue = 줄서기 (FIFO: First In First Out)
 * 먼저 들어간 게 먼저 나와요!
 * 코테에서 언제 쓰나요?
 *
 * BFS (너비 우선 탐색) ← 진짜 많이 씀!
 * 시뮬레이션 (대기열)
 * 레벨 순회
 */
public class QueuePractice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Queue는 인터페이스! LinkedList로 구현
        Queue<Integer> queue = new LinkedList<>();

        System.out.println("명령 개수 입력: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println("\n명령어: ");
        System.out.println("add [숫자] - 큐에 추가");
        System.out.println("poll - 큐에서 제거 및 출력");
        System.out.println("peek - 큐의 앞 요소 출력(맨 앞 확인");
        System.out.println("size - 큐의 크기 출력");
        System.out.println("isEmpty - 큐가 비어있는지 확인(true/false)");
        System.out.println();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            String command = st.nextToken();

            if (command.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
                sb.append("add ").append(num).append(" -> 큐: ").append(queue).append("\n");
            } else if (command.equals("poll")) {
                if (queue.isEmpty()) {
                    sb.append("poll -> 큐가 비어있습니다!\n");
                } else {
                    int polled = queue.poll();
                    sb.append("poll -> ").append(polled).append(" 제거, 큐: ").append(queue).append("\n");
                }
            } else if (command.equals("peek")) {
                if (queue.isEmpty()) {
                    sb.append("peek -> 큐가 비어있습니다!\n");
                } else {
                    sb.append("peek -> 맨 앞: ").append(queue.peek()).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append("size -> ").append(queue.size()).append("\n");
            } else if (command.equals("isEmpty")) {
                sb.append("isEmpty -> ").append(queue.isEmpty()).append("\n");
            }
        }

        System.out.println(sb);
    }

}
