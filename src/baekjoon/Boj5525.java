package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5525 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static char[] charS;
    static int counts = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        charS = S.toCharArray();
        solve();
        System.out.println(counts);
    }

    private static void solve() {
        int j;
        for (int i = 0; i < M; i++) {
            j = findI(i);
            i = findIO(j);
        }
    }

    private static int findIO(int j) {
        int count = 0;
        int i;
        for (i = j; i < M - 1; i++) {
            if (charS[i] == 'O' && charS[i + 1] == 'I') {
                int k;
                for (k = i; k < M - 1; k++) {
                    if (charS[k] == 'O' && charS[k + 1] == 'I') {
                        count++;
                        k++;
                    }
                    else break;
                }
                if (count - N + 1 > 0) {
                    counts += count - N + 1;
                }
                return k-1;
            }
        }
        return j;
    }

    private static int findI(int x) {
        int i;
        for (i = x; i < M - 2; i++) {
            if (charS[i] == 'I' && charS[i + 1] == 'O' && charS[i + 2] == 'I')
                break;
        }
        return i;
    }
}