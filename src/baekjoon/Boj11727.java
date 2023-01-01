package baekjoon;

import java.io.*;

public class Boj11727 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static void DP(){
        arr[1] = 1;
        arr[2] = 3;
        for(int i=3;i<arr.length;i++){
            arr[i] = (arr[i-1]+2*arr[i-2])%10007;
        }
    }
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+2];
        DP();
        System.out.println(arr[n]);
    }
}