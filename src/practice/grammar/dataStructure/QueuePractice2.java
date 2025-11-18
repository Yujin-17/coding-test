package practice.grammar.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 연습 9: Queue로 프린터 시뮬레이션
 *
 * Queue의 실전 활용 - 프린터 대기열!
 */
public class QueuePractice2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<String> printQueue = new LinkedList<>();

        System.out.println("=== 프린터 대기열 시뮬레이션 ===\n");
        System.out.println("출력할 문서 개수: ");
        int n = Integer.parseInt(br.readLine());

        // 문서 추가
        System.out.println(n + "개의 문서 이름 입력: ");
        for (int i = 0; i < n; i++) {
            String doc = br.readLine();
            printQueue.add(doc);
            sb.append("문서 추가: ").append(doc).append(" -> 대기열: ").append(printQueue).append("\n");
        }

        sb.append("\n=== 프린터 작동 시작 ===\n");
        int order = 1;

        // 모든 문서 출력
        while (!printQueue.isEmpty()) {
            String current = printQueue.poll();
            sb.append(order++).append("번째 출력: ").append(current);
            sb.append(" (남은 문서: ").append(printQueue.size()).append(")\n");

            // 출력 시간 시뮬레이션 (실제론 안 씀)
            try {
                Thread.sleep(500); // 0.5초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sb.append("\n 모든 문서 출력 완료 !\n");
            System.out.println(sb);
        }

    }
}
