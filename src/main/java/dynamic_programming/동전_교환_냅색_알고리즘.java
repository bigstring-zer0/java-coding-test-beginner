package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전_교환_냅색_알고리즘 {

    static int[] memo;
    static int[] coin;

    static int solution(int n, int m) {
        memo[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                memo[j] = Math.min(memo[j], memo[j - coin[i]] + 1);
            }
        }

        return memo[m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        coin = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        while (st.hasMoreTokens()) {
            coin[idx++] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        memo = new int[m + 1];

        Arrays.fill(memo, Integer.MAX_VALUE);

        System.out.println(solution(n, m));
    }
}
