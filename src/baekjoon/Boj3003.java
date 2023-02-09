package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args)throws IOException {
        st = new StringTokenizer(br.readLine());
        System.out.println((1-Integer.parseInt(st.nextToken()))+" "+ (1-Integer.parseInt(st.nextToken()))+" "+(2-Integer.parseInt(st.nextToken()))+" "+(2-Integer.parseInt(st.nextToken()))+" "+(2-Integer.parseInt(st.nextToken()))+" "+(8-Integer.parseInt(st.nextToken())));
    }
}
