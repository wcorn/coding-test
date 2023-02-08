package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1992 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;

    public static String conquer(int x, int y, int size) {
        String res = "";
        int temp = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != temp) {
                    int tempSize = size / 2;
                    res+="(";
                    res += conquer(x, y, tempSize);
                    res += conquer(x, y + tempSize, tempSize);
                    res += conquer(x + tempSize, y, tempSize);
                    res += conquer(x + tempSize, y + tempSize, tempSize);
                    res+=")";
                    return res;
                }
            }
        }
        res+=temp;
        return res;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }
        for (int j = 0; j < N; j++) {
            System.out.println(Arrays.toString(arr[j]));
        }
        System.out.println(conquer(0, 0, N));
    }
}