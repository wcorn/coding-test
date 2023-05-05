package baekjoon;

import java.io.*;
import java.util.*;

public class Boj10810 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int i, j, k;
        int[] arr = new int[N + 1];
        for (int z = 0; z < M; z++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            for (int f = i; f <= j; f++) {
                arr[f] = k;
            }
        }

        for (int z = 1; z < arr.length; z++) {
            sb.append(arr[z]+" ");
        }
        System.out.println(sb.toString());
    }
}
