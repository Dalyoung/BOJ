package p_2163;

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
//        System.setIn(new FileInputStream("input/p_2163.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        
        int ret = 0;
        
        if(N < M){
        	int t = N;
        	N = M;
        	M = t;
        }
    	
        ret = (M-1) + M * (N-1);
    	System.out.println(ret);
    	
        br.close();
    }
}