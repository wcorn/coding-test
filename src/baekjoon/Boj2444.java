package baekjoon;

import java.io.*;

public class Boj2444 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 2 * n - 1; i++) {
            if (i <= n) {
                for (int j = 1; j <= n - i; j++) {
                    bw.write(" ");
                }
                for (int j = 1; j <= 2 * i - 1; j++) {
                    bw.write("*");
                }
            }
            else {
                for (int j = 1; j <= i % n; j++) {
                    bw.write(" ");
                }
                for (int j = 1; j <= (2 * n - 1) - 2 * (i % n); j++) {
                    bw.write("*");
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
