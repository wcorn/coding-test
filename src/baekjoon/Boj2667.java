package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Boj2667 {
    static int[][] arr;
    static boolean[][] visited;
    static int count = -1;
    static ArrayList<Integer> countArr = new ArrayList<>();
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        String temp;
        for (int i = 0; i < N; i++) {
            temp = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(temp.substring(j, j + 1));
            }
        }
        findArea();
        Collections.sort(countArr);
        bw.append(String.valueOf(countArr.size())).append("\n");
        for (Integer integer : countArr) {
            bw.append(String.valueOf(integer)).append("\n");
        }
        bw.flush();
    }

    private static void findArea() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    count++;
                    countArr.add(0);
                    findHouse(i, j);
                }
            }
        }
    }

    private static void findHouse(int x, int y) {
        visited[x][y] = true;
        int count2 = countArr.get(count);
        count2++;
        countArr.set(count, count2);
        int nextX;
        int nextY;
        for (int i = 0; i < 4; i++) {
            nextX = x + dx[i];
            nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
                continue;
            if (visited[nextX][nextY] || arr[nextX][nextY] == 0)
                continue;
            findHouse(nextX, nextY);
        }
    }
}
