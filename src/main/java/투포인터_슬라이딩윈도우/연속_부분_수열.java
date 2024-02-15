package 투포인터_슬라이딩윈도우;

import java.io.IOException;

public class 연속_부분_수열 {

    public static int solution(int n, int m, int[] arr) {
        int lt = 0, rt = 0;

        int answer = 0;
        int sum = arr[lt];
        while (true) {
            if (sum == m) {
                answer++;
                sum -= arr[lt++];
            } else if (sum > m) {
                sum -= arr[lt++];
            } else {
                if (rt == n - 1) {
                    break;
                }
                sum += arr[++rt];
            }

        }

        do {
            if (sum == m) {
                answer++;
                sum -= arr[lt++];
            } else if (sum > m) {
                sum -= arr[lt++];
            } else {
                if (rt == n - 1) {
                    lt++;
                } else {
                    sum += arr[++rt];
                }
            }
        } while (lt < rt);
        return answer;
    }
    public static void main(String[] args) throws IOException {
        System.out.println(solution(8, 6, new int[]{1, 2, 1, 3, 1, 1, 1, 2}));
    }
}
