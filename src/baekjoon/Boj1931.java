package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1931 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Class> list = new ArrayList<>();

    private static class Class {
        int start;
        int end;

        Class(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class ClassComparator implements Comparator<Class> {

        @Override
        public int compare(Class o1, Class o2) {
            if (o1.end != o2.end) {
                if (o1.end > o2.end) return 1;
                if (o1.end < o2.end) return -1;
            }
            if (o1.end == o2.end) {
                if (o1.start > o2.start) return 1;
                if (o1.start < o2.start) return -1;
            }
            return 0;
        }
    }

    private static int ActivitySelection() {
        int count = 0;
        int lastTime = 0;
        for (int i = 0; i < list.size(); i++) {
            if (lastTime <= list.get(i).start) {
                count++;
                lastTime = list.get(i).end;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int start;
        int end;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            list.add(new Class(start, end));
        }
        Collections.sort(list, new ClassComparator());
        System.out.println(ActivitySelection());
    }
}
