package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1389 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static int[] result;
    static int N;
    static int M;
    static StringTokenizer st;

    private static int result() {
        int small = Integer.MAX_VALUE;
        int smallIndex = 1;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += arr[i][j];
            }
            if (small > sum - arr[i][i]) {
                small = sum - arr[i][i];
                smallIndex = i;
            }
        }
        return smallIndex;
    }
    private static void solve(){
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][k] != 0 && arr[k][j] != 0) {
                        int cost = arr[i][k] + arr[k][j]; // s -> v -> e 관계 수
                        if (arr[i][j] > cost) // 최소 관계 수로 갱신
                            arr[i][j] = cost;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int r1;
        int r2;
        arr = new int[N + 1][N + 1];
        result = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                arr[i][j] = Integer.MAX_VALUE >> 1;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            arr[r1][r2] = arr[r2][r1]=1;
        }
        solve();
        System.out.println(result());
    }
}
