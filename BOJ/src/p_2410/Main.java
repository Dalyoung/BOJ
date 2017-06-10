package p_2410;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main {
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.doit();
    }
     
     
     
    public void doit() throws IOException{
      //  System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.toBinaryString(N).length();
        int c[] = new int[K+1];
        long dp[] = new long[N+1];
        dp[0] = 1;
        c[1] = 1;
        int D = 1000000000;
        for(int i = 2; i <= K; i++){
        	c[i] = 2 * c[i - 1];
        }
        
//        System.out.println(Arrays.toString(c));
        
        for(int i = 1; i <= K; i++){
        	for(int j = c[i]; j <= N; j++){
        		
        		dp[j] = dp[j] % D + dp[j - c[i]] % D;
        		if(dp[j] > D){
        			dp[j] %= D;
        		}
        	}
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
        br.close();
    }
}