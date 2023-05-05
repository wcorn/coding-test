package baekjoon;

import java.io.*;

public class Boj25314 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException{
        int N = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder("int");
        for(int i=0;i<N/4;i++){
            result.insert(0, "long ");
        }
        System.out.println(result);
    }
}
