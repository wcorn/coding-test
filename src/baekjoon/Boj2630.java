package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * packageName    : baekjoon
 * fileName       : Boj2630
 * author         : peter
 * date           : 2023-01-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-01-06        peter       최초 생성
 */
public class Boj2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static StringTokenizer st;
    static int[] result = new int[2];

    public static void Divide(int left, int right, int top, int bottom) {
        int length = right - left + 1;
        int divdieLength = length / 2;
        int widthMid = left + divdieLength;
        int heightMid = top + divdieLength;
        Conquer(left, widthMid - 1, top, heightMid - 1);
        Conquer(widthMid, right, top, heightMid - 1);
        Conquer(left, widthMid - 1, heightMid, bottom);
        Conquer(widthMid, right, heightMid, bottom);
    }

    public static void Conquer(int left, int right, int top, int bottom) {
        int flag = arr[left][top];
        for (int i = left; i <= right; i++) {
            for (int j = top; j <= bottom; j++) {
                if (flag != arr[i][j]) {
                    Divide(left, right, top, bottom);
                    return;
                }
            }
        }
        result[flag]++;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Conquer(1, N, 1, N);
        sb.append(result[0] + "\n");
        sb.append(result[1]);
        System.out.println(sb.toString());
    }
}
