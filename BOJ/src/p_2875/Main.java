package p_2875;

import java.io.BufferedReader;
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
        int N, M, K;
        String [] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        
        while(N > 0 && M > 0 && K > 0){
        	if(N >= 2 * M){
        		N--;
        	}else{
        		M--;
        	}
        	K--;
        }
        int ret = 0;
        while(N > 1 && M > 0){
        	if(N >= 2*M){
        		N -= 2;
        		M--;
        		ret++;
        	}else{
        		M--;
        	}
        }
//        System.out.println(N + ", " + M + ", " + K);
        System.out.println(ret);
        br.close();
    }
}