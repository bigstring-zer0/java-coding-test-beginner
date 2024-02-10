package array;

import java.io.IOException;

public class 피보나치_수열 {
    public static int[] solution(int n) {
        int[] answer = new int[n];
        // 피보나치 수열의 특성상 1항 값 1로 고정
        answer[0] = 1;
        // 피보나치 수열의 특성상 2항 값 1로 고정
        answer[1] = 1;

        // 유명한 피보나치를 수열을 구현하는 문제다.
        // 단순 반복문, 메모제이션, DFS 등 다양한 풀이법이 있겠지만 간단하게
        // 1항 2항은 1로 고정이고 3항부터 3항의 값 n-2항의 값 + n-1항의 값 = n항의 값이라는
        // 원리를 활용하여 배열에다가 값을 기록하며 N 값이 주어졌을때 N 항까지의 피보니치 수열을 계산하는 방법으로 문제를 풀것이다.
        // 1항 2항 값은 1로 고정이니 3항을 의미하는 2번 인덱스 부터 루프 시작
        for (int i = 2; i < n; i++) {
            // i항의 값은 i - 2 항의 값 + i - 1 항의 값이라는 원리를 활용하여 i항 의값 저장
            // answer에는 1, 1, 2, 3, 5, 8, 13, 21... 순으로 i항의 값은 i - 2 항의 값 + i - 1 항의 값으로 저장될 것이다.
            answer[i] = answer[i - 2] + answer[i - 1];
        }

        return answer;

    }
    public static void main(String[] args) throws IOException {
        for (int val : solution(10)) {
            System.out.print(val + " ");
        }
    }
}
