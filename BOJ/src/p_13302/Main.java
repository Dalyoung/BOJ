package p_13302;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.doit();
    }
     
     
     
    int N, M;
    int arr[];
    int dp[][];
    public void doit() throws IOException{
      //  System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        dp = new int[N+1][2*N+3];
        if(M > 0){
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int i = 0; i < M; i++){
        		arr[Integer.parseInt(st.nextToken())] = 1;
        	}
        	//System.out.println(Arrays.toString(arr));
        }
        for(int i = 0; i <= N; i++){
        	Arrays.fill(dp[i], Integer.MAX_VALUE);
//        	System.out.println(Arrays.toString(dp[i]));
        }
        dp[0][0] = 0;
        for(int i = 0; i < N; i++){
        	for(int j = 0; j < 2*N; j++){
        		if(arr[i+1] == 1){
        			if(dp[i][j] != Integer.MAX_VALUE){
        				dp[i+1][j] = dp[i][j];
        			}
        		}else{
        			if(dp[i][j] != Integer.MAX_VALUE){
//        				System.out.println(i + ", " + j);
        				//1day
        				dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 10);
        				//3days
        				for(int k = 1; k <= 3 && i+k <= N; k++){
        					dp[i+k][j+1] = Math.min(dp[i+k][j+1], dp[i][j] + 25);
        				}
        				//5days
        				for(int k = 1; k <= 5 && i+k <= N; k++){
        					dp[i+k][j+2] = Math.min(dp[i+k][j+2], dp[i][j] + 37);
        				}
        				
        				// coupon
        				if(j >= 3){
        					dp[i+1][j-3] = Math.min(dp[i+1][j-3], dp[i][j]); 
        				}
        			}
        		}
        	}
        }
        
        int ret = Integer.MAX_VALUE;
        for(int j = 0; j <= 2*N; j++){
        	//         	Arrays.fill(dp[i], Integer.MAX_VALUE);
        	ret = Math.min(ret, dp[N][j]);
        }
        System.out.println(ret*1000);
        br.close();
    }
}