package p_10834;

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
       // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long r1 = 1, r2 = 1;
        int d = 0;
        for(int i = 0; i < N; i++){
        	String [] input = br.readLine().split(" ");
        	r1 *= Long.parseLong(input[0]);
        	r2 *= Long.parseLong(input[1]);
//        	System.out.println(r1 + ", " + r2);
        	if(r2 % r1 == 0){
        		r2 /= r1;
        		r1 = 1;
        	}
        	d += Integer.parseInt(input[2]);
        }
        d = d % 2;
        System.out.println(d + " " + (r2/r1));
        br.close();
    }
}