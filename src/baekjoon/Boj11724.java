package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Boj11724 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean[] visited;

    private static class Node {
        int data;
        ArrayList<Node> nodeList;

        public Node(int data) {
            this.data = data;
            nodeList = new ArrayList<>();
        }

        public void add(Node node) {
            nodeList.add(node);
        }
    }

    private static void DFS(Node node) {
        visited[node.data] = true;
        sb.append(node.data + " ");
        if (node.nodeList.isEmpty()) return;
        Iterator<Node> iterator = node.nodeList.iterator();
        while (iterator.hasNext()) {
            Node temp = iterator.next();
            if (visited[temp.data]) continue;
            DFS(temp);
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int n1;
        int n2;
        int count = 0;
        ArrayList<Node> nodeArrayList = new ArrayList<>(N + 1);
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            nodeArrayList.add(new Node(i));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            nodeArrayList.get(n1).nodeList.add(nodeArrayList.get(n2));
            nodeArrayList.get(n2).nodeList.add(nodeArrayList.get(n1));
        }
        for (int i = 1; i <=N; i++) {
            if (!visited[i]) {
                DFS(nodeArrayList.get(i));
                count++;
            }
        }
        System.out.println(count);
    }
}
