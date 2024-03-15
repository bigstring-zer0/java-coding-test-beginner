package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대_점수_구하기 {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(st.nextToken());
        memo = new int[m + 1];

        int score, time;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            score = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());
            for (int j = m; j >= time; j--) {
                memo[j] = Math.max(memo[j], memo[j - time] + score);
            }
        }

        System.out.println(memo[m]);
    }
}
