package baekjoon;

import java.io.*;
import java.util.*;

public class Boj16928 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[] snakeLadder = new int[101];
    static int[] count = new int[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int u;
        int v;
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            snakeLadder[u] = v;
        }
        BFS();
    }

    private static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        int now;
        int next;
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            now = q.poll();
            if (now == 100) {
                System.out.println(count[now]);
                break;
            }
            for (int i = 1; i <= 6; i++) {
                next = now + i;
                if (100 < next || visited[next]) continue;
                if (snakeLadder[next] != 0) {
                    if (!visited[snakeLadder[next]]) {
                        visited[snakeLadder[next]] = true;
                        count[snakeLadder[next]] = count[now]+1;
                        q.offer(snakeLadder[next]);
                    }
                } else {
                    visited[next] = true;
                    count[next] = count[now]+1;
                    q.offer(next);
                }
            }
        }
    }
}
