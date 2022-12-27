package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2754 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        switch (str) {
            case ("A+"):
                System.out.println(4.3);
                break;
            case ("A0"):
                System.out.println(4.0);
                break;
            case ("A-"):
                System.out.println(3.7);
                break;
            case ("B+"):
                System.out.println(3.3);
                break;
            case ("B0"):
                System.out.println(3.0);
                break;
            case ("B-"):
                System.out.println(2.7);
                break;
            case ("C+"):
                System.out.println(2.3);
                break;
            case ("C0"):
                System.out.println(2.0);
                break;
            case ("C-"):
                System.out.println(1.7);
                break;
            case ("D+"):
                System.out.println(1.3);
                break;
            case ("D0"):
                System.out.println(1.0);
                break;
            case ("D-"):
                System.out.println(0.7);
                break;
            case("F"):
                System.out.println(0.0);
                break;
        }
    }
}
