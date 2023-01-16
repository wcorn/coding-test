package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Boj1074 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int count = 0;

    public static void Recursion(int x, int y, int size) {
        if(size == 1)
            return;

        if(x < size/2 && y < size/2) {
            Recursion(x, y,size/2);
        }
        else if(x< size/2 && y >= size/2) {
            count += size * size / 4;
            Recursion(x, y - size/2,size/2);
        }
        else if(x >= size/2 && y < size/2) {
            count += (size * size / 4) * 2;
            Recursion(x - size/2, y,size/2 );
        }
        else {
            count += (size * size / 4) * 3;
            Recursion(x - size/2, y - size/2,size/2);
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        Recursion(x, y, (int) Math.pow(2, N));
        System.out.println(count);
    }
}
