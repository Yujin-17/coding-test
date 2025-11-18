package practice.grammar.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 연습 10: String 필수 메서드
 */
public class StringPractice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("문자열 입력: ");
        String str = br.readLine();

        sb.append("=== 기본 정보 ===\n");
        sb.append("원본: ").append(str).append("\n");
        sb.append("길이: ").append(str.length()).append("\n");
        sb.append("비어있나요?: ").append(str.isEmpty()).append("\n\n");

        sb.append("=== 대소문자 변환 ===\n");
        sb.append("대문자: ").append(str.toUpperCase()).append("\n");
        sb.append("소문자: ").append(str.toLowerCase()).append("\n\n");

        sb.append("=== 공백 제거 ===\n");
        sb.append("앞뒤 공백 제거: [").append(str.trim()).append("]\n\n");

        // 특정 문자 접근
        sb.append("=== 문자 접근 ===\n");
        if (str.length() >= 0) {
            sb.append("첫 번째 문자: ").append(str.charAt(0)).append("\n");
            sb.append("마지막 문자: ").append(str.charAt(str.length() - 1)).append("\n");
        }

        // 부분 문자열
        System.out.println("\n부분 문자열 추출 (시작 인덱스): ");
        int start = Integer.parseInt(br.readLine());
        System.out.println("부분 문자열 추출 (끝 인덱스): ");
        int end = Integer.parseInt(br.readLine());

        sb.append("\n=== 부분 문자열 ===\n");
        sb.append("subtring(").append(start).append(", ").append(end).append("):\n");
        sb.append(str.substring(start, end)).append("\n\n");

        // 문자 포함 여부
        System.out.println("\n포함 여부 확인할 문자열: ");
        String search = br.readLine();

        sb.append("=== 검색 ===\n");
        sb.append("contains(\"").append(search).append("\"): ").append(str.contains(search)).append("\n");
        sb.append("startsWith(\"").append(search).append("\"): ").append(str.startsWith(search)).append("\n");
        sb.append("endsWith(\"").append(search).append("\"): ").append(str.endsWith(search)).append("\n");

        if (str.contains(search)) {
            sb.append("indexOf(\"").append(search).append("\"): ").append(str.indexOf(search)).append("\n");
            sb.append("lastIndexOf(\"").append(search).append("\"): ").append(str.lastIndexOf(search)).append("\n");
        }

        System.out.println("\n" + sb);
    }
}
