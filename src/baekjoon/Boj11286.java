package baekjoon;

import java.io.*;

public class Boj11286 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int top;
    static int temp;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        int value;
        top = 0;
        for (int i = 0; i < N; i++) {
            value = Integer.parseInt(br.readLine());
            if (value == 0) {
                if (top == 0)

                    bw.append(String.valueOf(0)).append("\n");
                else {
                    remove();
                }
            } else
                add(value);
        }
        bw.flush();
    }

    private static void add(int data) {
        arr[++top] = data;
        absHeapSortUp();
    }

    private static void absHeapSortUp() {
        int tempTop = top;
        while (tempTop != 1) {
            if (Math.abs(arr[tempTop / 2]) > Math.abs(arr[tempTop])) {
                swap(tempTop / 2, tempTop);
                tempTop = tempTop / 2;
                continue;
            } else if (Math.abs(arr[tempTop / 2]) == Math.abs(arr[tempTop])) {
                if (arr[tempTop / 2] > arr[tempTop]) {
                    swap(tempTop / 2, tempTop);
                    tempTop = tempTop / 2;
                    continue;
                }
            }
            break;
        }

    }

    private static void remove() throws IOException {
        bw.append(String.valueOf(arr[1])).append("\n");
        arr[1] = arr[top];
        arr[top--] = 0;
        absHeapSortDown();
    }

    private static void absHeapSortDown() {
        int flag = 1;
        int target;
        while (flag <= top) {
            if (flag * 2 <= top) {
                target = flag * 2;
                if (flag * 2 + 1 <= top) {
                    if (Math.abs(arr[flag * 2]) > Math.abs(arr[flag * 2 + 1])) {
                        target = flag * 2 + 1;
                    } else if (Math.abs(arr[flag * 2]) == Math.abs(arr[flag * 2 + 1])) {
                        if (arr[flag * 2] > arr[flag * 2 + 1]) {
                            target = flag * 2 + 1;
                        }
                    }
                }
                if (Math.abs(arr[flag]) > Math.abs(arr[target])) {
                    swap(flag, target);
                    flag = target;
                    continue;
                } else if (Math.abs(arr[flag]) == Math.abs(arr[target])) {
                    if (arr[flag] > arr[target]) {
                        swap(flag, target);
                        flag = target;
                        continue;
                    }
                }
            }
            break;
        }
    }

    private static void swap(int a, int b) {
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}