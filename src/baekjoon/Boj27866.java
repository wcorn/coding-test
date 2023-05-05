package baekjoon;

import java.io.*;

public class Boj27866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        System.out.println(str.charAt(n - 1));
    }
}

