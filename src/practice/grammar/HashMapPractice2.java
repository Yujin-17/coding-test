package practice.grammar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HashMapPractice2 {

    /**
     * 외우기!! 코테에서 자주 쓰임
     * map.put(key, map.getOrDefault(key, 0) + 1);
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 빈도수를 저장할 HashMap
        HashMap<String, Integer> frequency = new HashMap<>();

        System.out.println("단어 개수 입력: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println(n + "개의 단어 입력: ");
        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            //빈도수 세기 핵심 패턴!
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        // 전체 빈도수 출력
        sb.append("\n === 단어 빈도수 === \n");
        for (String key : frequency.keySet()) {
            sb.append(key).append(": ").append(frequency.get(key)).append("번\n");
        }

        // 가장 많이 나온 단어 찾기
        String maxWord = "";
        int maxCount = 0;

        for (String key : frequency.keySet()) {
            if (frequency.get(key) > maxCount) {
                maxCount = frequency.get(key);
                maxWord = key;
            }
        }

        sb.append("\n=== 최다 빈도 단어 ===\n");
        sb.append(maxWord).append(": ").append(maxCount).append("번\n");

        // Entry로 순회하기 (더 효율적)
        sb.append("\n=== Entry로 순회 ===\n");
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("번\n");
        }

        System.out.println(sb);
    }
}
