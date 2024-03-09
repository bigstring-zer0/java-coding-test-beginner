package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최대_부분_증가_수열 { static int[] memo;

    static int solution(int n, int[] arr) {
        memo[0] = 1;

        for (int i = 1; i < n; i++) {
            int maxVal = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    maxVal = Math.max(maxVal, memo[j]);
                }
            }
            memo[i] = maxVal + 1;
        }
        return Arrays.stream(memo).max().getAsInt();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        memo = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, arr));
    }
}
