package p_10164;

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
        String [] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]), M = Integer.parseInt(temp[1]), K = Integer.parseInt(temp[2]);
        
        int[][] path = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];
        int count = 1;
       
        for(int i = 1; i <= N; i++){
        	for(int j = 1; j <= M; j++){
        		path[i][j] = count;
        		count++;
        		if(i == 1 || j == 1){
        			dp[i][j] = 1;
        		}
        	}
        }
        
//        for(int i = 0; i <= N; i++){
//        	System.out.println(Arrays.toString(dp[i]));
//        }
        int x = 1, y = 1;
        for(int i = 1; i <= N; i++){
        	for(int j = y; j <= M; j++){
        		if(K == path[i][j]){
//        			System.out.println(K + ", " + path[i][j] + ", " + dp[i-1][j] + ", " +  dp[i][j-1]);
        			x = i;
        			y = j;
        			dp[i][j] = dp[i-1][j] + dp[i][j-1];
        			continue;
        		}
        		
        		if(i != 1 && j != 1){
        			if(i == x){
        				dp[i][j] = dp[i][j-1];
        			}
        			else if(j == y){
        				dp[i][j] = dp[i-1][j];
        			}else{
        				dp[i][j] = dp[i-1][j] + dp[i][j-1];
        			}
        			
        		}
        		
        	}
        }
        System.out.println(dp[N][M]);
//        for(int i = 1; i <= N; i++){
//        	System.out.println(Arrays.toString(path[i]));
//        }
//        
//        for(int i = 0; i <= N; i++){
//        	System.out.println(Arrays.toString(dp[i]));
//        }
        
        br.close();
    }
}