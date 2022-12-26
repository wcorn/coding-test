package baekjoon;

import java.io.*;
import java.util.Arrays;

public class Boj1927 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int temp;
    static int top;

    public static void add(int data) {
        arr[++top] = data;
        minHeapSortUp();
    }

    public static void remove() {
        sb.append(arr[1] + "\n");
        arr[1] = arr[top];
        arr[top--] = 0;
        minHeapSortDown();
    }

    public static void swap(int a, int b) {
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void minHeapSortUp() {
        int tempTop = top;
        while (tempTop != 1) {
            if (arr[tempTop / 2] > arr[tempTop]) {
                swap(tempTop / 2, tempTop);
                tempTop = tempTop / 2;
                continue;
            }
            break;
        }
    }

    public static void minHeapSortDown() {
        int flag = 1;
        int target;
        while (flag <= top) {
            if (flag*2 <= top) {
                target = flag * 2;
                if (flag * 2 + 1 <= top) {
                    target = arr[flag * 2] <= arr[flag * 2 + 1] ? target : flag * 2 + 1;
                }
                if(arr[flag]>arr[target]){
                    swap(flag,target);
                    flag = target;
                    continue;
                }
            }
            break;
        }
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        int n;
        arr = new int[3 * num + 3];
        top = 0;
        for (int i = 0; i < num; i++) {
            n = Integer.parseInt(br.readLine());
            if (n == 0 && top == 0) {
                sb.append(0 + "\n");
            } else if (n == 0) {
                remove();
            } else {
                add(n);
            }
            System.out.println(Arrays.toString(arr));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}