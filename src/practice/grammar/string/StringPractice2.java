package practice.grammar.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringPractice2 {

    /**
     * **⚠️ 중요:**
     * - `==` 쓰지 마세요! 항상 `.equals()` 사용!
     * - `str.replace()` 는 원본 안 바뀜 (String은 불변!)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("문자열 입력 (공백 포함 가능): ");
        String str = br.readLine();

        // 1. split() - 문자열 분리
        sb.append("=== split() - 문자열 분리 ===\n");
        String[] words = str.split(" ");
        sb.append("공백으로 분리: ").append(Arrays.toString(words)).append("\n");
        sb.append("단어 개수: ").append(words.length).append("\n\n");

        // 2. replace() - 문자열 치환
        System.out.println("바꿀 문자열: ");
        String oldStr = br.readLine();
        System.out.println("새로운 문자열: ");
        String newStr = br.readLine();

        sb.append("=== replace() - 문자열 치환 ===\n");
        sb.append("원본: ").append(str).append("\n");
        sb.append("치환 후: ").append(str.replace(oldStr, newStr)).append("\n");
        sb.append("첫 번째만 치환: ").append(str.replaceFirst(oldStr, newStr)).append("\n\n");

        // 3. join() - 문자열 결합
        sb.append("=== String.join() - 문자열 결합 ===\n");
        String joined = String.join("-", words);
        sb.append("하이픈(-)으로 결합: ").append(joined).append("\n");

        String joined2 = String.join(" | ", words);
        sb.append("파이프(|)로 결합: ").append(joined2).append("\n\n");

        // 4. 문자 배열로 변환
        sb.append("=== toCharArray() - 문자 배열로 변환 ===\n");
        char[] chars = str.toCharArray();
        sb.append("문자 배열: ").append(Arrays.toString(chars)).append("\n");
        sb.append("역순: ");
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        sb.append("\n\n");

        // 5. 비교
        System.out.println("\n비교할 문자열 입력: ");
        String compare = br.readLine();

        sb.append("=== 문자열 비교 ===\n");
        sb.append("equals(): ").append(str.equals(compare)).append("\n");
        sb.append("equalsIgnoreCase(): ").append(str.equalsIgnoreCase(compare)).append("\n");
        sb.append("compareTo(): ").append(str.compareTo(compare)).append(" (0이면 같음)\n");

        System.out.println("\n" + sb);
    }
}
