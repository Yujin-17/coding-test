package practice.grammar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연습 1: BufferedReader 기본
 * 연습 2: 여러 숫자 입력받기 (StringTokenizer)
 * 연습 3: StringTokenizer (더 빠름!)
 * 연습 4: StringBuilder (출력 최적화)
 *
 * ✅ BufferedReader - 빠른 입력
 * ✅ split() vs StringTokenizer - 문자열 파싱
 * ✅ StringBuilder - 빠른 출력
 */
public class InputOutput {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("출력할 줄 수 입력: ");
        int n = Integer.parseInt(br.readLine());

        // 나쁜 예: 느림
        System.out.println("\n=== 느린 출력 방식 ===");
        long start1 = System.currentTimeMillis();
        for (int i = 1; i<= n; i++) {
            System.out.println(i + "번째 줄입니다.");
        }
        long end1 = System.currentTimeMillis();

        // 좋은 예: 빠름
        System.out.println("\n=== 빠른 출력 방식 ===");
        long start2 = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            sb.append(i).append("번째 줄입니다.\n");
        }
        System.out.println(sb);
        long end2 = System.currentTimeMillis();

        System.out.println("\n[속도 비교]");
        System.out.println("일반 출력: " + (end1 - start1) + "ms");
        System.out.println("StringBuilder: " + (end2 - start2) + "ms");

//        System.out.println("이름 입력: ");
//        String name = br.readLine();
//
//        System.out.println("나이 입력: ");
//        String age = br.readLine();
//
//        System.out.println("안녕하세요, " + name + "님! 당신은 " + age + "살 입니다.");

//        // 방법 1: split() 사용
//        System.out.println("=== split() 방식 ===");
//        System.out.println("숫자 5개 입력 (공백 구분): ");
//        String[] arr = br.readLine().split(" ");
//
//        System.out.println("입력한 숫자들: ");
//        for (String s : arr) {
//            System.out.println(s + " ");
//        }
//        System.out.println();
//
//        // int로 변환
//        int[] numbers = new int[arr.length];
//        for (int i =0; i < arr.length; i++) {
//            numbers[i] = Integer.parseInt(arr[i]);
//        }
//
//        System.out.println("합계: " + sum(numbers));

        // 방법 2: StringTokenizer 사용(더 빠름)
        System.out.println("=== StringTokenizer 방식 ===");
        System.out.println("숫자 5개 입력 (공백 구분): ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println("입력한 숫자들: ");
        for (int num : numbers) {
            System.out.println(num + " ");
        }
        System.out.println();

        System.out.println("합계: " + sum(numbers));
        System.out.println("최대값: " + max(numbers));
        System.out.println("최소값: " + min(numbers));
    }

    static int max(int[] arr) {
        int maxVal = arr[0];
        for (int num : arr) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        return maxVal;
    }

    static int min(int[] arr) {
        int minVal = arr[0];
        for (int num : arr) {
            if (num < minVal) {
                minVal = num;
            }
        }
        return minVal;
    }

    static int sum(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
}
