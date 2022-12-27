package baekjoon;

import java.io.*;
import java.util.Arrays;

public class Boj9461 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long arr[] = new long[101];

    public static void main(String[] args) throws IOException {
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        arr[6] = 3;
        arr[7] = 4;
        arr[8] = 5;
        arr[9] = 7;
        arr[10] = 9;
        Long N = Long.parseLong(br.readLine());
        for(int i=11;i<101;i++){
            arr[i] = arr[i-2]+arr[i-3];
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < N; i++) {
            bw.append((arr[Integer.parseInt(br.readLine())] + "\n"));
        }
        bw.flush();
    }
}
