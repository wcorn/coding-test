package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean[] visited;
    static int N;
    static int M;
    static int V;

    private static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if (a.data > b.data) return 1;
            if (a.data < b.data) return -1;
            return 0;
        }
    }

    private static class Node {
        int data;
        ArrayList<Node> nodeList;

        public Node(int data) {
            this.data = data;
            this.nodeList = new ArrayList<>();
        }

        public void add(Node addNode) {
            this.nodeList.add(addNode);
            Collections.sort(nodeList, new NodeComparator());
        }

        public void sort() {
            Collections.sort(nodeList, new NodeComparator());
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

    private static void BFS(Node node) {
        Queue<Node> queue = new LinkedList<Node>() {};
        queue.offer(node);
        visited[node.data] = true;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            sb.append(temp.data + " ");
            Iterator<Node> iterator = temp.nodeList.listIterator();
            while(iterator.hasNext()) {
                Node w = iterator.next();
                if(!visited[w.data]) {
                    visited[w.data] = true;
                    queue.add(w);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken(  ));
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        int n1;
        int n2;
        ArrayList<Node> nodeArrayList = new ArrayList<>(N + 1);
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
        for (int i = 1; i <= N; i++) {
            nodeArrayList.get(i).sort();
        }
        visited = new boolean[N + 1];
        DFS(nodeArrayList.get(V));
        sb.append("\n");
        visited = new boolean[N + 1];
        BFS(nodeArrayList.get(V));
        bw.write(sb.toString());
        bw.flush();
    }
}
