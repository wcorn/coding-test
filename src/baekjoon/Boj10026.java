package baekjoon;

import java.io.*;

public class Boj10026 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] paint;
    static char[][] paint_week;
    static boolean[][] visited;
    static int N;
    static int count;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        String tempStr;
        char tempCh;
        paint = new char[N][N];
        paint_week = new char[N][N];
        for (int i = 0; i < N; i++) {
            tempStr = br.readLine();
            for (int j = 0; j < N; j++) {
                tempCh = tempStr.substring(j, j + 1).charAt(0);
                if (tempCh == 'R' || tempCh == 'G')
                    paint_week[i][j] = 'W';
                else
                    paint_week[i][j] = tempCh;
                paint[i][j] = tempCh;
            }
        }
        findArea(paint);
        bw.write(" ");
        findArea(paint_week);
        bw.flush();
    }

    private static void findArea(char[][] paint) throws IOException {
        count = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count++;
                    findColor(paint, i, j);
                }
            }
        }
        bw.write(count + "");
    }

    private static void findColor(char[][] paint, int i, int j) {
        visited[i][j] = true;
        char temp = paint[i][j];
        int nextX;
        int nextY;
        for (int t = 0; t < 4; t++) {
            nextX = i + dx[t];
            nextY = j + dy[t];
            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
                continue;
            if (visited[nextX][nextY] || paint[nextX][nextY] != temp)
                continue;
//            System.out.println(paint[i][j]+" "+i+" "+j);
            findColor(paint, nextX, nextY);
        }
    }


}
