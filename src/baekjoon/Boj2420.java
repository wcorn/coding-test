package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Boj2420 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long n1 = Long.parseLong(st.nextToken());
        long n2 = Long.parseLong(st.nextToken());
        sb.append(Math.abs(n1-n2));
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
