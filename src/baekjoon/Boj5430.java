package baekjoon;


import java.io.*;
import java.util.*;

public class Boj5430 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<String> list = new ArrayList<>();
    static char[] px;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        String p;
        int n;
        String x;
        String[] x1;
        for (int i = 0; i < T; i++) {
            p = br.readLine();
            px = new char[p.length()];
            n = Integer.parseInt(br.readLine());
            x = br.readLine();
            x1 = x.substring(1, x.length() - 1).split(",");
            for (int j = 0; j < p.length(); j++) {
                px[j] = p.substring(j, j + 1).charAt(0);
            }
            list.addAll(Arrays.asList(x1).subList(0, n));
            bw.append(solve()).append("\n");
            list.clear();
            sb.setLength(0);
        }
        bw.flush();
    }

    private static String solve() {
        boolean head = true;
        int count;
        for (int i = 0; i < px.length; i++) {
            count = 0;
            switch (px[i]) {
                case 'R':
                    count++;
                    if (i == px.length - 1) {
                        head = !head;
                        break;
                    }
                    while (px[i + 1] != 'D') {
                        i++;
                        count++;
                        if (i == px.length - 1) {
                            break;
                        }
                    }
                    if ((count) % 2 != 0) {
                        head = !head;
                    }
                    break;
                case 'D':
                    if (list.isEmpty())
                        return "error";
                    if (head)
                        list.remove(0);
                    else
                        list.remove(list.size()-1);
                    break;
                default:
                    return "error";
            }
        }
        if(!head){
            Collections.reverse(list);
        }
        sb.append("[");
        Iterator<String> it = list.iterator();
        if (! it.hasNext())
            return "[]";
        while(true){
            sb.append(it.next());
            if(!it.hasNext()){
                return sb.append("]").toString();
            }
            sb.append(",");
        }
    }
}