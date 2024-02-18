package dfs_bfs_basic;

import java.io.IOException;

public class 피보나치_수열_메모제이션 {
    static int[] memo;
    public static int DFS(int num) {
        // num 은 피보나치 수열의 각 항을 의미한다.
        // 만약 memo[num]에 값이 0 이 아니라면 이미 해당 함수를 계산했다는 의미기 때문에,
        // 함수를 호출하지 않고 계산 결과 값만 바로 리턴한다.
        if (memo[num] != 0){
            return memo[num];
        }
        // 만약 num이 1이라면,
        if (num == 1){
            // 피보나치 수열의 1항은 1이므로 memo[num]에 1을 기록
            return memo[num] = 1;
        }
        // 만약 num이 2라면,
        if (num == 2) {
            // 피보나치 수열의 2항은 1이므로 memo[num]에 1을 기록
            return memo[num] = 1;
            // 그게아니라 num이 3 이상이라면,
        } else {
            // 피보나치수열의 각 항은 1항 2항을 제외하고 3항부터는 num-2항 값 + num-1항 값 이므로,
            // num항의 값을 num - 2항의 피보나치 수열을 계산한값 + num - 1항의 피보나치 수열을 계산한 값을 memo[num]에 기록
            return memo[num] = DFS(num - 2) + DFS(num - 1);
        }

    }

    public static int solution(int n) {
        // 피보나치 수열은 1항부터 시작하므로 n+1 크기의 계산한 값을 기록해두기 위한 memo 배열을 생성
        memo = new int[n + 1];
        // 피보나치 수열을 계산하기 위한 재귀함수 호출
        return DFS(n);
    }

    public static void main(String[] args) throws IOException {
        solution(45);
        for (int val : memo) {
            System.out.print(val + " ");
        }
    }
}
