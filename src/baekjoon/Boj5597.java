package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Boj5597 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        boolean[] arr = new boolean[31];
        for(int i=0;i<28;i++){
            arr[Integer.parseInt(br.readLine())] = true;
        }
        for(int i=1;i<31;i++){
            if(!arr[i])
                sb.append(i+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
