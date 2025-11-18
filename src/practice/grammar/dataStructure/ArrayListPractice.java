package practice.grammar.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * ArrayList가 배열보다 좋은 이유?
 * * 크기 자동 조절
 * * 추가/삭제 쉬움
 * * 정렬, 탐색 메서드 많음
 */
public class ArrayListPractice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ArrayList 생성
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("추가할 숫자 갯수: ");
        int n = Integer.parseInt(br.readLine());

        // 입력받아서 추가
        System.out.println(n + "개의 숫자 입력 (공백 구분): ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        // 출력
        System.out.println("입력한 리스트: " + list);

        // 자주 쓰는 메서드
        System.out.println("리스트 크기: " + list.size());
        System.out.println("2번째 요소: " + list.get(1));
        System.out.println("마지막 원소: " + list.get(list.size() - 1));
        System.out.println("5가 있나요? " + list.contains(5));

        // 정렬
        Collections.sort(list);
        System.out.println("오름차순 정렬: " + list);

        Collections.reverse(list);
        System.out.println("내림차순 정렬: " + list);
    }
}
