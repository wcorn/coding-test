package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Boj1780 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] arr;
    static int[] result = new int[3];

    public static void divdie(int left, int right, int top, int bottom) {
        int length = right - left + 1;
        int divdieLength = length / 3;
        int[][][] divdieArr = new int[3][3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divdieArr[i][j][0] = divdieLength;
                divdieArr[i][j][1] = divdieLength;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Conquer(left + divdieLength * i, left + divdieLength * (i + 1) - 1, top + divdieLength * j, top + divdieLength * (j + 1) - 1);
            }
        }
    }

    public static void Conquer(int left, int right, int top, int bottom) {
        int flag = arr[left][top];
        for (int i = left; i <= right; i++) {
            for (int j = top; j <= bottom; j++) {
                if (flag != arr[i][j]) {
                    divdie(left, right, top, bottom);
                    return;
                }
            }
        }
        result[flag + 1]++;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Conquer(1, N, 1, N);
        sb.append(result[0] + "\n");
        sb.append(result[1] + "\n");
        sb.append(result[2] + "\n");
        bw.write(sb.toString());
        bw.flush();
    }
}
