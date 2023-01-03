package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1541 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int sum =0;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(),"-");
        String[] str = st.nextToken().split("\\+");
        for(int i=0;i<str.length;i++){
            sum+=Integer.parseInt(str[i]);
        }
        while(st.hasMoreTokens()){
            str = st.nextToken().split("\\+");
            for(int i=0;i<str.length;i++){
                sum-=Integer.parseInt(str[i]);
            }
        }
        System.out.println(sum);
    }
}
