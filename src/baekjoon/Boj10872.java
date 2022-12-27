package baekjoon;

import java.io.*;

public class Boj10872 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        int result = 1;
        for(int i=1;i<=num;i++){
            result = result*i;
        }
        bw.write(Integer.toString(result));
        bw.flush();
        br.close();
        bw.close();
    }
}
