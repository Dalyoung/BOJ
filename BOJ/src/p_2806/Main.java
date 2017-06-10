package p_2806;

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
        char[] arr = br.readLine().toCharArray();
//        System.out.println(Arrays.toString(arr));
        int dp[][] = new int[2][N];
        
        if(arr[0] == 'A'){
        	dp[0][0] = 0;
        	dp[1][0] = 1;
        }else{
        	dp[0][0] = 1;
        	dp[1][0] = 0;
        }
        for(int i = 1; i < N; i++){
        	if(arr[i] == 'A'){
        		dp[0][i] = Math.min(dp[0][i-1], dp[1][i-1]+1);
        		dp[1][i] = Math.min(dp[1][i-1]+1, dp[0][i-1]+1);
        	}else{
        		dp[0][i] = Math.min(dp[0][i-1]+1, dp[1][i-1]+1);
        		dp[1][i] = Math.min(dp[1][i-1], dp[0][i-1]+1);
        	}
        }
//        System.out.println(Arrays.toString(dp[0]));
//        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Math.min(dp[0][N-1], dp[1][N-1]+1));
        br.close();
    }
}