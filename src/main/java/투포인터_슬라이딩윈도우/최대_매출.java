package 투포인터_슬라이딩윈도우;

import java.io.IOException;

public class 최대_매출 {
    public static int solution(int n, int k, int[] arr) {

//        int p1 = 0, p2 = k - 1;
//        int answer = Integer.MIN_VALUE;
//        int sum;
//        while (p2 < n) {
//            sum = 0;
//            for (int i = p1; i <= p2; i++) {
//                sum += arr[i];
//            }
//            answer = Math.max(answer, sum);
//            p1++;
//            p2++;
//        }


        int answer = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        for (int i = k; i < n; i++) {
            sum += arr[i];
            sum -= arr[i - k];
            answer = Math.max(answer, sum);
        }



        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution(10, 3, new int[]{12, 15, 11, 20, 25, 10, 20, 19, 13, 15}));
    }
}
