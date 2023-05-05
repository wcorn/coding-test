package baekjoon;

import java.io.*;
import java.util.*;

public class Boj10811 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        for (int k = 0; k < arr.length; k++) {
            arr[k] = k;
        }
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            flip(arr, i, j);
        }
        for (int k = 1; k < arr.length; k++) {
            sb.append(arr[k]).append(" ");
        }
        System.out.println(sb.toString());
    }
    public static void flip(int[] arr, int i, int j) {
        for(int k=0;k<Math.ceil((float)(j-i)/2);k++){
            swap(arr,i+k,j-k);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
