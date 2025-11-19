package grammar;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class CodeTestTemplate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        // HashMap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("key", map.getOrDefault("key", 0) + 1);

        // 정렬
        Collections.sort(list);  // 오름차순
        Collections.sort(list, Collections.reverseOrder());  // 내림차순
        list.sort((a, b) -> a - b);  // 람다식

        // Stream
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        long count = list.stream().filter(x -> x > 0).count();

        // 출력
        System.out.println(sb);
    }
}