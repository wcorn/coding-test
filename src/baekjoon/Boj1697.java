package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Boj1697 {
    static int[] check;
    private static void BFS(int x,int k) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(x);
        check[x] = 0;

        while(!queue.isEmpty()) {
            int n = queue.poll();

            if (check[k] != 0) break;

            if(n+1 <check.length&& check[n+1] == 0) {
                check[n+1] =check[n]+1;
                queue.offer(n+1);
            }
            if( n-1>=0 && check[n-1] == 0) {
                check[n-1] = check[n]+1;
                queue.offer(n-1);
            }
            if( n*2 < check.length && check[n*2] == 0) {
                check[n*2] = check[n]+1;
                queue.offer(n*2);
            }

        }
    }

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        check = new int[100001];

        if(n == k) {
            System.out.println(0);
            return;
        }

        BFS(n,k);

        System.out.println(check[k]);

    }
}