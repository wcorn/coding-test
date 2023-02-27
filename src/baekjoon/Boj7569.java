package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int M;
    static int N;
    static int H;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[][][] box;
    static Queue<Tomato> q = new LinkedList<>();
    static int riped = 0;
    static int notRiped = 0;
    static int c = 0;

    static class Tomato {
        int x;
        int y;
        int z;

        Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        int temp;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    temp = Integer.parseInt(st.nextToken());
                    box[i][j][k] = temp;
                    if (temp == 1) {
                        q.add(new Tomato(k, j, i));
                        riped++;
                    } else if (temp == 0) {
                        notRiped++;
                    }
                }
            }
        }
        BFS();
        System.out.println(c);
    }

    private static void BFS() {
        int count = 0;
        int nextX;
        int nextY;
        int nextZ;
        int size = q.size();
        if (size != 0 && notRiped != 0)
            c++;
        for (int i = 0; i < size; i++) {
            Tomato tomato = q.poll();
            for (int k = 0; k < 6; k++) {
                if(tomato==null)
                    break;
                nextX = tomato.x + dx[k];
                nextY = tomato.y + dy[k];
                nextZ = tomato.z + dz[k];
                if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || nextZ < 0 || nextZ >= H)
                    continue;
                if (box[nextZ][nextY][nextX] == 0) {
                    box[nextZ][nextY][nextX] = 1;
                    riped++;
                    notRiped--;
                    count++;
                    q.add(new Tomato(nextX, nextY, nextZ));
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