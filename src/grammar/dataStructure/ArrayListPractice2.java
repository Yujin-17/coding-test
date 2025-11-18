package grammar.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 연습 2: ArrayList 추가/삭제/수정
 */
public class ArrayListPractice2 {

    /**
     * **⚠️ 중요 포인트:**
     * - `remove(int index)` - 인덱스로 삭제
     * - `remove(Integer.valueOf(value))` - 값으로 삭제
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> list = new ArrayList<>();

        // 초기 데이터
        System.out.println("초기 숫자들 입력 (공백 구분): ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        sb.append("초기 리스트: ").append(list).append("\n");

        // 1. 특정 위치에 추가
        System.out.println("\n추가할 인덱스와 값 입력 (예: 2 99): ");
        st = new StringTokenizer(br.readLine());
        int idx = Integer.parseInt(st.nextToken());
        int val = Integer.parseInt(st.nextToken());
        list.add(idx, val);
        sb.append(idx + "번 인덱스에 " + val + " 추가: ").append(list).append("\n");

        // 2. 특정 값 삭제 (첫 번째 발견된 것만)
        System.out.println("\n삭제할 값 입력: ");
        int removeVal = Integer.parseInt(br.readLine());
        list.remove(Integer.valueOf(removeVal)); // 주의: remove(int)는 인덱스 삭제!
        sb.append(removeVal + " 삭제: ").append(list).append("\n");

        // 3. 인덱스로 삭제
        System.out.println("\n삭제할 인덱스 입력: ");
        int removeIdx = Integer.parseInt(br.readLine());
        list.remove(removeIdx);
        sb.append(removeIdx + "번 인덱스 삭제: ").append(list).append("\n");

        // 4. 복합 인덱스 값 수정
        System.out.println("\n수정할 인덱스와 새 값 입력 (예: 1 77): ");
        st = new StringTokenizer(br.readLine());
        int setIdx = Integer.parseInt(st.nextToken());
        int newVal = Integer.parseInt(st.nextToken());
        list.set(setIdx, newVal);
        sb.append(setIdx + "번 인덱스를 " + newVal + "로 수정: ").append(list).append("\n");

        // 5. 전체 삭제
        System.out.println("\n전체 삭제 할까요? (y/n): ");
        String answer = br.readLine();
        if(answer.equals("y")) {
            list.clear();
            sb.append("전체 삭제: ").append(list).append("\n");
        }

        System.out.println("\n" + sb);
    }
}
