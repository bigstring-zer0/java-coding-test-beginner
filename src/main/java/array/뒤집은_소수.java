package array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class 뒤집은_소수 {

    // 입력받은 숫자가 소수인지 판별하는 메서드
    // 2부터 num - 1 까지의 수를 자기 자신과 나누었을때
    // 나머지가 0이 되는 수가 하나라도 존재한다면 1과 자기자신 이외의 약수를 가진다는 원리를 활용
    public static boolean isPrime(int num) {
        // 만약 num이 1이라면 소수가 아니므로 false 리턴하고 함수 종료
        if (num == 1){
            return false;
        }
        // num이 소수인지 판별 시작
        for (int i = 2; i < num; i++) {
            // 만약 num과 2부터 num - 1까지 순차적으로 나누었을때 나머지가 0이라면,
            if (num % i == 0) {
                // 1과 num 이외의 약수를 가진다는 의미이므로 false를 리턴하고 함수 종료
                return false;
            }
        }
        // 루프를 다 돌았음에도 false를 리턴하지 않고 함수가 종료되지 않았다면 소수이므로 true를 리턴.
        return true;
    }
    public static List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int tmp;

        // StringBuilder 클래스의 reverse() 메서드를 활용하여 입력받은 수를 뒤집어
        // 뒤집은수가 소수인지를 판별하며 문제를 풀면 될것같다.
        // 소수인지 판별 시작
        for (int val : arr) {
            // 순차적으로 접근한 정수 val을 sb에 추가하고 reverse()를 통해 뒤집음
            sb.append(val).reverse();
            // 뒤집은 val을 문자열로 변환하고 해당 문자열을 정수로 변환후 tmp에 저장.
            tmp = Integer.parseInt(String.valueOf(sb));
            // 만약 val을 뒤집은 수가 저장되어있는 tmp가 소수라면 isPrime() 메서드는 true를 반환할것이므로
            // if문을 실행한다. 만약에 tmp가 소수가 아니라 false가 반환되었다면 if 문을 실행하지 않을것이며
            // 당연히 answer에 tmp를 추가하지 않을것이다.
            if (isPrime(tmp)) {
                // answer에 tmp를 추가.
                answer.add(tmp);
            }
            // sb에는 순차적으로 접근한 val이 저장되어 있으므로 sb를 초기화 해주지 않으면
            // 순차적으로 접근한 val의 값이 계속해서 추가될 것이다.
            // 그러면 기대한 값과 다른값이 계산될 수 있으므로 루프를 한번 돌때마다 sb를 초기화 해줘야 한다.
            sb.setLength(0);
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        for (Integer integer : solution(9, new int[]{32, 55, 62, 20, 250, 370, 200, 30, 100})) {
            System.out.print(integer + " ");
        }

    }
}
