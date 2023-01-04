package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Boj18870 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int[] sortArr;
    static int[] deduplicatedArr;

    public static int BinarySearch(int target) {
        int low = 0;
        int high = deduplicatedArr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (deduplicatedArr[mid] == target)
                return mid;
            else if (deduplicatedArr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    static void DualPivotQuicksort(int left, int right) {
        if (right > left) {
            if (sortArr[left] > sortArr[right]) swap(left, right);
            int lP = sortArr[left], rP = sortArr[right];

            int l = left + 1, g = right - 1, k = l;
            while (k <= g) {
                if (sortArr[k] < lP) {
                    swap(k, l);
                    l++;
                } else if (sortArr[k] >= rP) {
                    while (sortArr[g] > rP && k < g) g--;
                    swap(k, g);
                    g--;
                    if (sortArr[k] < lP) {
                        swap(k, l);
                        l++;
                    }
                }
                k++;
            }
            l--;
            g++;
            swap(left, l);
            swap(right, g);
            DualPivotQuicksort(left, l - 1);
            DualPivotQuicksort(l + 1, g - 1);
            DualPivotQuicksort(g + 1, right);
        }
    }

    static void swap(int i, int j) {
        final int tmp = sortArr[i];
        sortArr[i] = sortArr[j];
        sortArr[j] = tmp;
    }

    public static void Deduplication() {
        int[] tempArr = new int[arr.length];
        int flag = sortArr[0];
        int index = 0;
        tempArr[0] = flag;
        for (int i = 1; i < sortArr.length; i++) {
            if (flag != sortArr[i]) {
                index++;
                tempArr[index] = sortArr[i];
                flag = sortArr[i];
            }
        }
        deduplicatedArr = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            deduplicatedArr[i] = tempArr[i];
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        sortArr = new int[N];
        int temp;
        for (int i = 0; i < N; i++) {
            temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            sortArr[i] = temp;
        }
        DualPivotQuicksort(0, N - 1);
        Deduplication();
        for (int i = 0; i < arr.length; i++) {
            sb.append(BinarySearch(arr[i]) + " ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}