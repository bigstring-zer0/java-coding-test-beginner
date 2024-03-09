package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌다리_건너기 {
    static int[] memo;
    static int solution(int n) {
        memo[1] = 1;
        memo[2] = 2;

        // 개울을 건너는 방법은 마지막 돌다리까지 건너야 개울을 건너는 것이기 때문에
        // 입력값으로 주어지는 돌다리 갯수 + 1 까지 탐색해야 한다.
        for (int i = 3; i <= n + 1; i++) {
            memo[i] = memo[i - 2] + memo[i - 1];
        }

        return memo[n+1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 2];

        System.out.println(solution(n));

    }
}
