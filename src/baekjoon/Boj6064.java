package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Boj6064 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        int M;
        int N;
        int x;
        int y;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            bw.append(String.valueOf(solve(M, N, x, y))).append("\n");
        }
        bw.flush();
    }

    private static int solve(int m, int n, int x, int y) {
        int count = x;
        int tempY;
        int gcd = gcd(m, n);
        if (gcd != 1 && Math.abs(x - y) % gcd != 0)
            return -1;
        for (int i = 0; i < n; i++) {
            tempY = x % n == 0 ? n : x % n;
            if (tempY == y) {
                break;
            }

            x = tempY + m;
            count += m;
        }
        return count;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
