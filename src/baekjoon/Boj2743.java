package baekjoon;

import java.io.*;

public class Boj2743 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        char[] ch = str.toCharArray();
        str = "";
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 65 && ch[i] <= 90)
                ch[i] = (char) (ch[i] + 32);
            else
                ch[i] = (char) (ch[i] - 32);
            str+=ch[i];
        }
        System.out.print(str);
    }
}