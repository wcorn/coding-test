package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1107 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int M;
    static int N;
    static StringTokenizer st;
    static List<Integer> broken = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++)
                broken.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(solve());
    }

    private static int solve() {
        int min = Math.abs(N - 100);
        for (int i = 0; i <= 1000000; i++) {
            int length = check(i);
            if (length > 0) min = Math.min(min, Math.abs(N - i) + length);
        }
        return min;
    }

    private static int check(int target) {
        int count = 0;
        if (target == 0) return broken.contains(target) ? 0 : 1;
        while (target > 0) {
            if (broken.contains(target % 10))
                return 0;
            target /= 10;
            count++;
        }
        return count;
    }
}