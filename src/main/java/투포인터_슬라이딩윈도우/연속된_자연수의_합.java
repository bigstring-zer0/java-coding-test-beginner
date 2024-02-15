package 투포인터_슬라이딩윈도우;

import java.io.IOException;

public class 연속된_자연수의_합 {
    public static int solution(int n) {
        int lt = 1, rt = 1;
        int[] arr = new int[n / 2 + 2];
        int answer = 0;
        for (int i = 1; i <= (n / 2) + 1; i++) {
            arr[i] = i;
        }
        int sum = arr[lt];

        do {
            if (sum == n) {
                answer++;
                sum -= arr[lt++];
            } else if (sum > n) {
                sum -= arr[lt++];
            } else {
                sum += arr[++rt];
            }

        } while (lt < rt);

        return answer;
    }
    public static void main(String[] args) throws IOException {
        System.out.println(solution(15));
    }
}
