package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] box;
    static Queue<Tomato> q = new LinkedList<>();
    static int riped = 0;
    static int notRiped = 0;
    static int c = 0;

    static class Tomato {
        int x;
        int y;

        Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[M][N];
        int temp;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                temp = Integer.parseInt(st.nextToken());
                box[i][j] = temp;
                if (temp == 1) {
                    q.add(new Tomato(j, i));
                    riped++;
                } else if (temp == 0) {
                    notRiped++;
                }
            }
        }
        BFS();
        System.out.println(c);
    }

    private static void BFS() {
        int nextX;
        int nextY;
        int size = q.size();
        int count=0;
        if (size != 0 && notRiped != 0)
            c++;
        for (int i = 0; i < size; i++) {
            Tomato tomato = q.poll();
            if (tomato == null)
                break;
            for (int t = 0; t < 4; t++) {
                nextX = tomato.x+dx[t];
                nextY = tomato.y+dy[t];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                    continue;
                if (box[nextY][nextX] == 0) {
                    box[nextY][nextX] = 1;
                    count++;
                    riped++;
                    notRiped--;
                    q.add(new Tomato(nextX, nextY));
                }
            }
        }
        if (notRiped == 0)
            return;
        else if (count == 0) {
            c = -1;
            return;
        }
        BFS();
    }
}
