package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Boj2738 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n1][n2];
        for(int i=0;i<n1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n2;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<n1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n2;j++){
                sb.append(arr[i][j]+Integer.parseInt(st.nextToken())+" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}