package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 가장_높은_탑_쌓기 {
    static class Brick {
        int area;
        int height;
        int weight;

        public Brick(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }
        public int getArea() {
            return area;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }

    }

    static int[] memo;
    static List<Brick> bricks = new ArrayList<>();

    static int solution() {
        memo[0] = bricks.get(0).getHeight();

        for (int i = 1; i < bricks.size(); i++) {
            int maxHeight = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (bricks.get(i).getWeight() < bricks.get(j).getWeight()) {
                    maxHeight = Math.max(maxHeight, memo[j]);
                }
            }
            memo[i] = maxHeight + bricks.get(i).getHeight();
        }
        return Arrays.stream(memo).max().getAsInt();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n];
        StringTokenizer st;
        int area, height, weight;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            area = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            bricks.add(new Brick(area, height, weight));
        }

        bricks.sort(Comparator.comparing(Brick::getArea).reversed());
        System.out.println(solution());

    }
}
