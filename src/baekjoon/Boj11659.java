package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11659 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int[] sum;

    public static void NestedSum(int N) {
        for (int i = 2; i < N; i++) {
            sum[i] = arr[i] + sum[i - 1];
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int i;
        int j;
        arr = new int[N+1];
        sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int k = 1; k < N+1; k++) {
            arr[k] = Integer.parseInt(st.nextToken());
        }
        sum[1] = arr[1];
        NestedSum(N+1);
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            sb.append(sum[j]-sum[i-1]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
