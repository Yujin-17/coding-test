package grammar.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 연습 12: String vs StringBuilder (성능 차이!)
 * 핵심:
 *
 * String: 불변 (immutable) → 변경할 때마다 새 객체 생성
 * StringBuilder: 가변 (mutable) → 기존 객체 수정
 */
public class StringPractice3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("반복 횟수 입력 (10000 추천): ");
        int n = Integer.parseInt(br.readLine());

        // 1. String 으로 연결 (느림)
        System.out.println("\n=== String 사용 (느림) ===");
        long start1 = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < n; i++) {
            str += i; // 매번 새로운 String 객체 생성
        }
        long end1 = System.currentTimeMillis();
        System.out.println("걸린 시간: " + (end1 - start1) + "ms");

        // 2. StringBuilder 로 사용 (빠름)
        System.out.println("\n=== StringBuilder 사용 (빠름) ===");
        long start2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i); // 기존 객체에 추가
        }
        String result = sb.toString();
        long end2 = System.currentTimeMillis();
        System.out.println("걸린 시간: " + (end2 - start2) + "ms");

        System.out.println("\n속도 차이: 약 " + ((end1 - start1) / (end2 - start2 + 1)) + "배");

        // StringBuilder 의 주요 메서드
        System.out.println("\n=== StringBuilder 주요 메서드 ===");
        StringBuilder demo = new StringBuilder("Hello");

        System.out.println("원본: " + demo);

        demo.append(" World");
        System.out.println("append(\" World\"): " + demo);

        demo.insert(5, ",");
        System.out.println("insert(5, \",\"): " + demo);

        demo.delete(5, 6);
        System.out.println("delete(5, 6): " + demo);

        demo.reverse();
        System.out.println("reverse(): " + demo);

        demo.reverse(); // 다시 원래대로
        System.out.println("다시 reverse(): " + demo);

        System.out.println("length(): " + demo.length());
        System.out.println("charAt(0): " + demo.charAt(0));

        demo.setCharAt(0, 'h');
        System.out.println("setCharAt(0, 'h'): " + demo);

        String finalStr = demo.toString();
        System.out.println("toString(): " + finalStr);
    }
}
