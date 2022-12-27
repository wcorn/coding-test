package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Boj10807 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int v;
        int count=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        v = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            if(arr[i]==v) count++;
        }
        bw.write(Integer.toString(count));
        bw.flush();
        br.close();
        bw.close();
    }
}
