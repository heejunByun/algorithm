package programmers.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringTokenTest {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringTokenizer st2;

        st = new StringTokenizer(br.readLine(), " ");
        st2 = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int A2 = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st2.nextToken());
        int B2 = Integer.parseInt(st2.nextToken());

        System.out.println("A = " + A);
        System.out.println("A2 = " + A2);
        System.out.println("B = " + B);
        System.out.println("B2 = " + B2);


    }
}