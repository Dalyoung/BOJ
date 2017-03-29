package p_2010;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.doit();
    }
     
    public void doit() throws IOException{
//        System.setIn(new FileInputStream("input/p_2010.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        for(int i = 0; i < N; i++){
        	sum += Long.parseLong(br.readLine());
        }
        System.out.println(sum - N + 1);
        br.close();
    }
}