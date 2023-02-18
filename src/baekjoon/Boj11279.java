package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11279 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int temp;
    static int top;
    private static void add(int x){
        arr[++top] = x;
        maxHeapSortUp();
    }
    private static void remove(){
        sb.append(arr[1] + "\n");
        arr[1] = arr[top];
        arr[top--] = 0;
        maxHeapSortDown();
    }
    private static void swap(int a, int b) {
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    private static void maxHeapSortUp(){
        int tempTop = top;
        while (tempTop != 1) {
            if (arr[tempTop / 2] < arr[tempTop]) {
                swap(tempTop / 2, tempTop);
                tempTop = tempTop / 2;
                continue;
            }
            break;
        }
    }
    private static void maxHeapSortDown(){
        int flag = 1;
        int target;
        while (flag <= top) {
            if (flag*2 <= top) {
                target = flag * 2;
                if (flag * 2 + 1 <= top) {
                    target = arr[flag * 2] >= arr[flag * 2 + 1] ? target : flag * 2 + 1;
                }
                if(arr[flag]<arr[target]){
                    swap(flag,target);
                    flag = target;
                    continue;
                }
            }
            break;
        }
    }
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int x;
        arr = new int[3 * N + 3];
        top = 0;
        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());
            if (x == 0 && top == 0) {
                sb.append(0 + "\n");
            } else if (x == 0) {
                remove();
            } else {
                add(x);
            }
        }
        bw.append(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
