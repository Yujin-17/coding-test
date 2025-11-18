package practice.grammar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 📚 자료구조 - HashMap
 * HashMap = 키(Key)-값(Value) 쌍으로 저장
 * 코테에서 언제 쓰나요?
 *
 * 빈도수 세기 (가장 많이 씀!)
 * 빠른 검색 (O(1))
 * 중복 체크
 */
public class HashMapPractice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // HashMap 생성
        HashMap<String, Integer> map = new HashMap<>();

        System.out.println("학생 수 입력: ");
        int n = Integer.parseInt(br.readLine());

        // 이름 점수 입력
        System.out.println(n + "명의 이름과 점수 입력 (공백 구분): ");
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            map.put(name, score);
        }

        // 전체 출력
        sb.append("\n=== 전체 학생 ===\n");
        for (String key : map.keySet()) {
            sb.append(key).append(": ").append(map.get(key)).append("\n");
        }

        // 특정 학생 검색
        System.out.println("\n검색할 학생 이름: ");
        String searchName = br.readLine();

        if (map.containsKey(searchName)) {
            sb.append(searchName).append(": ").append(map.get(searchName)).append("\n");
        } else {
            sb.append(searchName).append(" 학생은 없습니다.\n");
        }

        // 자주 쓰는 메서드들
        sb.append("\n=== HashMap 정보 ===\n");
        sb.append("총 학생 수: ").append(map.size()).append("\n");
        sb.append("비어있나요? ").append(map.isEmpty()).append("\n");

        // 점수 수정
        System.out.println("\n수정할 학생 이름과 새로운 점수 입력 (공백 구분): ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        String updateName = st.nextToken();
        int newScore = Integer.parseInt(st.nextToken());

        if (map.containsKey(updateName)) {
            int oldSocre = map.get(updateName);
            map.put(updateName, newScore);
            sb.append(updateName).append("의 점수: ").append(oldSocre).append(" -> ").append(newScore).append("\n");
        }

        System.out.println(sb);
    }

}
