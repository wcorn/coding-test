package baekjoon;

import java.io.*;

public class Boj9086 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String str;
        for(int i=0;i<N;i++){
            str = br.readLine();
            bw.append(str.substring(0,1)).append(str.substring(str.length()-1)).append("\n");
        }
        bw.flush();
    }
}
