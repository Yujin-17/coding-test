package grammar.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 연습 15: 객체 정렬 (Student 클래스 만들어서)'
 *
 * 숫자 비교
 * (a, b) -> a.score - b.score  // 오름차순
 * (a, b) -> b.score - a.score  // 내림차순
 *
 * 문자열 비교
 * (a, b) -> a.name.compareTo(b.name)  // 사전순
 *
 * 다중 조건
 * if (조건1 다르면) return 조건1 정렬;
 * if (조건2 다르면) return 조건2 정렬;
 * return 조건3 정렬;
 * ```
 */
public class SortingPractice3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Student> students = new ArrayList<>();

        System.out.println("학생 수 입력: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println(n + "명의 이름, 점수, 나이 입력 (공백 구분):");
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            students.add(new Student(name, score, age));
        }

        sb.append("원본: ").append(students).append("\n\n");

        // 1. 점수 기준 오름차순
        ArrayList<Student> list1 = new ArrayList<>(students);
        Collections.sort(list1, (a, b) -> a.score - b.score);
        sb.append("=== 점수 오름차순 ===\n");
        sb.append(list1).append("\n\n");

        // 2. 점수 기준 내림차순
        ArrayList<Student> list2 = new ArrayList<>(students);
        Collections.sort(list2, (a, b) -> b.score - a.score);
        sb.append("=== 점수 내림차순 ===\n");
        sb.append(list2).append("\n\n");

        // 3. 이름 기준 사전순
        ArrayList<Student> list3 = new ArrayList<>(students);
        Collections.sort(list3, (a, b) -> a.name.compareTo(b.name));
        sb.append("=== 이름 사전순 ===\n");
        sb.append(list3).append("\n\n");

        // 4. 다음 조건 정렬: 점수 내림차순, 같으면 나이 오름차순
        ArrayList<Student> list4 = new ArrayList<>(students);
        Collections.sort(list4, (a, b) -> {
            if (b.score != a.score) {
                return b.score - a.score; // 점수 내림차순
            }
            return a.age - b.age; // 나이 오름차순
        });
        sb.append("=== 점수 내림차순, 같으면 나이 오름차순 ===\n");
        sb.append(list4).append("\n\n");

        // 5. 복잡한 다음 조건: 점수 내림차순 -> 나이 오름차순 -> 이름 사전순
        ArrayList<Student> list5 = new ArrayList<>(students);
        Collections.sort(list5, (a, b) -> {
            if (b.score != a.score) {
                return b.score - a.score ; // 점수 내림차순
            }
            if (a.age != b.age) {
                return a.age - b.age; // 나이 오름차순
            }
            return a.name.compareTo(b.name);
        });
        sb.append("=== 점수 내림차순 -> 나이 오름차순 -> 이름 사전순 ===\n");
        sb.append(list5).append("\n\n");

        System.out.println(sb);
    }
}
