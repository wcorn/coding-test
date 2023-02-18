package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Boj9375 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    private static Item[] bucket = new Item[1000];
    private static int[] count;

    private static class Item {
        private String key;
        private final String value;
        Item nextItem;

        public Item(String value, String key) {
            this.key = key;
            this.value = value;
            this.nextItem = null;
        }

        public String getKey() {
            return this.key;
        }
        public String getValue(){
            return this.value;
        }
    }

    private static class MyHashMap {
        public void put(Item addItem) {
            int i = 0;
            while (true) {
                if (bucket[i] == null) {
                    bucket[i] = addItem;
                    count[i]++;
                    return;
                } else if (bucket[i].getKey().equals(addItem.getKey())) {
                    Item tempItem = bucket[i];
                    while (tempItem.nextItem != null) {
                        tempItem = tempItem.nextItem;
                    }
                    tempItem.nextItem = addItem;
                    count[i]++;
                    return;
                } else i++;
            }
        }

        private int CombinationHashCount() {
            int result = 1;
            for (int i = 0; i < 1000; i++) {
                result = result * (count[i] + 1);
            }
            return result - 1;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int num;
        for (int i = 0; i < N; i++) {
            count = new int[1000];
            MyHashMap myHashMap = new MyHashMap();
            num = Integer.parseInt(br.readLine());
            for (int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine());
                myHashMap.put(new Item(st.nextToken(), st.nextToken()));
            }
            sb.append(myHashMap.CombinationHashCount() + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
